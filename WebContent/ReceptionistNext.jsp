<%@page import="com.pojo.Patient"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Receptionist</title>
</head>
<body>
<% String act = (String)request.getAttribute("act");
%>
<%
if(act.equals("patient")){
%>
<h1>Please Enter Patient Details</h1>
<form action="ReceptionistController" method="GET">
<table style="with: 50%">
	<tr>
		<td>Name</td>
		<td><input type="text" name="name"/></td>
	</tr>
	<tr>
		<td>Nationality</td>
		<td><input type="text" name="nationality"/></td>
	</tr>
	<tr>
		<td>Blood Group</td>
		<td><input type="text" name="bloodGroup"/></td>
	</tr>
	<tr>
		<td>Insurance Number</td>
		<td><input type="text" name="insurance"/></td>
	</tr>
</table>
			
<input type="submit" value="Submit Patient Details" name="act"/>
</form>
<%} 
else if(act.equals("appointment"))
{
%>
<h1>Please enter appointment details:</h1>
<form action="ReceptionistController" method="GET">
<table style="with: 50%">
	<tr>
		<td>Pediatric</td>
		<td><input type="radio" name="department" value="1"/></td>
	</tr>
	<tr>
		<td>Orthopedic</td>
		<td><input type="radio" name="department" value="2"/></td>
	</tr>
	<tr>
		<td>ENT</td>
		<td><input type="radio" name="department" value="3"/></td>
	</tr>
	<tr>
		<td>Endocrinology</td>
		<td><input type="radio" name="department" value="4"/></td>
	</tr>
	<tr>
		<td>Cardiology</td>
		<td><input type="radio" name="department" value="5"/></td>
	</tr>
	<tr>
		<td>Dermatology</td>
		<td><input type="radio" name="department" value="6"/></td>
	</tr>
	<tr>
		<td>Emergency</td>
		<td><input type="radio" name="department" value="7"/></td>
	</tr>
	<tr>
		<td>Surgery</td>
		<td><input type="radio" name="department" value="8"/></td>
	</tr>
	<tr>
		<td>Oncology</td>
		<td><input type="radio" name="department" value="9"/></td>
	</tr>
	<tr>
		<td>Enter Patient Id</td>
		<td><input type="text" name="patientId" value="patientId"/></td>
	</tr>
	
</table>
			
<input type="submit" value="Submit Appointment" name="act" />
</form>
<%} 
else if(act.equals("viewPatient"))
{	
%>
<h1>Patient List</h1>
<table>
        <tr>
			<td>Patient Id</td>
			<td>Patient Name</td>
		</tr>
		<c:forEach items="${patientList}" var="patient">
    
        <tr>
            <td><c:out value="${patient.personId}" /></td>
            <td><c:out value="${patient.name}" /></td>
        </tr>
        </c:forEach>
</table>

<% } else if(act.equals("viewDoctor"))
{	
%>
<h1>Doctor List</h1>
<table>
		<tr>
			<td>Doctor Id</td>
			<td>Doctor Name</td>
			<td>Department</td>
		</tr>
		<c:forEach items="${doctorList}" var="doctor">
		    <tr>
		        <td><c:out value="${doctor.personId}" /></td>
		        <td><c:out value="${doctor.name}" /></td>
		        <td><c:out value="${doctor.department}" /></td>
		    </tr>
		</c:forEach>
</table>

<% } else if(act.equals("viewAppointment"))
{	
%>
<h1>Appointment List</h1>
<table>
		<tr>
			<td>Appointment Id</td>
			<td>Patient Id</td>
			<td>Doctor Id</td>
			<td>Date</td>
		</tr>
		<c:forEach items="${appointmentList}" var="appointment">
		    <tr>
		    		<td><c:out value="${appointment.appointmentId}" /></td>
		        <td><c:out value="${appointment.patientId}" /></td>
		        <td><c:out value="${appointment.doctorId}" /></td>
		        <td><fmt:formatDate pattern="yyyy-MM-dd" type="DATE" value="${appointment.date.getTime()}" var="dateB" />${dateB}</td>
		    </tr>
		</c:forEach>
</table>

<% } %>
<br>
<br>
<form action="ReceptionistController" method="POST">
<input type="submit" name="act" value="Go Back">
</form>
</body>
</html>