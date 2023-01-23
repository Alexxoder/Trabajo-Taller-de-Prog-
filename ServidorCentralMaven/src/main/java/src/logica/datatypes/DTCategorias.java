package src.logica.datatypes;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTCategorias {

	private ArrayList<DTCategoria> categorias;

	public DTCategorias() {
		
	}
	
	public ArrayList<DTCategoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(ArrayList<DTCategoria> categorias) {
		this.categorias = categorias;
	}
}
