package src.logica.datatypes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTProveedorExtendido extends DTUsuarioExtendido {
	//atributos
	private String link, descripcion;
	private Map<String, DTActividadTuristica> actividades;
	private ArrayList<DTActividadTuristica> listaActividades;
	private ArrayList<DTActividadTuristica> listaActividadesConfirmadas;
	//creates
	public DTProveedorExtendido() {
		
	}
	
	public DTProveedorExtendido(String nick, String nombre, String apellido, String correo, String contrasenia, LocalDate fechaNacimiento, String imagen, String enlace, String descrip, Map<String, DTActividadTuristica> actividades) {
		super(nick, nombre, apellido, correo, contrasenia, fechaNacimiento, imagen);
		this.descripcion = descrip;
		this.link = enlace;
		this.actividades = actividades;
	}
	
	//getters
	public String getLink() {
		return link;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public Map<String, DTActividadTuristica> getActividades() {
		return actividades;
	}
		
	
	//setters
	public void setActividades(Map<String, DTActividadTuristica> colActividades) {
		this.actividades = colActividades;
	}
	
	public void setDescripcionProveedor(String descripcionProveedor) {
		this.descripcion = descripcionProveedor;
	}
	
	public void setLink(String enlace) {
		this.link = enlace;
	}
	
	public Map<String, DTActividadTuristica> getDTActividadesConfirmadas(){
		Map<String, DTActividadTuristica> res = new HashMap<>();
		
		actividades.forEach((key, value)-> {
			if (value.getEstado().toString().equals("Confirmada")) {
				DTActividadTuristica datatype = new DTActividadTuristica(key, value.getDescripcion(), value.getCiudad(), value.getDuracion(), value.getCosto(), value.getfechaDeAlta(), value.getDepartamento(), value.getSalidas(), value.getEstado(), value.getImagen());
				res.put(datatype.getNombre(), datatype);
			}
		});
	
		return res;
		
	}

	public ArrayList<DTActividadTuristica> getListaActividades() {
		return listaActividades;
	}

	public void setListaActividades(ArrayList<DTActividadTuristica> listaActividades) {
		this.listaActividades = listaActividades;
	}

	public ArrayList<DTActividadTuristica> getListaActividadesConfirmadas() {
		return listaActividadesConfirmadas;
	}

	public void setListaActividadesConfirmadas(ArrayList<DTActividadTuristica> listaActividadesConfirmadas) {
		this.listaActividadesConfirmadas = listaActividadesConfirmadas;
	}
	
}