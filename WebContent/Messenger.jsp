<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Messenger</title>
</head>
<body>
<h1>Messenger: </h1>
<% String act = (String)request.getAttribute("act"); 
if(act.equals("Messenger")){
%>
<form action="MessengerController" method="POST">
	<table>
		<tr>
			<td><input type="radio" name="act" value="shift"></td>
			<td>Shift Patient to Room</td>
		</tr>
		<tr>
			<td><input type="radio" name="act" value="getMedicine"></td>
			<td>Get medicine for In-Patient from Pharmacy</td>
		</tr>
	</table>
<input type="submit" value="Submit"><br>
<input type="submit" value="Go Home" name="act">
</form>
<%} else if(act.equals("showShift")) {%>
<form action="MessengerController" method="POST">
	Select Patient to Shift
	<table>
        <tr>
        		<td></td>
			<td>Patient Id</td>
			<td>Patient Name</td>
		</tr>
		<c:forEach items="${shiftList}" var="patient">
	        <tr>
	        		<td><input type="radio" name="personId" value="${patient.personId}"></td>
	            <td><c:out value="${patient.personId}" /></td>
	            <td><c:out value="${patient.name}" /></td>
	        </tr>
        </c:forEach>
</table>
<input type="submit" name="act" value="Shift Patient">
<input type="submit" value="Go Back" name="act">
</form>
<%} else if(act.equals("showMedicine")) {%>
<form action="MessengerController" method="POST">
	Select Patient to Shift
	<table>
        <tr>
        		<td></td>
			<td>Patient Id</td>
			<td>Patient Name</td>
		</tr>
		<c:forEach items="${medicineList}" var="patient">
	        <tr>
	        		<td><input type="radio" name="personId" value="${patient.personId}"></td>
	            <td><c:out value="${patient.personId}" /></td>
	            <td><c:out value="${patient.name}" /></td>
	        </tr>
        </c:forEach>
</table>
<input type="submit" name="act" value="Get Medicine Patient">
<input type="submit" value="Go Back" name="act">
</form>
<%} %>
</body>
</html>