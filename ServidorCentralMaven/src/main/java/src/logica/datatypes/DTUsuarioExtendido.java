package src.logica.datatypes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTUsuarioExtendido {
	private String nickname, nombre, apellido, correo, contrasenia, imagen;
	private LocalDate fechaNac;
	private Map<String, DTUsuario> seguidores, seguidos;
	private ArrayList<DTUsuario> listaSeguidores, listaSeguidos;
	private String fechaNacString;

	//creates
	public DTUsuarioExtendido() {
		
	}
	
	public DTUsuarioExtendido(String nick, String nombre, String apellido, String correo, String contrasenia, LocalDate fechaNacimiento, String imagen) {
		this.nickname = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNac=fechaNacimiento;
		this.contrasenia = contrasenia;
		this.imagen = imagen;
		this.fechaNacString = fechaNac.toString();
		this.seguidores = new HashMap<String, DTUsuario>();
		this.seguidos = new HashMap<String, DTUsuario>();
		this.listaSeguidores = new ArrayList<DTUsuario>();
		this.listaSeguidos = new ArrayList<DTUsuario>();

	}
	
	//getters
	public String getFechaNacString() {
		return fechaNacString;
	}
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
	
	public  Map<String, DTUsuario> getSeguidos(){
		return seguidos;
	}
	
	public  Map<String, DTUsuario> getSeguidores(){
		return seguidores;
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
	
	public void setContrasenia(String contra) {
		contrasenia = contra;
	}

	public void setFechaNac(LocalDate birthdate) {
		fechaNac= birthdate;
	}

	public void setImagen(String image) {
		imagen = image;	
	}
	
	public void setSeguidores(Map<String, DTUsuario> seguidores) {
		this.seguidores = seguidores;
	}
	
	public void setSeguidos (Map<String, DTUsuario> seguidos) {
		this.seguidos = seguidos;
	}

	public ArrayList<DTUsuario> getListaSeguidores() {
		return listaSeguidores;
	}

	public void setListaSeguidores(ArrayList<DTUsuario> listaSeguidores) {
		this.listaSeguidores = listaSeguidores;
	}

	public ArrayList<DTUsuario> getListaSeguidos() {
		return listaSeguidos;
	}

	public void setListaSeguidos(ArrayList<DTUsuario> listaSeguidos) {
		this.listaSeguidos = listaSeguidos;
	}
	
	public void setFechaNacString(String fechaNueva) {
		this.fechaNacString = fechaNueva;
	}
	
}