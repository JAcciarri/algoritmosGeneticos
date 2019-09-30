<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="ag_web.*"%>
<!DOCTYPE html>
<html>
<head>

<link href="css\styles.css" rel="stylesheet" type="text/css">


<meta charset="ISO-8859-1">
	<title>Problema del Viajante - Algoritmos Geneticos</title>
</head>

<body>

	<%  String[] ciudades = Ciudades.getCiudades(); %>

	<h2>Algoritmos Genéticos - TSP Problema del viajante</h2>
	<h3>Grupo n° 4: Acciarri Joshua - Biondo Dolores - Oliva Martin</h3>

	<form action="CiudadServlet" method="POST">
		<label>Elegir ciudad de origen: </label> <select name="destino">
			<% for (int i = 0; i<ciudades.length; i++) {%>
			<option><%=ciudades[i]%></option>
			<% }%>
		</select>
		<button type="submit" class="button-default">Iniciar Busqueda</button>
		<div>
			<br> <label> Encontrar recorrido minimo </label> <a
				href="CiudadServlet" class="button-default">Iniciar</a>
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
	<h3>
		Recorrido desde:
		<%=cElegida%>
	</h3>
	<h3>
		Distancia total:
		<%=dTotal%></h3>


	<% String url = "img/mapas/"+index+".jpg"; %>


                              <table class="table">
                                  
                                        <tr>
                                            <th>ID Ciudad</th>
                                            <th >Nombre</th>
                                        </tr>
                                
                              
                    <% 
                    for (int i=0; i<recorrido.length; i++){ %> 
                                        <tr>
                                            <td ><%=i%></td>
                                            <td ><%=recorrido[i]%></td>
                                        </tr>
                    <%} %>
                               
                                </table>
                          
                            
               <img src="<%=url%>" id="mapa" width=400px height=600px>             
  
	<% }
	else
		if(request.getAttribute("mejorRecorrido")!=null){
		String[] mejorRecorrido = (String[])request.getAttribute("mejorRecorrido");
		 %>
	<h3>
		El mejor recorrido es desde:
		<%=mejorRecorrido[0]%>
	</h3>
	<h3>
		Con una distancia total de:
		<%=(int)request.getAttribute("mejorDistancia")%></h3>

	
	<table class="table">
          
                                     	<tr>
                                            <th >ID Ciudad</th>
                                            <th>Nombre</th>
                                        </tr>
                                  
                            
                    <% 
                    for (int i=0; i<mejorRecorrido.length; i++){ %> 
                                        <tr>
                                            <td><%=i%></td>
                                            <td><%=mejorRecorrido[i]%></td>
                                        </tr>
                    <%} %>
                                  
                                </table>
	
		<%}%>
</body>

</html>