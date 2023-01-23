<%@page import="com.turismouy.generados.DtActividadTuristica"%>
<%@page import="com.turismouy.generados.DtSalidaTuristica"%>
<%@page import="com.turismouy.generados.DtUsuarioExtendido" %>
<%@page import="com.turismouy.generados.DtTuristaExtendido" %>
<%@page import="com.turismouy.generados.DtProveedorExtendido" %>
<%@page import="com.turismouy.generados.DtDepartamento" %>
<%@page import="com.turismouy.generados.DtCategoria" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
<jsp:include page="/WEB-INF/template/head.jsp"></jsp:include>
<title>Salidas</title>
</head>
<body>
<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>

<div class="container-fluid mt-3">
        <div class="row">
            <div class="col-3 ">
                <div class="list-group d-flex ">
                    <h5 class="list-group-item ">Navegacion</h5>
                    <a href="index.html" class="list-group-item btn btn-primary ">Inicio</a>
                    <%DtUsuarioExtendido usuario =  (DtUsuarioExtendido) request.getSession().getAttribute("usuario_logueado");
                        if (usuario != null && usuario instanceof DtTuristaExtendido){
                        %>
                        <a href="/ServidorWeb/inscripcionSalida" class="list-group-item btn btn-primary">Inscribirme a una Salida Turística</a>
                        <%} else if (usuario != null && usuario instanceof DtProveedorExtendido){
                        %>
                        <a href="/ServidorWeb/altaSalida" class="list-group-item btn btn-primary">Alta de Salida Turística</a>
                        <%} %>
                    <a href="/ServidorWeb/actividades" class="list-group-item btn btn-primary ">Consultar Actividades Turísticas</a>
                </div>
                <br>
                <div class="list-group d-flex">
                	<h5 class="list-group-item">Actividades Turisticas</h5>
                        <%
                        	List<DtActividadTuristica> dtActividades = (List<DtActividadTuristica>) request.getAttribute("dtActividades");
                        	if (dtActividades != null)
                        		for (DtActividadTuristica dtActividad : dtActividades) {
                        %>
                        <a class="list-group-item btn btn-primary" href="?actividad=<%= dtActividad.getNombre() %>"><%= dtActividad.getNombre() %></a>
              			<%
                        		}
                        %>
                </div>
            </div>


            <div class="col-9">

                <div>
                    <div class="row">
                        <div class="col-3">

                        </div>
                        <div class="col">
                            <div class="row">
                                <div class="col">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>Nombre</th>
                                            </tr>
                                        </thead>
                                    </table>
                                </div>
                                <div class="col">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>Fecha</th>
                                            </tr>
                                        </thead>
                                    </table>
                                </div>
                                <div class="col">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>Hora</th>
                                            </tr>
                                        </thead>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%List<DtSalidaTuristica> dtSalidas = (List<DtSalidaTuristica>) request.getAttribute("dtSalidas");                    
                    if(dtSalidas != null)
                    	for(DtSalidaTuristica dtsalida: dtSalidas){
                    %>

                    <a  href="?nombreSalida=<%=dtsalida.getNombre()%>" class="col list-group-item list-group-item-action">
                        <div class="row border-bottom">
                        	
                        
                            <div class="col-3 my-2">
							<% if (dtsalida.getImagen() != null) {
                        		%>
                            <img src = <%= dtsalida.getImagen() %> class="img-fluid rounded" alt = <%=dtsalida.getNombre()%>>
                            <% } else {
                            	%>
                            <img src = "https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded" alt="imagen no existente">
                            
                            <% } %>                            
                            </div>
                            <div class="col">
                                <div class="row">
                                    <div class="col">
                                        <table class="table table-borderless">
                                            <tbody>
                                                <tr>
                                                    <td><%=dtsalida.getNombre()%></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="col">
                                        <table class="table table-borderless">
                                            <tbody>
                                                <tr>
                                                    <td>Fecha de Salida: <%=dtsalida.getFechaSalidaString()%></td>
                                                    <td>Fecha de Alta: <%=dtsalida.getFechaAltaString()%></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="col">
                                        <table class="table table-borderless">
                                            <tbody>
                                                <tr>
                                                    <td>Hora: <%=dtsalida.getHoraSalidaString()%>hs</td>
                                                    <td>Cupos: <%=dtsalida.getCuposDisponibles()%></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                    </a>
                    <%}%>
                </div>
            </div>
		</div>
	</div>

</body>
</html>