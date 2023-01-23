package com.turismouy.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.events.EventException;

import com.turismouy.generados.DtActividadTuristica;
import com.turismouy.generados.DtActividades;
import com.turismouy.generados.DtSalidaTuristica;
import com.turismouy.generados.DtSalidas;
import com.turismouy.generados.Publicador;
import com.turismouy.generados.PublicadorService;

/**
 * Servlet implementation class ServletSalidas
 */
@WebServlet("/salidas")
public class ServletSalidas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalidas() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void redirigirASalidas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            String nombreSalida = request.getParameter("nombreSalida");
            String nombreActividad = request.getParameter("actividad");


            PublicadorService service = new PublicadorService();
            Publicador port = service.getPublicadorPort();

            if(nombreSalida == null) {// no se seteó la salida (lista todos las salidas)
                DtActividades dtActividadesPort = port.obtenerDTActividades();
                List<DtActividadTuristica> dtActividades = dtActividadesPort.getActividades();
                request.setAttribute("dtActividades", dtActividades);
                
                if (nombreActividad == null) {
                    DtSalidas dtSalidasPort = port.obtenerDTSalidas();
                    List<DtSalidaTuristica> dtSalidas = dtSalidasPort.getSalidas();
                    request.setAttribute("dtSalidas", dtSalidas);
                }
                else {
                    DtSalidas dtSalidasPort = port.obtenerDTSalidasTuristicas(nombreActividad);
                    List<DtSalidaTuristica> dtSalidas = dtSalidasPort.getSalidas();
                    request.setAttribute("dtSalidas", dtSalidas);
                }
                
                request.getRequestDispatcher("/WEB-INF/salidas/listarSalidas.jsp").forward(request, response);
                    
            } else {
                // ve la salida seleccionada
                DtSalidaTuristica dtSalida;
                try {
                    
                    dtSalida = port.obtenerDTSalidaTuristica(nombreSalida);
                    request.setAttribute("dtSalida", dtSalida);
                    request.getRequestDispatcher("/WEB-INF/salidas/consultaSalida.jsp").forward(request, response);
                } catch(EventException ex){ //aca va un catch si no encuentra la actividad todo
                    response.sendError(404); // el usuario no existe
                    request.getRequestDispatcher("/WEB-INF/errorPages/404.jsp").
                            include(request, response);
                }
                

               
            }
        }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		redirigirASalidas(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
