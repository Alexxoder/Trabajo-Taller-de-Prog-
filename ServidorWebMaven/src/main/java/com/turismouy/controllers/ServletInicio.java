package com.turismouy.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turismouy.model.EstadoSesion;

/**
 * Servlet implementation class ServletInicio
 */
@WebServlet("/inicio")
public class ServletInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInicio() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * inicializa la sesión si no estaba creada 
     * @param request 
     */
    public static void initSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        //si no tiene una sesion iniciada es visitante
        if (session.getAttribute("estado_sesion") == null) {
            session.setAttribute("estado_sesion", EstadoSesion.VISITANTE);
        }
    }
    
    /**
     * Devuelve el estado de la sesión
     * @param request
     * @return 
     */
    public static EstadoSesion getEstado(HttpServletRequest request)
    {
        return (EstadoSesion) request.getSession().getAttribute("estado_sesion");
    }
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        initSession(req);
        
        switch(getEstado(req)){
            case VISITANTE:
                // hace que se ejecute el jsp sin cambiar la url
                //si es visitante es porque cerre' la sesion, nunca entra aca cuando logueo, entonces lo mando al index
                req.getRequestDispatcher("/inicio.jsp").forward(req, resp);
                break;
            case LOGIN_INCORRECTO:
                // hace que se ejecute el jsp sin cambiar la url
                req.getRequestDispatcher("/WEB-INF/home/inicioSesionErroneo.jsp").
                forward(req, resp);
                break;
            case LOGIN_TURISTA:
                // manda una redirección a otra URL (cambia la URL)
               req.getRequestDispatcher("/inicio.jsp").forward(req, resp);
                break;
            case LOGIN_PROVEEDOR:
                // manda una redirección a otra URL (cambia la URL)
                req.getRequestDispatcher("/inicio.jsp").forward(req, resp);
                break;
        }
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
