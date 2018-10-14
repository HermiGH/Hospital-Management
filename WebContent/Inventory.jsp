<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inventory</title>
</head>
<body>
<h1>Inventory</h1>
<% 
String act=(String)request.getAttribute("act");
if(act.equals("Inventory")){
%>
<form action="InventoryController" method="POST">
<table style="with: 50%">
	<tr>
		<td>View Patient List</td>
		<td><input type="checkbox" name="act" value="viewPatient" /></td>
	</tr>
	<tr>
		<td>View Appointment List</td>
		<td><input type="checkbox" name="act"  value="viewAppointment"/></td>
	</tr>
	<tr>
		<td>View Doctor List</td>
		<td><input type="checkbox" name="act"  value="viewDoctor"/></td>
	</tr>
	<tr>
		<td>View Patient to be shifted List</td>
		<td><input type="checkbox" name="act"  value="viewPatientShift"/></td>
	</tr>
	<tr>
		<td>View Patient to get medicine List</td>
		<td><input type="checkbox" name="act"  value="viewPatientMedicine"/></td>
	</tr>
	<tr>
		<td>View Patient to get Diet plan List</td>
		<td><input type="checkbox" name="act"  value="viewPatientDiet"/></td>
	</tr>
	<tr>
		<td>View Patient to get testes List</td>
		<td><input type="checkbox" name="act"  value="viewPatientTest"/></td>
	</tr>
</table>
			
<input type="submit" value="option" />
<br>
<input type="submit" value="Go Home" name="act"/>
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

<%}
else if(act.equals("viewPatientShift"))
{	
%>
<h1>Patient List</h1>
<table>
        <tr>
			<td>Patient Id</td>
			<td>Patient Name</td>
		</tr>
		<c:forEach items="${shiftPatientList}" var="patient">
    
        <tr>
            <td><c:out value="${patient.personId}" /></td>
            <td><c:out value="${patient.name}" /></td>
        </tr>
        </c:forEach>
</table>

<%}
else if(act.equals("viewPatientMedicine"))
{	
%>
<h1>Patient List</h1>
<table>
        <tr>
			<td>Patient Id</td>
			<td>Patient Name</td>
		</tr>
		<c:forEach items="${medicinePatientList}" var="patient">
    
        <tr>
            <td><c:out value="${patient.personId}" /></td>
            <td><c:out value="${patient.name}" /></td>
        </tr>
        </c:forEach>
</table>

<%}
else if(act.equals("viewPatientDiet"))
{	
%>
<h1>Patient List</h1>
<table>
        <tr>
			<td>Patient Id</td>
			<td>Patient Name</td>
		</tr>
		<c:forEach items="${dieticianList}" var="patient">
    
        <tr>
            <td><c:out value="${patient.personId}" /></td>
            <td><c:out value="${patient.name}" /></td>
        </tr>
        </c:forEach>
</table>

<%}
else if(act.equals("viewPatientTest"))
{	
%>
<h1>Patient List</h1>
<table>
        <tr>
			<td>Patient Id</td>
			<td>Patient Name</td>
		</tr>
		<c:forEach items="${testPatientList}" var="patient">
    
        <tr>
            <td><c:out value="${patient.personId}" /></td>
            <td><c:out value="${patient.name}" /></td>
        </tr>
        </c:forEach>
</table>

<% } 
%>
<form action="InventoryController" method="POST" >
	<input type="submit" name="act" value="Go Back">
</form>
</body>
</html>