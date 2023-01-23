package com.turismouy.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.turismouy.generados.DtProveedor;
import com.turismouy.generados.DtTurista;
import com.turismouy.generados.Publicador;
import com.turismouy.generados.PublicadorService;
import com.turismouy.generados.UsuarioRepetidoException_Exception;


/**
 * Servlet implementation class ServletRegistro
 */
@WebServlet("/registro")
public class ServletAltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAltaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void redirigirARegistrarse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UsuarioRepetidoException_Exception {
    	String nickName = request.getParameter("nickname");
    	if (nickName == null) {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registro/registroUsuario.jsp");
			dispatcher.forward(request, response);
    	}
    }
    
    protected void procesarAltaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UsuarioRepetidoException_Exception {
    	
    	//Fabrica fabrica = new Fabrica();
    	//IUsuario controlU = fabrica.getIUsuario();
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

    	//obtengo los datos generales
    	String nickName = request.getParameter("nickname");
    	String email = request.getParameter("email");
    	String contrasenia = request.getParameter("contrasenia");
    	String contraseniaConfirmada = request.getParameter("confContrasenia");
    	String nombre = request.getParameter("nombre");
    	String apellido = request.getParameter("apellido");
    	
    	String stringNacimiento = request.getParameter("fechaNac");
//    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    	LocalDate fechaNacimiento = LocalDate.parse(stringNacimiento,formatter);
//    	PrintWriter printWriter = response.getWriter();
//    	printWriter.print(stringNacimiento);
//    	printWriter.print(fechaNacimiento);
    	
    	DtTurista turistaNuevo = new DtTurista();
    	DtProveedor proveedorNuevo = new DtProveedor();
 
    	String imagen = request.getParameter("imagen");
          if (imagen.isBlank()) {
              imagen ="https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg";
          }
    	
    	//obtengo los datos de turista
    	String nacionalidad = request.getParameter("nacionalidad");
    	
    	//obtengo los datos de proveedor
    	String descripcion = request.getParameter("descripcion");
    	String link = request.getParameter("link");
    	
    	//verifico la contraseñia
    	if (contrasenia.equals(contraseniaConfirmada))
    		try {
    			if (!nacionalidad.isBlank()){//esto ocurre si se registra un turista
    			    turistaNuevo.setApellido(apellido);
    			    turistaNuevo.setContrasenia(contrasenia);
    			    turistaNuevo.setCorreo(email);
    			    turistaNuevo.setFechaNacString(stringNacimiento);
    			    //turistaNuevo.setFechaNac(fechaNacimiento);
    			    turistaNuevo.setImagen(imagen);
    			    turistaNuevo.setNacionalidad(nacionalidad);
    			    turistaNuevo.setNickname(nickName);
    			    turistaNuevo.setNombre(nombre);
    				port.aceptarAltaTurista(turistaNuevo);
    				response.sendRedirect("/ServidorWeb/usuarios");
    			}else { //si no se registra un proveedor
    			    proveedorNuevo.setApellido(apellido);
    			    proveedorNuevo.setContrasenia(contrasenia);
    			    proveedorNuevo.setCorreo(email);
    			    proveedorNuevo.setDescripcion(descripcion);
    			    proveedorNuevo.setFechaNacString(stringNacimiento);
    			    //proveedorNuevo.setFechaNac(fechaNacimiento);
    			    proveedorNuevo.setImagen(imagen);
    			    proveedorNuevo.setLink(link);
    			    proveedorNuevo.setNickname(nickName);
    			    proveedorNuevo.setNombre(nombre);
    				port.aceptarAltaProveedor(proveedorNuevo);
    				response.sendRedirect("/ServidorWeb/usuarios");
    			}
    		} catch (UsuarioRepetidoException_Exception e) {
    			request.getRequestDispatcher("/WEB-INF/registro/registroUsuarioErroneoUsuarioNick.jsp").forward(request, response);
    		}
    	else {
    		request.getRequestDispatcher("/WEB-INF/registro/registroUsuarioErroneoContra.jsp").forward(request, response);
    	}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			redirigirARegistrarse(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			procesarAltaUsuario(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
