<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Receptionist List</title>
</head>
<body>
<% String name =  request.getParameter("checkBox");
	
%>
<form action="ReceptionistController" method="POST">
<table style="with: 50%">
	<tr>
		<td>Create a new Patient</td>
		<td><input type="checkbox" name="act" value="patient" /></td>
	</tr>
	<tr>
		<td>Schedule an Appointment</td>
		<td><input type="checkbox" name="act"  value="appointment"/></td>
	</tr>
	<tr>
		<td>View Patient List</td>
		<td><input type="checkbox" name="act"  value="viewPatient"/></td>
	</tr>
	<tr>
		<td>View Doctor List</td>
		<td><input type="checkbox" name="act"  value="viewDoctor"/></td>
	</tr>
	<tr>
		<td>View Appointment List</td>
		<td><input type="checkbox" name="act"  value="viewAppointment"/></td>
	</tr>
	
</table>
			
<input type="submit" value="option" />
<br>
</form>
<form  action="ReceptionistController" method="POST">
	<input type="submit" value="Go Home" name="act">
</form>
</body>
</html>