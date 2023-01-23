package com.turismouy.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turismouy.generados.DtActividadTuristica;
import com.turismouy.generados.DtUsuarioExtendido;
import com.turismouy.generados.Publicador;
import com.turismouy.generados.PublicadorService;
import com.turismouy.generados.SalidasVigentesException_Exception;


/**
 * Servlet implementation class ServletFinalizarActividad
 */
@WebServlet("/finalizarActividad")
public class ServletFinalizarActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFinalizarActividad() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actividad = request.getParameter("actividad");
        String nombreActividad = request.getParameter("nombreActividad");
        //Fabrica fabrica = new Fabrica();
        //IActividad controlActividad = fabrica.getIActividad();
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

        if(actividad == null) {
            try {
                
                port.finalizarActividad(nombreActividad);
                response.sendRedirect("/ServidorWeb/actividades");
            } catch (SalidasVigentesException_Exception e) {
                // TODO Auto-generated catch block
                request.setAttribute("salidasVigentes", true);
                DtUsuarioExtendido usrLogueado = (DtUsuarioExtendido) request.getSession().getAttribute("usuario_logueado");
                response.sendRedirect("/ServidorWeb/usuarios?usuario=" + usrLogueado.getNickname());
                }
        }
        else {
            DtActividadTuristica dtActividad = port.obtenerDTActividadTuristica(actividad);
            request.setAttribute("dtActividad", dtActividad);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/actividades/finalizarActividad.jsp");
            dispatcher.forward(request, response);        
            }
        
        }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesarPedido(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
