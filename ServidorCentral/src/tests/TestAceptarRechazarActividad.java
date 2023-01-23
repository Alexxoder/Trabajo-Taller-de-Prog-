package src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import src.logica.clases.ActividadTuristica;
import src.logica.clases.Departamento;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;
import src.logica.clases.Manejador;
import src.logica.clases.SalidaTuristica;

class TestAceptarRechazarActividad {

	@Test
	void testConfirmarActividad() {
		Manejador manejador = Manejador.getInstancia();
		manejador.getPaquetes().clear();
		manejador.getActividades().clear();
		manejador.getUsuarios().clear();
		manejador.getDepartamentos().clear();
		
		HashMap<String, SalidaTuristica> salidas1 = new HashMap<>();
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		ActividadTuristica actividad1 = new ActividadTuristica("actividad1", "descripcion1", "ciudad1", 5, 5, LocalDate.of(2022, 5, 21), depto, salidas1, EstadoActividad.Agregada, null);
		manejador.getActividades().put("actividad1", actividad1);
		
		Fabrica fabrica = new Fabrica();
		IActividad controlA = fabrica.getIActividad();
		controlA.confirmarActividad("actividad1");
		
		assertEquals(EstadoActividad.Confirmada, actividad1.getEstadoActividad());
	}

	@Test
	void testRechazarActividad() {
		Manejador manejador = Manejador.getInstancia();
		manejador.getPaquetes().clear();
		manejador.getActividades().clear();
		manejador.getUsuarios().clear();
		manejador.getDepartamentos().clear();
		
		HashMap<String, SalidaTuristica> salidas1 = new HashMap<>();
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		ActividadTuristica actividad1 = new ActividadTuristica("actividad1", "descripcion1", "ciudad1", 5, 5, LocalDate.of(2022, 5, 21), depto, salidas1, EstadoActividad.Agregada, null);
		manejador.getActividades().put("actividad1", actividad1);
		
		Fabrica fabrica = new Fabrica();
		IActividad controlA = fabrica.getIActividad();
		controlA.rechazarActividad("actividad1");
		
		assertEquals(EstadoActividad.Rechazada, actividad1.getEstadoActividad());
	}

}
