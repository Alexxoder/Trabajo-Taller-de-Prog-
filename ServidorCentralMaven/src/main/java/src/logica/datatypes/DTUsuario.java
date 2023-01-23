package src.logica.datatypes;
import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class  DTUsuario {
	//atributos
	private String nickname, nombre, apellido, correo, contrasenia, imagen;
	private LocalDate fechaNac;
	private String fechaNacString;

	//creates
	public  DTUsuario() {
		
	}
	
	public  DTUsuario(String nick, String nombre, String apellido, String correo, String contrasenia, LocalDate fechaNacimiento, String imagen) {
		this.nickname = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNac=fechaNacimiento;
		this.contrasenia = contrasenia;
		this.imagen = imagen;
		this.fechaNacString = fechaNac.toString();
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


	public String getFechaNacString() {
		return this.fechaNacString;
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
	
	public void setFechaNac(LocalDate birthday) {
		fechaNac= birthday;
	}
	
	public void setImagen(String image) {
		imagen = image;
	}
	
	public void setFechaNacString(String fecha) {
		fechaNacString = fecha;
	}
}