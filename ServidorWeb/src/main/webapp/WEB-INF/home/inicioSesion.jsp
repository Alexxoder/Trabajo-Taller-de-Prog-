<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
<jsp:include page="/WEB-INF/template/head.jsp"></jsp:include>
<title>Inicio Sesión</title>
</head>
<body>
<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
    <div class="container outercont mt-3">
        <div class="row justify-content-center mt-5">
            <div class="col-4">
                <div class="card">
                    <div class="card-body">
                        <form method="POST" action="/ServidorWeb/login">
                            <div class="form-group mb-3">
                                <label for="usuario">NickName o Mail: </label>
                                <input type="text" class="form-control" name="usuarioid" id="usuarioid" placeholder="Ej: eleven11 o eleven11@gmail.com" required>
                                <div class="valid-feedback">Looks good!</div>
                            </div>
                            <div class="form-group mb-3">
                                <label for="contrasenia">Contraseña: </label>
                                <input type="password" class="form-control" name="contrasenia" id="contrasenia" required>
                            </div>
                            <div class="rememberpass">
                                <input type="checkbox" class="form-check-input" name="recordar" id="recordar"> Recordarme
                            </div>
                            <div class="row px-2">
                                <button type="submit" class="btn btn-primary mt-3" name="accederBtn" id="accederBtn">Acceder</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>