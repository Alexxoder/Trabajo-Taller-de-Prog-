package src.logica.clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import src.logica.datatypes.DTActividadExtendida;
import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTCategoria;
import src.logica.datatypes.DTPaqueteActividad;
import src.logica.datatypes.DTSalidaTuristica;

public class ActividadTuristica {
  // atributos
  private String nombre;
  private String descripcion;
  private String ciudad;
  private int duracion;
  private int costo;
  private LocalDate fechaDeAlta;
  private Departamento departamento;
  private EstadoActividad estado;
  private Map<String, SalidaTuristica> salidas;
  private Map<String, Categoria> categorias;
  private String imagen;

  // creates
  public ActividadTuristica() {
    nombre = descripcion = ciudad = "";
    duracion = 0;
    costo = 0;
    fechaDeAlta = LocalDate.of(0, 0, 0);
    departamento = null;
    salidas = new HashMap<>();
    categorias = new HashMap<>();
    estado = EstadoActividad.Agregada;
    imagen = null;
  }

  public ActividadTuristica(String nombre, String descripcion, String ciudad, int duracion, int costo, LocalDate fechaDeAlta, Departamento departamento, Map<String, SalidaTuristica> salidas, EstadoActividad estado, String imagen) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.ciudad = ciudad;
    this.duracion = duracion;
    this.costo = costo;
    this.fechaDeAlta = fechaDeAlta;
    this.departamento = departamento;
    this.salidas = salidas;
    this.estado = estado;
    this.imagen = imagen;
  }

  // getters
  public String getNombre() {
    return nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public String getCiudad() {
    return ciudad;
  }

  public int getDuracion() {
   return duracion;
  }

  public int getCosto() {
    return costo;
  }

  public LocalDate getfechaDeAlta() {
    return fechaDeAlta;
  }

  public Departamento getDepartamento() {
    return departamento;
  }

  public String getNombreDepartamento() {
    return departamento.getNombreDepto();
  }

  public Map<String, SalidaTuristica> getSalidas() {
    return salidas;
  }

  public EstadoActividad getEstadoActividad() {
    return estado;
  }
	
  public Map<String, Categoria> getCategorias() {
    return categorias;
  }
	
  public String getImagen() {
    return imagen;
  }
  // setters
	
  public void setNombreActividad(String nombre) {
    this.nombre = nombre;
   }

  public void setDescripcionActividad(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setDuracionActividad(int duracion) {
    this.duracion = duracion;
  }

  public void setCostoActividad(int costo) {
    this.costo = costo;
  }

  public void setCiudadActividad(String ciudad) {
    this.ciudad = ciudad;
  }

  public void setFechaDeAltaActividad(LocalDate fecha) {
    this.fechaDeAlta = fecha;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  public void setSalidas(Map<String, SalidaTuristica> salidas) {
    this.salidas = salidas;
  }
	
  public void setEstadoActividad(EstadoActividad estado) {
    this.estado = estado;
  }

  public void setCategorias(Map<String, Categoria> categorias) {
    this.categorias = categorias;
  }
	
  public void setImagen(String imagen) {
    this.imagen = imagen;
  }
	
  //operaciones
	
	public boolean estaConfirmada() {
		if (estado == EstadoActividad.Confirmada)
			return true;
		else 
			return false;
	}
	
	public boolean ocurreEnDepto(String nombreDepto) {
		if (departamento.getNombreDepto().equals(nombreDepto))
			return true;
		else
			return false;
	}
	
  public Map<String, DTSalidaTuristica> obtenerDTSalidasVigentes() {
    Map<String, DTSalidaTuristica> dtSalidas = new HashMap<>();
    this.salidas.forEach((key, value) -> {
      if (value.estaVigente()) {
        dtSalidas.put(key, value.obtenerDT());
      }
    });
    return dtSalidas;
  }

  public boolean pertenecePaquete(ActividadTuristica actividad) {
    return true;
  }

  public DTActividadTuristica obtenerDTActividad() {
    String depto = getDepartamento().getNombreDepto();
    Map<String, DTSalidaTuristica> salidas = obtenerDTSalidasTuristicas();
    DTActividadTuristica res = new DTActividadTuristica(this.nombre, this.descripcion, this.ciudad,
        this.duracion, this.costo, this.fechaDeAlta, depto, salidas, this.estado, this.imagen);
    return res;
  }

  public DTActividadExtendida obtenerDTActividadExtendida() {
    String depto = getDepartamento().getNombreDepto();
    Map<String, DTSalidaTuristica> salidas = obtenerDTSalidasTuristicas();
    Map<String, DTPaqueteActividad> paquetes = obtenerDTPaquetes();
    Map<String, DTCategoria> dtcategorias = obtenerDTCategorias();
    DTActividadExtendida res = new DTActividadExtendida(nombre, descripcion, duracion, costo, ciudad, fechaDeAlta, depto, salidas, paquetes, dtcategorias, imagen);
    return res;
  }

  public boolean verificarSalida(String nombreSalida) {
    boolean res;
    if (salidas.get(nombreSalida) == null) {
      res = false;
    } else {
      res = true;
    }
    return res;
  }

  public void modificarDatosSalida(String nombreSalida, int topeTuristas, LocalDate fechaAlta, LocalDate fechaSalida, LocalTime horaSalida, String lugarSalida) { 
    // le meti el parametro que no esta en el dcd
    SalidaTuristica salidaAModificar = getSalida(nombreSalida);
    salidaAModificar.setNombre(nombreSalida);
    salidaAModificar.setTopeTuristas(topeTuristas);
    salidaAModificar.setFechaSalida(fechaSalida);
    salidaAModificar.setFechaAlta(fechaAlta);
    salidaAModificar.setHoraSalida(horaSalida);
    salidaAModificar.setLugarSalida(lugarSalida);
  }

  public void crearSalidaTuristica(String nombreSalida, int topeTuristas, LocalDate fechaAlta, LocalDate fechaSalida, LocalTime horaSalida, String lugarSalida, String imagen) {
    SalidaTuristica salidaCreada = new SalidaTuristica(nombreSalida, topeTuristas, fechaAlta, fechaSalida, horaSalida, lugarSalida, imagen);
    salidas.put(nombreSalida, salidaCreada);
    Manejador manejador = Manejador.getInstancia();
    manejador.getSalidas().put(nombreSalida, salidaCreada);
  }

  public Map<String, DTSalidaTuristica> obtenerDTSalidasTuristicas() {
	  Map<String, DTSalidaTuristica> res = new HashMap<String, DTSalidaTuristica>();
	  salidas.forEach((key, value) -> {
      DTSalidaTuristica salidaObtenida = new DTSalidaTuristica(key, value.getTopeTuristas(), value.getCuposDisponibles(), value.getFechaAlta(), value.getFechaSalida(), value.getHoraSalida(), value.getLugarSalida(), value.getImagen());
      res.put(key, salidaObtenida);
   });
    return res;
  }

  public DTSalidaTuristica obtenerDTSalidaTuristica(String nombreSalida) {
    SalidaTuristica salida = salidas.get(nombreSalida);
    DTSalidaTuristica dtsalida = salida.obtenerDT();
    return dtsalida;
  }
  
  public Map<String, DTCategoria> obtenerDTCategorias(){
	Map<String, DTCategoria> colDTCategorias = new HashMap<String, DTCategoria>();
	categorias.forEach((key, value)-> {
		colDTCategorias.put(key, value.obtenerDTCategoria());
	});
	return colDTCategorias;
  }
  
  public Map<String, DTPaqueteActividad> obtenerDTPaquetes() {
    Map<String, DTPaqueteActividad> res = new HashMap<>();
    Manejador manejador = Manejador.getInstancia();
    Map<String, PaqueteActividad> colPaquetes = manejador.getPaquetes();
    colPaquetes.forEach((key, value) -> {
    	//esta comparacion no compara strings, no necesita equals
      if (value.getActividades().get(nombre) == this) {
        DTPaqueteActividad paqueteObtenido = value.obtenerDTPaquete();
        res.put(key, paqueteObtenido);
      }
    });
    return res;
  }
	
  public SalidaTuristica getSalida(String nombreSalida) {
    SalidaTuristica salida = salidas.get(nombreSalida);
    return salida;
   }
}