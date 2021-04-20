<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="data.CarOwner"%>
<%@page import="java.util.Collection"%>

<%
    @SuppressWarnings("unchecked")
    Collection<CarOwner> objects
                   = (Collection<CarOwner>)request.getAttribute("objects");
%>

<HTML>
    <HEAD>
        <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <TITLE>The list of offences drivers</TITLE>
        <STYLE>
            TABLE {
                border-collapse: collapse;
            }
            TH, TD {
                border: 1px solid black;
                padding: 5px 30px 5px 10px;
            }
        </STYLE>
    </HEAD>
    <BODY>
        <FORM action="delete.html" method="post">
            <TABLE>
                <TR>
                    <TH>&nbsp;</TH>
                    <TH>Car number</TH>
                    <TH>Surname</TH>
                    <TH>Name</TH>
                    <TH>Middle name</TH>
                    <TH>Composition of the offense</TH>
                    <TH>Date of offense</TH>
                    <TH>Penalty sum</TH>
                    <TH>Date of payment of the fine</TH>
                    <TH>Penalty</TH>
                </TR>
                <%
                    for(CarOwner object : objects) {
                %>
                    <TR>
                        <TD>
                            <INPUT type="checkbox" name="id"
                                   value="<%= object.getId() %>">
                        </TD>
                        <TD>
                            <A href="edit.html?id=<%= object.getId() %>">
                                <%= object.getCarNumber() %>
                            </A>
                        </TD>
                        <TD><%= object.getSurname() %></TD>
                        <TD><%= object.getName() %></TD>
                        <TD><%= object.getMiddlName() %></TD>
                        <TD><%= object.getCompositionOffense() %></TD>
                        <TD><%= object.getDateOffense() %></TD>
                        <TD><%= object.getPenaltySum() %></TD>
                        <TD><%= object.getDatePayment()!=null ? object.getDatePayment() : new String() %></TD>
                        <TD><%= object.getPenalty() %></TD>
                    </TR>
                <%
                    }
                %>
            </TABLE>
            <%		double sumAllFines=0;
            		double sumUncollectedFines=0;
                    for(CarOwner object : objects) {
                    	if(object.getDatePayment()==null){
                    		sumUncollectedFines+=object.getPenalty()+object.getPenaltySum();
                    	}
                    	else{
                    		sumAllFines+=object.getPenalty()+object.getPenaltySum();
                    	}
                    }
            %>
            <P>Total amount of all fines:<%= sumAllFines %></P>
            <P>Total amount of uncollected fines:<%= sumUncollectedFines %></P>
            <P>
                <A href="edit.html">Add</A>&nbsp;&nbsp;&nbsp;
                <BUTTON type="submit">Delete</BUTTON>
            </P>
        </FORM>
    </BODY>
</HTML>