<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="data.Project"%>

<%
Project object=(Project)request.getAttribute("object");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit form</title>
</head>
<body>
	<FORM action="saveProject.html" method="post">
		<p>Project name:&nbsp;&nbsp;&nbsp;<INPUT type="text" name="NameProject" value="<%= object!=null ? object.getNameProject() : new String() %>"></p>
    	<p>Client name:&nbsp;&nbsp;&nbsp;<INPUT type="text" name="NameClient" value="<%= object!=null ? object.getNameClient() : new String() %>"></p>
    	<p>Project start date:&nbsp;&nbsp;&nbsp;<INPUT type="date" name="StartDate" value="<%= object!=null ? object.getStartDate() : new String() %>"></p>
    	<p>End date of the project:&nbsp;&nbsp;&nbsp;<INPUT type="date" name="EndDate" value="<%= object!=null ? object.getEndDate() : new String() %>"></p>
    	<INPUT type="hidden" name="id" value="<%= object!=null ? object.getId() : new String()%>">
    	<P><button>Save</button></P>
	</FORM>
	<P><A href="index.html">Back</A></P>
</body>
</html>