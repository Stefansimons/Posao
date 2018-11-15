<%@page import="rs.PrijavaZaPosao"%>
<%@page import="rs.DAOradnik"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
DAOradnik dao=new DAOradnik();

PrijavaZaPosao p=dao.getRadnikByID(2);

System.out.print(p.toString());
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>