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
import src.logica.datatypes.DTActividadTuristica;

class ObtenerDTActividadTuristicaTest {

	@Test
	void obtenerDTActividadTest() {
		Manejador manejador = Manejador.getInstancia();
		Fabrica fabrica = new Fabrica();
		IActividad controlActividad = fabrica.getIActividad();
		
		Departamento departamentoTest = new Departamento("Departamento Test", "www.test.com.uy", "Un departamento para testearlos a todos");
		manejador.getDepartamentos().put("Departamento Test", departamentoTest);
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		EstadoActividad estado2 = EstadoActividad.Confirmada;
		ActividadTuristica actividadTest = new ActividadTuristica("Actividad Test", "Una actividad para testearlos a todos", "TesteoCity", 4, 2000, LocalDate.of(2022, 9, 1), departamentoTest, new HashMap<>(), estado1, null);
		manejador.getActividades().put("Actividad Test", actividadTest);
		
		DTActividadTuristica ocurrido = controlActividad.obtenerDTActividadTuristica("Actividad Test");
		DTActividadTuristica esperado = new DTActividadTuristica("Actividad Test", "Una actividad para testearlos a todos", "TesteoCity", 4, 2000, LocalDate.of(2022, 9, 1), departamentoTest.getNombreDepto(), new HashMap<>(), estado2, null);
		
		assertEquals(esperado.getNombre(), ocurrido.getNombre());
		assertEquals(esperado.getDescripcion(), ocurrido.getDescripcion());
		assertEquals(esperado.getCiudad(), ocurrido.getCiudad());
		assertEquals(esperado.getDuracion(), ocurrido.getDuracion());
		assertEquals(esperado.getCosto(), ocurrido.getCosto());
		assertEquals(esperado.getfechaDeAlta(), ocurrido.getfechaDeAlta());
		assertEquals(esperado.getDepartamento(), ocurrido.getDepartamento());
		assertEquals(esperado.getSalidas().isEmpty(), ocurrido.getSalidas().isEmpty());
	}
}
