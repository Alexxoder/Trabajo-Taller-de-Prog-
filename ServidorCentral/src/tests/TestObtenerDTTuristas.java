package src.tests;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import src.logica.clases.ActividadTuristica;
import src.logica.clases.ControladorUsuario;
import src.logica.clases.Manejador;
import src.logica.clases.PaqueteActividad;
import src.logica.clases.SalidaTuristica;
import src.logica.clases.Turista;
import src.logica.datatypes.DTTurista;
import src.logica.clases.Departamento;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Inscripcion;

class TestObtenerDTTuristas {

	@Test
	void testObtenerDTTuristas() {
		Manejador manejador = Manejador.getInstancia();
		ControladorUsuario controlU = new ControladorUsuario();
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		LocalDate date;
		Map<String, SalidaTuristica> salidas1 = new HashMap<>();
		Map<String, SalidaTuristica> salidas2 = new HashMap<>();
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		EstadoActividad estado2 = EstadoActividad.Confirmada;
		ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);
		ActividadTuristica actividad2 = new ActividadTuristica("paseo2", "lindo2", "nacional2", 2, 200, date = LocalDate.of(2, 2, 2), depto, salidas2, estado2, null);
		actividad1.crearSalidaTuristica("salida1", 1, date=LocalDate.of(1, 1, 1), date, LocalTime.of(1, 1), "casa", null);
		actividad2.crearSalidaTuristica("salida2", 2, date=LocalDate.of(2, 2, 2), date, LocalTime.of(2, 2), "casa", null);
		Map<String, ActividadTuristica> actividades = new HashMap<>();
		actividades.put(actividad2.getNombre(), actividad2);
		actividades.put(actividad1.getNombre(), actividad1);
		PaqueteActividad paquete1 = new PaqueteActividad("paq1", "paquetefeo1", 1 , 1, date = LocalDate.of(1, 1, 1), null, actividades);
		PaqueteActividad paquete2 = new PaqueteActividad("paq2", "paquetefeo2", 2, 2, date = LocalDate.of(2, 2, 2), null,  actividades);
		Set<Inscripcion> ins = new HashSet<>();
		Turista turista1 = new Turista("nick1", "nombre1", "apellido1", "correo1", "1234", date=LocalDate.of(1, 1, 1), null, "nacionalidad1", ins);
		Turista turista2 = new Turista("nick2", "nombre2", "apellido2", "correo2", "1234", date=LocalDate.of(1, 1, 1), null, "nacionalidad2", ins);
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		manejador.getActividades().put(actividad2.getNombre(), actividad2);
		manejador.getPaquetes().put(paquete1.getNombre(), paquete1);
		manejador.getPaquetes().put(paquete2.getNombre(), paquete2);
		manejador.getUsuarios().put(turista1.getNickname(), turista1);
		manejador.getUsuarios().put(turista2.getNickname(), turista2);
		
		//prueba
		Map<String, DTTurista> dtprueba1 = controlU.obtenerDTTuristas();
		DTTurista dtpruebaT1 = dtprueba1.get(turista1.getNickname());
		DTTurista dtpruebaT2 = dtprueba1.get(turista2.getNickname());
		
		
		//salida esperada
		DTTurista dtcorrecto1 = (DTTurista) turista1.obtenerDTUsuario();
		DTTurista dtcorrecto2 = (DTTurista) turista2.obtenerDTUsuario();
		
		//comparacion
		
		assertEquals(dtpruebaT1.getNickname(), dtcorrecto1.getNickname());
		assertEquals(dtpruebaT1.getNombre(), dtcorrecto1.getNombre());
		assertEquals(dtpruebaT1.getApellido(), dtcorrecto1.getApellido());
		assertEquals(dtpruebaT1.getCorreo(), dtcorrecto1.getCorreo());
		assertEquals(dtpruebaT1.getNacionalidad(), dtcorrecto1.getNacionalidad());
		assertEquals(dtpruebaT1.getFechaNacimiento(), dtcorrecto1.getFechaNacimiento());
		
		assertEquals(dtpruebaT2.getNickname(), dtcorrecto2.getNickname());
		assertEquals(dtpruebaT2.getNombre(), dtcorrecto2.getNombre());
		assertEquals(dtpruebaT2.getApellido(), dtcorrecto2.getApellido());
		assertEquals(dtpruebaT2.getCorreo(), dtcorrecto2.getCorreo());
		assertEquals(dtpruebaT2.getNacionalidad(), dtcorrecto2.getNacionalidad());
		assertEquals(dtpruebaT2.getFechaNacimiento(), dtcorrecto2.getFechaNacimiento());
		
	}

}
