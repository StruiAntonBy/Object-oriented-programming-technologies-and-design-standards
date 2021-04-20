<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="data.Requirement"%>
<%@page import="data.User"%>
<%@page import="java.util.Collection"%>

<%
@SuppressWarnings("unchecked")
Collection<Requirement> objects=(Collection<Requirement>)request.getAttribute("objects");
User user=(User)session.getAttribute("user");
int ProjectId=(int)request.getAttribute("ProjectId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Requirements</title>
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
	<%
		if(user!=null && user.getRole()==2){
	%>
		<FORM action="deleteRequirement.html" method="post">
	<%
		}
	%>
	<table>
		<tr>
			<%
				if(user!=null && user.getRole()==2){
			%>
				<th>&nbsp;</th>
			<%
				}
			%>
			<th>Description</th>
			<th>Time the implementation</th>
			<th>Mark of implementation</th>
			<th>Priority</th>
			<th>The probability of a change</th>
		</tr>
		<%
			for(Requirement object : objects){
		%>
		<tr>
			<%
				if(user!=null && user.getRole()==2){
			%>
				<td><INPUT type="checkbox" name="id" value="<%= object.getId() %>"></td>
			<%
				}
			%>
			<td>
			<%
				if(user!=null && user.getRole()==2){
			%>
			<A href="editRequirement.html?id=<%= object.getId() %>"><%= object.getDescription() %></A>
			<%
				}
				else{
			%>
				<%= object.getDescription() %>
			<%
				}
			%>
			</td>
			<td><%= object.getTimeImplementation() %></td>
			<td><%= object.isMarkOfImplementation() ? "Yes" : "No" %></td>
			<% 	String ret;
				switch(object.getPriority()){
					case 1:
						ret="High";
						break;
					case 2:
						ret="Medium";
						break;
					default:
						ret="Low";
						break;
				}
			%>
			<td><%= ret %></td>
			<% switch(object.getProbabilityOfChange()){
					case 1:
						ret="High";
						break;
					case 2:
						ret="Medium";
						break;
					default:
						ret="Low";
						break;
				}
			%>
			<td><%= ret %></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		if(user!=null && user.getRole()==2){
	%>
		<INPUT type="hidden" name="ProjectId" value="<%= ProjectId %>">
		<p><A href="editRequirement.html?ProjectId=<%= ProjectId %>">Add</A>&nbsp;&nbsp;&nbsp;<button type="submit">Delete</button></p>
		</FORM>
	<%
		}
	%>
	<p><A href="index.html">Back</A></p>
</body>
</html>