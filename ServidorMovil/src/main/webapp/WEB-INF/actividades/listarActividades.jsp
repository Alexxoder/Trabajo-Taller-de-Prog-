<%@page import="com.turismouy.generados.DtCategoria"%>
<%@page import="com.turismouy.generados.DtDepartamento"%>
<%@page import="com.turismouy.generados.DtActividadTuristica"%>
<%@page import= "com.turismouy.generados.DtUsuarioExtendido" %>
<%@page import= "com.turismouy.generados.DtProveedorExtendido" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actividades</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
          <a class="nav-link" href="/ServidorMovil/inicio">
            <span class="navbar.text h1 text-primary">Turismo<span class="navbar.text h1 text-light">.uy</span></span>
        </a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="/ServidorMovil/actividades">Actividades</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/ServidorMovil/salidas">Salidas</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/ServidorMovil/logOut">Salir</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <div class="d-flex align-items-center highlight-toolbar bg-dark ps-3 pe-2 py-1">
        <medium class="font-monospace text-muted text-uppercase">Ver Actividades</medium>
      </div>

      <div class="container-fluid mt-3">
        <div class="row">
          <div class="col p-0">
            <div class="dropdown">
              <button class="btn btn-secondary dropdown-toggle w-100 m-0" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                Departamentos
              </button>
              <ul class="dropdown-menu">
              <%
				List<DtDepartamento> dtDeptos = (List<DtDepartamento>) request.getAttribute("dtDeptos");
                if (dtDeptos != null)
                   for (DtDepartamento dtDepto : dtDeptos) {
                   %>
                   <li><a class="dropdown-item" href="?departamento=<%= dtDepto.getNombreDepto() %>"><%= dtDepto.getNombreDepto() %></a></li>
                   <%
                     }
                    %>
              </ul>
            </div>
          </div>
          <div class="col p-0">
            <div class="dropdown">
              <button class="btn btn-secondary dropdown-toggle w-100 m-0" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                Categorias
              </button>
              <ul class="dropdown-menu">
               <%
				List<DtCategoria> dtCategorias = (List<DtCategoria>) request.getAttribute("dtCategorias");
                if (dtCategorias != null)
                   	for (DtCategoria dtCategoria : dtCategorias) {
               %>
               <li><a class="dropdown-item" href="?categoria=<%= dtCategoria.getNombre() %>"><%= dtCategoria.getNombre() %></a></li>
               <%
                 }
                %>
                </ul>
            </div>
          </div>
        </div>

		
                <div class="col-sm-9">
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
                                        <div class="col-sm-9">
                                            <a class="col-sm-6 link-dark text-decoration-none" href="?nombreActividad=<%= dtActividad.getNombre() %>">
                                                <div class="row mt-3">
                                                    <div class="col-sm-6">
                                                    <% if (dtActividad.getImagen() != null) { %>
                                                        <img class="img-fluid" src="<%=dtActividad.getImagen()%>" alt="<%= dtActividad.getNombre() %>"> 
                                                    <% } else { %>
                                                        <img src ="https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded" alt="imagen no existente">
                                                    <% } %>
                                                    </div>
                                                    <div class="col-sm">
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

</body>
</html>