<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map" %>
<%@page import= "com.turismouy.generados.DtUsuario" %>
<%@page import= "com.turismouy.generados.DtTurista" %>
<%@page import= "com.turismouy.generados.DtProveedor" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/template/head.jsp"></jsp:include>
    <title>Usuarios</title>
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
                </div>

            </div>
            <div class="col-9">
                <div>
                    <h1>Consulta De Usuario</h1>
                </div>

                <div class="list-group">
                <% 
                  List<DtUsuario> usuarios = (List<DtUsuario>)request.getAttribute("colUsuarios");
                  if (!usuarios.isEmpty())
                  for(DtUsuario dtUsuario : usuarios) {               
                %>
                    <div class="row">
                        <div class="col">                        	
                            <a href="?usuario=<%= dtUsuario.getNickname() %>"  class="list-group-item list-group-item-action">                          
                                <div class="row">
                                    <div class="col-2">
                                    <% if (dtUsuario.getImagen() != null){
                                    %>
                                        <img class="img-fluid" src="<%= dtUsuario.getImagen() %>">
                                    <% }
                                     else {
                                    %> <img src = "https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded" alt="imagen no existente">
                        			<% } %>
                                     
                                    </div>
                                    <div class="col">
                                        <h5 class="mb-1"><%= dtUsuario.getNickname() %></h5>
                                        <h6 class="mb-1"><%= dtUsuario.getNombre() %></h6>
                                        <h6 class="mb-1"><%= dtUsuario.getApellido() %></h6>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
               <% } %>



                </div>

            </div>


        </div>

    </div>
</body>
</html>
