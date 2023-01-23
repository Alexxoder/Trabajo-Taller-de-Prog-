package src.logica.clases;

import src.logica.datatypes.DTDepartamento;

public class Departamento {
	//atributos
	private String nombreDepto, urlDepto, descripcionDepto;
	
	//creates
	public Departamento(String nombre, String url, String descripcion) {
		this.nombreDepto = nombre;
		this.urlDepto = url;
		this.descripcionDepto = descripcion;
	}
	
	public Departamento() {
		nombreDepto = "";
		urlDepto = "";
		descripcionDepto = "";
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
		
	//operaciones
	public boolean esDepartamento(String departamento) {
		return true;
	}
	
	public DTDepartamento obtenerDTDepto() {
		DTDepartamento res = new DTDepartamento(nombreDepto, urlDepto, descripcionDepto);
		return res;
	}
}
