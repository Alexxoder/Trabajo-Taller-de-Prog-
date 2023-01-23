package src.logica.datatypes;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTActividades {
	
	private ArrayList<DTActividadTuristica> actividades;

	public DTActividades() {
		
	}
	
	public ArrayList<DTActividadTuristica> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<DTActividadTuristica> actividades) {
		this.actividades = actividades;
	}
}
