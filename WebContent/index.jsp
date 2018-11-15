<%@page import="rs.PrijavaZaPosao"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%
  
  ArrayList<PrijavaZaPosao> lp=(ArrayList)request.getAttribute("radnici");
  %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Prijava za posao</h2>
<form action="Prijava" method="post">
	IME:<br>
	<input type="text" name="ime"><br>
	PREZIME:<br>
	<input type="text" name="prezime"><br>
GODINE ISKUSTVA:<br>
	
	<input type="text" name="god_iskustva"><br>
	KOLIKU PLATU ZELITE:<br>
	<input type="text" name="plata"><br><br>
	
	<input type="submit" name="akcija" value="prijava">


</form>
<h3>${errmsg}</h3>

<% if(lp!=null && lp.size()>0){ %>
<table >
	<tr>
		<th>IME</th>
		<th>PREZIME</th>
		<th>GODINE ISKUSTVA</th>
		<th>PLATA</th>
		<th>DATUM PRIJAVE</th>
		<th colspan="1">AKCIJA</th>
	</tr>
	<% for(PrijavaZaPosao pr:lp) {%>
	<tr>
		<th><%=pr.getIme() %></th>
		<th><%=pr.getPrezime()%></th>
		<th><%=pr.getGodine_iskustva()%></th>
		<th><%out.print(pr.getZeljena_plata()+"RSD") ;%></th>
		<th><%=pr.getDatum_prijave() %></th>
		<th><form action="Prijava" method="get"><input type="submit" name="akcija" value="obrisi"><input type="hidden" name="id" value="<%=pr.getRadnikID()%>"> </form>
		<th><form action="Prijava" method="get"><input type="submit" name="akcija" value="izmeni"><input type="hidden" name="id" value="<%=pr.getRadnikID()%>"> </form>
	
	</tr>
	
	<%} %>


</table>
<%}else {out.print("");} %>
</body>
</html>