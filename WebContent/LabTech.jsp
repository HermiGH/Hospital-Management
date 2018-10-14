<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lab Technician</title>
</head>
<body>
<h1>Lab Technician</h1>
<% String act = (String)request.getAttribute("act"); 
if(act.equals("LabTech")){
%>
<form action="LabTechnicianController" method="POST">
	<table>
		<tr>
			<td><input type="radio" name="act" value="test"></td>
			<td>Test List</td>
		</tr>
	</table>
<input type="submit" value="Submit"><br>
<input type="submit" value="Go Home" name="act">
</form>
<%} else if(act.equals("test")) {%>
<form action="LabTechnicianController" method="POST">
	Select Patient to Test
	<table>
        <tr>
        		<td></td>
			<td>Patient Id</td>
			<td>Patient Name</td>
		</tr>
		<c:forEach items="${testList}" var="patient">
	        <tr>
	        		<td><input type="radio" name="personId" value="${patient.personId}"></td>
	            <td><c:out value="${patient.personId}" /></td>
	            <td><c:out value="${patient.name}" /></td>
	        </tr>
        </c:forEach>
</table>
<input type="submit" name="act" value="Test Patient">
<input type="submit" value="Go Back" name="act">
</form>
<%} %>
</body>
</html>