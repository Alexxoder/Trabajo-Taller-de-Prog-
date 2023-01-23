package src.logica.datatypes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTCategoria {
	//atributos
	private String nombre;
		
	//creates
	public DTCategoria() {
		
	}
		
	public DTCategoria(String nombre) {
		this.nombre = nombre;
	}
		
	//getters
	public String getNombre() {
		return nombre;
	}

	//setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
