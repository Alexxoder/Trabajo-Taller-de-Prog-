package src.logica.clases;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import src.logica.datatypes.DTActividadExtendida;
import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTPaqueteActividad;
import src.logica.datatypes.DTPaqueteActividadExtendido;


public class PaqueteActividad {
	//atributos
	private String nombre;
	private String descripcion; 
	private int validez;
	private double descuento;
	private LocalDate fechaAlta;
	private boolean comprado;
	private String imagen;
	private Map<String, ActividadTuristica> actividades;
	
	//creates


	public PaqueteActividad() {
		nombre = descripcion = imagen = "";
		validez = 0;
		descuento = 0;
		fechaAlta = LocalDate.of(0, 0, 0);
		comprado = false;
		actividades = new HashMap<>();
	}
	
	public PaqueteActividad(String nom, String des, int val, double descuen, LocalDate alta, String imagen, Map<String, ActividadTuristica> actividades){
	    nombre = nom;
	    descripcion = des;
	    validez = val;
	    descuento = descuen;
	    fechaAlta = alta;
	    comprado = false;
	    this.imagen = imagen;
	    this.actividades = actividades;
	}
	
	//getters
	public String getNombre(){
	    return nombre;
	}
	
	public String getDescripcion(){
	    return descripcion;
	}
	
	public int getValidez(){
	    return validez;
	}
	
	public double getDescuento(){
	    return descuento;
	}
	
	public Map<String, ActividadTuristica> getActividades(){
		return actividades;
	}
	
	public LocalDate getFechaAlta(){
		return fechaAlta;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	//setters
	public void setNombre(String nom){
	    nombre = nom;
	}
	
	public void setDescripcion(String des){
	    descripcion = des;
	}
	
	public void setValidez(int val){
	    validez = val;
	}
	
	public void setDescuento(double descue){
	    descuento = descue;
	}
	
	public void setActividades(Map<String, ActividadTuristica> actividades){
		this.actividades = actividades;
	}
	
	public void setFechaAlta(LocalDate fechaAlta){
		this.fechaAlta = fechaAlta;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	//operaciones
	public void ingresarActividadTuristica(ActividadTuristica actividadTuristica){
		actividades.put(actividadTuristica.getNombre(), actividadTuristica);
	}
	
	public Boolean pertenecePaquete(ActividadTuristica actividadTuristica){
		return actividades.get(actividadTuristica.getNombre()).getNombre().equals( actividadTuristica.getNombre());
	}
	
	public DTPaqueteActividad obtenerDTPaquete(){
		DTPaqueteActividad res = new DTPaqueteActividad(nombre, descripcion, validez, descuento, fechaAlta, imagen);
		return res;
	}
	
	public DTPaqueteActividadExtendido obtenerDTPaqueteExt(){
		HashMap<String, DTActividadTuristica> dtactividades = new HashMap<>();

        actividades.forEach((key, value)-> {
            DTActividadTuristica dtActividad = new DTActividadTuristica(key, value.getDescripcion(), value.getCiudad(), value.getDuracion(), value.getCosto(), value.getfechaDeAlta(), value.getDepartamento().getNombreDepto(), value.obtenerDTSalidasTuristicas(), value.getEstadoActividad(), value.getImagen());
            dtactividades.put(key, dtActividad);
        });

        DTPaqueteActividadExtendido res = new DTPaqueteActividadExtendido(this.nombre, this.descripcion, this.validez, this.descuento, dtactividades);
        return res;
	}
	
	public void agregarActividades(DTPaqueteActividadExtendido DTPaquete){
		
	}
	
	public Map<String, DTActividadExtendida> obtenerDTActividadesExtendido(String nombreDepto){
        HashMap<String, DTActividadExtendida> dtactsExtendido = new HashMap<>();
        HashMap<String, DTPaqueteActividad> dtpaquetes = new HashMap<>();
        dtpaquetes.put(this.nombre, obtenerDTPaquete());

        actividades.forEach((key, value)-> {
            if (value.ocurreEnDepto(nombreDepto)){
                DTActividadTuristica dtAT = value.obtenerDTActividad();
                DTActividadExtendida dtATE = new DTActividadExtendida(dtAT.getNombre(), dtAT.getDescripcion(), dtAT.getDuracion(), dtAT.getCosto(), dtAT.getCiudad() , dtAT.getfechaDeAlta(), dtAT.getDepartamento(), dtAT.getSalidas(), dtpaquetes, value.obtenerDTCategorias(), value.getImagen());
                dtactsExtendido.put(dtAT.getNombre(), dtATE);
            }
        });

        return dtactsExtendido;

    }
	
	public boolean fueComprado() {
		return comprado;
	}
}
