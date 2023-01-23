package src.logica.clases;
import java.time.LocalDate;

import java.util.HashMap;
import java.util.Map;
import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTProveedor;
import src.logica.datatypes.DTProveedorExtendido;
import src.logica.datatypes.DTUsuario;
import src.logica.datatypes.DTUsuarioExtendido;

public class Proveedor extends Usuario {
	//atributos
	private Map<String, ActividadTuristica> coleccionDeActividades;
	private String link, descripcion;
	
	//creates
	public Proveedor(String nick, String nombre, String apellido, String correo, String contrasenia, LocalDate fechaNacimiento, String imagen, String enlace, String descrip, Map<String, ActividadTuristica> colAct)  {
		super(nick, nombre, apellido, correo, contrasenia, fechaNacimiento, imagen);
		this.descripcion = descrip;
		this.coleccionDeActividades = colAct;
		this.link = enlace;
		if (colAct == null) {
			this.coleccionDeActividades = new HashMap<>();
		}else {
			this.coleccionDeActividades  = colAct;
		}
	}
	
	public Proveedor() {
		super("", "", "", "", "", LocalDate.of(0, 0, 0), "");
		descripcion = "";
		coleccionDeActividades = new HashMap<>();
		link = "";
		
	}
	//getters
	public String getLink() {
		return this.link;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public Map<String, ActividadTuristica> getActividades() {
		return this.coleccionDeActividades;
	}
	
	//setters
	public void setActividades(Map<String, ActividadTuristica> colActividades) {
		this.coleccionDeActividades = colActividades;
	}
	
	public void setDescripcionProveedor(String descripcionProveedor) {
		this.descripcion = descripcionProveedor;
	}
	
	public void setLink(String enlace) {
		this.link = enlace;
	}

	@Override
	public DTUsuario obtenerDTUsuario() {
        DTProveedor dtProveedor = new DTProveedor(this.getNickname(), this.getNombre(), this.getApellido(), this.getCorreo(), this.getContrasenia(), this.getFechaNacimiento(), this.getImagen(), this.link, this.descripcion);
        return dtProveedor;
    }
	
	@Override
	public DTUsuarioExtendido obtenerDTUsuarioExtendido() {
		HashMap<String, DTActividadTuristica> colDTA = new HashMap<>();
		coleccionDeActividades.forEach((key, value)-> {
			DTActividadTuristica dtA = value.obtenerDTActividad();
			colDTA.put(key, dtA);
		});
		DTProveedorExtendido res = new DTProveedorExtendido(getNickname(), getNombre(), getApellido(), getCorreo(), getContrasenia(), getFechaNacimiento(), getImagen(), link, descripcion, colDTA);
		
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
}
