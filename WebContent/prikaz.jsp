<%@page import="rs.PrijavaZaPosao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    PrijavaZaPosao pr=(PrijavaZaPosao)request.getAttribute("radnik");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Admin" method="post">

	
	
		<input type="hidden" name="id" value="<%=pr.getRadnikID() %>">	
	<input type="text" name="ime" value="<%=pr.getIme() %>">	
	
	<input type="text" name="prezime" value="<%=pr.getPrezime() %>">	
	<input type="text" name="god_iskustva" value="<%=pr.getGodine_iskustva() %>">	
	<input type="text" name="plata" value="<%=pr.getZeljena_plata() %>">	
	
		<input type="submit"  value="izmeni">	
	
	



</form>
</body>
</html>