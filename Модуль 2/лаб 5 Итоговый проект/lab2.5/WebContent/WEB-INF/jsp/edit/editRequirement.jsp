<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="data.Requirement"%>

<%
Requirement object=(Requirement)request.getAttribute("object");
int ProjectId=(int)request.getAttribute("ProjectId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit form</title>
</head>
<body>
	<FORM action="saveRequirement.html" method="post">
    	<P>Description:&nbsp;&nbsp;&nbsp;</P><textarea name="Description"><%= object!=null ? object.getDescription() : new String() %></textarea>
    	<P>Time the implementation:&nbsp;&nbsp;&nbsp;<INPUT type="number" name="TimeImplementation" value="<%= object!=null ? object.getTimeImplementation() : new String() %>"></P>
    	<P>Mark of implementation:&nbsp;&nbsp;&nbsp;
    	<INPUT type="checkbox" name="MarkOfImplementation" value="true" <%= object!=null && object.isMarkOfImplementation() ? "checked" : new String() %>>
    	</P>
    	<P>Priority:&nbsp;&nbsp;&nbsp;
    	<input name="Priority" type="radio" value="1" <%= object!=null && object.getPriority()==1 ? "checked" : new String() %>>High
    	<input name="Priority" type="radio" value="2" <%= object!=null && object.getPriority()==2 ? "checked" : new String() %>>Medium
    	<input name="Priority" type="radio" value="3" <%= object!=null && object.getPriority()==3 ? "checked" : new String() %>>Low
    	</P>
    	<P>The probability of a change:&nbsp;&nbsp;&nbsp;
    	<input name="ProbabilityOfChange" type="radio" value="1" <%= object!=null && object.getProbabilityOfChange()==1 ? "checked" : new String() %>>High
    	<input name="ProbabilityOfChange" type="radio" value="2" <%= object!=null && object.getProbabilityOfChange()==2 ? "checked" : new String() %>>Medium
    	<input name="ProbabilityOfChange" type="radio" value="3" <%= object!=null && object.getProbabilityOfChange()==3 ? "checked" : new String() %>>Low
    	</P>
    	<INPUT type="hidden" name="id" value="<%= object!=null ? object.getId() : new String()%>">
    	<INPUT type="hidden" name="ProjectId" value="<%= ProjectId %>">
    	<P><button>Save</button></P>
	</FORM>
	<P><A href="listRequirements.html?ProjectId=<%= ProjectId %>">Back</A></P>
</body>
</html>