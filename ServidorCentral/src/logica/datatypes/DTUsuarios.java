package src.logica.datatypes;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTUsuarios {
	
	private ArrayList<DTUsuario> usuarios;
	
	public DTUsuarios() {
		
	}

	public ArrayList<DTUsuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<DTUsuario> usuarios) {
		this.usuarios = usuarios;
	}
}
