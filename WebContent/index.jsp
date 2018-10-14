<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hospital Mangement System</title>
</head>
<body>
	<%
	String checkBox = (String)request.getAttribute("doctor");
	if(checkBox==null){%>
	<h1>Log in as:</h1>
	<form action="PersonController" method="POST">
		<table style="with: 50%">
				<tr>
					<td>Receptionist</td>
					<td><input type="checkbox" name="checkBox" value="Receptionist" /></td>
				</tr>
				<tr>
					<td>Doctor</td>
					<td><input type="checkbox" name="checkBox"  value="Doctor"/></td>
				</tr>
				<tr>
					<td>Nurse</td>
					<td><input type="checkbox" name="checkBox"  value="Nurse"/></td>
				</tr>
				<tr>
					<td>Messenger</td>
					<td><input type="checkbox" name="checkBox"  value="Messenger"/></td>
				</tr>
				<tr>
					<td>Lab Technician</td>
					<td><input type="checkbox" name="checkBox"  value="LabTech"/></td>
				</tr>
				<tr>
					<td>Dietician</td>
					<td><input type="checkbox" name="checkBox"  value="Dietician"/></td>
				</tr>
				<tr>
					<td>Inventory</td>
					<td><input type="checkbox" name="checkBox"  value="Inventory"/></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
	</form>
	<%
	}
	else if(checkBox!=null && checkBox.equals("Doctor")){
		%> 
	<form action="PersonController" method="POST">
		<table style="with: 50%">
				<tr>
					<td>Enter your person ID </td>
					<td><input type="text" name="doctorId" /></td>
				</tr>
			</table>
			<input type="submit" name="checkBox" value="Submit Doctor Id" />
	</form>
	<%} %>
</body>
</html>