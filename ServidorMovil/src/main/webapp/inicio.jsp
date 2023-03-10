<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio</title>
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

    <div class="container-fluid mt-3">
      <a class=" col-6 link-dark text-decoration-none" href="/ServidorMovil/actividades">
        <div class="row">
            <div class="col-sm-3">
                <img class="img-fluid" src="https://s3.amazonaws.com/turismorocha/eventos/2569/cover/degusta-048968300-1659558891.jpg" alt="comida">
            </div>
            <div class="col-sm-9 mb-3 mt-1">
                <h3>Actividades</h3>
                <p class="col-sm-9">
                    Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno est??ndar de las industrias desde el a??o 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido us??
                    una galer??a de textos y los mezcl?? de tal manera que logr?? hacer un libro de textos especimen.
                </p>
            </div>
        </div>
      </a>

      <a class=" col-6 link-dark text-decoration-none" href="/ServidorMovil/salidas">
        <div class="row">
            <div class="col-sm-3">
                <img class="img-fluid" src="https://s3.amazonaws.com/turismorocha/operadores/1/med/bahia-resto-053888900-1458674720.JPG" alt="comida">
            </div>
            <div class="col-sm-9 mb-3 mt-1">
                <h3>Salidas</h3>
                <p class="col-sm-9">
                    Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno est??ndar de las industrias desde el a??o 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido us??
                    una galer??a de textos y los mezcl?? de tal manera que logr?? hacer un libro de textos especimen.
                </p>
            </div>
        </div>
      </a>
    </div>
</body>
</html>