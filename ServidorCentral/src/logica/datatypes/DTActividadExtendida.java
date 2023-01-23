package src.logica.datatypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Manejador;
import src.logica.clases.PaqueteActividad;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTActividadExtendida {
	//atributos
	private String nombre;
	private String descripcion;
	private int duracion;
	private int costo;
	private String ciudad;
	private LocalDate fechaAlta;
	private String departamento;
	private Map<String, DTSalidaTuristica> salidas = new HashMap<>();
	private Map<String, DTPaqueteActividad> paquetes = new HashMap<>();
	private EstadoActividad estado;
	private Map<String, DTCategoria> categorias = new HashMap<>();
	private String imagen;
	private ArrayList<DTSalidaTuristica> listaSalidas;
	private ArrayList<DTPaqueteActividad> listaPaquetes;
	private ArrayList<DTCategoria> listaCategorias;
	private String fechaAltaString;

	
	//creates
	public DTActividadExtendida() {
		
	}
	
	public DTActividadExtendida(String nombre, String descripcion, int duracion, int costo, String ciudad, LocalDate fechaAlta, String departamento, Map<String, DTSalidaTuristica> salidas, Map<String, DTPaqueteActividad> paquetes, Map<String, DTCategoria> categorias, String imagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ciudad = ciudad;
		this.duracion = duracion;
		this.costo = costo;
		this.fechaAlta = fechaAlta;
		this.departamento = departamento;
		this.salidas = salidas;
		this.paquetes = paquetes;
		this.estado = EstadoActividad.Agregada;
		this.categorias = categorias;
		this.imagen = imagen;
		this.fechaAltaString = fechaAlta.toString();
		this.listaSalidas = new ArrayList<DTSalidaTuristica>(salidas.values());
	}
	
	//getters
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public int getCosto() {
		return costo;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public Map<String, DTSalidaTuristica> getSalidas() {
		return salidas;
	}
	
	public Map<String, DTPaqueteActividad> getPaquetes() {
		return paquetes;
	}
	
	public EstadoActividad getEstadoActividad() {
		return estado;
	}
	
	public Map<String, DTCategoria> getCategorias() {
		return categorias;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	//setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public void setSalidas(Map<String, DTSalidaTuristica> salidas) {
		this.salidas = salidas;
	}
	
	public void setPaquetes(Map<String, DTPaqueteActividad> paquetes) {
		this.paquetes = paquetes;
	}
	
	public void setEstado(EstadoActividad estado) {
		this.estado = estado;
	}
	
	public void setCategorias(Map<String, DTCategoria> categorias) {
		this.categorias = categorias;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	//operaciones
	public void agregarPaquete(String nombrePaquete) {
        Manejador manejador = Manejador.getInstancia();
        PaqueteActividad paqueteAAgregar = manejador.getPaquete(nombrePaquete);

        DTPaqueteActividad dtp = paqueteAAgregar.obtenerDTPaquete();
        paquetes.put(dtp.getNombre(), dtp);

    }

	public ArrayList<DTSalidaTuristica> getListaSalidas() {
		return listaSalidas;
	}

	public void setListaSalidas(ArrayList<DTSalidaTuristica> listaSalidas) {
		this.listaSalidas = listaSalidas;
	}

	public ArrayList<DTPaqueteActividad> getListaPaquetes() {
		return listaPaquetes;
	}

	public void setListaPaquetes(ArrayList<DTPaqueteActividad> listaPaquetes) {
		this.listaPaquetes = listaPaquetes;
	}

	public ArrayList<DTCategoria> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(ArrayList<DTCategoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public String getFechaAltaString() {
		return fechaAltaString;
	}

	public void setFechaAltaString(String fechaAltaString) {
		this.fechaAltaString = fechaAltaString;
	}
}
