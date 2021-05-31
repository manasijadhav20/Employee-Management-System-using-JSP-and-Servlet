import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.logging.Logger;
import sun.util.logging.PlatformLogger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MANASI
 */
//The @WebServlet annotation is used to declare a servlet.
@WebServlet("/employee")

public class employee extends HttpServlet{
  
    Connection con;
    PreparedStatement pst;
    int row;
    
    public void doPost(HttpServletRequest req,HttpServletResponse rsp)throws IOException,ServletException
    {
        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();
        
        try {
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost/jsp_db","root","");
           String  empid=req.getParameter("empid");
           String  empfname=req.getParameter("fname");
           String  emplname=req.getParameter("lname");
           String empemail = req.getParameter("email");
          String emppassword = req.getParameter("password");
           
           pst = con.prepareStatement("insert into employee(id,fname,lname,email,password)values(?,?,?,?,?) ");
           pst.setString(1, empid);
           pst.setString(2, empfname);
           pst.setString(3, emplname);
           pst.setString(4,empemail);
           pst.setString(5,emppassword);
           row=pst.executeUpdate();
           out.println("<body style=\"background-image: linear-gradient(to right,#00467f, #a5cc82)\">");
           out.println("<font color='whitesmoke'><h1>Record Added Successfully!!</h1></font><br>");
           out.println("<form action=\"login.jsp\">");
           out.println("<button tpe=\"submit\">Login Page</button>");
           out.println("</form>");
           out.println("</body>");
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            out.println("<font color='red'>Record Failed </font>");
            out.println("<form action=\"index.jsp\">");
           out.println("<button tpe=\"submit\">Back to Registration Page</button>");
           out.println("</form>");
        }
    
        
    }
}
