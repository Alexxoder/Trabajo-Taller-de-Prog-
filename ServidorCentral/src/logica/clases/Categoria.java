package src.logica.clases;

import src.logica.datatypes.DTCategoria;
import java.util.Map;
import java.util.HashMap;

public class Categoria {
	//atributos
	private String nombre;
	private Map<String, ActividadTuristica> actividades;

	
	
	//creates
	public Categoria() {
		nombre = "";
		actividades = new HashMap<>();
	}
	
	public Categoria(String nombre) {
		this.nombre = nombre;
		actividades = new HashMap<>();
	}
	
	//getters
	public String getNombre() {
		return nombre;
	}
	
	public Map<String, ActividadTuristica> getActividades() {
		return actividades;
	}

	//setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setActividades(Map<String, ActividadTuristica> actividades ) {
		this.actividades = actividades;
	}
	
	//operaciones
	public DTCategoria obtenerDTCategoria(){
		DTCategoria dtRes = new DTCategoria(nombre);
		return dtRes;
	}
}

