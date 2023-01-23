package src.logica.datatypes;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTProveedores {

	private ArrayList<DTProveedor> proveedores;

	public DTProveedores() {
		
	}
	
	public ArrayList<DTProveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<DTProveedor> proveedores) {
		this.proveedores = proveedores;
	}
}
