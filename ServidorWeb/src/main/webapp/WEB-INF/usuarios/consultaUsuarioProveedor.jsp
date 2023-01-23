<%@page import="com.turismouy.generados.DtUsuario"%>
<%@page import="java.util.List"%>
<%@page import="com.turismouy.generados.DtSalidaTuristica"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "com.turismouy.generados.DtUsuario" %>
<%@page import= "com.turismouy.generados.DtUsuarioExtendido" %>
<%@page import= "com.turismouy.generados.DtProveedorExtendido" %>
<%@page import= "com.turismouy.generados.DtActividadTuristica" %>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html lang="es">

<head>
<jsp:include page="/WEB-INF/template/head.jsp"></jsp:include>
<title>Consulta Proveedor</title>
</head>
<body>
<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
<div class="container-fluid mt-3">
        <div class="row">
            <!--  aca se ponen los filtros de departamentos y categorias y navegacion -->
            <div class="col-3 ">
                <div class="list-group d-flex ">
                    <h5 class="list-group-item ">Navegacion</h5>
                    <a href="index.html" class="list-group-item btn btn-primary ">Inicio</a>
                    <a href="/ServidorWeb/usuarios" class="list-group-item btn btn-primary ">Usuarios</a>
                </div>
            </div>


            <div class="col-9">
                <div class="row">
                    <div class="col-3">
                        <%	DtUsuarioExtendido usrListado =  (DtUsuarioExtendido) request.getAttribute("usuario");
                        	DtUsuarioExtendido usrLogueado = (DtUsuarioExtendido) request.getSession().getAttribute("usuario_logueado");
                        	DtUsuarioExtendido usr;
                        	if (usrListado == null) {  
                    			usr = usrLogueado;
                    		} else {
                    			usr = usrListado;
                    		}
                    		DtProveedorExtendido provedor = (DtProveedorExtendido) usr;
                    		if (provedor.getImagen() != null) {
                    	%>
                        <img src=<%= provedor.getImagen()%> class="img-fluid rounded">
                        <% 
                        	} else {
                        %> <img src = "https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded" alt="imagen no existente">
                        <%
                        	} 
                        %>
                    </div>
                    <div class="col-6">
                        <h2><%= provedor.getNombre()%></h2>
                        <h3><%= provedor.getNickname()%></h3>
                        <h4><%= provedor.getCorreo()%></h4>
                    </div>
                    <div class="col-9">

                        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                            <li class="nav-item" role="presentation">
                                <button class="nav-link active" id="pills-perfil-tab" data-bs-toggle="pill" data-bs-target="#pills-perfil" type="button" role="tab" aria-controls="pills-perfil" aria-selected="true">Perfil</button>
                            </li>
							<li class="nav-item" role="presentation">
                                <button class="nav-link" id="pills-seguidores-tab" data-bs-toggle="pill" data-bs-target="#pills-seguidores" type="button" role="tab" aria-controls="pills-seguidores" aria-selected="true">Seguidores</button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="pills-seguidos-tab" data-bs-toggle="pill" data-bs-target="#pills-seguidos" type="button" role="tab" aria-controls="pills-seguidos" aria-selected="true">Seguidos</button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="pills-actividades-tab" data-bs-toggle="pill" data-bs-target="#pills-actividades" type="button" role="tab" aria-controls="pills-actividades" aria-selected="false">Actividades</button>
                            </li>
                            
                        </ul>
                        <div class="tab-content" id="pills-tabContent">
                            <div class="tab-pane fade show active" id="pills-perfil" role="tabpanel" aria-labelledby="pills-perfil-tab">
                                <h6>Nickname: </h6>
                                <p><%= provedor.getNickname() %></p>
                                <h6>Nombre: </h6>
                                <p><%= provedor.getNombre() %></p>
                                <h6>Apellido: </h6>
                                <p><%= provedor.getApellido() %></p>
                                <h6>Email: </h6>
                                <p><%= provedor.getCorreo() %></p>
                                <h6>Fecha De Nacimiento: </h6>
                                <p><%= usr.getFechaNacString() %></p>
                                <h6>Descripcion: </h6>
                                <p><%= provedor.getDescripcion() %></p>
                                <%
                                	if (provedor.getLink() != null) {
                                %>
                                <h6>Sitio Web: </h6>
                                <p><%= provedor.getLink() %></p>
                                <%
                                	}
                                %>
                                <%
                                	if (usrLogueado!= null && provedor.getNickname().equals(usrLogueado.getNickname())) {
                                %>
                                <button class="btn btn-primary">Editar Datos</button>
                                <%
                                	}
                                %>
                            </div>
                            <div class="tab-pane fade" id="pills-seguidores" role="tabpanel" aria-labelledby="pills-seguidores-tab">
                            	<% 	
                            		List<DtUsuario> seguidores =  provedor.getListaSeguidores();
                         			if (seguidores != null)
                         				for (DtUsuario seguidor : seguidores) {
                         		%>
                         		<div class="row">
			                        <div class="col">                        	
			                            <a href="?usuario=<%= seguidor.getNickname() %>"  class="list-group-item list-group-item-action">                          
			                                <div class="row">
			                                    <div class="col-2">
			                                    <% if (seguidor.getImagen() != null){
			                                    %>
			                                        <img class="img-fluid" src="<%= seguidor.getImagen() %>">
			                                    <% }
			                                     else {
			                                    %> <img src = "https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded" alt="imagen no existente">
			                        			<% } %>
			                                     
			                                    </div>
			                                    <div class="col">
			                                        <h5 class="mb-1"><%= seguidor.getNickname() %></h5>
			                                        <h6 class="mb-1"><%= seguidor.getNombre() %></h6>
			                                        <h6 class="mb-1"><%= seguidor.getApellido() %></h6>
			                                    </div>
			                                </div>
			                            </a>
			                        </div>
			                    </div>
			                    <%
                         				}
			                    %>
                            </div>
                            <div class="tab-pane fade" id="pills-seguidos" role="tabpanel" aria-labelledby="pills-seguidos-tab">
                            	<% 	
                            		List<DtUsuario> seguidos =  provedor.getListaSeguidos();
                         			if (seguidos != null)
                         				for (DtUsuario seguido : seguidos) {
                         		%>
                         		<div class="row">
			                        <div class="col">                        	
			                            <a href="?usuario=<%= seguido.getNickname() %>"  class="list-group-item list-group-item-action">                          
			                                <div class="row">
			                                    <div class="col-2">
			                                    <% if (seguido.getImagen() != null){
			                                    %>
			                                        <img class="img-fluid" src="<%= seguido.getImagen() %>">
			                                    <% }
			                                     else {
			                                    %> <img src = "https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded" alt="imagen no existente">
			                        			<% } %>
			                                     
			                                    </div>
			                                    <div class="col">
			                                        <h5 class="mb-1"><%= seguido.getNickname() %></h5>
			                                        <h6 class="mb-1"><%= seguido.getNombre() %></h6>
			                                        <h6 class="mb-1"><%= seguido.getApellido() %></h6>
			                                    </div>
			                                </div>
			                            </a>
			                        </div>
			                    </div>
			                    <%
                         				}
			                    %>
                            </div>
                            <div class="tab-pane fade" id="pills-actividades" role="tabpanel" aria-labelledby="pills-actividades-tab">
                                <div class="col">
                                    <!-- aca se muestran las actividades -->
                                    <div class="row">
                                        <div class="list-group">
                                        
                                        <%
                                        List<DtActividadTuristica> colActividades;
                                        boolean esSesion = usrLogueado!= null && provedor.getNickname().equals(usrLogueado.getNickname());
                                        
                                        if (esSesion){
                                        	colActividades = provedor.getListaActividades();
                                        }else {
                                        	colActividades = provedor.getListaActividadesConfirmadas();
                                        }
                                        	if (colActividades != null)
                                        		for (DtActividadTuristica actividad : colActividades) {
                                        %>
                                            <div class="list-group-item">
                                                <div class="row">
                                                    <div class="col-9">
                                                        <a class=" col-6 link-dark text-decoration-none" href="/ServidorWeb/actividades?nombreActividad=<%= actividad.getNombre() %>">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                <% if (actividad.getImagen() != null) { %>
                                                        			<img class="img-fluid" src=<%=actividad.getImagen()%> alt=<%= actividad.getNombre() %>> 
                                                    			<% } else { %>
                                                        			<img src ="https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded" alt="imagen no existente">
                                                    			<% } %>
                                                                </div>
                                                                <div class="col actividad ">
                                                                    <h3><%= actividad.getNombre() %></h3>
                                                                    <p><%= actividad.getDescripcion() %></p>
                                                                    <h6>Costo:</h6>
                                                                    <p>$<%= actividad.getCosto() %></p>
                                                                    <h6>Duración:</h6>
                                                                    <p><%= actividad.getDuracion() %> horas</p>
                                                                    <h6>Ciudad:</h6>
                                                                    <p><%= actividad.getCiudad() %></p>
                                                                    <h6>Fecha de Alta:</h6>
                                                                    <p><%= actividad.getFechaDeAltaString() %></p>
                                                                    <%if(esSesion){ %>
                                                                    <h6>Estado:</h6>
                                                                    <p><%= actividad.getEstado().toString() %> </p>
                                                                    	<% if(actividad.getEstado().toString().equals("CONFIRMADA")) { %>
                                                                    	<a class = "btn btn-primary" href="/ServidorWeb/finalizarActividad?actividad=<%= actividad.getNombre()%>">Finalizar Actividad</a>
                                                                    	<%}%>
                                                                    <%} %>
                                                                    
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                    <div class="col-3">
                                                        <h3>Salidas</h3>
                                                        <%
                                                        	List<DtSalidaTuristica> colSalidas = actividad.getListaSalidas();
                                                        	if (colSalidas != null)
                                                        		for(DtSalidaTuristica salida : colSalidas) {
                                                        %>
                                                        <a class=" col-6 link-dark text-decoration-none" href="/ServidorWeb/salidas?nombreSalida=<%= salida.getNombre() %>">
                                                            <div class="row">
                                                                <div class="">
                                                                <% if (salida.getImagen() != null) { %>
									                            	<img src = <%= salida.getImagen() %> class="img-fluid rounded" alt = <%=salida.getNombre()%>>
									                            <% } else { %>
									                            	<img src = "https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded" alt="imagen no existente">
									                            <% } %>
                                                                </div>
                                                                <div class="col actividad ">
                                                                    <h5><%= salida.getNombre() %></h5>
                                                                </div>
                                                            </div>
                                                        </a>
                                                        <%
                                                        		}
                                                        %>
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
                </div>
            </div>
        </div>
    </div>

</body>
</html>