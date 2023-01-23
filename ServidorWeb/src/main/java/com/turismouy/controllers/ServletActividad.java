package com.turismouy.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.w3c.dom.events.EventException;

import com.turismouy.generados.ActividadRepetidaException_Exception;
import com.turismouy.generados.DtActividadTuristica;
import com.turismouy.generados.DtActividades;
import com.turismouy.generados.DtCategoria;
import com.turismouy.generados.DtCategorias;
import com.turismouy.generados.DtDepartamento;
import com.turismouy.generados.DtDepartamentos;
import com.turismouy.generados.Publicador;
import com.turismouy.generados.PublicadorService;


/**
 * Servlet implementation class ServletActividad
 */
@WebServlet("/actividades")
public class ServletActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ActividadRepetidaException_Exception {
        String nombreActividad = request.getParameter("nombreActividad");
        String nombreDepartamento = request.getParameter("departamento");
        String nombreCategoria = request.getParameter("categoria");
        
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
        
        if(nombreActividad == null) { // no se seteó la actividad (lista todos las actividades)
            
            DtDepartamentos deptos = port.obtenerDTDepartamentos();
            List<DtDepartamento> dtDeptos = deptos.getDepartamentos();
            request.setAttribute("dtDeptos", dtDeptos);
            
            DtCategorias categorias = port.obtenerDTCategorias();
            List<DtCategoria> dtCategorias = categorias.getCategorias();
            request.setAttribute("dtCategorias", dtCategorias);
            
            //request.setAttribute("nombreDepartamento", nombreDepartamento);
            //request.setAttribute("nombreCategoria" , nombreCategoria);
            
            if (nombreDepartamento == null && nombreCategoria == null) {
                DtActividades actividades = port.obtenerDTActividadesConfirmadas();
                List<DtActividadTuristica> dtActividades = actividades.getActividades();
                request.setAttribute("dtActividades", dtActividades);
                request.getRequestDispatcher("/WEB-INF/actividades/listarActividades.jsp").forward(request, response);
            }
            else if (nombreDepartamento != null) {
                DtActividades actividades = port.obtenerDTActividadesConfirmadasDepto(nombreDepartamento);
                List<DtActividadTuristica> dtActividades = actividades.getActividades();
                request.setAttribute("dtActividades", dtActividades);
                request.getRequestDispatcher("/WEB-INF/actividades/listarActividades.jsp").forward(request, response);
            }
            
            else if (nombreCategoria != null) {
                DtActividades actividades = port.obtenerDTActividadesConfirmadasCategoria(nombreCategoria);
                List<DtActividadTuristica> dtActividades = actividades.getActividades();
                request.setAttribute("dtActividades", dtActividades);
                request.getRequestDispatcher("/WEB-INF/actividades/listarActividades.jsp").forward(request, response);
            }
                
        } else { // ve la actividad seleccionada
            DtActividadTuristica dtActividad;
            try {
                dtActividad = port.obtenerDTActividadTuristica(nombreActividad);
                request.setAttribute("dtActividad", dtActividad);
                request.getRequestDispatcher("/WEB-INF/actividades/consultaActividad.jsp").forward(request, response);
            } catch(EventException ex){ //aca va un catch si no encuentra la actividad todo
                response.sendError(404); // el usuario no existe
                request.getRequestDispatcher("/WEB-INF/errorPages/404.jsp").
                        include(request, response);
            }
            
            // setea la actividad

           
        }
    }
    



    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //outPrintWriter.print("antes de invocar");
            procesarPedido(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ActividadRepetidaException_Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
