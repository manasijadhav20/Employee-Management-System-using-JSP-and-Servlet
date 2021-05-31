<%-- 
    Document   : loginpage
    Created on : 3 Feb, 2021, 10:53:40 PM
    Author     : MANASI
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %> 
<html>
<head>
</head>
<body>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    String email,password;
    PreparedStatement pst;
    ResultSet rs;
    String useremail,userpassword,userfname,userlname,userid;
    
%>
<%
    try{
  Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/jsp_db","root","");
          email = request.getParameter("email");
          password = request.getParameter("password");
          pst = con.prepareStatement("select * from employee where email=?");
          pst.setString(1,email);
          rs = pst.executeQuery();
          
          if(rs.next())
          {
              userfname = rs.getString("fname");
              useremail = rs.getString("email");
              userpassword = rs.getString("password");
              userid = rs.getString("id");
              userlname = rs.getString("lname");
              if(email.equals(useremail) && password.equals(userpassword))
              {
                  session.setAttribute("id", userid);
                  session.setAttribute("fname", userfname);
                  session.setAttribute("lname", userlname);
                  session.setAttribute("email", useremail);
                  session.setAttribute("password", userpassword);
                  response.sendRedirect("welcome.jsp");
                  
              }
          }
              else
              {
                  %>
                  <p>Login Failed</p>
                  <%
                  response.sendRedirect("index.jsp");
                  rs.close();
                  pst.close();
              }
          }
    catch(Exception ae)
    {
        out.println(ae);
          }

           
%>
</body>
</html>