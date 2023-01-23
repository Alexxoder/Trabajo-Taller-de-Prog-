<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "com.turismouy.generados.DtUsuarioExtendido" %>
<header class="border-bottom border-primary">
<div id="header">
	 <div class="container-fluid">
	 <%
	 DtUsuarioExtendido user = (DtUsuarioExtendido) session.getAttribute("usuario_logueado");
	 if (user == null) { %>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link fw-semibold" href="/ServidorWeb/login">Iniciar Sesion</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fw-semibold" href="/ServidorWeb/registro">Registrarse</a>
                </li>
            </ul>
            <%}else{%>
               <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link fw-semibold" href="/ServidorWeb/usuarios?usuario=<%= user.getNickname() %>"><%= user.getNombre() %> <%= user.getApellido() %> 
						<img src=<%=user.getImagen()%> width="25" height="25" alt="">
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fw-semibold" href="/ServidorWeb/logOut">Cerrar Sesión</a>
                </li>
            </ul>
            <%} %>
            <nav class="navbar navbar-expand-sm affix">
                <a class="nav-link" href="/ServidorWeb/inicio">
                    <span class="navbar.text h1">Turismo<span class="navbar.text h1 text-primary">.uy</span></span>
                </a>
                <ul class="navbar-nav">
                    <li class="nav-item m-2">
                        <a class="nav-link fw-semibold" href="/ServidorWeb/usuarios">Usuarios</a>
                    </li>
                    <li class="nav-item m-2">
                        <a class="nav-link fw-semibold" href="/ServidorWeb/actividades">Actividades</a>
                    </li>
                    <li class="nav-item m-2">
                        <a class="nav-link fw-semibold" href="#">Paquetes</a>
                    </li>
                    <li class="nav-item m-2">
                        <a class="nav-link fw-semibold" href="/ServidorWeb/salidas">Salidas</a>
                    </li>
                </ul>
                <form class="navbar-form container-fluid" action="#">
                    <div class="input-group-md flex-grow-1 m-2">
                        <input class="form-control" type="text" placeholder="Buscar">
                    </div>
                    <button class="btn btn-primary" type="submit">Buscar</button>
                </form>
            </nav>
        </div>
</div>
</header>