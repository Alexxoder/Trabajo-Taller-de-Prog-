<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
<jsp:include page="/WEB-INF/template/head.jsp"></jsp:include>
<title>Registro de Usuario</title>
</head>

<body>
<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>

	<div class="container-fluid mt-3">
        <div class="row">
            <!--  aca se ponen los filtros de departamentos y categorias y navegacion -->
            <div class="col-3 ">
                <div class="list-group d-flex ">
                    <h5 class="mb-3">Navegacion</h5>
                    <a href="/ServidorWeb/usuarios" class="list-group-item btn btn-primary ">Usuarios</a>
                </div>
            </div>
            <div class="col-9">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <form class="form-control" method="post" action="/ServidorWeb/registro">
                                <h1>Registrarse</h1>
                                <div class="alert alert-danger" role="alert"> 
                                    <p>El NickName o el Correo Electrónico ya están registrados.</p>
                                </div>
                                <div class="form-group mt-1">
                                    <label class="form-label" for="usuario">Nickname: *</label>
                                    <input type="text" class="form-control" name="nickname" id="nickname" placeholder="Ej: eleven11" required>
                                </div>
                                <div class="form-group mt-1">
                                    <label class="form-label" for="email">Correo electrónico: *</label>
                                    <input type="email" class="form-control" name="email" id="email" required>
                                </div>
                                <div class="form-group mt-1">
                                    <label class="form-label" for="contrasenia">Contraseña: *</label>
                                    <input type="password" class="form-control" name="contrasenia" id="contrasenia" required>
                                </div>
                                <div class="form-group mt-1">
                                    <label class="form-label" for="confContrasenia">Confirmar contraseña: *</label>
                                    <input type="password" class="form-control" name="confContrasenia" id="confContrasenia" required>
                                </div>
                                <div class="form-group mt-1">
                                    <label class="form-label" for="nombre">Nombre: *</label>
                                    <input type="text" class="form-control" name="nombre" id="nombre" required>
                                </div>
                                <div class="form-group mt-1">
                                    <label class="form-label" for="apellido">Apellido: *</label>
                                    <input type="text" class="form-control" name="apellido" id="apellido" required>
                                </div>
                                <div class="form-group mt-1">
                                    <label class="form-label" for="fechaNac">Fecha de nacimiento: *</label>
                                    <input type="date" class="form-control" name="fechaNac" id="fechaNac" required>
                                </div>
                                <div class="form-group mt-1">
                                    <label class="form-label" for="imagen">Imagen de Usuario:</label>
<!--                                     <input class="form-control file-upload-input" type="file" onchange="readURL(this)" accept="Image/*"> -->
									 <input type="url" class="form-control" name="imagen" id="imagen"> <br/>
                                </div>

                                <div class="form mt-1">
                                    <label class="form-label" for="">Tipo de Usuario:</label>
                                    <label class="form-check-label" for="porveedor">Proveedor</label>
                                    <input class="form-check-input" type="radio" onclick ="mostrarOcultarDiv(1)" name="tipoUsuario" id="proveedor" value="Proveedor">
                                    <label class="form-check-label" for="turista">Turista</label>
                                    <input class="form-check-input" type="radio" onclick = "mostrarOcultarDiv(2)" name="tipoUsuario" id="turista" value="Turista">
                                </div>

                                <div class="d-none form-group mt-1" id="divTurista">
                                    <label for="nacionalidad">Nacionalidad: *</label>
                                    <input type="text" class="form-control" name="nacionalidad" id="nacionalidad" >
                                </div>

                                <div id="divProveedor" class="d-none">
                                    <div class="form-group mt-1">
                                        <label for="descripcion">Descripción general: *</label>
                                        <input type="text" class="form-control" name="descripcion" id="descripcion" >
                                    </div>
                                    <div class="form-group mt-1">
                                        <label for="link">Sitio web: </label>
                                        <input type="url" class="form-control" name="link" id="link">
                                    </div>
                                </div>

                                <div class="row justify-content-center">
                                    <div class="col-5">
                                        <button type="submit" class="btn btn-primary mt-3" id="registrarsebtn">Completar registro</button>
                                    </div>
                                </div>
                                    <p>(*) Campos obligatorios.</p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src = "scripts.js"></script>
    <script>
    function mostrarOcultarDiv(val) {

            if (val == 1) {
            	document.getElementById('divTurista').className="d-none form-group mt-1"
                document.getElementById('nacionalidad').removeAttribute('required')
                document.getElementById('divProveedor').className="d-block"
                document.getElementbyId('descripcion').setAttribute('required','')
                
            }
            if (val == 2) {
                document.getElementById('divProveedor').className="d-none"
                document.getElementById('descripcion').removeAttribute('required')
                document.getElementById('divTurista').className="d-block form-group mt-1"
                document.getElementbyId('nacionalidad').setAttribute('required','')
            }
        }
    </script>
</body>
</html>