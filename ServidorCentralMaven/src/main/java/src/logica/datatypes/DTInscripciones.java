package src.logica.datatypes;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTInscripciones {

	private ArrayList<DTInscripcion> inscripciones;

	public DTInscripciones() {
		
	}
	
	public ArrayList<DTInscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(ArrayList<DTInscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}
}
