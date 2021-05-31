<%-- 
    Document   : welcome
    Created on : 3 Feb, 2021, 11:39:44 PM
    Author     : MANASI
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body style="background-image: linear-gradient(to right,#00467f, #a5cc82);">
<p><h2 align="center">You have successfully logged in </h2></p>

<table width="500px" border="1" align="center">
    <tr><td style="text-align:center" colspan="5"><h1>Employee Details</h1></td></tr>
    <tr><td style="text-align:center"><b>Employee ID</b></td><td style="text-align:center"><%=session.getAttribute("id")%></td> </tr>
    <tr><td style="text-align:center"><b>First Name</b></td><td style="text-align:center"><%=session.getAttribute("fname")%></td></tr>
    <tr><td style="text-align:center"><b>Last Name</b></td><td style="text-align:center"><%=session.getAttribute("lname")%></td></tr>
    <tr><td style="text-align:center"><b>Email Address</b></td><td style="text-align:center"><%=session.getAttribute("email")%></td></tr>
    <tr><td style="text-align:center"><b>Password</b></td><td style="text-align:center"><%=session.getAttribute("password")%></td></tr>
</table>
<br>
<form action="logout.jsp" align="center">
<button tpe="submit" background-color>Logout</button>
</form>
</body>
</html>