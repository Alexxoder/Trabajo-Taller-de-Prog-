package src.logica.datatypes;
import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTProveedor extends DTUsuario {
	//atributos
	private String link, descripcion;
	
	//creates
	
	public DTProveedor() {
		
	}
	public DTProveedor(String nick, String nombre, String apellido, String correo, String contrasenia, LocalDate fechaNacimiento, String imagen, String enlace, String descrip) {
		super(nick, nombre, apellido, correo, contrasenia, fechaNacimiento, imagen);
		this.link = enlace;
		this.descripcion = descrip;
	}
	
	//getters
	public String getLink() {
		return this.link;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	//setters
	public void setDescripcionProveedor(String descripcionProveedor) {
		this.descripcion = descripcionProveedor;
	}
	
	public void setLink(String enlace) {
		this.link = enlace;
	}
	
}
