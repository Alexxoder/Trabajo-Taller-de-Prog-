package com.turismouy.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turismouy.generados.DtUsuarioExtendido;
import com.turismouy.generados.Publicador;
import com.turismouy.generados.PublicadorService;
import com.turismouy.generados.UsuarioNoExisteException_Exception;

/**
 * Servlet implementation class ServletSeguirUsuario
 */
@WebServlet("/seguir")
public class ServletSeguirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSeguirUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickNameUsuario = request.getParameter("nickNameUsuario");
		String nickNameASeguir = request.getParameter("nickNameASeguir");
		
		PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
        
        port.seguirONoAUsuario(nickNameUsuario, nickNameASeguir);
        try {
            DtUsuarioExtendido usr = port.obtenerUsuarioPorID(nickNameUsuario);
            request.getSession().setAttribute("usuario_logueado", usr);
            response.sendRedirect("/ServidorWeb/usuarios?usuario=" + nickNameASeguir);
            //request.getRequestDispatcher("/usuarios?usuario=" + nickNameASeguir).forward(request, response);
        } catch (UsuarioNoExisteException_Exception e) {
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
