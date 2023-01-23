package src.logica.clases;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import src.logica.datatypes.DTUsuario;
import src.logica.datatypes.DTUsuarioExtendido;

public abstract class Usuario {
	//atributos
	private String nickname, nombre, apellido, correo, contrasenia, imagen;
	private LocalDate fechaNac;
	private Map<String, Usuario> seguidos, seguidores;
	
	//creates
	public Usuario() {
		nickname = nombre = apellido = correo = contrasenia = imagen = "";
		fechaNac = LocalDate.of(0, 0, 0);
		seguidos = new HashMap<String, Usuario>();
		seguidores = new HashMap<String, Usuario>();
	}
	
	public Usuario(String nick, String nombre, String apellido, String correo, String contrasenia, LocalDate fechaNacimiento, String imagen) {
		this.nickname = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.fechaNac = fechaNacimiento;
		if (imagen == null)
			this.imagen = "https://eva.fing.edu.uy/theme/image.php/adaptable/core/1659006881/u/f1";
		else
			this.imagen = imagen;
		seguidos = new HashMap<String, Usuario>();
		seguidores = new HashMap<String, Usuario>();
	}
	
	//getters
	public String getNickname() {
		return nickname;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNac;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public Map<String, Usuario> getSeguidores() {
		return seguidores;
	}
	
	public Map<String, Usuario> getSeguidos() {
		return seguidos;
	}
	
	//setters
	public void setNickname(String nick) {
		nickname = nick;
	}
	
	public void setNombre(String name) {
		nombre = name;
	}
	
	public void setApellido(String apell) {
		apellido = apell;
	}
	
	public void setCorreo(String email) {
		correo = email;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public void setFechaNac(LocalDate birthdate) {
		fechaNac= birthdate;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public void setSeguidores(Map<String, Usuario> seguidores) {
		this.seguidores = seguidores;
	}
	
	public void setSeguidos(Map<String, Usuario> seguidos) {
		this.seguidos = seguidos;
	}
	
	//operaciones
	public  abstract DTUsuario obtenerDTUsuario();

	
	public abstract DTUsuarioExtendido obtenerDTUsuarioExtendido();

	
	public void modificarUsuario(String nombreUsuario) {
		
	}
	
	
}
