package src.logica.datatypes;
import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTTurista extends DTUsuario{
	//atributos
	private String nacionalidad;
	
	//creates
	public DTTurista() {
		
	}
	
	public DTTurista(String nick, String nombre, String apellido, String correo, String contrasenia, String imagen, LocalDate fechaNacimiento, String nacionalidad) {
		super(nick, nombre, apellido, correo, contrasenia, fechaNacimiento, imagen);
		this.nacionalidad = nacionalidad;
	}
	
	//getters
	public String getNacionalidad() {
		return this.nacionalidad;
	}
	
	//setters
	public void setNacionalidad(String nacion) {
		this.nacionalidad = nacion;
	}
	
}
