package src.logica.datatypes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTDepartamento {
	//atributos
	private String nombreDepto, urlDepto, descripcionDepto;
	
	//creates
	public DTDepartamento() {
		
	}
	
	public DTDepartamento(String nombre, String url, String descripcion) {
		this.descripcionDepto = descripcion;
		this.nombreDepto = nombre;
		this.urlDepto = url;
	}
	
	//getters
	public String getNombreDepto() {
		return nombreDepto;
	}
	
	public String getUrlDepto() {
		return urlDepto;
	}
	
	public String getDescripcionDepto() {
		return descripcionDepto;
	}
	
	//setters
	public void setNombreDepto(String nombre) {
		this.nombreDepto = nombre;
	}
	
	public void setUrlDepto(String url) {
		this.urlDepto = url;
	}
	
	public void setDescripcionDepto(String descripcion) {
		this.descripcionDepto = descripcion;
	}
}
