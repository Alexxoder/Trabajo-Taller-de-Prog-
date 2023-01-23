package src.logica.datatypes;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTSalidas {

	private ArrayList<DTSalidaTuristica> salidas;
	
	public DTSalidas() {
		
	}

	public ArrayList<DTSalidaTuristica> getSalidas() {
		return salidas;
	}

	public void setSalidas(ArrayList<DTSalidaTuristica> salidas) {
		this.salidas = salidas;
	}
}
