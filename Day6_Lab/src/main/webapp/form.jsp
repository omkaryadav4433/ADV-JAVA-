<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%--getServletContext().setAttribute("ipl",new iplbean());--%>
<jsp:useBean id="ipl" class="bean.iplbeans" scope="application"></jsp:useBean>
<body>
<%--display team details--%>
<%--getServletContext().getAttribute("ipl"):IPLBean-->getAllteams() --%>
<h5>Teams:${applicationScope.ipl.fetchAllTeams()}</h5>
</body>
</html>