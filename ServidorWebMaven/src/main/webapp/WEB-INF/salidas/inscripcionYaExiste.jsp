<%@page import="java.util.List"%>
<%@page import="com.turismouy.generados.DtCategoria"%>
<%@page import="com.turismouy.generados.DtDepartamento"%>
<%@page import="com.turismouy.generados.DtSalidaTuristica"%>
<%@page import="java.util.Map"%>
<%@page import="com.turismouy.generados.DtActividadTuristica" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp"></jsp:include>
<title>Inscripción a Salida Turística</title>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
    <div class="container-fluid mt-3">
        <div class="row">
            <!--  aca se pone la navegacion-->
            <div class="col-3 ">
                <div class="list-group d-flex ">
                    <h5 class="list-group-item ">Navegacion</h5>
                    <a href="/ServidorWeb/salidas" class="list-group-item btn btn-primary ">Salidas</a>
                    <a href="index.html" class="list-group-item btn btn-primary ">Inicio</a>
                </div>

                
                <div class="col">
                            <div class="list-group d-flex">
                        <h5 class="list-group-item">Seleccione un departamento</h5>
                        <%
                        	List<DtDepartamento> dtDeptos = (List<DtDepartamento>) request.getAttribute("dtDeptos");
                        	if (dtDeptos != null)
                        		for (DtDepartamento dtDepto : dtDeptos) {
                        %>
                       		<a class="list-group-item btn btn-primary" href="?departamento=<%= dtDepto.getNombreDepto() %>"><%= dtDepto.getNombreDepto() %></a>
                        <%
                        		}
                        %>
                    	   </div>
						<br>
                    	<div class="list-group d-flex">
                        	<h5 class="list-group-item">O categorías</h5>
                        <%
                        	List<DtCategoria> dtCategorias = (List<DtCategoria>) request.getAttribute("dtCategorias");
                        	if (dtCategorias != null)
                        		for (DtCategoria dtCategoria : dtCategorias) {
                        %>
                        	<a class="list-group-item btn btn-primary" href="?categoria=<%= dtCategoria.getNombre() %>"><%= dtCategoria.getNombre() %></a>
              			<%
                        		}
                        %>
                    	</div>
                    	</div>
            </div>

            <div class="col-9">
            <div class="list-group">
            	<h2>Inscripción a Salida Turística</h2>
                    <form method="get" action="/ServidorWeb/inscripcionSalida">
                    	<label class="form-label" for="actividades">Seleccione una actividad</label>
                    	<select class="form-select" name="nombreActividad" id="actividades">
                        	<% 
                 	 			List<DtActividadTuristica> actividades = (List<DtActividadTuristica>)request.getAttribute("dtActividades");
                 	 			if (actividades != null)
                  				for(DtActividadTuristica dtActividad : actividades) {               
                			%>
                            <option value="<%= dtActividad.getNombre()%>"> <%= dtActividad.getNombre()%></option>
                            <%} %>                                                                        
                    	</select>
                    	<button class="btn btn-primary my-2" type="submit">Seleccionar</button>
                    </form>
                    <!-- datos de las salidas -->
                    <div class="col-9">
                    <div id="listarActividades" class="main">
                        <div class="row">
                            <div class="list-group">
                        <%
                        List<DtSalidaTuristica> dtSalidas = (List<DtSalidaTuristica>) request.getAttribute("dtSalidas");                    
                    	if(dtSalidas != null)
                    	for(DtSalidaTuristica dtsalida: dtSalidas){
                   		 %>
                                <div class="list-group-item">
                                    <div class="row">
                                        <div class="col-9">
                                            <div class="col-6 link-dark text-decoration-none" href="?nombreActividad=<%= dtsalida.getNombre() %>">
                                                <div class="row">
                                                    <div class="col-6">
                                                    <% if (dtsalida.getImagen() != null) { %>
                                                        <img class="img-fluid" src="<%=dtsalida.getImagen()%>" alt="<%= dtsalida.getNombre() %>"> 
                                                    <% } else { %>
                                                        <img src ="https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded" alt="imagen no existente">
                                                    <% } %>
                                                    </div>
                                                    <div class="col salida">
                                                        <h3><%= dtsalida.getNombre() %></h3>
                                                        <p>Fecha Salida: <%= dtsalida.getFechaSalidaString() %></p>
                                                        <p>Cupos Disponibles: <%= dtsalida.getCuposDisponibles() %></p>
                                                        <p>Hora Salida: <%= dtsalida.getHoraSalidaString() %></p>
                                                        <p>Lugar Salida: <%= dtsalida.getLugarSalida() %></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
						<%
								}
						%>
                            </div>
                        </div>
                    </div>
                </div>
                    
				
                <div class="alert alert-danger" role="alert">
                    <p>Usted ya se inscribió a esta salida. Solo puede inscribirse una vez a una salida.</p>
                </div>    
                <form method="post" action="/ServidorWeb/inscripcionSalida">
                <label class="form-label" for="nombreSalida">Nombre Salida:</label>
                <input class="form-control" type="text" id="salida" name="nombreSalida">
                <label class="form-label" for="cantTuristal">Cantidad de Turistas: </label>
                <input class="form-control" type="number" id="cantTurista" name="cantTurista">

                <input class="d-none"type="text" id="nombreActividadInput" name="nombreActividadInput" value="<%= request.getParameter("nombreActividad")%>">
           		<button class="btn btn-primary my-2" type="submit">Inscribirme</button>
           		</form>            
                </div>
                
           </div>
      </div>
</body>
</html>