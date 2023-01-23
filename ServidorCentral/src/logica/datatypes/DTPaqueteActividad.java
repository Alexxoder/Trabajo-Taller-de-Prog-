package src.logica.datatypes;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTPaqueteActividad {
	//atributos
	private String nombre;
	private String descripcion; 
	private int validez;
	private double descuento;
	private LocalDate alta;
	private String imagen;
	
	//creates
	public DTPaqueteActividad() {
		
	}
	
	public DTPaqueteActividad(String nom, String des, int val, double descuen, LocalDate fechaAlta, String imagen) {
	    nombre = nom;
	    descripcion = des;
	    validez = val;
	    descuento = descuen;
	    alta = fechaAlta;
	    this.imagen = imagen;
	}
	
	//getters
	public String getNombre() {
	    return nombre;
	}
	
	public String getDescripcion() {
	    return descripcion;
	}
	
	public int getValidez() {
	    return validez;
	}
	
	public double getDescuento() {
	    return descuento;
	}
	
	public LocalDate getFechaAlta() {
		return alta;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	//setters
	public void setNombre(String nom) {
	    nombre = nom;
	}
	
	public void setDescripcion(String des) {
	    descripcion = des;
	}
	
	public void setValidez(int val) {
	    validez = val;
	}
	
	public void setDescuento(double descue) {
	    descuento = descue;
	}
	
	public void setFechaAlta(LocalDate fechaAlta) {
		alta = fechaAlta;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}
