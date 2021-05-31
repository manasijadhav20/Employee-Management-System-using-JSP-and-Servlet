
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MANASI
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int row;
    
    public void doPost(HttpServletRequest req,HttpServletResponse rsp)throws IOException,ServletException
    {
        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();
        
        String eid = req.getParameter("id");
        
        try {
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost/jsp_db","root","");
           
          String empid = req.getParameter("empid");
          String fname = req.getParameter("fname");
          String lname = req.getParameter("lname");
          String email = req.getParameter("email");
          String password = req.getParameter("password");
          
          pst = con.prepareStatement("update employee set fname=?,lname=?,email=?,password=? where id=?");
          pst.setString(1,fname);
          pst.setString(2,lname);
          pst.setString(3,email);
          pst.setString(4,password);
          pst.setString(5,empid);
          row = pst.executeUpdate();
          out.println("<body style=\"background-image: linear-gradient(to right,#00467f, #a5cc82)\">");
           out.println("<font color='whitesmoke'><h1>Record Updated Successfully!!</h1></font><br>");
           out.println("<form action=\"login.jsp\">");
           out.println("<button tpe=\"submit\">Login Page</button>");
           out.println("</form>");
           out.println("</body>");
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            out.println("<font color='red'>Update Failed </font>");
        }
    }
    
}
