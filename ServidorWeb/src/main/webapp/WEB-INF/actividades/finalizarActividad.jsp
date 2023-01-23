<%@page import="com.turismouy.generados.DtSalidaTuristica"%>
<%@page import="java.util.Map"%>
<%@page import="com.turismouy.generados.DtActividadTuristica"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
<jsp:include page="/WEB-INF/template/head.jsp"></jsp:include>
<title>Finalizar Actividad Turística</title>
</head>
<body>
<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
  <div class="container-fluid mt-3">
        <div class="row">
            <!--  aca se ponen los filtros de departamentos y categorias -->
            <div class="col-3 ">
                <div class="list-group d-flex ">
                    <h5 class="list-group-item ">Navegacion</h5>
                    <a href="index.html" class="list-group-item btn btn-primary ">Inicio</a>
                    <a href="/ServidorWeb/actividades" class="list-group-item btn btn-primary ">Actividades</a>
                </div>
            </div>

            <div class="col-9">
                <!-- aca se muestran la actividad -->
                <div class="row">
                    <div class="list-group">
                        <div class="list-group-item">
                            <div class="row">
                                <div class="col">
                                    <a class=" col-6 link-dark text-decoration-none" href="#">
                                        <div class="row">
                                            <div class="col-6">
                                            <%DtActividadTuristica dtActividad =(DtActividadTuristica) request.getAttribute("dtActividad");%>
                                                <%if(dtActividad.getImagen() != null){ %>
                                                        <img class="img-fluid " src=<%=dtActividad.getImagen()%> alt=<%=dtActividad.getNombre()%>> 
                                                        <%}else{ %>
                                                        <img src = "https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded" alt="imagen no existente">
                                                 <%} %>
                                            </div>
                                            <div class="col actividad ">                                            
                                                <h3><%=dtActividad.getNombre()%></h3>
                                                <p><%=dtActividad.getDescripcion()%></p>
                                                <p>Duración: <%=dtActividad.getDuracion()%> Horas</p>
                                                <p>Costo: $<%=dtActividad.getCosto()%></p>
                                                <p>Ciudad: <%=dtActividad.getCiudad()%></p>
                                                <p>Fecha de Alta: <%= dtActividad.getFechaDeAltaString() %></p>
                                            </div>
											<a class="btn btn-primary" href="/ServidorWeb/finalizarActividad?nombreActividad=<%= dtActividad.getNombre() %>">Finalizar actividad</a>
                                        </div>
                                    </a>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</body>
</html>