<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Message</title>
</head>
<body>
<h1>Sorry no data to display</h1>
<% String act = (String)request.getAttribute("act"); 
if(act.equals("errorDoctor")){
%>
<form action="Doctor.jsp">
	<input type="submit">
</form>
<%} %>
<%if(act.equals("Nurse")){
%>
<form action="NurseController" method="POST">
	<input type="submit" name="act" value="Nurse">
</form>
<%} %>
</body>
</html>