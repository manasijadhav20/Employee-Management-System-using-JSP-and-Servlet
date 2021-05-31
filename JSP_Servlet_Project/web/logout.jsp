<%-- 
    Document   : logout
    Created on : 3 Feb, 2021, 11:43:33 PM
    Author     : MANASI
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
<% session.invalidate(); %>
<p>You have been successfully logout</p>
<%response.sendRedirect("index.jsp"); %>
</body>
</html>