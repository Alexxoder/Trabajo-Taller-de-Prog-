package src.logica.datatypes;
import java.util.ArrayList;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTPaqueteActividadExtendido {
	//atributos
	private String nombre;
	private String descripcion; 
	private int validez;
	private double descuento;
	private Map<String, DTActividadTuristica> actividades;
	private ArrayList<DTActividadTuristica> listaActividades;
	
	//creates
	public DTPaqueteActividadExtendido() {
		
	}
	
	public DTPaqueteActividadExtendido(String nom, String des, int val, double descuento, Map<String, DTActividadTuristica> actividades) {
	    nombre = nom;
	    descripcion = des;
	    validez = val;
	    this.descuento = descuento;
	    this.actividades = actividades;	    
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
	
	public Map<String, DTActividadTuristica> getActividades() {
		return actividades;
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
	
	
	public void setDescuento(double descuento) {
	    this.descuento = descuento;
	}
	
	public void setActividades(Map<String, DTActividadTuristica> actividades) {
		this.actividades = actividades;
	}

	public ArrayList<DTActividadTuristica> getListaActividades() {
		return listaActividades;
	}

	public void setListaActividades(ArrayList<DTActividadTuristica> listaActividades) {
		this.listaActividades = listaActividades;
	}
}
