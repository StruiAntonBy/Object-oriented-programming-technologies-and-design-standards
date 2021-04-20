<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="data.Project"%>
<%@page import="data.User"%>
<%@page import="java.util.Collection"%>

<%
@SuppressWarnings("unchecked")
Collection<Project> objects=(Collection<Project>)request.getAttribute("objects");
User user=(User)session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of projects</title>
<STYLE>
  	TABLE {
         	border-collapse: collapse;
    }
    TH, TD {
           	border: 1px solid black;
            padding: 5px 30px 5px 10px;
   	}
   	#navbar ul{
        display: none;
        background-color: #f90;
        position: absolute;
        top: 100%;
      }
      #navbar li:hover ul { display: block; }
      #navbar, #navbar ul{
        margin: 0;
        padding: 0;
        list-style-type: none;
      }
      #navbar {
        height: 30px;
        background-color: #666;
        padding-left: 25px;
        min-width: 470px;
      }
      #navbar li {
        float: left;
        position: relative;
        height: 100%;
      }
      #navbar li a {
        display: block;
        padding: 6px;
        width: 550px;
        color: #fff;
        text-decoration: none;
        text-align: center;
      }
      #navbar ul li { float: none; }
      #navbar li:hover { background-color: #f90; }
      #navbar ul li:hover { background-color: #666; }
</STYLE>
</head>
<body>
<ul id="navbar">
	<% String authorization="Authorize";
		if(user!=null){
			authorization="You are logged in as "+user.getLogin();
			switch(user.getRole()){
				case 1:
					authorization=authorization + "(administrator)";
					break;
				case 2:
					authorization=authorization + "(business analyst)";
					break;
				case 3:
					authorization=authorization + "(user)";
					break;
			}
		}
	%>
    <li><a href="<%= user!=null ? "#" : "authorization.html" %>"><%= authorization %></a>
    	<% 
    		if(user!=null){ 
    	%>
    		<ul>
    			<li><a href="exit.html">Exit</a></li>
			</ul>
    	<% 
    		} 
    	%>
    </li>
    <%
    	if(user!=null && user.getRole()==1){
    %>
    	<li><a href="listUsers.html">List of users</a></li>
    <%
		}
    %>
</ul>
<p></p>
<%
	if(user!=null && user.getRole()==2){
%>
<FORM action="deleteProject.html" method="post">
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
		<th>Project name</th>
		<th>Client name</th>
		<th>Project start date</th>
		<th>End date of the project</th>
		<th>Percentage of project completion</th>
		<th>Need for programmers</th>
	</tr>
	<%
		for(Project object : objects){
	%>
	<tr>
		<%
			if(user!=null && user.getRole()==2){
		%>
		<td><INPUT type="radio" name="id" value="<%= object.getId() %>"></td>
		<%
			}
		%>
		<td><A href="listRequirements.html?ProjectId=<%= object.getId() %>"><%= object.getNameProject() %></A></td>
		<td><%= object.getNameClient() %></td>
		<td><%= object.getStartDate() %></td>
		<td><%= object.getEndDate() %></td>
		<td><%= Integer.toString((int)(object.getPercentProjectCompletion()*100))+"%" %></td>
		<td><%= object.getNeedForProgrammers() %></td>
	</tr>
	<%
		}
	%>
</table>
<%
	if(user!=null && user.getRole()==2){
%>
	<p><input type="submit" name="action" value="Edit">&nbsp;&nbsp;&nbsp;<input type="submit" name="action" value="Delete"></p>
	<p><A href="editProject.html">Add</A></p>
	</FORM>
<%
	}
%>
</body>
</html>