package com.turismouy.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turismouy.generados.ActividadRepetidaException_Exception;
import com.turismouy.generados.DtActividadExtendida;
import com.turismouy.generados.DtCategoria;
import com.turismouy.generados.DtCategorias;
import com.turismouy.generados.DtUsuarioExtendido;
import com.turismouy.generados.Publicador;
import com.turismouy.generados.PublicadorService;



/**
 * Servlet implementation class ServletConsultaSalida
 */
@WebServlet("/altaActividad")
public class ServletAltaActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAltaActividad() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //si entra en el get tiene que mostrar el formulario para rellenar
        //Fabrica fabrica = new Fabrica();
        //IActividad controladorActividad = fabrica.getIActividad();
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

        DtCategorias categorias = port.obtenerDTCategorias();
        List<DtCategoria> dtCategorias = categorias.getCategorias();
        request.setAttribute("dtCategorias", dtCategorias);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/actividades/altaDeActividad.jsp");
        dispatcher.forward(request, response); 
        }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //si entra en el post es porque ya enviaron el formulario
        //Fabrica fabrica = new Fabrica();
        //IActividad controladorActividad = fabrica.getIActividad();
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

        String nombreDepartamento = request.getParameter("departamento");
        String nombreActividad = request.getParameter("actividad");
        String descripcionActividad = request.getParameter("descripcion");
        int duracionActividad = Integer.parseInt(request.getParameter("duracion")); 
        int costo = Integer.parseInt(request.getParameter("costo")); 
        String ciudad = request.getParameter("ciudad");
        String imagen = request.getParameter("imagen");
        if (imagen.isBlank()) {
            imagen ="https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg";
        }
        String[] nombresCategorias = (String[])request.getParameterValues("categorias");
         
        ArrayList<DtCategoria> dtcategorias = new ArrayList<DtCategoria>();
        DtCategoria dtCategoria;
        for(String nombreCategoria: nombresCategorias) {
            dtCategoria = port.obtenerDTCategoria(nombreCategoria);
            dtcategorias.add(dtCategoria);
        }

        DtUsuarioExtendido usuario = (DtUsuarioExtendido)request.getSession().getAttribute("usuario_logueado");
        String nickNameProveedor = usuario.getNickname();
        
        //se crea el DTActividadExtendida y se setean solo los valores necesarios para dar de alta
        DtActividadExtendida actividadNueva = new DtActividadExtendida();
        actividadNueva.setDepartamento(nombreDepartamento);
        actividadNueva.getListaCategorias().addAll(dtcategorias);
        //actividadNueva.setCategorias((Categorias) dtcategorias);//esta hay que cambiar
        actividadNueva.setCiudad(ciudad);
        actividadNueva.setCosto(costo);
        actividadNueva.setDescripcion(descripcionActividad);
        actividadNueva.setDuracion(duracionActividad);
        //actividadNueva.setFechaAlta(LocalDate.now());
        actividadNueva.setImagen(imagen);
        actividadNueva.setNombre(nombreActividad);
        
        try {
            port.aceptarAltaActividad(nickNameProveedor, actividadNueva);
        } catch (ActividadRepetidaException_Exception e) {
            // TODO Auto-generated catch block
        	DtCategorias categorias = port.obtenerDTCategorias();
            List<DtCategoria> dtCategorias = categorias.getCategorias();
            request.setAttribute("dtCategorias", dtCategorias);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/actividades/altaDeActividadError.jsp");
            dispatcher.forward(request, response); 
        }               
        response.sendRedirect("/ServidorWeb/actividades");

    }
    }
	

