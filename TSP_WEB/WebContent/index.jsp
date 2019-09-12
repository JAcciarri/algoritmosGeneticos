<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="ag_web.*" %>
<!DOCTYPE html>
<html>
<link href="css\styles.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Travelling Salesman Problem</title>
</head>
<body>

<%  String[] ciudades = Ciudades.getCiudades(); %>

	<form action="CiudadServlet" method="POST">
		<label>Ciudad de origen: </label> 
			<select name="destino">
				<% for (int i = 0; i<ciudades.length; i++) {%>
						<option><%=ciudades[i]%></option>
				<% }%>		
			</select>
			<button type="submit" class="button-default">Iniciar Busqueda</button>
		<div>
			<br> 
			<label>¿Mejor recorrido?  </label>
			<a href="CiudadServlet" class="button-default">Show</a>	
		</div>
	</form>

	<%  if (request.getAttribute("dTotal")!=null)
		{
		   int index=0;
		   int dTotal = (int)request.getAttribute("dTotal"); 
		   String cElegida = (String)request.getAttribute("cElegida");
		   String[] recorrido = (String[])request.getAttribute("recorrido");
		   for (int i=0; i<ciudades.length; i++){
			   if (ciudades[i].equalsIgnoreCase(cElegida)) 
				   index = i;
		   }
		   %>
	<h3>Recorrido desde: <%=cElegida%> </h3>
	<h3>Distancia total: <%=dTotal%></h3>
	
	<% switch(index){
	case 0: %><img src="img/mapaArgentina1.jpg" id="mapa" width=400px height=600px><% break;
	case 1: %><img src="img/mapaArgentina2.jpg" id="mapa" width=400px height=600px><% break;
	
	}%>
	
	
	<table class="table">
		<tr>
			<th>Recorrido</th>
		</tr>
		<tr>
			<%
		   		for (int i=0; i<recorrido.length; i++){
		   		%>
			<td><%=recorrido[i] %></td>
			</tr>

			<% }%>
		
	</table>

	<% }
	else
		if(request.getAttribute("mejorCiudad")!=null){
		Celda cell = (Celda)request.getAttribute("mejorCiudad");
		 %>
			<h3>El mejor recorrido es desde: <%=cell.getCiudadDesde()%> </h3>
			<h3>Con una distancia total de: <%=cell.getDistanciaEntreAmbas()%></h3>
		<%}%>
	

</html>