<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="data.User"%>
<%@page import="java.util.Collection"%>

<%
@SuppressWarnings("unchecked")
Collection<User> objects=(Collection<User>)request.getAttribute("objects");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of users</title>
<STYLE>
  	TABLE {
         	border-collapse: collapse;
    }
    TH, TD {
           	border: 1px solid black;
            padding: 5px 30px 5px 10px;
   	}
</STYLE>
</head>
<body>
<FORM action="deleteUser.html" method="post">
	<table>
		<tr>
			<th>&nbsp;</th>
			<th>Login</th>
			<th>Role</th>
		</tr>
		<%
			for(User object : objects){
		%>
			<tr>
				<td><INPUT type="checkbox" name="id" value="<%= object.getId() %>"></td>
				<td><A href="editUser.html?id=<%= object.getId() %>"><%= object.getLogin() %></A></td>
				<%
					String ret=null;
					switch(object.getRole()){
						case 1:
							ret="Administrator";
							break;
						case 2:
							ret="Business analyst";
							break;
						case 3:
							ret="User";
							break;
					}
				%>
				<td><%= ret %></td>
			</tr>
		<%
			}
		%>
	</table>
	<P><A href="editUser.html">Add</A>&nbsp;&nbsp;&nbsp;<BUTTON type="submit">Delete</BUTTON></P>
	<P><A href="index.html">Back</A></P>
</FORM>
</body>
</html>