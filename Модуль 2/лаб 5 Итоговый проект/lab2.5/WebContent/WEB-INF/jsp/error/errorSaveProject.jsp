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
<p><A href="editProject.html">Back</A><p>
<%
	}
	else{
%>
<form action="editProject.html" method="post">
	<INPUT type="hidden" name="id" value="<%= Integer.parseInt(request.getParameter("id"))%>">
	<button>Back</button>
</form>
<%
	}
%>
</body>
</html>