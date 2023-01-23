<%@page import="java.util.List"%>
<%@page import="com.turismouy.generados.DtCategorias"%>
<%@page import="com.turismouy.generados.DtCategoria"%>
<%@page import="com.turismouy.generados.DtDepartamentos"%>
<%@page import="com.turismouy.generados.DtDepartamento"%>
<%@page import="com.turismouy.generados.DtActividades"%>
<%@page import="com.turismouy.generados.DtActividadTuristica"%>
<%@page import= "com.turismouy.generados.DtUsuarioExtendido" %>
<%@page import= "com.turismouy.generados.DtProveedorExtendido" %>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="es">

    <head>
        <jsp:include page="/WEB-INF/template/head.jsp"></jsp:include>
        <title>Actividades</title>
    </head>

    <body>
        <jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>

        <div class="container-fluid mt-3">
            <div class="row">
                <!--  aca se ponen los filtros de departamentos y categorias y navegacion -->
                <div class="col-3">
                    <div class="list-group d-flex">
                        <h5 class="list-group-item">Navegacion</h5>
                        <a href="index.html" class="list-group-item btn btn-primary">Inicio</a>
                        <%DtUsuarioExtendido usuario =  (DtUsuarioExtendido) request.getSession().getAttribute("usuario_logueado");
                        if (usuario != null && usuario instanceof DtProveedorExtendido){
                        %>
                        <a href="/ServidorWeb/altaActividad" class="list-group-item btn btn-primary">Alta de Actividad</a>
                        <%} %>
                    </div>
					<br>
                    <div class="list-group d-flex">
                        <h5 class="list-group-item">Departamentos</h5>
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
                        	<h5 class="list-group-item">Categorias</h5>
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

                <div class="col-9">
                    <!-- aca se muestran las actividades -->
                    <div id="listarActividades" class="main">
                        <div class="row">
                            <div class="list-group">
                        <% 
                        	List<DtActividadTuristica> dtActividades = (List<DtActividadTuristica>) request.getAttribute("dtActividades");
                        	if (!dtActividades.isEmpty())
                        		for (DtActividadTuristica dtActividad : dtActividades) {
                        %>
                                <div class="list-group-item">
                                    <div class="row">
                                        <div class="col-9">
                                            <a class="col-6 link-dark text-decoration-none" href="?nombreActividad=<%= dtActividad.getNombre() %>">
                                                <div class="row">
                                                    <div class="col-6">
                                                    <% if (dtActividad.getImagen() != null) { %>
                                                        <img class="img-fluid" src="<%=dtActividad.getImagen()%>" alt="<%= dtActividad.getNombre() %>"> 
                                                    <% } else { %>
                                                        <img src ="https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded" alt="imagen no existente">
                                                    <% } %>
                                                    </div>
                                                    <div class="col actividad">
                                                        <h3><%= dtActividad.getNombre() %></h3>
                                                        <p><%= dtActividad.getDescripcion() %></p>
                                                    </div>
                                                </div>
                                            </a>
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
            </div>
        </div>
    </body>
   	
   	</html>