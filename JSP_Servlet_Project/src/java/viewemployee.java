
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
//The @WebServletannotation is used to declare a servlet.
@WebServlet("/viewemployee")
public class viewemployee extends HttpServlet{
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int row;
    
    public void doGet(HttpServletRequest req,HttpServletResponse rsp)throws IOException,ServletException
    {
        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();
        
        try {
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost/jsp_db","root","");
           
           String sql;
           
           sql = "select * from employee";
           Statement stmt = con.createStatement();
           rs = stmt.executeQuery(sql);
           
           out.println("<body style=\"background-image: linear-gradient(to right,#00467f, #a5cc82)\">");
           out.println("<table cellspacing='1' width='700x' height='250px' border='1' align='center'>");
           out.println("<tr>");
           out.println("<td style=\"text-align:center\"> Employee ID </td>");
           out.println("<td style=\"text-align:center\"> First Name </td>");
           out.println("<td style=\"text-align:center\"> Last Name</td>");
           out.println("<td style=\"text-align:center\"> Email Address </td>");
           out.println("<td style=\"text-align:center\"> Password </td>");
           out.println("<td text-color='white'> Edit </td>");
           out.println("<td color:white;> Delete </td>");
           out.println("</tr>");
           out.println("</body>");
           
           while(rs.next())
           {
                out.println("<tr>");
                out.println("<td style=\"text-align:center\">" + rs.getString("id") + "</td>");
                out.println("<td style=\"text-align:center\">" + rs.getString("fname") + "</td>");
                out.println("<td style=\"text-align:center\">" + rs.getString("lname") + "</td>");
                out.println("<td style=\"text-align:center\">" + rs.getString("email") + "</td>");
                out.println("<td style=\"text-align:center\">" + rs.getString("password") + "</td>");
                out.println("<td style=\"text-align:center\">" + "<a style=\"color: white\" href='Editemployee?id=" + rs.getString("id") + "'> Edit </a>" + "</td>");
                out.println("<td style=\"text-align:center\">" + "<a style=\"color: white\" href='Deleteemployee?id=" + rs.getString("id") + "'> Delete </a>" + "</td>");
                out.println("</tr>");
               
           }
           out.println("</table>");
       
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            out.println("<font color='red'>Record Failed </font>");
        }
    }
    
}
