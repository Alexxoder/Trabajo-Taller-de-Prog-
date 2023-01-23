package src.tests;




import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.junit.jupiter.api.Test;

import src.logica.clases.ActividadTuristica;

import src.logica.clases.ControladorUsuario;
import src.logica.clases.Departamento;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Inscripcion;
import src.logica.clases.Manejador;
import src.logica.clases.PaqueteActividad;
import src.logica.clases.Proveedor;
import src.logica.clases.SalidaTuristica;
import src.logica.clases.Turista;
import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTProveedor;
import src.logica.datatypes.DTProveedorExtendido;
import src.logica.datatypes.DTSalidaTuristica;
import src.logica.datatypes.DTTurista;
import src.logica.datatypes.DTTuristaExtendido;
import src.logica.datatypes.DTUsuario;




class TestConsultaUsuario {

	@Test
	void testObtenerDTUsuarios() {
		
		Manejador manejador = Manejador.getInstancia();
		ControladorUsuario controlU = new ControladorUsuario();
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		LocalDate date;
		HashMap<String, SalidaTuristica> salidas1 = new HashMap<>();
		HashMap<String, SalidaTuristica> salidas2 = new HashMap<>();
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		EstadoActividad estado2 = EstadoActividad.Confirmada;
		ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1,estado1, null);
		ActividadTuristica actividad2 = new ActividadTuristica("paseo2", "lindo2", "nacional2", 2, 200, date = LocalDate.of(2, 2, 2), depto, salidas2,estado2, null);
		actividad1.crearSalidaTuristica("salida1", 1, date=LocalDate.of(1, 1, 1), date , LocalTime.of(1, 1), "casa", null);
		actividad2.crearSalidaTuristica("salida2", 2, date=LocalDate.of(2, 2, 2), date , LocalTime.of(2, 2), "casa", null);
		HashMap<String, ActividadTuristica> actividades = new HashMap<>();
		actividades.put(actividad2.getNombre(), actividad2);
		actividades.put(actividad1.getNombre(), actividad1);
		PaqueteActividad paquete1 = new PaqueteActividad("paq1", "paquetefeo1", 1 , 1, date = LocalDate.of(1, 1, 1), null, actividades);
		PaqueteActividad paquete2 = new PaqueteActividad("paq2", "paquetefeo2", 2, 2, date = LocalDate.of(2, 2, 2), null,  actividades);
		HashSet<Inscripcion> ins = new HashSet<>();
		Turista turista = new Turista("nickT", "nombreT", "apellidoT", "correoT", "1234", date=LocalDate.of(1, 1, 1), null, "nacionalidad", ins);
		Proveedor proveedor = new Proveedor("nickU", "nombreU", "apellidoU", "correoU", "1234", date = LocalDate.of(2, 2, 2), null, "enlace", "descri", actividades);
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		manejador.getActividades().put(actividad2.getNombre(), actividad2);
		manejador.getPaquetes().put(paquete1.getNombre(), paquete1);
		manejador.getPaquetes().put(paquete2.getNombre(), paquete2);
		manejador.getUsuarios().put(turista.getNickname(), turista);
		manejador.getUsuarios().put(proveedor.getNickname(), proveedor);
	
		
		//prueba
		Map<String, DTUsuario> usuprueba = controlU.obtenerDTUsuarios();
		
		//salida esperada
		DTTurista correctaT = new DTTurista(turista.getNickname(), turista.getNombre(), turista.getApellido(), turista.getCorreo(), turista.getContrasenia(), turista.getImagen(), turista.getFechaNacimiento(), turista.getNacionalidad());
		DTProveedor correctaP = new DTProveedor(proveedor.getNickname(), proveedor.getNombre(), proveedor.getApellido(), proveedor.getCorreo(), proveedor.getContrasenia(), proveedor.getFechaNacimiento(), proveedor.getImagen(), proveedor.getLink(), proveedor.getDescripcion());
		
		//comparacion
		
		DTTurista pruebaT =(DTTurista) usuprueba.get(turista.getNickname());
		DTProveedor pruebaP = (DTProveedor) usuprueba.get(proveedor.getNickname());
		
		assertEquals(pruebaT.getNickname(), correctaT.getNickname());
		assertEquals(pruebaT.getNombre(), correctaT.getNombre());
		assertEquals(pruebaT.getApellido(), correctaT.getApellido());
		assertEquals(pruebaT.getCorreo(), correctaT.getCorreo());
		assertEquals(pruebaT.getFechaNacimiento(), correctaT.getFechaNacimiento());
		assertEquals(pruebaT.getNacionalidad(), correctaT.getNacionalidad());
		
		assertEquals(pruebaP.getNickname(), correctaP.getNickname());
		assertEquals(pruebaP.getNombre(), correctaP.getNombre());
		assertEquals(pruebaP.getApellido(), correctaP.getApellido());
		assertEquals(pruebaP.getCorreo(), correctaP.getCorreo());
		assertEquals(pruebaP.getFechaNacimiento(), correctaP.getFechaNacimiento());
		assertEquals(pruebaP.getLink(), correctaP.getLink());
		assertEquals(pruebaP.getDescripcion(), correctaP.getDescripcion());
	
		
	}
	
	@Test
	void testObtenerDTUsuarioExtendido(){
		Manejador manejador = Manejador.getInstancia();
		ControladorUsuario controlU = new ControladorUsuario();
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		LocalDate date;
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		EstadoActividad estado2 = EstadoActividad.Confirmada;
		//Hay que poner el estado
		HashMap<String, SalidaTuristica> salidas1 = new HashMap<>();
		HashMap<String, SalidaTuristica> salidas2 = new HashMap<>();
		ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);
		ActividadTuristica actividad2 = new ActividadTuristica("paseo2", "lindo2", "nacional2", 2, 200, date = LocalDate.of(2, 2, 2), depto, salidas2, estado2, null);
		actividad1.crearSalidaTuristica("salida1", 1, date=LocalDate.of(1, 1, 1), date , LocalTime.of(1, 1), "casa", null);
		actividad2.crearSalidaTuristica("salida2", 2, date=LocalDate.of(2, 2, 2), date , LocalTime.of(2, 2), "casa", null);
		HashMap<String, ActividadTuristica> actividades = new HashMap<>();
		actividades.put(actividad2.getNombre(), actividad2);
		actividades.put(actividad1.getNombre(), actividad1);
		PaqueteActividad paquete1 = new PaqueteActividad("paq1", "paquetefeo1", 1, 1, date = LocalDate.of(1, 1, 1), null, actividades);
		PaqueteActividad paquete2 = new PaqueteActividad("paq2", "paquetefeo2", 2, 2, date = LocalDate.of(2, 2, 2), null, actividades);
		HashSet<Inscripcion> ins = new HashSet<>(); 
		Inscripcion ins1 = new Inscripcion(date = LocalDate.of(1, 1, 1), 1, 1, actividad1.getSalida("salida1"));
		Inscripcion ins2 = new Inscripcion(date = LocalDate.of(2, 2, 2), 2, 2, actividad2.getSalida("salida2"));
		ins.add(ins1);
		ins.add(ins2);
		Turista turista = new Turista("nickT", "nombreT", "apellidoT", "correoT", "1234", date=LocalDate.of(1, 1, 1), null, "nacionalidad", ins);
		Proveedor proveedor = new Proveedor("nickU", "nombreU", "apellidoU", "correoU", "1234", date = LocalDate.of(2, 2, 2), null, "enlace", "descri", actividades);
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		manejador.getActividades().put(actividad2.getNombre(), actividad2);
		manejador.getPaquetes().put(paquete1.getNombre(), paquete1);
		manejador.getPaquetes().put(paquete2.getNombre(), paquete2);
		manejador.getUsuarios().put(turista.getNickname(), turista);
		manejador.getUsuarios().put(proveedor.getNickname(), proveedor);
	
		
		//prueba
		DTTuristaExtendido usupruebaT = (DTTuristaExtendido) controlU.obtenerDTUsuarioExtendido(turista.getNickname());
		DTProveedorExtendido usupruebaP = (DTProveedorExtendido) controlU.obtenerDTUsuarioExtendido(proveedor.getNickname());
		Map<String, DTSalidaTuristica> dtsalidasPrueba = usupruebaT.getSalidas();
		Map<String, DTActividadTuristica> dtactsPrueba = usupruebaP.getActividades();
		

		//salida esperada
		Map<String, DTSalidaTuristica> dtSalidacorrecta = actividad1.obtenerDTSalidasTuristicas();
		dtSalidacorrecta.putAll(actividad2.obtenerDTSalidasTuristicas());
		
		HashMap<String, DTActividadTuristica> dtActividadCorrecta = new HashMap<>();
		dtActividadCorrecta.put(actividad1.getNombre(), actividad1.obtenerDTActividad());
		dtActividadCorrecta.put(actividad2.getNombre(), actividad2.obtenerDTActividad());
		
		DTTuristaExtendido correctaT = new DTTuristaExtendido("nickT", "nombreT", "apellidoT", "correoT","1234" ,date=LocalDate.of(1, 1, 1),null, "nacionalidad", dtSalidacorrecta, null);
		DTProveedorExtendido correctaP = new DTProveedorExtendido("nickU", "nombreU", "apellidoU", "correoU","1234" ,date = LocalDate.of(2, 2, 2),null ,"enlace", "descri", dtActividadCorrecta);
		
		
		//comparacion
		assertEquals(usupruebaT.getNickname(), correctaT.getNickname());
		assertEquals(usupruebaT.getNombre(), correctaT.getNombre());
		assertEquals(usupruebaT.getApellido(), correctaT.getApellido());
		assertEquals(usupruebaT.getCorreo(), correctaT.getCorreo());
		assertEquals(usupruebaT.getFechaNacimiento(), correctaT.getFechaNacimiento());
		assertEquals(usupruebaT.getNacionalidad(), correctaT.getNacionalidad());
		
		//PRUEBA DE SALIDAS
		boolean error = false;
		Iterator<Map.Entry<String, DTSalidaTuristica>> iter = dtSalidacorrecta.entrySet().iterator();
		
		while (iter.hasNext() && !error){
			HashMap.Entry<String, DTSalidaTuristica> entry = iter.next();
			String key = entry.getKey();
			if (!(dtsalidasPrueba.containsKey(key))){
				error = true;
			}
			
		}
		
		if (error){
			assertEquals(null, error);
		}
		
	
		assertEquals(usupruebaP.getNickname(), correctaP.getNickname());
		assertEquals(usupruebaP.getNombre(), correctaP.getNombre());
		assertEquals(usupruebaP.getApellido(), correctaP.getApellido());
		assertEquals(usupruebaP.getCorreo(), correctaP.getCorreo());
		assertEquals(usupruebaP.getFechaNacimiento(), correctaP.getFechaNacimiento());
		assertEquals(usupruebaP.getLink(), correctaP.getLink());
		assertEquals(usupruebaP.getDescripcion(), correctaP.getDescripcion());

		//PRUEBA DE ACTIVIDADES
		
		Iterator<HashMap.Entry<String, DTActividadTuristica>> it1 = dtActividadCorrecta.entrySet().iterator();
		error = false;
		
		while (it1.hasNext() && !error){
			HashMap.Entry<String, DTActividadTuristica> entry = it1.next();
			String key = entry.getKey();
			if (!(dtactsPrueba.containsKey(key))){
				error = true;
			}
			
			if (error){
				assertEquals(null, error);
			}
		}
	

}
	
}
