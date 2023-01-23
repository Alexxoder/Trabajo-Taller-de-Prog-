<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.turismouy.generados.DtSalidaTuristica"%>
<%@page import="java.util.Map"%>
<%@page import="com.turismouy.generados.DtActividadTuristica"%>

<!DOCTYPE html>
<html lang="es">

<head>
<jsp:include page="/WEB-INF/template/head.jsp"></jsp:include>
<title>Consultar Salida</title>
</head>
<body>
<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
<!-- borrar luego:Pero este es el formato que hay que seguir para agregar los header y footer -->
        <div class="container-fluid mt-3">
            <div class="row">
                <!-- navegacion izquierda -->
                <div class="col-3">
                    <div class="list-group d-flex ">
                        <h5 class="list-group-item ">Navegacion</h5>
                        <a class="list-group-item btn btn-primary " href="/ServidorWeb/salidas">Consultar Salidas Turísticas</a>
                        <a class="list-group-item btn btn-primary " href="/ServidorWeb/actividades">Consultar Actividades Turísticas</a>
                        <a class="list-group-item btn btn-primary " href="/ServidorWeb/altaSalida">Alta de Salida</a>
                        <a class="list-group-item btn btn-primary " href="/ServidorWeb/inscripcionSalida">Inscripcion a Salida</a>
                    </div>

                </div>

                <div class="col-9">
                    <div class="row">
                        <div class="col-3">
                        	<%DtSalidaTuristica dtSalida = (DtSalidaTuristica) request.getAttribute("dtSalida");%>
                        	<% if (dtSalida.getImagen() != null) {
                        	%>
                            <img src = <%= dtSalida.getImagen() %> class="img-fluid rounded">
                            <% } else {
                            	%>
                            <img src = "https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded">
                            
                            <% } %>
                        
                        </div>
                        <div class="col-6">
                            <h2><%= dtSalida.getNombre() %></h2>
                        </div>
                        <h6>Cantidad máxima de turistas: <%= dtSalida.getTopeTuristas() %> </h6>
                        <h6>Cupos Disponibles:<%= dtSalida.getCuposDisponibles() %> </h6>
                        <h6>Fecha De Salida: <%= dtSalida.getFechaSalidaString() %> </h6>
                        <h6>Hora: <%= dtSalida.getHoraSalidaString() %> </h6>
                        <h6>Lugar: <%= dtSalida.getLugarSalida() %> </h6>
                        <h6>Fecha De Alta: <%= dtSalida.getFechaAltaString() %> </h6>
                    </div>
                </div>
            </div>
        </div>

</body>
</html>