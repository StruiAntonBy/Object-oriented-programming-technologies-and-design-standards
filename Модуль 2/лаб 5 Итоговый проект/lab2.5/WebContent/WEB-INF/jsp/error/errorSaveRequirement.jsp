<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
<h1>Incorrect data entry</h1>
<%
	if(request.getParameter("id")==""){
%>
<p><A href="editRequirement.html?ProjectId=<%= Integer.parseInt(request.getParameter("ProjectId"))%>">Back</A><p>
<%
	}
	else{
%>
<p><A href="editRequirement.html?id=<%= Integer.parseInt(request.getParameter("id"))%>">Back</A><p>
<%
	}
%>
</body>
</html>