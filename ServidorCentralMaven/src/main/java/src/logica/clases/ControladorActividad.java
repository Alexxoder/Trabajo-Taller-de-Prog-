package src.logica.clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import src.excepciones.DepartamentoRepetidoException;
import src.excepciones.ExcepcionAltaCategoria;
import src.excepciones.ExcepcionAltaSalida;
import src.excepciones.ExcepcionModificarSalida;
import src.excepciones.SalidasVigentesException;
import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTCategoria;
import src.logica.datatypes.DTDepartamento;
import src.logica.datatypes.DTSalidaTuristica;
import src.excepciones.ActividadRepetidaException;

public class ControladorActividad implements IActividad {
	//creates
	public ControladorActividad(){
		
	}
	
	//operaciones
	@Override
	public Map<String, DTActividadTuristica> obtenerDTActividades() {
		Map<String, DTActividadTuristica> res = new HashMap<String, DTActividadTuristica>();
		
		Manejador manej = Manejador.getInstancia();
		Map<String, ActividadTuristica> actividades = manej.getActividades();
		
		actividades.forEach((key, value)-> {
			DTActividadTuristica datatype = new DTActividadTuristica(key, value.getDescripcion(), value.getCiudad(), value.getDuracion(), value.getCosto(), value.getfechaDeAlta(), value.getNombreDepartamento(), value.obtenerDTSalidasTuristicas(), value.getEstadoActividad(), value.getImagen());
			res.put(datatype.getNombre(), datatype);		
		});
	
		return res;	
	}
	
	@Override
	public Map<String, DTActividadTuristica> obtenerDTActividadesConfirmadas() {
		Map<String, DTActividadTuristica> res = new HashMap<>();
		
		Manejador manej = Manejador.getInstancia();
		Map<String, ActividadTuristica> actividades = manej.getActividades();
		
		actividades.forEach((key, value)-> {
			if (value.estaConfirmada()) {
				DTActividadTuristica datatype = new DTActividadTuristica(key, value.getDescripcion(), value.getCiudad(), value.getDuracion(), value.getCosto(), value.getfechaDeAlta(), value.getNombreDepartamento(), value.obtenerDTSalidasTuristicas(), value.getEstadoActividad(), value.getImagen());
				res.put(datatype.getNombre(), datatype);
			}
		});
	
		return res;
	}
	
	 
	@Override
	public Map<String, DTActividadTuristica> obtenerDTActividadesConfirmadasDepto(String nombreDepartamento){
		Map<String, DTActividadTuristica> res = new HashMap<>();
		
		Manejador manej = Manejador.getInstancia();
		Map<String, ActividadTuristica> actividades = manej.getActividades();
		actividades.forEach((key, value)-> {
			if (value.estaConfirmada() && value.ocurreEnDepto(nombreDepartamento)) {
				DTActividadTuristica datatype = new DTActividadTuristica(key, value.getDescripcion(), value.getCiudad(), value.getDuracion(), value.getCosto(), value.getfechaDeAlta(), value.getNombreDepartamento(), value.obtenerDTSalidasTuristicas(), value.getEstadoActividad(), value.getImagen());
				res.put(datatype.getNombre(), datatype);		
			}
		});
		return res;
	}
	

	@Override
	public Map<String, DTActividadTuristica> obtenerDTActividadesConfirmadasCategoria(String nombreCategoria){
		Map<String, DTActividadTuristica> res = new HashMap<>();
		
		Manejador manej = Manejador.getInstancia();
		Map<String, Categoria> categorias = manej.getCategorias();
		Categoria categoria = categorias.get(nombreCategoria);
		Map<String, ActividadTuristica> actividades = categoria.getActividades();
		actividades.forEach((key, value)-> {
			if (value.estaConfirmada()) {
				DTActividadTuristica datatype = new DTActividadTuristica(key, value.getDescripcion(), value.getCiudad(), value.getDuracion(), value.getCosto(), value.getfechaDeAlta(), value.getNombreDepartamento(), value.obtenerDTSalidasTuristicas(), value.getEstadoActividad(), value.getImagen());
				res.put(datatype.getNombre(), datatype);		
			}
		});
		return res;
	}
	
	@Override
	public Map<String, DTSalidaTuristica> obtenerDTSalidasVigentes(String nombreActividad) {
		Manejador manejador = Manejador.getInstancia();
		ActividadTuristica actividad = manejador.getActividad(nombreActividad);
		Map<String, DTSalidaTuristica> dtSalidas = actividad.obtenerDTSalidasVigentes();
		return dtSalidas;	
	}
	
	@Override
	public Map<String, DTDepartamento> obtenerDTDepartamentos() {
		HashMap<String, DTDepartamento> res = new HashMap<String, DTDepartamento>();
		
		Manejador manej = Manejador.getInstancia();
		Map<String, Departamento> departamentos = manej.getDepartamentos();
		
		departamentos.forEach((key, value)-> {
			DTDepartamento datatype = new DTDepartamento(key, value.getUrlDepto(), value.getDescripcionDepto());
			res.put(key, datatype);		
		});
	
	return res;
	}
	
	@Override
	public void aceptarAltaActividad(String nickNameProveedor, String nombreDepartamento, String nombreActividad, String descripcion, String ciudad, int duracion, int costo, LocalDate fechaAlta, Map<String, DTCategoria> dtCategorias, String imagen)throws ActividadRepetidaException {
		boolean existeActividad = false;
		Manejador manejador = Manejador.getInstancia();
		Map<String, ActividadTuristica> colActividades = manejador.getActividades();
		existeActividad = colActividades.containsKey(nombreActividad);
		if (!existeActividad) {
			
			Proveedor proveedor = (Proveedor) manejador.getUsuarios().get(nickNameProveedor);
			Departamento departamento = manejador.getDepartamentos().get(nombreDepartamento);
			//creo la actividad
			HashMap<String, SalidaTuristica> salidas = new HashMap<>();
			HashMap<String, Categoria> categorias = new HashMap<>();
			ActividadTuristica nuevaActividad = new ActividadTuristica(nombreActividad, descripcion, ciudad, duracion, costo, fechaAlta, departamento, salidas, EstadoActividad.Agregada, imagen);
			dtCategorias.forEach((key, value) -> {
				String nombre = value.getNombre();
				Categoria categoria = manejador.getCategorias().get(nombre);
				//se agrega la actividad a la categoria
				categoria.getActividades().put(nombreActividad, nuevaActividad);
				
				categorias.put(nombre, categoria);
			});
			//agrego las categorias a la actividad
			nuevaActividad.setCategorias(categorias);
			
			//agrego la actividad al manejador
			manejador.getActividades().put(nombreActividad, nuevaActividad);
			
			//vinculo la actividad al proveedor
			proveedor.getActividades().put(nombreActividad, nuevaActividad);
		} else {
			throw new ActividadRepetidaException("la actividad " + nombreActividad + " ya existe");
		}
	}
	
	@Override
	public DTActividadTuristica obtenerDTActividadTuristica(String nombreActividad) {
		Manejador manej = Manejador.getInstancia();
		ActividadTuristica act = manej.getActividad(nombreActividad);
		
		DTActividadTuristica res = new DTActividadTuristica(nombreActividad, act.getDescripcion(), act.getCiudad(), act.getDuracion(), act.getCosto(), act.getfechaDeAlta(), act.getNombreDepartamento(), act.obtenerDTSalidasTuristicas(), act.getEstadoActividad(), act.getImagen());
		
		return res;
	}
	
	@Override
	public void altaDepartamento(String nombreDepto, String descripcion, String URL) throws DepartamentoRepetidoException {
		Manejador manej = Manejador.getInstancia();
		Map<String, Departamento> deptos = manej.getDepartamentos();
		
		//busco si existe un departamento con el nombre
		Departamento depto = deptos.get(nombreDepto);
		if (depto != null)
			throw new DepartamentoRepetidoException("El departamento " + nombreDepto + " ya esta registrado");
		else {
			Departamento dep = new Departamento(nombreDepto, URL, descripcion);
			deptos.put(nombreDepto, dep);
		}
	}
	
	@Override
	public Map<String, DTSalidaTuristica> obtenerDTSalidasTuristicas(String nombreActividad) {
		Manejador manej = Manejador.getInstancia();
		ActividadTuristica act = manej.getActividad(nombreActividad);
		
		Map<String, DTSalidaTuristica> res = act.obtenerDTSalidasTuristicas();
		return res;		
	}
	
	//@Override
//	public DTSalidaTuristica obtenerDTSalidaTuristica(String nombreActividad, String nombreSalida) {
//		Manejador manej = Manejador.getInstancia();
//		ActividadTuristica act = manej.getActividad(nombreActividad);
//		
//		DTSalidaTuristica res = act.obtenerDTSalidaTuristica(nombreSalida);
//		return res;	
//	}
	
	@Override
	public DTSalidaTuristica obtenerDTSalidaTuristica(String nombreSalida) {
		Manejador manejador = Manejador.getInstancia();
		Map<String, SalidaTuristica> salidas = manejador.getSalidas();
		DTSalidaTuristica dtSalidaTuristica = salidas.get(nombreSalida).obtenerDT();
		return dtSalidaTuristica;
	}
	
	@Override
	public void ingresarDatosSalidaTuristica(String nombreActividad, String nombreSalida, int topeTuristas, LocalDate fechaAlta, LocalDate fechaSalida, LocalTime horaSalida, String lugarSalida, String imagen) throws ExcepcionAltaSalida {
		Manejador manej = Manejador.getInstancia();
		ActividadTuristica act = manej.getActividad(nombreActividad);
		SalidaTuristica salida = manej.getSalidas().get(nombreSalida);
				
		boolean existeSalida = false;
		if (salida != null) {
			existeSalida = true;
		}

		if (existeSalida) {
			throw new ExcepcionAltaSalida("La salida " + nombreSalida + " ya esta registrada, si desea modificar datos de la misma ingrese datos y presione modificar");
		}
		else if (!existeSalida) {
			if (fechaSalida.isAfter(fechaAlta)) {
			act.crearSalidaTuristica(nombreSalida, topeTuristas, fechaAlta, fechaSalida, horaSalida, lugarSalida, imagen);
			}
			else {
				throw new ExcepcionAltaSalida("La fecha de salida ingresada debe ser posterior a la fecha de alta");
			}
		}	
	}
	
	@Override
	public void modificarDatosSalidaTuristica(String nombreActividad, String nombreSalida, int topeTuristas, LocalDate fechaSalida, LocalDate fechaAlta, LocalTime horaSalida, String lugarSalida) throws ExcepcionModificarSalida {
		Manejador manej = Manejador.getInstancia();
		ActividadTuristica activ = manej.getActividad(nombreActividad);
		boolean existeSalida = activ.verificarSalida(nombreSalida);
		if (!existeSalida) {
			throw new ExcepcionModificarSalida("La salida " + nombreSalida + " aun no esta registrada");
		}
		else {
			activ.modificarDatosSalida(nombreSalida, topeTuristas, fechaSalida, fechaAlta, horaSalida, lugarSalida);
		}
		
	}
	
	@Override
	public void aceptarAltaCategoria(String nombre) throws ExcepcionAltaCategoria {
		Manejador manejador = Manejador.getInstancia();
		Map<String, Categoria> colCategorias = manejador.getCategorias();
		Boolean existe = colCategorias.containsKey(nombre);
		if (existe) {
			throw new ExcepcionAltaCategoria("Ya existe una categoría con ese nombre");
		}
		else {
			Categoria nueva = new Categoria(nombre);
			colCategorias.put(nombre, nueva);
		}
	}
	
	@Override
	public Map<String, DTActividadTuristica> obtenerActividadesTuristicasAgregadas() {
		Manejador manej = Manejador.getInstancia();
		Map<String, DTActividadTuristica> res = new HashMap<String, DTActividadTuristica>();
		Map<String, ActividadTuristica> actividades = manej.getActividades();
		actividades.forEach((key, value) -> {
			EstadoActividad estado = value.getEstadoActividad();
			if (estado == EstadoActividad.Agregada) {
				DTActividadTuristica dataType = value.obtenerDTActividad();
				res.put(key, dataType);
			}
			
		});
		return res;
		
	}

	@Override
	public void confirmarActividad(String nombreActividadAgregada) {
		Manejador manej = Manejador.getInstancia();
		Map<String, ActividadTuristica> actividades = manej.getActividades();
		ActividadTuristica actAConfirmar = actividades.get(nombreActividadAgregada);
		actAConfirmar.setEstadoActividad(EstadoActividad.Confirmada);
	}

	@Override
	public void rechazarActividad(String nombreActividadAgregada) {
		Manejador manej = Manejador.getInstancia();
		Map<String, ActividadTuristica> actividades = manej.getActividades();
		ActividadTuristica actARechazar = actividades.get(nombreActividadAgregada);
		actARechazar.setEstadoActividad(EstadoActividad.Rechazada);
	}
	
	@Override
	public void finalizarActividad(String nombreActividad) throws SalidasVigentesException {
		Manejador manej = Manejador.getInstancia();
		Map<String, ActividadTuristica> actividades = manej.getActividades();
		ActividadTuristica actividadFin = actividades.get(nombreActividad);
		Map<String, DTSalidaTuristica> salidasVigentes = actividadFin.obtenerDTSalidasVigentes();
		if (salidasVigentes.isEmpty()) {
			actividadFin.setEstadoActividad(EstadoActividad.Finalizada);
		}
		else throw new SalidasVigentesException("La actividad no puede finalizarse. Todavía tiene salidas vigentes");

	}
	
//	@Override
//	public DTActividadExtendida obtenerDTActividadExtendido(String nombreActividad) {
//		Manejador manejador = Manejador.getInstancia();
//		Map<String, ActividadTuristica> colActividades = manejador.getActividades();
//		ActividadTuristica actividad = colActividades.get(nombreActividad);
//		return actividad.obtenerDTActividadExtendida();
//	}
		

	@Override
	public Map<String, DTSalidaTuristica> obtenerDTSalidas() {
		Manejador manejador = Manejador.getInstancia();
		Map<String, SalidaTuristica> salidasMap = manejador.getSalidas();
		Map<String, DTSalidaTuristica> salidasdt = new HashMap<>();
		
		for (SalidaTuristica salida: salidasMap.values()) {
			salidasdt.put(salida.getNombre(), salida.obtenerDT());
		}
		
		return salidasdt;
	}

	@Override
	public Map<String, DTCategoria> obtenerDTCategorias() {
		Manejador manejador = Manejador.getInstancia();
		Map<String, Categoria> categorias;
		Map<String, DTCategoria> dtCategorias = new HashMap<String, DTCategoria>();
		categorias = manejador.getCategorias();
		for (Categoria categoria: categorias.values()) {
			dtCategorias.put(categoria.getNombre(), categoria.obtenerDTCategoria());
		}
		return dtCategorias;
	}

	@Override
	public DTCategoria obtenerDTCategoria(String nombreCategoria) {
		Manejador manejador = Manejador.getInstancia();
		Map<String, Categoria> categorias = manejador.getCategorias();
		Categoria categoria = categorias.get(nombreCategoria);
		DTCategoria dtCategoria = categoria.obtenerDTCategoria();
		return dtCategoria;
	}

//	@Override
//	public Map<String, DTActividadTuristica> obtenerDTActividadesConfirmadasYFinalizadas() {
//		Map<String, DTActividadTuristica> res = new HashMap<>();
//		
//		Manejador manej = Manejador.getInstancia();
//		Map<String, ActividadTuristica> actividades = manej.getActividades();
//		
//		actividades.forEach((key, value)-> {
//			if (value.estaConfirmada() || value.getEstadoActividad() == EstadoActividad.Finalizada) {
//				DTActividadTuristica datatype = new DTActividadTuristica(key, value.getDescripcion(), value.getCiudad(), value.getDuracion(), value.getCosto(), value.getfechaDeAlta(), value.getNombreDepartamento(), value.obtenerDTSalidasTuristicas(), value.getEstadoActividad(), value.getImagen());
//				res.put(datatype.getNombre(), datatype);
//			}
//			
//		});
//	
//		return res;
//	}
}
