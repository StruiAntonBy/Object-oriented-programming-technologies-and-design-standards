<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<%@page import="data.CarOwner"%>

<%
	CarOwner object = (CarOwner)request.getAttribute("object");
%>
<HTML>
    <HEAD>
        <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <TITLE>Edit form</TITLE>
    </HEAD>
    <BODY>
        <FORM action="save.html" method="post">
            <%
                if(object != null) {
            %>
                <INPUT type="hidden" name="id"
                       value="<%= object.getId() %>">
            <%
                }
            %>
            <P>Car number:&nbsp;&nbsp;&nbsp;
            <INPUT type="text" name="CarNumber"
                   value="<%= object != null
                              ? object.getCarNumber()
                              : new String() %>"></P>
            <P>Surname:&nbsp;&nbsp;&nbsp;
            <INPUT type="text" name="Surname"
                   value="<%= object != null
                              ? object.getSurname()
                              : new String() %>"></P>
            <P>Name:&nbsp;&nbsp;&nbsp;
            <INPUT type="text" name="Name"
                   value="<%= object != null
                              ? object.getName()
                              : new String() %>"></P>
            <P>Middle name:&nbsp;&nbsp;&nbsp;
            <INPUT type="text" name="MiddlName"
                   value="<%= object != null
                              ? object.getMiddlName()
                              : new String() %>"></P>
            <P>Composition of the offense:&nbsp;&nbsp;&nbsp;
            <INPUT type="text" name="CompositionOffense"
                   value="<%= object != null
                              ? object.getCompositionOffense()
                              : new String() %>"></P>
          	<P>Date of offense:&nbsp;&nbsp;&nbsp;
            <INPUT type="date" name="DateOffense"
                   value="<%= object != null
                              ? object.getDateOffense()
                              : new String() %>"></P>
            <P>Penalty sum:&nbsp;&nbsp;&nbsp;
            <INPUT type="number" name="PenaltySum"
                   value="<%= object != null
                              ? object.getPenaltySum()
                              : new String() %>"></P>
            <P>Date of payment of the fine:&nbsp;&nbsp;&nbsp;
            <INPUT type="date" name="DatePayment"
                   value="<%= object != null && object.getDatePayment()!=null
                              ? object.getDatePayment()
                              : new String() %>"></P>
            <P><BUTTON type="submit">Save</BUTTON></P>
            <A href="index.html">Back</A>
        </FORM>
    </BODY>
</HTML>