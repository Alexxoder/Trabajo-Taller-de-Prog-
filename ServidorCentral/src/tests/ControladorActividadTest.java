package src.tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import src.excepciones.ActividadRepetidaException;
import src.logica.clases.ActividadTuristica;
import src.logica.clases.Categoria;
import src.logica.clases.ControladorActividad;
import src.logica.clases.Departamento;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Manejador;
import src.logica.clases.Proveedor;
import src.logica.clases.SalidaTuristica;
import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTCategoria;

class ControladorActividadTest {

	
	
	@Test
	void testAceptarAltaActividadOk() {
		ControladorActividad controladorA = new ControladorActividad();
		String nickNameProveedor = "n1";
		String nombreDepartamento = "nombre1";
		String nombreActividad = "paseo";
		String descripcion = "paseo largo";
		String ciudad = "salto";
		int duracion = 1;
		LocalDate fechaAlta = LocalDate.of(1, 1, 1);
		int costo = 100;
		
		Manejador manejador = Manejador.getInstancia();
		
		//aca agrego porque no acepta valores vacio mi operacion
		Proveedor proveedor1 = new Proveedor("n1", "nom1", "ape1", "corr1", "1234", LocalDate.of(2000, 2, 1), null, "enlace1", "desc1", null);
		Proveedor proveedor2 = new Proveedor("n2", "nom2", "ape2", "corr2", "1234", LocalDate.of(2000, 2, 1), null, "enlace2", "desc2", null);
		manejador.getUsuarios().put("n1", proveedor1);
		manejador.getUsuarios().put("n2", proveedor2);
		//aca igual
		Departamento depto1 = new Departamento("nombre1", "url1", "descripcion1");
		Departamento depto2 = new Departamento("nombre2", "url2", "descripcion2");
		manejador.getDepartamentos().put(depto1.getNombreDepto(), depto1);
		manejador.getDepartamentos().put(depto2.getNombreDepto(), depto2);
		//aca igual
		Categoria catego1 = new Categoria("Catego1");
		Categoria catego2 = new Categoria("Catego2");
		manejador.getCategorias().put("Catego1", catego1);
		manejador.getCategorias().put("Catego2", catego2);
		DTCategoria dtCate1 = catego1.obtenerDTCategoria();
		DTCategoria dtCate2 = catego2.obtenerDTCategoria();
		Map<String, DTCategoria> colCategorias = new HashMap<>();
		colCategorias.put("Catego1", dtCate1);
		colCategorias.put("Catego2", dtCate2);
		
		try {
			//aca invoco la operacion que quiero testear
			controladorA.aceptarAltaActividad(nickNameProveedor, nombreDepartamento, nombreActividad, descripcion, ciudad, duracion, costo, fechaAlta, colCategorias, null);
			//aca obtengo el dato ingresado del manejador con una operacion
			DTActividadTuristica dtActividadTuristica =  controladorA.obtenerDTActividadTuristica(nombreActividad);
			
			//aca comparo los datos que quedaron guardados con los que deberian de haber quedado
			assertEquals(dtActividadTuristica.getNombre(), nombreActividad);
			assertEquals(dtActividadTuristica.getDescripcion(), descripcion);
			assertEquals(dtActividadTuristica.getCiudad(), ciudad);
			assertEquals(dtActividadTuristica.getDuracion(), duracion);
			assertEquals(dtActividadTuristica.getCosto(), costo);
			
			
		} catch (ActividadRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testAceptarAltaActividadExistente() {
		ControladorActividad controladorA = new ControladorActividad();
		String nickNameProveedor = "n1";
		String nombreDepartamento = "nombre1";
		String nombreActividad = "paseo";
		String descripcion = "paseo largo";
		String ciudad = "salto";
		int duracion = 1;
		int costo = 100;
		
		Manejador manejador = Manejador.getInstancia();
		
		//aca agrego porque no acepta valores vacio mi operacion
		Proveedor proveedor1 = new Proveedor("n1", "nom1", "ape1", "corr1", "1234", LocalDate.of(2000, 2, 1), null,"enlace1", "desc1", null);
		Proveedor proveedor2 = new Proveedor("n2", "nom2", "ape2", "corr2", "1234", LocalDate.of(2000, 2, 1), null, "enlace2", "desc2", null);
		manejador.getUsuarios().put("n1", proveedor1);
		manejador.getUsuarios().put("n2", proveedor2);
		//aca igual
		Departamento depto1 = new Departamento("nombre1", "url1", "descripcion1");
		Departamento depto2 = new Departamento("nombre2", "url2", "descripcion2");
		manejador.getDepartamentos().put(depto1.getNombreDepto(), depto1);
		manejador.getDepartamentos().put(depto2.getNombreDepto(), depto2);
		//aca voy a crear una actividad para que quede en el manejador
		LocalDate fecha = LocalDate.of(1, 1, 1);
		Map<String, SalidaTuristica> salidas = new HashMap<>();
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		ActividadTuristica existe = new ActividadTuristica("paseo",  "descripcion" , "String ciudad", duracion , 3, fecha, depto1, salidas, estado1, null);
		manejador.getActividades().put("existe", existe);
		
		try {
			//aca invoco la operacion que quiero testear
			controladorA.aceptarAltaActividad(nickNameProveedor, nombreDepartamento, nombreActividad, descripcion, ciudad, duracion, costo, fecha, new HashMap<>(), null);
			
			
		} catch (ActividadRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
