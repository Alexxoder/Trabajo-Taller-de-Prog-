package src.logica.datatypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTTuristaExtendido extends DTUsuarioExtendido{
	//atributos
	private String nacionalidad;
	private Map<String, DTSalidaTuristica> salidas;
	private Map<String,DTInscripcion> inscripciones;
	private ArrayList<DTSalidaTuristica> listaSalidas;
	private ArrayList<DTInscripcion> listaInscripciones;

	
	//creates
	public DTTuristaExtendido() {
		
	}
	
	public DTTuristaExtendido(String nick, String nombre, String apellido, String correo, String contrasenia, LocalDate fechaNacimiento, String imagen, String nacionalidad, Map<String, DTSalidaTuristica> salidas, Map<String, DTInscripcion> inscripciones) {
		super(nick, nombre, apellido, correo, contrasenia, fechaNacimiento, imagen);
		this.nacionalidad = nacionalidad;
		this.salidas = salidas;
		this.inscripciones = inscripciones;
	}

	//getters
	public String getNacionalidad() {
		return this.nacionalidad;
	}
	
	public Map<String,DTInscripcion> getInscripciones() {
		return this.inscripciones;
	}
	
	public Map<String, DTSalidaTuristica> getSalidas() {
		return this.salidas;
	}
	

	//setters
	public void setNacionalidad(String nacion) {
		this.nacionalidad = nacion;
	}
	
	public void setSalidas(Map<String, DTSalidaTuristica> salidas){
		this.salidas = salidas;
	}
	
	public void setInscripciones(Map<String,DTInscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	public ArrayList<DTSalidaTuristica> getListaSalidas() {
		return listaSalidas;
	}

	public void setListaSalidas(ArrayList<DTSalidaTuristica> listaSalidas) {
		this.listaSalidas = listaSalidas;
	}

	public ArrayList<DTInscripcion> getListaInscripciones() {
		return listaInscripciones;
	}

	public void setListaInscripciones(ArrayList<DTInscripcion> listaInscripciones) {
		this.listaInscripciones = listaInscripciones;
	}
	

}