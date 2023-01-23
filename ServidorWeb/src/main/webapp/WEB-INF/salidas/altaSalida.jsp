<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map" %>
<%@page import= "com.turismouy.generados.DtDepartamento" %>
<%@page import= "com.turismouy.generados.DtActividadTuristica" %>
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
                        <label for="departamentos">Selecionar Departamento: *</label>
                        <form  action="/ServidorWeb/altaSalida">
                        <select name="departamento" id="departamento">                                              
                        	<% 
                 	 			List<DtDepartamento> deptos = (List<DtDepartamento>)request.getAttribute("colDeptos");
                 	 			if (!deptos.isEmpty())
                  				for(DtDepartamento dtDepto : deptos) {               
                			
                			
                			if (request.getParameter("departamento") != null)
                			{         			
                			if (dtDepto.getNombreDepto().equals(request.getParameter("departamento")))
                			{
                			%>
                			<option value="<%= dtDepto.getNombreDepto()%>" selected> <%= dtDepto.getNombreDepto()%></option>
                            <%}else{%>
                            <option value="<%= dtDepto.getNombreDepto()%>"> <%= dtDepto.getNombreDepto()%></option>
                            <%}}else{ %>
                            <option value="<%= dtDepto.getNombreDepto()%>"> <%= dtDepto.getNombreDepto()%></option>
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
                            	List<DtActividadTuristica> acts = (List<DtActividadTuristica>) request.getAttribute("colActividades");
                 	 			if (acts != null)
                  				for(DtActividadTuristica dtAct : acts) {               
                			%>
                            <option value="<%= dtAct.getNombre() %>"> <%= dtAct.getNombre() %></option>
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
