package src.tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.excepciones.ActividadRepetidaException;
import src.excepciones.DepartamentoRepetidoException;
import src.excepciones.UsuarioRepetidoException;
import src.excepciones.ExcepcionAltaSalida;
import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;
import src.logica.clases.IUsuario;
import src.logica.clases.Manejador;
import src.logica.datatypes.DTSalidaTuristica;

class ObtenerDTSalidasVigentesTest {

	
	private Fabrica fabrica = new Fabrica();
	private IActividad controladorActividad = fabrica.getIActividad();
	private IUsuario controladorUsuario = fabrica.getIUsuario();

	@BeforeEach
	public  void limpiarDatos() {
		
		Manejador manejador = Manejador.getInstancia();
		manejador.getPaquetes().clear();
		manejador.getActividades().clear();
		manejador.getUsuarios().clear();
		manejador.getDepartamentos().clear();

	}
	@Test
	void testObtenerDTSalidasVigentes() throws DepartamentoRepetidoException, UsuarioRepetidoException, ActividadRepetidaException, ExcepcionAltaSalida {
		//ingreso los datos
		controladorActividad.altaDepartamento("nombreDepartamento", "desc", "lala");
		controladorUsuario.aceptarAltaProveedor("nombreProvedor", "apellido", "nickProveedor", "correo", "1234", LocalDate.of(2000, 1, 1), null, "lele", "link");
		controladorActividad.aceptarAltaActividad("nickProveedor", "String nombreDepartamento", "String nombreActividad", "String descripcion", "String ciudad", 10, 100,  LocalDate.of(2022, 9, 1), new HashMap<>(), null);		
		controladorActividad.ingresarDatosSalidaTuristica("String nombreActividad", "nombreSalida", 5, LocalDate.of(2022, 9, 10), LocalDate.of(2022, 9, 15), LocalTime.of(1, 1), "esquina", null);
		//obtengo las actividades del manejador
		
		
		
		
		Map<String, DTSalidaTuristica> dtSalidas = controladorActividad.obtenerDTSalidasVigentes("String nombreActividad");
		
		
		dtSalidas.forEach((key, value)-> {
			if (key == "nombreSalida")  {
				assertEquals(value.getTopeTuristas(), 5);
				assertEquals(value.getCuposDisponibles(), 5);
				assertEquals(value.getFechaAlta(), LocalDate.of(2022, 9, 15));
				assertEquals(value.getFechaSalida(), LocalDate.of(2022, 9, 10));
				assertEquals(value.getLugarSalida(), "esquina");
				assertEquals(value.getHoraSalida(), LocalTime.of(1, 1));
			}
		});
		
		
		
		
	}

}
