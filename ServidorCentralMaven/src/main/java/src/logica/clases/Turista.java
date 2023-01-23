package src.logica.clases;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import src.logica.datatypes.DTSalidaTuristica;
import src.logica.datatypes.DTTurista;
import src.logica.datatypes.DTTuristaExtendido;
import src.logica.datatypes.DTUsuario;
import src.logica.datatypes.DTUsuarioExtendido;
import src.logica.datatypes.DTInscripcion;

public class Turista extends Usuario {
	// atributos
	private String nacionalidad;
	private Set<Inscripcion> inscripciones;

	// creates
	public Turista() {
		super("", "", "", "", "", LocalDate.of(0, 0, 0), "");
		nacionalidad = "";
		inscripciones = new HashSet<>();
	}
	
	public Turista(String nick, String nombre, String apellido, String correo, String contrasenia, LocalDate fechaNacimiento, String imagen, String nacionalidad, Set<Inscripcion> colInscripciones) {
		super(nick, nombre, apellido, correo, contrasenia, fechaNacimiento, imagen);
		this.nacionalidad = nacionalidad;
		this.inscripciones = colInscripciones;
	}

	// getters
	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public Set<Inscripcion> getColInscripciones() {
		return this.inscripciones;
	}
	
	// setters
	public void setNacionalidad(String nacion) {
		this.nacionalidad = nacion;
	}

	public void setColInscripciones(Set<Inscripcion> colInscripciones) {
		this.inscripciones = colInscripciones;
	}

	// operaciones
	public DTUsuarioExtendido obtenerDTExtendido() {
		return null;
	}

	public boolean estaInscripto(String nombreSalida) {
		return true;
	}

	public void inscribirTurista(SalidaTuristica salida, int cantidadTuristas, LocalDate fechaInscripcion, int costo) {
		int costoTotal = costo * cantidadTuristas;
		Inscripcion inscripcion = new Inscripcion(fechaInscripcion, cantidadTuristas, costoTotal, salida);
		salida.setCuposDisponibles(salida.getCuposDisponibles() - cantidadTuristas);
		inscripciones.add(inscripcion);
	}

	@Override
	public DTUsuarioExtendido obtenerDTUsuarioExtendido() {
		Map<String, DTSalidaTuristica> salidas = new HashMap<>();
		Map<String, DTInscripcion> dtInscripciones = new HashMap<>();
		if (inscripciones != null)
			for (Inscripcion i : inscripciones) {
				SalidaTuristica salidaTuristica = i.getSalida();
				DTSalidaTuristica dtS = new DTSalidaTuristica(salidaTuristica.getNombre(), salidaTuristica.getTopeTuristas(), salidaTuristica.getCuposDisponibles(), salidaTuristica.getFechaAlta(), salidaTuristica.getFechaSalida(), salidaTuristica.getHoraSalida(), salidaTuristica.getLugarSalida(), salidaTuristica.getImagen());
				salidas.put(salidaTuristica.getNombre(), dtS);
				DTInscripcion dtInscripcion = i.obtenerDTInscripcion();
				dtInscripciones.put(dtInscripcion.getNombreSalida(), dtInscripcion);
			}
		DTTuristaExtendido res = new DTTuristaExtendido(getNickname(), getNombre(), getApellido(), getCorreo(), getContrasenia(), getFechaNacimiento(), getImagen(), getNacionalidad(), salidas, dtInscripciones);
		
		//obtengo los seguidos y los convierto a DTUsuariosExtendidos para luego guardarlos en el actual DTUsuarioExtendido
				Map<String, Usuario> seguidos = getSeguidos();
				Map<String, DTUsuario> dtSeguidos = new HashMap<String, DTUsuario>();
				if (seguidos != null) {
					seguidos.forEach((key, value) -> {
						dtSeguidos.put(key, value.obtenerDTUsuario());
					});
				}
				res.setSeguidos(dtSeguidos);
				
				//obtengo los seguidores y los convierto a DTUsuarioExtendidos para luego guardarlos en el actual DTUsuarioExtendido
				Map<String, Usuario> seguidores = getSeguidores();
				Map<String, DTUsuario> dtSeguidores = new HashMap<String, DTUsuario>();
				if (seguidores != null) {
					seguidores.forEach((key, value) -> {
						dtSeguidores.put(key, value.obtenerDTUsuario());
					});
				}
				res.setSeguidores(dtSeguidores);
		
		return res;
	}

	public DTUsuario obtenerDTUsuario() {
		DTTurista dtTurista = new DTTurista(this.getNickname(), this.getNombre(), this.getApellido(), this.getCorreo(), this.getContrasenia(), this.getImagen(), this.getFechaNacimiento(), this.nacionalidad);
		return dtTurista;
	}
}
