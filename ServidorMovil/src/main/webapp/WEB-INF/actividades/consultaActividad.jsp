<%@page import="com.turismouy.generados.DtSalidaTuristica"%>
<%@page import="java.util.List"%>
<%@page import="com.turismouy.generados.DtActividadTuristica"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consulta de Actividad</title>
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
        <div class="col">
          <!-- aca se muestran la actividad -->
                <div class="row">
                    <div class="list-group">
                        <div class="list-group-item">
                            <div class="row">
                                <div class="col">
                                    <a class=" col-6 link-dark text-decoration-none" href="#">
                                        <div class="row">
                                            <div class="col-sm-6">
                                            <%DtActividadTuristica dtActividad =(DtActividadTuristica) request.getAttribute("dtActividad");%>
                                                <%if(dtActividad.getImagen() != null){ %>
                                                        <img class="img-fluid " src=<%=dtActividad.getImagen()%> alt=<%=dtActividad.getNombre()%>> 
                                                        <%}else{ %>
                                                        <img src = "https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded" alt="imagen no existente">
                                                 <%} %>
                                            </div>
                                            <div class="col-sm-6 mt-1 ">                                            
                                                <h3><%=dtActividad.getNombre()%></h3>
                                                <p><%=dtActividad.getDescripcion()%></p>
                                                <p>Duración: <%=dtActividad.getDuracion()%> Horas</p>
                                                <p>Costo: $<%=dtActividad.getCosto()%></p>
                                                <p>Ciudad: <%=dtActividad.getCiudad()%></p>
                                                <p>Fecha de Alta: <%= dtActividad.getFechaDeAltaString() %></p>
                                            </div>
                                        </div>
                                    </a>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <h3>Salidas</h3>
                    <!-- salidas -->
                    <%List<DtSalidaTuristica>colsalidas = dtActividad.getListaSalidas();
                    if(!colsalidas.isEmpty())
                    	for(DtSalidaTuristica dtsalida: colsalidas){
                    %>
                    <a class="link-dark text-decoration-none" href="/ServidorMovil/salidas?nombreSalida=<%=dtsalida.getNombre()%>">
                        <div class="row">
                            <div class="col-5 col-sm-4 mt-2">
                                <% if (dtsalida.getImagen() != null) {
                        		%>
                            	<img src = <%= dtsalida.getImagen() %> class="img-fluid rounded" alt = <%=dtsalida.getNombre()%>>
                            	<% } else {
                            	%>
                            	<img src = "https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg" class="img-fluid rounded" alt="imagen no existente">
                            	
                            	<% } %>   
                            </div>
                            <div class="col col-sm-4 mt-2 ">
                                <h5><%= dtsalida.getNombre() %></h5>
                                <p>Fecha: <%= dtsalida.getFechaSalida() %></p>
                                <p>Hora: <%= dtsalida.getHoraSalida() %>hs</p>
                                <p>Lugar: <%= dtsalida.getLugarSalida() %></p>
                                <br>
                            </div>

                        </div>
                    </a>
					<%} %>
                </div>
      </div>
      </div>

</body>
</html>