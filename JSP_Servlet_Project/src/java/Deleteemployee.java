
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
@WebServlet("/Deleteemployee")
public class Deleteemployee extends HttpServlet{
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int row;
    
    public void doGet(HttpServletRequest req,HttpServletResponse rsp)throws IOException,ServletException
    {
        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();
        
        String empid = req.getParameter("id");
        
        try {
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost/jsp_db","root","");
           
            pst = con.prepareStatement("delete from employee where id=?");
            pst.setString(1,empid);
            row = pst.executeUpdate();
            out.println("<body style=\"background-image: linear-gradient(to right,#00467f, #a5cc82)\">");
            out.println("<font color='whitesmoke'><h1>Record Deleted Successfully!!</h1></font><br>");
            out.println("<form action=\"index.jsp\">");
           out.println("<button tpe=\"submit\">Registration Page</button>");
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
