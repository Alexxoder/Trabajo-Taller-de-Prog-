package src.logica.clases;

import java.time.LocalDate;


import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

import src.excepciones.UsuarioRepetidoException;
import src.logica.datatypes.DTInscripcion;
import src.logica.datatypes.DTProveedor;
import src.logica.datatypes.DTTurista;
import src.logica.datatypes.DTUsuario;
import src.logica.datatypes.DTUsuarioExtendido;

import java.util.HashSet;

import src.excepciones.InscripcionCapacidadExcedidaException;

import src.excepciones.InscripcionYaExisteException;
import src.excepciones.UsuarioNoExisteException;

public class ControladorUsuario implements IUsuario {
	// creates
	public ControladorUsuario() {

	}

	// operaciones
	@Override
	public Map<String, DTUsuario> obtenerDTUsuarios() {
		Map<String, DTUsuario> res = new HashMap<>();
		Manejador manejador = Manejador.getInstancia();
		Map<String, Usuario> colUsuarios = manejador.getUsuarios();
		colUsuarios.forEach((key, value) -> {
			Usuario usuarioObtenido = value;
			DTUsuario dtObtenido = usuarioObtenido.obtenerDTUsuario();
			res.put(key, dtObtenido);
		});
		return res;
	}

	@Override
	public DTUsuarioExtendido obtenerDTUsuarioExtendido(String nickNameUsuario) {
		Manejador manejador = Manejador.getInstancia();
		Map<String, Usuario> colUsuarios = manejador.getUsuarios();
		Usuario usuarioObtenido = colUsuarios.get(nickNameUsuario);
		DTUsuarioExtendido res = usuarioObtenido.obtenerDTUsuarioExtendido();
		return res;
	};

	@Override
	public Map<String, DTTurista> obtenerDTTuristas() {
		Map<String, DTTurista> dtTuristas = new HashMap<>();
		Manejador manejador = Manejador.getInstancia();
		Map<String, Usuario> usuarios = manejador.getUsuarios();
		usuarios.forEach((key, value) -> {
			if (value instanceof Turista) {

				dtTuristas.put(key, (DTTurista) value.obtenerDTUsuario());
			}
		});
		return dtTuristas;
	}

	@Override
	public void aceptarInscripcion(String nickTurista, String nombreSalida, String nombreActividad, int cantidadTuristas, LocalDate fechaInscripcion) throws InscripcionYaExisteException, InscripcionCapacidadExcedidaException {
		boolean inscripto = false;
		boolean hayCupos = false;
		Manejador manejador = Manejador.getInstancia();
		
		//obtengo los objetos de los parametros
		ActividadTuristica actividad = manejador.getActividad(nombreActividad);
		SalidaTuristica salida = actividad.getSalida(nombreSalida);
		Turista turista = (Turista) manejador.getUsuarios().get(nickTurista);
		
		//agarro las inscripcions del turista y me fijo si ya se inscribio en esa salida
		Set<Inscripcion> inscripcionesTurista = turista.getColInscripciones();
		for (Inscripcion inscripcionTurista : inscripcionesTurista) {
			//si la salida pertenece a alguna inscripcion del turista
			if (inscripcionTurista.getSalida().getNombre().equals(nombreSalida))
				inscripto = true;
		}

		if (!inscripto) {
			hayCupos = salida.getCuposDisponibles() >= cantidadTuristas;
			if (hayCupos) {
				int costoActividad = actividad.getCosto();
						turista.inscribirTurista(salida, cantidadTuristas, fechaInscripcion, costoActividad);
			} else {
				throw new InscripcionCapacidadExcedidaException("la cantidad de participantes para la actividad excede la cantidad de cupos disponibles");
			}
		} else {
			throw new InscripcionYaExisteException("el turista ya esta inscripto a la salida: " + nombreSalida); 
		}

	}

	@Override
	public void cancelarInscripcion() {

	}

	@Override
	public HashMap<String, DTProveedor> obtenerDTProveedores() {
		HashMap<String, DTProveedor> colDTProvedores = new HashMap<>();
		Manejador manejador = Manejador.getInstancia();
		Map<String, Usuario> usuarios = manejador.getUsuarios();
		for (Usuario usuario : usuarios.values()) {
			if (usuario instanceof Proveedor) {
				DTProveedor dtProveedor = (DTProveedor) usuario.obtenerDTUsuario();
				colDTProvedores.put(dtProveedor.getNickname(), dtProveedor);
			}

		}

		return colDTProvedores;
	}

	@Override
	public void aceptarAltaTurista(String nickname, String nombre, String apellido, String correo, String contrasenia, LocalDate fechaNacimiento, String imagen, String nacionalidad) throws UsuarioRepetidoException {
		Manejador manejador = Manejador.getInstancia();

		Map<String, Usuario> usuarios = manejador.getUsuarios();
		boolean nick = usuarios.containsKey(nickname);
		if (nick) {
			throw new UsuarioRepetidoException("Usuario con nick " + nickname + " ya esta registrado");
		}

		boolean regiscorreo = false;

		Iterator<HashMap.Entry<String, Usuario>> iter = usuarios.entrySet().iterator();

		while (iter.hasNext() && !regiscorreo) {

			HashMap.Entry<String, Usuario> entry = iter.next();
			regiscorreo = entry.getValue().getCorreo().equals(correo);
		}

		if (regiscorreo) {
			throw new UsuarioRepetidoException("Usuario con correo " + correo + " ya esta registrado");
		}
		HashSet<Inscripcion> colInscripciones = new HashSet<>();
		Turista turista = new Turista(nickname, nombre, apellido, correo, contrasenia, fechaNacimiento, imagen, nacionalidad, colInscripciones);
		usuarios.put(nickname, turista);
	}
	
	@Override
    public void aceptarAltaProveedor(String nombre, String apellido, String nickname, String correo, String contrasenia, LocalDate fechaNacimento, String imagen, String descripcion, String link) throws UsuarioRepetidoException {

        Manejador manejador = Manejador.getInstancia();

        Map<String, Usuario> usuarios = manejador.getUsuarios();

        boolean nick = usuarios.containsKey(nickname);

        if (nick) {

            throw new UsuarioRepetidoException("Usuario con nick "+ nickname+" ya esta registrado");
        }

        boolean regiscorreo = false;

        Iterator<HashMap.Entry<String, Usuario>> iter = usuarios.entrySet().iterator();

        while (iter.hasNext() && !regiscorreo) {

            HashMap.Entry<String, Usuario> entry = iter.next();
            regiscorreo = entry.getValue().getCorreo().equals(correo);
        }

        if (regiscorreo) {
            throw new UsuarioRepetidoException("Usuario con correo "+ correo+ " ya esta registrado");
        }
        HashMap<String, ActividadTuristica> actividades = new HashMap<>();
		 Proveedor proveedor = new Proveedor(nickname, nombre, apellido, correo, contrasenia, fechaNacimento, imagen, link, descripcion, actividades);
		 usuarios.put(nickname, proveedor);

    }

	@Override
	public Usuario obtenerUsuarioPorNick(String nickName) {
		Manejador manejador = Manejador.getInstancia();
		Usuario user = manejador.getUsuarios().get(nickName);
		return user;
	}

	@Override
	public Usuario obtenerUsuarioPorCorreo(String correo) {
		
		Usuario user = null;
		
		Manejador manejador = Manejador.getInstancia();

        Map<String, Usuario> usuarios = manejador.getUsuarios();
        
        boolean escorreo = false;

        Iterator<HashMap.Entry<String, Usuario>> iter = usuarios.entrySet().iterator();

        while (iter.hasNext() && !escorreo) {

            HashMap.Entry<String, Usuario> entry = iter.next();
            escorreo = entry.getValue().getCorreo().equals(correo);
            if (escorreo) {
            	user = entry.getValue();
			}
        }
		return user;
	}

	@Override
	public DTUsuarioExtendido obtenerUsuarioPorID(String nickOCorreo) throws UsuarioNoExisteException {
		DTUsuarioExtendido res = null;
		//obtengo el usuario mediante el nick;
		Usuario nickUsuario = obtenerUsuarioPorNick(nickOCorreo);
		//obtengo el usuario mediante el correo;
		Usuario correo = obtenerUsuarioPorCorreo(nickOCorreo);
		//si los dos son null no existe en el sistema
		if (nickUsuario == null && correo == null) {
			throw new UsuarioNoExisteException(nickOCorreo);
		}
		
		if (nickUsuario == null) {
			res = correo.obtenerDTUsuarioExtendido();
		} else {
			res = nickUsuario.obtenerDTUsuarioExtendido();
		}
		
		return res;
	}
	
	@Override
	public Map<String, DTInscripcion> obtenerDTInscripcionesAsociadasTurista(String nombreTurista) {
		Map<String, DTInscripcion> res = new HashMap<String, DTInscripcion>();
		Manejador manejador = Manejador.getInstancia();
		Turista turista = (Turista) manejador.getUsuarios().get(nombreTurista);
		Set<Inscripcion> inscripciones = turista.getColInscripciones();
		for (Inscripcion inscripcionTurista: inscripciones) {
			DTInscripcion dtInscripcion = inscripcionTurista.obtenerDTInscripcion();
			res.put(dtInscripcion.getNombreSalida(), dtInscripcion);
		}
		return res;
	}

	@Override
	public void seguirONoAUsuario(String nombreUsuario, String nombreASeguir) {
		Manejador manejador = Manejador.getInstancia();
		Usuario usuario = manejador.getUsuarios().get(nombreUsuario);
		Usuario aSeguir = manejador.getUsuarios().get(nombreASeguir);
		if (usuario.getSeguidos().containsKey(nombreASeguir)) { //ocurre cuando ya lo sigue
			usuario.getSeguidos().remove(nombreASeguir);
			aSeguir.getSeguidores().remove(nombreUsuario);
		} else { //ocurre cuando no lo sigue
			usuario.getSeguidos().put(nombreASeguir, aSeguir);
			aSeguir.getSeguidores().put(nombreUsuario, usuario);
		}
	}
	
}