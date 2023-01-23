package src.logica.datatypes;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTTuristas {

	private ArrayList<DTTurista> turistas;
	
	public DTTuristas() {
		
	}

	public ArrayList<DTTurista> getTuristas() {
		return turistas;
	}

	public void setTuristas(ArrayList<DTTurista> turistas) {
		this.turistas = turistas;
	}
}
