package com.turismouy.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turismouy.generados.DtActividadTuristica;
import com.turismouy.generados.DtActividades;
import com.turismouy.generados.DtDepartamento;
import com.turismouy.generados.DtDepartamentos;
import com.turismouy.generados.DtSalidaTuristica;
import com.turismouy.generados.ExcepcionAltaSalida_Exception;
import com.turismouy.generados.Publicador;
import com.turismouy.generados.PublicadorService;


/**
 * Servlet implementation class ServletSalida
 */
@WebServlet("/altaSalida")
public class ServletAltaSalida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAltaSalida() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    protected void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException{
        String dpto = request.getParameter("departamento");
        //Fabrica fabrica = new Fabrica();
        //IActividad controlA = fabrica.getIActividad();
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

        DtDepartamentos dtDeptos = port.obtenerDTDepartamentos();
        List<DtDepartamento> deptos = dtDeptos.getDepartamentos();
        request.setAttribute("colDeptos", deptos);
        if(dpto != null){
            String depto = request.getParameter("departamento");
            DtActividades dtActividades = port.obtenerDTActividadesConfirmadasDepto(depto);
            List<DtActividadTuristica> actividades = dtActividades.getActividades();
            request.setAttribute("colActividades", actividades);
        }
        if((request.getParameter("nombre") != null) & (request.getParameter("fecha") != null) & (request.getParameter("hora") != null) & (request.getParameter("lugar") != null) & (request.getParameter("topeTuristas") != null))
        {
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //LocalDate fechaSalida = LocalDate.parse(request.getParameter("fecha"), formatter);
            //formatter = DateTimeFormatter.ofPattern("HH:mm");
            //LocalTime horaSalida = LocalTime.parse(request.getParameter("hora"), formatter);
            
            //creo el DtSalidaTuristica a ingresar y le seteo los valores necesarios
            DtSalidaTuristica salidaNueva = new DtSalidaTuristica();
            salidaNueva.setCuposDisponibles(Integer.valueOf(request.getParameter("topeTuristas")));
            //salidaNueva.setFechaAlta(LocalDate.now());
            salidaNueva.setFechaSalidaString(request.getParameter("fecha"));
            salidaNueva.setHoraSalidaString(request.getParameter("hora"));
            //salidaNueva.setImagen(request.getParameter("imagen"));
            salidaNueva.setLugarSalida(request.getParameter("lugar"));
            salidaNueva.setNombre(request.getParameter("nombre"));
            salidaNueva.setTopeTuristas(Integer.valueOf(request.getParameter("topeTuristas")));
            try {
                port.ingresarDatosSalidaTuristica(request.getParameter("actividad"), salidaNueva);
            } catch (NumberFormatException event) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/salidas/altaSalidaError.jsp");
                dispatcher.forward(request, response);
            } catch (ExcepcionAltaSalida_Exception e) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/salidas/altaSalidaError.jsp");
                dispatcher.forward(request, response);
            }
            if(request.getParameter("imagen") != null)
            {              
               DtSalidaTuristica dtSalida =  port.obtenerDTSalidaTuristica(request.getParameter("nombre"));
               dtSalida.setImagen(request.getParameter("imagen"));
            }
            response.sendRedirect("/ServidorWeb/salidas");

            
        }else {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/salidas/altaSalida.jsp");
        dispatcher.forward(request, response);
        }
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           procesar(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    procesar(request, response);
	}

}
