package src.logica.datatypes;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTActividadesExtendidas {

	private ArrayList<DTActividadExtendida> actividadesExtendidas;

	public DTActividadesExtendidas() {
		
	}
	
	public ArrayList<DTActividadExtendida> getActividadesExtendidas() {
		return actividadesExtendidas;
	}

	public void setActividadesExtendidas(ArrayList<DTActividadExtendida> actividadesExtendidas) {
		this.actividadesExtendidas = actividadesExtendidas;
	}
}
