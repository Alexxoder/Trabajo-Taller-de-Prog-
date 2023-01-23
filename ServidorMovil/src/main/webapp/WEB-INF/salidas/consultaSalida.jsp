<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.turismouy.generados.DtSalidaTuristica"%>
<%@page import="java.util.List"%>
<%@page import="com.turismouy.generados.DtActividadTuristica"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consultar Salida</title>
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
        <medium class="font-monospace text-muted text-uppercase">Ver Salidas</medium>
      </div>

      <div class="container-fluid mt-3">
        <div class="col">
          <div class="row justify-content-center mt-5">
              <div class="col-sm-3">
							<%DtSalidaTuristica dtSalida = (DtSalidaTuristica) request.getAttribute("dtSalida");%>
                        	<% if (dtSalida.getImagen() != null) {
                        	%>
                            <img src = <%= dtSalida.getImagen() %> class="img-fluid rounded">
                            <% } else {
                            	%>
                            <img src = "https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded">
                            
                            <% } %>              </div>
              <div class="col-sm-6">
                       <h2><%= dtSalida.getNombre() %></h2>
              </div>
          </div>
          <div class="row justify-content-center">
            <br>
            <div class="col-sm-9">
              <h6>Cantidad máxima de turistas: <%= dtSalida.getTopeTuristas() %> </h6>
			  <h6>Cupos Disponibles:<%= dtSalida.getCuposDisponibles() %> </h6>
              <h6>Fecha De Salida: <%= dtSalida.getFechaSalida() %> </h6>
              <h6>Hora: <%= dtSalida.getHoraSalida() %> </h6>
		      <h6>Lugar: <%= dtSalida.getLugarSalida() %> </h6>
              <h6>Fecha De Alta: <%= dtSalida.getFechaAlta() %> </h6>
            </div>
          </div>
        </div>
      </div>
</body>
</html>