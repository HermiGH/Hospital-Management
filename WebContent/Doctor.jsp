<%@page import="com.pojo.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doctor</title>
</head>
<body>
<form action="DoctorController" method="POST">
<%Doctor doctor = (Doctor)request.getAttribute("doctor"); %>
<table style="with: 50%">
	<tr>
		<td>Patient Appointment</td>
		<td><input type="checkbox" name="act" value="checkPatient" /></td>
	</tr>
	<tr>
		<td>View Appointment List</td>
		<td><input type="checkbox" name="act"  value="viewAppointmentList"/></td>
	</tr>
	<tr>
		<td>View Patient List</td>
		<td><input type="checkbox" name="act" value="viewPatientList" /></td>
	</tr>
</table>
			
<input type="submit" value="Submit" />
<br>
</form>
<form action="DoctorController"  method="POST">
<input type="submit" name="act" value="Go Home">
</form>
</body>
</html>