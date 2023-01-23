<%@page import="com.turismouy.generados.DtCategoria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp"></jsp:include>
<title>AltaActividad</title>
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
                    <a href="/ServidorWeb/actividades" class="list-group-item btn btn-primary ">Actividades</a>
                </div>

            </div>

            <div class="col-9">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <form method="post" action="/ServidorWeb/altaActividad" class="form-control">
                                <h1> Nueva actividad</h1>
                                <div class="form-group mb-3">
                                    <label class="form-label" for="departamento"> Departamento: *</label>

                                    <select name="departamento" class="form-select" aria-label="Selección por defecto" required>
                                            <option value="Montevideo" selected>Montevideo</option>
                                            <option value="Canelones">Canelones</option>
                                            <option value="Maldonado">Maldonado</option>
                                            <option value="Rocha">Rocha</option>
                                            <option value="Treinta y Tres">Treinta y tres</option>
                                            <option value="Rivera">Rivera</option>
                                            <option value="Artigas">Artigas</option>
                                            <option value="Salto">Salto</option>
                                            <option value="Paysandú">Paysandú</option>
                                            <option value="Durazno">Durazno</option>
                                            <option value="Flores">Flores</option>
                                            <option value="Florida">Florida</option>
                                            <option value="Tacuarembó">Tacuarembó</option>
                                            <option value="Río Negro">Río Negro</option>
                                            <option value="Colonia">Colonia</option>
                                            <option value="Soriano">Soriano</option>
                                            <option value="Lavalleja">Lavalleja</option>
                                            <option value="San José">San José</option>
                                            <option value="Cerro Largo">Cerro Largo</option>
                                        </select><br/>
                                </div>

                                <div class="form-group mb-3">
                                    <label class="form-label" for="actividad"> Nombre de la actividad: *</label>
                                    <input type="text" class="form-control" name="actividad" id="actividad" placeholder="Ej: Paseo por las grutas" required><br/>
                                </div>
                                <div class="form-group mb-3">
                                    <label class="form-label" for="descripcion"> Descripción de la actividad: *</label>
                                    <input type="text" class="form-control" name="descripcion" id="descripcion" required> <br/>
                                </div>
                                <div class="form-group mb-3">	
                                    <label class="form-label" for="duracion"> Duración (horas): *</label>
                                    <input type="number" class="form-control" name="duracion" id="duracion" required> <br/>
                                </div>
                                <div class="form-group mb-3">
                                    <label class="form-label" for="costo"> Costo ($U): *</label>
                                    <input type="number" class="form-control" name="costo" id="costo" min="1" required><br/>
                                </div>
                                <div class="form-group mb-3">
                                    <label for="ciudad"> Ciudad: *</label>
                                    <input type="text" class="form-control" name="ciudad" id="ciudad" required> <br/>
                                </div>
<!--                                 //Opcional -->
<!--                                 <div class="form-group mb-3"> -->
<!--                                     <label class="form-label" for="imagen">Imagen de Actividad:</label> -->
<!--                                     <input class="form-control" class="file-upload-input" type="file" onchange="readURL(this)" accept="Image/*"> <br/> -->
<!--                                 </div> -->
								<div class="form-group mb-3">
                                    <label for="imagen">URL de la Imagen:</label>
                                    <input type="url" class="form-control" name="imagen" id="imagen"> <br/>
                                </div>

                                <div class="form-group mb-3">
                                    
                                    <label class="form-label" for="categorias">Categorías asociadas: * (presione ctrl y click para seleccionar varias)</label>
                                    <select name="categorias" id="categorias" multiple required>
                                    <% 
                                    List<DtCategoria> dtCategorias = (List<DtCategoria>) request.getAttribute("dtCategorias");
                                    if(dtCategorias != null){
                                    for (DtCategoria categoria: dtCategorias){	            
                                    %>
                                    <option value="<%=categoria.getNombre() %>"><%=categoria.getNombre() %>></option>
                                    <%}} %>
									</select> 
									
                                </div>

                                <div class="row justify-content-center">
                                    <div class="col-5">
                                        <button type="submit" class="btn btn-primary mt-3" id="registrarsebtn"> Completar registro</button>
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
</body>
</html>