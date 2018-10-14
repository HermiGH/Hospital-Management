<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nurse</title>
</head>
<body>
<h1>Nurse Roles</h1>
<%
String act=(String)request.getAttribute("act");
if(act=="nurse"){
%>
<form action="NurseController" method="POST">
	<table>
		<tr><td><input type="radio" name="act" value="checkInPatient"></td>
		<td>Check In Patient</td>
		</tr>
	</table>
	<input type="submit" value="Submit"><br>
	<input type="submit" name="act" value="Go Home">
</form>

<%} else if(act.equals("checkInPatientAct")){%>
<form action="NurseController" method="POST">
	Select Patient to Check In
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
</table>
<input type="submit" name="act" value="Check In Patient">
</form>
<%} %>
</body>
</html>