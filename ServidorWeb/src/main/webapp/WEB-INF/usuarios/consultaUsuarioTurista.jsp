<%@page import="com.turismouy.generados.DtInscripcion"%>
<%@page import="java.util.List"%>
<%@page import="com.turismouy.generados.DtTuristaExtendido"%>
<%@page import="com.turismouy.generados.DtSalidaTuristica"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map" %>
<%@page import= "com.turismouy.generados.DtUsuario" %>
<%@page import= "com.turismouy.generados.DtUsuarioExtendido" %>
<!DOCTYPE html>
<html lang="es">

<head>
	<jsp:include page="/WEB-INF/template/head.jsp"></jsp:include>
    <title>Consulta Turista</title>   
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
					<%    	DtUsuarioExtendido usrListado =  (DtUsuarioExtendido) request.getAttribute("usuario");
                            DtUsuarioExtendido usrLogueado = (DtUsuarioExtendido) request.getSession().getAttribute("usuario_logueado");
                            DtUsuarioExtendido usr;
                            if (usrListado == null) {
                                usr = usrLogueado;
                            } else {
                                usr = usrListado;
                            }
                            DtTuristaExtendido turista = (DtTuristaExtendido) usr;
                            if (turista.getImagen() != null) {
                        %>
                        <img src=<%= turista.getImagen()%> class="img-fluid rounded">
                        <% 
                        	} else {
                        %> <img src = "https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded" alt="imagen no existente">
                        <%
                        	} 
                        %>
                    </div>
                    <div class="col-6">
                        <h2><%= turista.getNombre()%></h2>
                        <h3><%= turista.getNickname()%></h3>
                        <h4><%= turista.getCorreo()%></h4>
                        <br>
                        <%
                        	if (usrLogueado != null) {
                        		List<DtUsuario> seguidos = usrLogueado.getListaSeguidos();
                        		boolean loSigue = false;
                        		for (DtUsuario seguido : seguidos) {
                        			if (seguido.getNickname().equals(turista.getNickname()))
                        				loSigue = true;
                        		}
                        		if (loSigue) {
                        %>
                        <a class="btn btn-primary" href="/ServidorWeb/seguir?nickNameUsuario=<%= usrLogueado.getNickname() %>&nickNameASeguir=<%= turista.getNickname() %>">Dejar de Seguir</a>
                        <%
                        		} else {
                        %>
                        <a class="btn btn-primary" href="/ServidorWeb/seguir?nickNameUsuario=<%= usrLogueado.getNickname() %>&nickNameASeguir=<%= turista.getNickname() %>">Seguir</a>
                        <%
                        		}
                        	}
                        %>
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
                                <button class="nav-link" id="pills-salida-tab" data-bs-toggle="pill" data-bs-target="#pills-salida" type="button" role="tab" aria-controls="pills-salida" aria-selected="false">Salida</button>
                            </li>
                            <% if (usrLogueado!= null && turista.getNickname().equals(usrLogueado.getNickname())) {
 								%>
                            <li class="nav-item " role="presentation">
                                <button class="nav-link" id="pills-paquete-tab" data-bs-toggle="pill" data-bs-target="#pills-paquete" type="button" role="tab" aria-controls="pills-paquete" aria-selected="false">Paquete</button>
                            </li>
                            <% } else {%>
                            <li class="d-none" role="presentation">
                                <button class="nav-link" id="pills-paquete-tab" data-bs-toggle="pill" data-bs-target="#pills-paquete" type="button" role="tab" aria-controls="pills-paquete" aria-selected="false">Paquete</button>
                            </li>
                            <% } %>
                        </ul>
                        <div class="tab-content" id="pills-tabContent">
                            <div class="tab-pane fade show active" id="pills-perfil" role="tabpanel" aria-labelledby="pills-perfil-tab">
                                <h6>Nickname: </h6>
                                <p><%= turista.getNickname() %></p>
                                <h6>Nombre: </h6>
                                <p><%= turista.getNombre() %></p>
                                <h6>Apellido: </h6>
                                <p><%= turista.getApellido() %></p>
                                <h6>Email: </h6>
                                <p><%= turista.getCorreo() %></p>
                                <h6>Fecha De Nacimiento: </h6>
                                <p><%= usr.getFechaNacString() %></p>
                                <h6>Nacionalidad: </h6>
                                <p><%= turista.getNacionalidad() %> </p>
                                <%
                                boolean esSesion = (usrLogueado!= null && turista.getNickname().equals(usrLogueado.getNickname()));
                                if (esSesion) {
 								%>
                                <button class="btn btn-primary">Editar Datos</button>
                                <% } %>
                            </div>
                            <div class="tab-pane fade" id="pills-seguidores" role="tabpanel" aria-labelledby="pills-seguidores-tab">
                            	<% 	
                            		List<DtUsuario> seguidores =  turista.getListaSeguidores();
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
                            		List<DtUsuario> seguidos =  turista.getListaSeguidos();
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
                            <div class="tab-pane fade" id="pills-salida" role="tabpanel" aria-labelledby="pills-salida-tab">
                                <div class="container-fluid list-group list-group-flush">
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
                                                                <th>Fecha de Inscripcion</th>
                                                            </tr>
                                                        </thead>
                                                    </table>
                                                </div>
                                               <%if (esSesion) { %>
                                                <div class="col">
                                                    <table class="table">
                                                        <thead>
                                                            <tr>
                                                                <th>Costo</th>
                                                            </tr>
                                                        </thead>
                                                    </table>
                                                </div>
                                                <div class="col">
                                                    <table class="table">
                                                        <thead>
                                                            <tr>
                                                                <th>Cantidad De Turistas</th>
                                                            </tr>
                                                        </thead>
                                                    </table>
                                                </div>
                                               <% } else { %>
                                                <div class="d-none">
                                                    <table class="table">
                                                        <thead>
                                                            <tr>
                                                                <th>Costo</th>
                                                            </tr>
                                                        </thead>
                                                    </table>
                                                </div>
                                                <div class="d-none">
                                                    <table class="table">
                                                        <thead>
                                                            <tr>
                                                                <th>Cantidad De Turistas</th>
                                                            </tr>
                                                        </thead>
                                                    </table>
                                                </div>
                                                <% } %>
                                            </div>
                                        </div>
                                    </div>
			  					<%
			  					List<DtSalidaTuristica> dtSalidas = turista.getListaSalidas(); 
			  					Map<String, DtInscripcion> inscripciones = (Map<String, DtInscripcion>) request.getAttribute("inscripciones");
			                    if(dtSalidas != null)
			                    	for(DtSalidaTuristica dtsalida: dtSalidas) {
			                    %>
			
			                    	<a  href="/ServidorWeb/salidas?nombreSalida=<%=dtsalida.getNombre()%>" class="col list-group-item list-group-item-action">
			                        <div class="row">
			                        
			                            <div class="col-3">
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
			                                                    <td><%= inscripciones.get(dtsalida.getNombre()).getFechaString()%></td>
			                                                </tr>
			                                            </tbody>
			                                        </table>
			                                    </div>
			                                    <% if (esSesion) { %>
			                                    <div class="col">
			                                        <table class="table table-borderless">
			                                            <tbody>
			                                                <tr>
			                                                    <td>$ <%=inscripciones.get(dtsalida.getNombre()).getCostoInscripcion()%></td>
			                                                </tr>
			                                            </tbody>
			                                        </table>
			                                    </div>
			                                    <div class="col">
			                                        <table class="table table-borderless">
			                                            <tbody>
			                                                <tr>
			                                                    <td><%=inscripciones.get(dtsalida.getNombre()).getCantTuristas()%> turista/s</td>
			                                                </tr>
			                                            </tbody>
			                                        </table>
			                                    </div>
			                                   <% } %>
			                                </div>
			                            </div>
			                        </div>
			                    	</a>
			                    <%}%>
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