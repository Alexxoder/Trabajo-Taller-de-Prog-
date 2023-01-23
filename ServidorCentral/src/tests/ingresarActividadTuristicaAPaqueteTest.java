package src.tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import src.logica.clases.ActividadTuristica;
import src.logica.clases.Departamento;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Fabrica;
import src.logica.clases.IPaquete;
import src.logica.clases.Manejador;
import src.logica.clases.PaqueteActividad;
import src.logica.clases.SalidaTuristica;

class ingresarActividadTuristicaAPaqueteTest {

	@AfterEach
	public  void limpiarDatos() {
		
		 Manejador manejador = Manejador.getInstancia();
		 manejador.getPaquetes().clear();
		 manejador.getActividades().clear();
		 manejador.getUsuarios().clear();
		 manejador.getDepartamentos().clear();

	}
	
	@Test
	void ingresarActividadTuristicaAPaquete() {
		
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
		//nueva salida
		SalidaTuristica salida1 = new SalidaTuristica(nombresal1, tope, fechaAlta, fechaSalida, hsalida, lugarSalida, null);
		salidas.put(nombresal1, salida1);

		EstadoActividad estado1 = EstadoActividad.Confirmada;
		EstadoActividad estado2 = EstadoActividad.Confirmada;
		
		//nuevas actividades
		ActividadTuristica actividad1 = new ActividadTuristica(nombreActividad1, descripact1, ciudad1, duracion1, costo1, fechaAlta, montevideo, salidas, estado1, null);
		ActividadTuristica actividad2 = new ActividadTuristica(nombreActividad2, descripact2, ciudad2, duracion2, costo2, fechaAlta, canelones, salidas, estado2, null);
		
		actividades.put(nombreActividad1, actividad1);
		actividades.put(nombreActividad2, actividad2);
		
		Manejador manejador = Manejador.getInstancia();
		Map<String, PaqueteActividad> colPaquetes = manejador.getPaquetes();
		//nuevo paquete
		PaqueteActividad nuevo = new PaqueteActividad(nombrePaquete, descripcion, periodoValidez, porcentajeDescuento, fechaAlta, null, actividades);
		colPaquetes.put(nombrePaquete, nuevo);
		
		Fabrica fabrica = new Fabrica();
		IPaquete controladorPaquete = fabrica.getIPaquete();
		controladorPaquete.ingresarActividadTuristica(actividad1.getNombre(), nombrePaquete);
		
		
		//compruebo que se ingreso la actividad al paquete
		PaqueteActividad prueba = manejador.getPaquete(nombrePaquete);
		Map<String, ActividadTuristica> actividadesPaquete = prueba.getActividades();
		ActividadTuristica actividadDePaquete = actividadesPaquete.get(actividad1.getNombre());
		
		assertEquals(actividadDePaquete.getNombre(), actividad1.getNombre());
		
		
	}

}
