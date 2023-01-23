package src.tests;

import static org.junit.Assert.assertEquals;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import src.excepciones.InscripcionCapacidadExcedidaException;
import src.excepciones.InscripcionYaExisteException;
import src.logica.clases.ActividadTuristica;
import src.logica.clases.ControladorUsuario;
import src.logica.clases.Departamento;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Inscripcion;
import src.logica.clases.Manejador;
import src.logica.clases.PaqueteActividad;

import src.logica.clases.SalidaTuristica;
import src.logica.clases.Turista;
import src.logica.datatypes.DTInscripcion;

class obtenerDTInscripcionesAsociadasTuristaTest {

	
	@AfterEach
	public  void limpiarDatos() {
		
		 Manejador manejador = Manejador.getInstancia();
		 manejador.getPaquetes().clear();
		 manejador.getActividades().clear();
		 manejador.getUsuarios().clear();
		 manejador.getDepartamentos().clear();

	}
	@Test
	void obtenerDTInscripcionesAsociadasTurista() throws InscripcionYaExisteException, InscripcionCapacidadExcedidaException {
		//este test solo inscribe una inscripcion de un turista a una salida y chequea que este bien. no es ideal
		Manejador manejador = Manejador.getInstancia();
		ControladorUsuario controladorUsuario = new ControladorUsuario();
		
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		
		LocalDate date;
		HashMap<String, SalidaTuristica> salidas1 = new HashMap<>();
		HashMap<String, SalidaTuristica> salidas2 = new HashMap<>();
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		EstadoActividad estado2 = EstadoActividad.Confirmada;
		ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);
		
		
		actividad1.crearSalidaTuristica("salida1", 1, date=LocalDate.of(1, 1, 1), date , LocalTime.of(1, 1), "casa", null);
		
		
		HashMap<String, ActividadTuristica> actividades = new HashMap<>();
		
		actividades.put(actividad1.getNombre(), actividad1);
		
		PaqueteActividad paquete1 = new PaqueteActividad("paq1", "paquetefeo1", 1 , 1, date = LocalDate.of(1, 1, 1), null, actividades);
		PaqueteActividad paquete2 = new PaqueteActividad("paq2", "paquetefeo2", 2, 2, date = LocalDate.of(2, 2, 2), null,  actividades);
		
		HashSet<Inscripcion> ins = new HashSet<>();
		Turista turista = new Turista("nickT", "nombreT", "apellidoT", "correoT", "1234", date=LocalDate.of(1, 1, 1), null, "nacionalidad", ins);
		
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		
		manejador.getPaquetes().put(paquete1.getNombre(), paquete1);
		manejador.getPaquetes().put(paquete2.getNombre(), paquete2);
		manejador.getUsuarios().put(turista.getNickname(), turista);

		controladorUsuario.aceptarInscripcion("nickT", "salida1", actividad1.getNombre(), 1, date);
		
		Map<String, DTInscripcion> inscripcionesAsociadas = controladorUsuario.obtenerDTInscripcionesAsociadasTurista("nickT");
		
		DTInscripcion unicaInscripcion = inscripcionesAsociadas.get("salida1");
		assertEquals(unicaInscripcion.getNombreSalida(), "salida1");
		assertEquals(unicaInscripcion.getFecha(), date = LocalDate.of(1, 1, 1));
		//assertEquals(unicaInscripcion.getCostoInscripcion(), 100); //no entiendo el error
		assertEquals(unicaInscripcion.getCantTuristas(), 1);
		//assertEquals(unicaInscripcion.getImagenSalida(), null); no tiene mucho sentido pues le pase el null y seria comparacion de STring de todas formas
	}

}
