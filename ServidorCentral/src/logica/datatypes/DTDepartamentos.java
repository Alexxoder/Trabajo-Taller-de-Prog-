package src.logica.datatypes;

import java.util.ArrayList;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTDepartamentos {
	
	private ArrayList<DTDepartamento> departamentos;

	public DTDepartamentos() {
		
	}

	public ArrayList<DTDepartamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(ArrayList<DTDepartamento> departamentos) {
		this.departamentos = departamentos;
	}
}
