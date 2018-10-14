<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doctor</title>
</head>
<body>
<%String name = (String)request.getAttribute("act"); 
if(name.equals("showPatientList")){
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
<%
} else if(name.equals("showAppointmentList")){
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

<% 
} else if(name.equals("checkPatientList")){
%>
<h1>Enter Diagnosis</h1>
<form action="DoctorController" method="post">
<table>
        <tr>
        		<td></td>
			<td>Patient Id</td>
			<td>Patient Name</td>
		</tr>
		<c:forEach items="${patientList}" var="patient">
    
        <tr>
        		<td><input type="radio" name="personId" value="${patient.personId}"></td>
            <td><c:out value="${patient.personId}" /></td>
            <td><c:out value="${patient.name}" /></td>
        </tr>
        </c:forEach>
        <tr>
        		<td>Diagnosis<input type="text" name="diagnosis"></td>
        		<td>Medicine<input type="text" name="medicine"></td>
        		<td>Test<input type="text" name="test"></td>
        </tr>
       
</table>
<input type="submit" value="Submit Diagnosis" name="act" >
</form>
<%} %>
<form action="DoctorController" method="POST" >
	<input type="submit" name="act" value="Go Back">
</form>
</body>
</html>