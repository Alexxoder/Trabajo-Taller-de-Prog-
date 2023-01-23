package com.turismouy.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turismouy.generados.PublicadorService;

import com.turismouy.generados.DtUsuario;
import com.turismouy.generados.DtUsuarioExtendido;
import com.turismouy.generados.DtUsuarios;
import com.turismouy.generados.Publicador;
import com.turismouy.generados.DtInscripcion;
import com.turismouy.generados.DtProveedorExtendido;
import com.turismouy.generados.DtTuristaExtendido;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/usuarios")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarios/listarUsuarios.jsp");
    	dispatcher.forward(request, response);    	
	}
    
    protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nick = request.getParameter("usuario");
        //Fabrica fabrica = new Fabrica();
        //IUsuario controlU = fabrica.getIUsuario();
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

        
        DtUsuarios users = port.obtenerDTUsuarios();
        List<DtUsuario> usuarios = users.getUsuarios();
        if (nick == null) 
        {             
            request.setAttribute("colUsuarios", usuarios);
            listarUsuarios(request, response);
        }
        else
        {
            DtUsuarioExtendido user = port.obtenerDTUsuarioExtendido(nick);
            
            if (request.getAttribute("salidasVigentes") != null) {
                request.setAttribute("usuario", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarios/consultaUsuarioProveedorFinalizarError.jsp");
                dispatcher.forward(request, response);      
            }
            if (user instanceof DtProveedorExtendido) {
                request.setAttribute("usuario", user);
                consultaUsuarioProveedor(request,response);
            } else {
                DtTuristaExtendido turista = (DtTuristaExtendido) user;
                
                //creo maps para hacerlo mas facil en el jsp
                Map<String, DtInscripcion> inscripciones = new HashMap<>();
                for (DtInscripcion inscripcion : turista.getListaInscripciones()) {
                    inscripciones.put(inscripcion.getNombreSalida(), inscripcion);
                }
                request.setAttribute("inscripciones", inscripciones);
                request.setAttribute("usuario", user);
                consultaUsuarioTurista(request,response); 
            }
        }
                        
    }
    
    protected void consultaUsuarioTurista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarios/consultaUsuarioTurista.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void consultaUsuarioProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarios/consultaUsuarioProveedor.jsp");
        dispatcher.forward(request, response);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    procesarPedido(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
