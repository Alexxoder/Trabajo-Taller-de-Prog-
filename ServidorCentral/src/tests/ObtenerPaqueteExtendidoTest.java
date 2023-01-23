package src.tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import src.logica.clases.ActividadTuristica;
import src.logica.clases.Departamento;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Fabrica;
import src.logica.clases.IPaquete;
import src.logica.clases.Manejador;
import src.logica.clases.PaqueteActividad;
import src.logica.clases.SalidaTuristica;
import src.logica.datatypes.DTPaqueteActividadExtendido;

class ObtenerPaqueteExtendidoTest {

	@SuppressWarnings("deprecation")
	@Test
	void paqueteExtendidoTest() {
		String nombrePaquete = "paquete1";
		String descripcion = "este es un paquete";
		int periodoValidez = 5;
		double porcentajeDescuento = 0.30;
		LocalDate fechaAlta = LocalDate.of(1999, 9, 9);
		Departamento canelones = new Departamento("Canelones", "www", "pasto");
		Departamento montevideo = new Departamento("Montevideo", "www", "concreto");
		
		Map<String, ActividadTuristica> actividades = new HashMap<>();
		String nombreActividad1 = "act1";
		String nombreActividad2 = "act2";
		String descripact1 = "es act1";
		String descripact2 = "es act2";
		String ciudad1 = "monte";
		String ciudad2 = "cane";
		int duracion1 = 1;
		int duracion2 = 2;
		int costo1 = 300;
		int costo2 = 400;
		
		HashMap<String, SalidaTuristica> salidas = new HashMap<>();
		String nombresal1 = "salida1";
		int tope = 3;
		LocalDate fechaSalida = LocalDate.of(1999, 9, 10);
		LocalTime hsalida = LocalTime.of(3, 30);
		String lugarSalida = "artigas";
		SalidaTuristica salida1 = new SalidaTuristica(nombresal1, tope, fechaAlta, fechaSalida, hsalida, lugarSalida, null);
		salidas.put(nombresal1, salida1);

		EstadoActividad estado1 = EstadoActividad.Confirmada;
		EstadoActividad estado2 = EstadoActividad.Confirmada;
		ActividadTuristica actividad1 = new ActividadTuristica(nombreActividad1, descripact1, ciudad1, duracion1, costo1, fechaAlta, montevideo, salidas, estado1, null);
		ActividadTuristica actividad2 = new ActividadTuristica(nombreActividad2, descripact2, ciudad2, duracion2, costo2, fechaAlta, canelones, salidas, estado2, null);
		
		actividades.put(nombreActividad1, actividad1);
		actividades.put(nombreActividad2, actividad2);
		
		Manejador manejador = Manejador.getInstancia();
		Map<String, PaqueteActividad> colPaquetes = manejador.getPaquetes();
		PaqueteActividad nuevo = new PaqueteActividad(nombrePaquete, descripcion, periodoValidez, porcentajeDescuento, fechaAlta, null, actividades);
		colPaquetes.put(nombrePaquete, nuevo);
		
		Fabrica fabrica = new Fabrica();
		
		IPaquete controlPaquete = fabrica.getIPaquete();
		DTPaqueteActividadExtendido paqueteActividadExtendido = controlPaquete.obtenerPaqueteExtendido(nombrePaquete);
		
		
		//paquetes	datos basicos	
		assertEquals(nombrePaquete, paqueteActividadExtendido.getNombre());
		assertEquals(descripcion, paqueteActividadExtendido.getDescripcion());
		assertEquals(periodoValidez, paqueteActividadExtendido.getValidez());
		assertEquals(porcentajeDescuento, paqueteActividadExtendido.getDescuento());
		
		///actividades en paquetes
		assertEquals(nombreActividad1, paqueteActividadExtendido.getActividades().get(nombreActividad1).getNombre());
		assertEquals(nombreActividad2, paqueteActividadExtendido.getActividades().get(nombreActividad2).getNombre());
		assertEquals(descripact1, paqueteActividadExtendido.getActividades().get(nombreActividad1).getDescripcion());
		assertEquals(descripact2, paqueteActividadExtendido.getActividades().get(nombreActividad2).getDescripcion());
		assertEquals(ciudad1, paqueteActividadExtendido.getActividades().get(nombreActividad1).getCiudad());
		assertEquals(ciudad2, paqueteActividadExtendido.getActividades().get(nombreActividad2).getCiudad());
		assertEquals(duracion1, paqueteActividadExtendido.getActividades().get(nombreActividad1).getDuracion());
		assertEquals(duracion2, paqueteActividadExtendido.getActividades().get(nombreActividad2).getDuracion());
		assertEquals(costo1, paqueteActividadExtendido.getActividades().get(nombreActividad1).getCosto());
		assertEquals(costo2, paqueteActividadExtendido.getActividades().get(nombreActividad2).getCosto());
		assertEquals(fechaAlta, paqueteActividadExtendido.getActividades().get(nombreActividad1).getfechaDeAlta());
		assertEquals(fechaAlta,  paqueteActividadExtendido.getActividades().get(nombreActividad2).getfechaDeAlta());
		assertEquals("Montevideo",  paqueteActividadExtendido.getActividades().get(nombreActividad1).getDepartamento());
		assertEquals("Canelones",  paqueteActividadExtendido.getActividades().get(nombreActividad2).getDepartamento());
		
		assertEquals(nombresal1, paqueteActividadExtendido.getActividades().get(nombreActividad1).getSalidas().get(nombresal1).getNombre());
		assertEquals(tope, paqueteActividadExtendido.getActividades().get(nombreActividad1).getSalidas().get(nombresal1).getTopeTuristas());
		assertEquals(lugarSalida, paqueteActividadExtendido.getActividades().get(nombreActividad1).getSalidas().get(nombresal1).getLugarSalida());
		assertEquals(fechaAlta, paqueteActividadExtendido.getActividades().get(nombreActividad1).getSalidas().get(nombresal1).getFechaAlta());
		assertEquals(fechaSalida, paqueteActividadExtendido.getActividades().get(nombreActividad1).getSalidas().get(nombresal1).getFechaSalida());
		assertEquals(hsalida, paqueteActividadExtendido.getActividades().get(nombreActividad1).getSalidas().get(nombresal1).getHoraSalida());
	
	}
	

}
