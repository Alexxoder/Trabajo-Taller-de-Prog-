package src.tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import src.excepciones.InscripcionCapacidadExcedidaException;
import src.excepciones.InscripcionYaExisteException;
import src.logica.clases.ActividadTuristica;
import src.logica.clases.Departamento;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Fabrica;
import src.logica.clases.IUsuario;
import src.logica.clases.Inscripcion;
import src.logica.clases.Manejador;
import src.logica.clases.SalidaTuristica;
import src.logica.clases.Turista;



class ControladorUsuarioTest {

	@AfterEach
	public  void limpiarDatos() {
		
		 Manejador manejador = Manejador.getInstancia();
		 manejador.getPaquetes().clear();
		 manejador.getActividades().clear();
		 manejador.getUsuarios().clear();
		 manejador.getDepartamentos().clear();

	}
	
	
	@Test
	void testAceptarInscripcionNoInscriptoYCuposDisponibles() throws InscripcionYaExisteException, InscripcionCapacidadExcedidaException {
		try {
			
			Fabrica fabrica = new Fabrica();
			IUsuario controladorU = fabrica.getIUsuario();
			Manejador manejador =  Manejador.getInstancia();
			
			Departamento depto = new Departamento("canelones", "urlsito", "feo");
			LocalDate date;
			
			
			
			
			//aca se crea  una actividad con un conjunto vacio de salidas
			Map<String, SalidaTuristica> salidas1 = new HashMap<>();
			EstadoActividad estado1 = EstadoActividad.Confirmada;
			EstadoActividad estado2 = EstadoActividad.Confirmada;
			ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);
			//aca se crea  una actividad con un conjunto vacio de salidas
			Map<String, SalidaTuristica> salidas2 = new HashMap<>();
			ActividadTuristica actividad2 = new ActividadTuristica("paseo2", "lindo2", "nacional2", 2, 200, date = LocalDate.of(2, 2, 2), depto, salidas2, estado2, null);
			//aca se crean salidas y se las guarda en las actividades
			actividad1.crearSalidaTuristica("salida1", 5, date=LocalDate.of(1, 1, 1), date , LocalTime.of(1, 1), "casa", null);
			actividad2.crearSalidaTuristica("salida2", 2, date=LocalDate.of(2, 2, 2), date , LocalTime.of(2, 2), "casa", null);
			
			//aca agrego las actividades al manejador
			manejador.getActividades().put(actividad1.getNombre(), actividad1);
			manejador.getActividades().put(actividad2.getNombre(), actividad2);
			
			
			//aca creo una inscripcion y la añado a una coleccion de inscripciones
			Float costoTotal = (float) 20;
			int entero = 1;
			Set<Inscripcion> inscripciones = new HashSet<>();
			Inscripcion inscripcion1 = new Inscripcion(date, entero, costoTotal, actividad2.getSalida("salida2"));
			inscripciones.add(inscripcion1);
			
			//creo un turista con la inscripcion a la salida 2 de la actividad 2
			Turista turista = new Turista("nickT", "nombreT", "apellidoT", "correoT", "1234", date=LocalDate.of(1, 1, 1), null, "nacionalidad", inscripciones);
			
			//agrego el turista al manejador
			manejador.getUsuarios().put(turista.getNickname(), turista);
		
			
			controladorU.aceptarInscripcion(turista.getNickname(), "salida1", actividad1.getNombre(), 2, date = LocalDate.of(1, 1, 1));
			
			
			Turista turista2 = (Turista) manejador.getUsuarios().get(turista.getNickname());
			Set<Inscripcion> inscripcionesT = turista2.getColInscripciones();
			assertEquals(false, inscripcionesT.isEmpty()); // si no se agrego la inscripcion al turista, la coleccion deberia estar vacia
		} catch (InscripcionYaExisteException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	 
	// peligro, no se borran datos antes
	
	@Test
	void testAceptarInscripcionNoInscriptoYSinCuposDisponibles() throws InscripcionYaExisteException, InscripcionCapacidadExcedidaException {
		
		try {
			Fabrica fabrica = new Fabrica();
			IUsuario controladorU = fabrica.getIUsuario();
			Manejador manejador =  Manejador.getInstancia();
			
			Departamento depto = new Departamento("canelones", "urlsito", "feo");
			LocalDate date;
			
			
			
			
			//aca se crea  una actividad con un conjunto vacio de salidas
			HashMap<String, SalidaTuristica> salidas1 = new HashMap<>();
			EstadoActividad estado1 = EstadoActividad.Confirmada;
			EstadoActividad estado2 = EstadoActividad.Confirmada;
			ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);

			//aca se crea  una actividad con un conjunto vacio de salidas
			HashMap<String, SalidaTuristica> salidas2 = new HashMap<>();
			ActividadTuristica actividad2 = new ActividadTuristica("paseo2", "lindo2", "nacional2", 2, 200, date = LocalDate.of(2, 2, 2), depto, salidas2, estado2, null);

			
			//aca se crean salidas y se las guarda en las actividades
			actividad1.crearSalidaTuristica("salida1", 1, date=LocalDate.of(1, 1 , 1), date , LocalTime.of(1, 1), "casa", null);
			actividad2.crearSalidaTuristica("salida2", 2, date=LocalDate.of(2, 2, 2), date , LocalTime.of(2, 2), "casa", null);
			
			//aca agrego las actividades al manejador
			manejador.getActividades().put(actividad1.getNombre(), actividad1);
			manejador.getActividades().put(actividad2.getNombre(), actividad2);
			
			
			//aca creo una inscripcion y la añado a una coleccion de inscripciones
			Float costoTotal = (float) 20;
			int entero = 1;
			HashSet<Inscripcion> inscripciones = new HashSet<>();
			Inscripcion inscripcion1 = new Inscripcion(date, entero, costoTotal, actividad2.getSalida("salida2"));
			inscripciones.add(inscripcion1);
			
			//creo un turista con la inscripcion a la salida 2 de la actividad 2
			Turista turista = new Turista("nickT", "nombreT", "apellidoT", "correoT", "1234", date=LocalDate.of(1, 1, 1), null, "nacionalidad", inscripciones);
			
			//agrego el turista al manejador
			manejador.getUsuarios().put(turista.getNickname(), turista);
		
			controladorU.aceptarInscripcion(turista.getNickname(), "salida1", actividad1.getNombre(), 2, date = LocalDate.of(1, 1, 1));
		} catch (InscripcionCapacidadExcedidaException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
}	
	
	
	
	@Test
	void testAceptarInscripcionYaInscripto() throws InscripcionYaExisteException, InscripcionCapacidadExcedidaException {
		try {
			Fabrica fabrica = new Fabrica();
			IUsuario controladorU = fabrica.getIUsuario();
			Manejador manejador =  Manejador.getInstancia();
			
			Departamento depto = new Departamento("canelones", "urlsito", "feo");
			LocalDate date;
			
			
			
			
			//aca se crea  una actividad con un conjunto vacio de salidas
			HashMap<String, SalidaTuristica> salidas1 = new HashMap<>();
			EstadoActividad estado1 = EstadoActividad.Confirmada;
			EstadoActividad estado2 = EstadoActividad.Confirmada;
			ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);

			//aca se crea  una actividad con un conjunto vacio de salidas
			HashMap<String, SalidaTuristica> salidas2 = new HashMap<>();
			ActividadTuristica actividad2 = new ActividadTuristica("paseo2", "lindo2", "nacional2", 2, 200, date = LocalDate.of(2, 2, 2), depto, salidas2, estado2, null);

			
			//aca se crean salidas y se las guarda en las actividades
			actividad1.crearSalidaTuristica("salida1", 1, date=LocalDate.of(1, 1, 1), date , LocalTime.of(1, 1), "casa", null);
			actividad2.crearSalidaTuristica("salida2", 2, date=LocalDate.of(2, 2, 2), date , LocalTime.of(2, 2), "casa", null);
			
			//aca agrego las actividades al manejador
			manejador.getActividades().put(actividad1.getNombre(), actividad1);
			manejador.getActividades().put(actividad2.getNombre(), actividad2);
			
			
			//aca creo una inscripcion y la añado a una coleccion de inscripciones
			Float costoTotal = (float) 20;
			int entero = 1;
			HashSet<Inscripcion> inscripciones = new HashSet<>();
			Inscripcion inscripcion1 = new Inscripcion(date, entero, costoTotal, actividad1.getSalida("salida1"));
			inscripciones.add(inscripcion1);
			
			//creo un turista con la inscripcion a la salida 1 de la actividad 1 repetido
			Turista turista = new Turista("nickT", "nombreT", "apellidoT", "correoT", "1234", date=LocalDate.of(1, 1, 1), null, "nacionalidad", inscripciones);
			
			//agrego el turista al manejador
			manejador.getUsuarios().put(turista.getNickname(), turista);
		
			
			
			
			controladorU.aceptarInscripcion(turista.getNickname(), "salida1", actividad1.getNombre(), 2, date = LocalDate.of(1, 1 , 1));
		} catch (InscripcionYaExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

}
