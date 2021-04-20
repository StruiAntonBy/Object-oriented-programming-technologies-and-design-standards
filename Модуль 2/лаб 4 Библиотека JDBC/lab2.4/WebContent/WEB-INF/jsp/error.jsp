<%@page isErrorPage="true"
        language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
    <HEAD>
        <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <TITLE>Error</TITLE>
    </HEAD>
    <BODY>
        <c:choose>
            <c:when test="${not empty pageContext.exception}">
                <H2>Error working with the database</H2>
                <P>Contact your system administrator</P>
            </c:when>
            <c:otherwise>
                <H2>Unexpected app error</H2>
                <P>Contact your system administrator</P>
            </c:otherwise>
        </c:choose>
    </BODY>
</HTML>