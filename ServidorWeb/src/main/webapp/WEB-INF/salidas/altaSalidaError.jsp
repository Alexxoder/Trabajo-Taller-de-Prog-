<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map" %>
<%@page import= "src.logica.datatypes.DTDepartamento" %>
<%@page import= "src.logica.datatypes.DTActividadTuristica" %>
<%@page import= "src.logica.clases.IActividad" %>
<%@page import= "src.logica.clases.Fabrica" %>
<!DOCTYPE html>
<html lang="es">

<head>
<jsp:include page="/WEB-INF/template/head.jsp"></jsp:include>
<title>Consultar Salida</title>
</head>
<body>
<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>

    <div class="container-fluid mt-3">
        <div class="row">
            <!-- navegacion izquierda -->
            <div class="col-3">
                <div class="list-group d-flex ">
                    <h5 class="list-group-item ">Navegacion</h5>
                    <a class="list-group-item btn btn-primary " href="/ServidorWeb/salidas">Consultar Salidas Turísticas</a>
                    <a class="list-group-item btn btn-primary " href="/ServidorWeb/actividades">Consultar Actividades Turísticas</a>
                </div>
                
            </div>

            <div class="col-9 mt-3">

                    <div class="form-group mb-3">
                    	<div class="alert alert-danger" role="alert">
                                   <p>Debe ingresar una fecha posterior a la Actividad o la Salida ya esta Ingresada</p>
                        </div>                  
                        <label for="departamentos">Selecionar Departamento: *</label>
                        <form  action="/ServidorWeb/altaSalida">
                        <select name="departamento" id="departamento">                                              
                        	<% 
                 	 			Map<String,DTDepartamento> deptos = (Map<String,DTDepartamento>)request.getAttribute("colDeptos");
                 	 			if (!deptos.isEmpty())
                  				for(Map.Entry<String,DTDepartamento> dtDepto:deptos.entrySet()) {               
                			
                			
                			if (request.getParameter("departamento") != null)
                			{         			
                			if (dtDepto.getValue().getNombreDepto().equals(request.getParameter("departamento")))
                			{
                			%>
                			<option value="<%= dtDepto.getValue().getNombreDepto()%>" selected> <%= dtDepto.getValue().getNombreDepto()%></option>
                            <%}else{%>
                            <option value="<%= dtDepto.getValue().getNombreDepto()%>"> <%= dtDepto.getValue().getNombreDepto()%></option>
                            <%}}else{ %>
                            <option value="<%= dtDepto.getValue().getNombreDepto()%>"> <%= dtDepto.getValue().getNombreDepto()%></option>
                            <%}} %>                                                                      
                        </select>
                        <input type="submit" name="seleccionar"> 
                    	</form>                    	
                                                              
                    </div>
                    
                    <form  action="/ServidorWeb/altaSalida">
                    <div class="form-group mb-3">                    
                        <label for="actividad">Selecionar Actividad: *</label>
                        <select name="actividad" id="actividades">
                        	<option> seleccione una actividad</option>
                        	<% 
                            	Map<String,DTActividadTuristica> acts = (Map<String,DTActividadTuristica>) request.getAttribute("colActividades");
                 	 			if (acts != null)
                  				for(Map.Entry<String,DTActividadTuristica> dtAct:acts.entrySet()) {               
                			%>
                            <option value="<%= dtAct.getValue().getNombre()%>"> <%= dtAct.getValue().getNombre()%></option>
                            <%} %>
                        </select>
                         
                    </div>
                    
                    <label for="datosSalida">Datos de la Salida:</label>
                    <div class="form-group mb-3">
                        <label for="nombre">Nombre: *</label>
                        <input type="text" class="form-control" name="nombre" id="nombre" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="fecha">Fecha: *</label>
                        <input type="date" class="form-control" name="fecha" id="fecha" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="hora">Hora: *</label>
                        <input type="time" class="form-control" name="hora" id="hora" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="lugar">Lugar de Salida: *</label>
                        <input type="text" class="form-control" name="lugar" id="lugar" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="topeTuristas">Cantidad Máxima de Turistas: *</label>
                        <input type="number" class="form-control" name="topeTuristas" id="topeTuristas" min="0" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="imagen">Imagen: </label>
                        <input type="text" class="form-control" name="imagen" id="imagen">
                    </div>
                    
                    <div class="row px-2">
                        <button type="submit" class="btn btn-primary mt-3" name="ingresar" id="ingresar">Ingresar</button>
                    </div>
                    </form>
                    
                    <span>(*) Campos Obligatorios.</span>
            </div>
        </div>
	</div>>
</body>

</html>
