package com.turismouy.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turismouy.generados.DtActividadTuristica;
import com.turismouy.generados.DtActividades;
import com.turismouy.generados.DtCategoria;
import com.turismouy.generados.DtCategorias;
import com.turismouy.generados.DtDepartamento;
import com.turismouy.generados.DtDepartamentos;
import com.turismouy.generados.DtInscripcion;
import com.turismouy.generados.DtSalidaTuristica;
import com.turismouy.generados.DtSalidas;
import com.turismouy.generados.DtUsuarioExtendido;
import com.turismouy.generados.InscripcionCapacidadExcedidaException_Exception;
import com.turismouy.generados.InscripcionYaExisteException_Exception;
import com.turismouy.generados.Publicador;
import com.turismouy.generados.PublicadorService;


/**
 * Servlet implementation class ServletInscripcionSalida
 */
@WebServlet("/inscripcionSalida")
public class ServletInscripcionSalida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInscripcionSalida() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void redirigirAInscripcion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // Fabrica fabrica = new Fabrica();
        //IActividad controladorActividad = fabrica.getIActividad();
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

        DtCategorias dtCategoriasPort = port.obtenerDTCategorias();
        DtDepartamentos dtDeptosPort = port.obtenerDTDepartamentos();
        List<DtCategoria> dtCategorias = dtCategoriasPort.getCategorias();
        List<DtDepartamento> dtDeptos = dtDeptosPort.getDepartamentos();
        request.setAttribute("dtDeptos", dtDeptos);
        request.setAttribute("dtCategorias", dtCategorias);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/salidas/inscribirmeSalidaTuristica.jsp");
        dispatcher.forward(request, response);
    }

    protected void procesarFiltros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreActividad = request.getParameter("nombreActividad");
        String nombreDepartamento = request.getParameter("departamento");
        String nombreCategoria = request.getParameter("categoria");
        //Fabrica fabrica = new Fabrica();
        //IActividad controladorActividad = fabrica.getIActividad();
        //IPaquete controladorPaquete = fabrica.getIPaquete();
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();


        DtCategorias dtCategoriasPort = port.obtenerDTCategorias();
        DtDepartamentos dtDeptosPort = port.obtenerDTDepartamentos();
        List<DtCategoria> dtCategorias = dtCategoriasPort.getCategorias();
        List<DtDepartamento> dtDeptos = dtDeptosPort.getDepartamentos();
        request.setAttribute("dtDeptos", dtDeptos);
        request.setAttribute("dtCategorias", dtCategorias);
        
        if (nombreDepartamento != null) {
            DtActividades dtActividadesPort = port.obtenerDTActividadesConfirmadasDepto(nombreDepartamento);
            List<DtActividadTuristica> dtActividades = dtActividadesPort.getActividades();
            request.setAttribute("dtActividades", dtActividades);
            request.getRequestDispatcher("/WEB-INF/salidas/inscribirmeSalidaTuristica.jsp").forward(request, response);

        }
        
        else if (nombreCategoria != null) {
            DtActividades dtActividadesPort = port.obtenerDTActividadesConfirmadasCategoria(nombreCategoria);
            List<DtActividadTuristica> dtActividades = dtActividadesPort.getActividades();
            request.setAttribute("dtActividades", dtActividades);
            request.getRequestDispatcher("/WEB-INF/salidas/inscribirmeSalidaTuristica.jsp").forward(request, response);
        }
        
       

        
           
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
        DtCategorias categorias = port.obtenerDTCategorias();
	    List<DtCategoria> dtCategorias = categorias.getCategorias();
	    DtDepartamentos deptos = port.obtenerDTDepartamentos();
        List<DtDepartamento> dtDeptos = deptos.getDepartamentos();
        request.setAttribute("dtDeptos", dtDeptos);
        request.setAttribute("dtCategorias", dtCategorias);
	    
	    if (request.getParameter("nombreActividad") != null) {
	        request.setAttribute("costo", port.obtenerDTActividadExtendido(request.getParameter("nombreActividad")).getCosto());
            DtSalidas salidas = port.obtenerDTSalidasVigentes(request.getParameter("nombreActividad"));
	        List<DtSalidaTuristica> dtSalidas = salidas.getSalidas();
	        List<DtSalidaTuristica> dtSalidascupos = new ArrayList<>();
            for(DtSalidaTuristica dtsalida: dtSalidas) {
                if (dtsalida.getCuposDisponibles()>0) {
                    dtSalidascupos.add(dtsalida);
                }
            }
            request.setAttribute("dtSalidas", dtSalidascupos);
            request.getRequestDispatcher("/WEB-INF/salidas/inscribirmeSalidaTuristica.jsp").forward(request, response);
        } else if (request.getParameter("departamento") == null && request.getParameter("categoria") == null)
	        redirigirAInscripcion(request, response);
	    else
	        procesarFiltros(request,response);
	    
	    
	    
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
		HttpSession session = request.getSession();
		DtUsuarioExtendido dtuser = (DtUsuarioExtendido) session.getAttribute("usuario_logueado");
		String nickUser = dtuser.getNickname();
		String nombreActividadString = request.getParameter("nombreActividadInput");
		String nombreSalida = request.getParameter("nombreSalida");
		Integer cupo =Integer.valueOf(request.getParameter("cantTurista"));
		
		DtCategorias categorias = port.obtenerDTCategorias();
        List<DtCategoria> dtCategorias = categorias.getCategorias();
        DtDepartamentos deptos = port.obtenerDTDepartamentos();
        List<DtDepartamento> dtDeptos = deptos.getDepartamentos();
        request.setAttribute("dtDeptos", dtDeptos);
        request.setAttribute("dtCategorias", dtCategorias);
	       
		DtInscripcion datosInscripcion = new DtInscripcion();
		datosInscripcion.setNombreSalida(nombreSalida);
		datosInscripcion.setCantTuristas(cupo);
		datosInscripcion.setFecha(LocalDate.now());
		
		
        try {
		    if (nombreActividadString != null) {
		        port.aceptarInscripcion(datosInscripcion, nickUser, nombreActividadString);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/inicio");
		        dispatcher.forward(request, response);
		        
            } 
        } catch (InscripcionYaExisteException_Exception e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/salidas/inscripcionYaExiste.jsp");
            dispatcher.forward(request, response);
            e.printStackTrace();
        } catch (InscripcionCapacidadExcedidaException_Exception e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/salidas/inscripcionCapacidadExcedida.jsp");
            dispatcher.forward(request, response);
            e.printStackTrace();
        }
		
		
		
  
	    
	}

}
