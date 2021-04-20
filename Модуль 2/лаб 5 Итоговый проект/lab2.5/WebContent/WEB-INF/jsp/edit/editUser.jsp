<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="data.User"%>

<%
User user=(User)request.getAttribute("object");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit form</title>
</head>
<body>
	<FORM action="saveUser.html" method="post">
    	<P>Login:&nbsp;&nbsp;&nbsp;<INPUT type="text" name="Login" value="<%= user!=null ? user.getLogin() : new String() %>"></P>
    	<P>Password:&nbsp;&nbsp;&nbsp;<INPUT type="password" name="Password"></P>
    	<P>Role:&nbsp;&nbsp;&nbsp;
    	<input name="Role" type="radio" value="1" <%= user!=null && user.getRole()==1 ? "checked" : new String() %>>Administrator
    	<input name="Role" type="radio" value="2" <%= user!=null && user.getRole()==2 ? "checked" : new String() %>>Business analyst
    	<input name="Role" type="radio" value="3" <%= user!=null && user.getRole()==3 ? "checked" : new String() %>>User
    	</P>
    	<INPUT type="hidden" name="id" value="<%= user!=null ? user.getId() : new String()%>">
    	<P><button>Save</button></P>
	</FORM>
	<P><A href="listUsers.html">Back</A></P>
</body>
</html>