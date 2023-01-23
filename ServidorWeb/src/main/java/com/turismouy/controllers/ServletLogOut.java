package com.turismouy.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turismouy.model.EstadoSesion;

/**
 * Servlet implementation class LogOut
 */
@WebServlet("/logOut")
public class ServletLogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		//si voy a cerrar sesion el estado de la sesion pasa a ser visitante
		EstadoSesion nuevoEstado;
		nuevoEstado = EstadoSesion.VISITANTE;
		session.setAttribute("estado_sesion", nuevoEstado);
		//es necesario remover
		session.removeAttribute("usuario_logueado");
		//invalido la sesion
		session.invalidate();
		//me redirijo a inicio 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/inicio");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
