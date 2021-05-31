
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
 * @author MMANASI
 */
@WebServlet("/Editemployee")
public class Editemployee extends HttpServlet {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int row;
    
    public void doGet(HttpServletRequest req,HttpServletResponse rsp)throws IOException,ServletException
    {
        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();
        
        String eid = req.getParameter("id");
        
        try {
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost/jsp_db","root","");
           
           pst = con.prepareStatement("select * from employee where id = ?");
           pst.setString(1,eid);
           rs = pst.executeQuery();
           
           while(rs.next())
           {
               
               out.println("<body style=\"background-image: linear-gradient(to right,#00467f, #a5cc82)\">");

               out.println("<form action='EditServlet' method='POST'>");
               out.println("<table width=\"500px\" border=\"1\" align=\"center\">");
               out.println("<tr><td style=\"text-align:center\" colspan=\"5\"><h1>Edit Employee</h1></td></tr>");
               out.println("<tr> <td style=\"text-align:center\"><b>Employee ID<b></td> <td style=\"text-align:center\"><input type='text' name='empid' id='empid' value='" + rs.getString("id") + "'/></td> </tr><br>");
               out.println("<tr> <td style=\"text-align:center\"><b>First Name &nbsp;</b></td> <td style=\"text-align:center\"><input type='text' name='fname' id='fname' value='" + rs.getString("fname") + "'/></td> </tr><br>");
               out.println("<tr> <td style=\"text-align:center\"><b>Last Name </b></td> <td style=\"text-align:center\"><input type='text' name='lname' id='lname' value='" + rs.getString("lname") + "'/></td> </tr><br>");
               out.println("<tr> <td style=\"text-align:center\"><b>Email Address</b></td> <td style=\"text-align:center\"><input type='email' name='email' id='email' value='" + rs.getString("email") + "'/></td> </tr><br>");
               out.println("<tr> <td style=\"text-align:center\"><b>Password &nbsp;</b></td> <td style=\"text-align:center\"><input type='text' name='password' id='password' value='" + rs.getString("password") + "'/></td> </tr><br>");
              
               out.println("<tr> <td style=\"text-align:center\" colspan='2'><input type='submit' value='Edit'/></td> </tr>");
               out.println("</table>");
               out.println("</form>");
//               out.println("</center>");
               out.println("</body>");
//               out.println("</center>");
               out.println("</html>");
           }
       
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            out.println("<font color='red'>Record Failed </font>");
        }
    }
    
}
