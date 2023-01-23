package com.turismouy.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.turismouy.generados.DtUsuarioExtendido;
import com.turismouy.generados.DtTuristaExtendido;
import com.turismouy.generados.Publicador;
import com.turismouy.generados.PublicadorService;
import com.turismouy.generados.UsuarioNoExisteException_Exception;
import com.turismouy.model.EstadoSesion;


/**
 * Servlet implementation class ServletlLogin
 */
@WebServlet("/login")
public class ServletlLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletlLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void redirigirALogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String usuarioid = request.getParameter("usuario");
    	if (usuarioid == null) {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home/inicioSesion.jsp");
			dispatcher.forward(request, response);
    	}
    }
    
    protected void procesarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession objSession = request.getSession();
    	String idUser = request.getParameter("usuarioid");
    	String contrasenia = request.getParameter("contrasenia");
    	EstadoSesion nuevoEstado;
    	
    	//chequear usuario con contrasenia 
    	try {
    		
    		//si el idUser es un correo o nickname
    		// y el tipo de usuario
    		//Fabrica fabrica = new Fabrica();
    		//IUsuario iuser = fabrica.getIUsuario();
			 PublicadorService service = new PublicadorService();
       		 Publicador port = service.getPublicadorPort();

    		
    		DtUsuarioExtendido usr = port.obtenerUsuarioPorID(idUser);
    		
    		
			if (!usr.getContrasenia().equals(contrasenia))
				nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
			else {
				
				if (usr instanceof DtTuristaExtendido) {
				    nuevoEstado = EstadoSesion.LOGIN_TURISTA;
				} else {
					nuevoEstado = EstadoSesion.LOGIN_PROVEEDOR;
				}
				// setea el usuario logueado
				request.getSession().setAttribute("usuario_logueado", usr);
			}
		} catch (UsuarioNoExisteException_Exception ex) {
			nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
		}

    	objSession.setAttribute("estado_sesion", nuevoEstado);

		// redirige a la página principal para que luego rediriga a la página
		// que corresponde
		RequestDispatcher dispatcher = request.getRequestDispatcher("/inicio");
		dispatcher.forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		redirigirALogin(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarLogin(request, response);
	}

}
