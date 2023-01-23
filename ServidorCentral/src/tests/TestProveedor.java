package src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.excepciones.UsuarioRepetidoException;
import src.logica.clases.Fabrica;
import src.logica.clases.IUsuario;
import src.logica.clases.Manejador;
import src.logica.clases.Proveedor;
import src.logica.datatypes.DTProveedor;

public class TestProveedor {
	
	private static IUsuario controlUser;
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = new Fabrica();
		controlUser = fabrica.getIUsuario();
	}

		@BeforeEach
	public void limpiarDatos() {

		Manejador manejador = Manejador.getInstancia();
		manejador.getPaquetes().clear();
		manejador.getActividades().clear();
		manejador.getUsuarios().clear();
		manejador.getDepartamentos().clear();

	}

	@Test
	void testAceptarAltaProveedor() {
		
		String nombre = "pepe";
		String apellido = "pepito";
		String nickname ="pipo";
		String correo = "pipito@pepin.com";
		String contrasenia = "1234";
		LocalDate fechanacDate = LocalDate.of(1974, 3, 30);
		String imagen = null;
		String enlace = "www.pipin.com";
		String descripcion = "hola nieri";
		
		try {
			controlUser.aceptarAltaProveedor(nombre, apellido, nickname, correo, contrasenia, fechanacDate, imagen, descripcion, enlace);
			DTProveedor proveedor = controlUser.obtenerDTProveedores().get(nickname);
			assertEquals(nombre, proveedor.getNombre());
			assertEquals(apellido, proveedor.getApellido());
			assertEquals(correo, proveedor.getCorreo());
			assertEquals(nickname, proveedor.getNickname());
			assertEquals(fechanacDate, proveedor.getFechaNacimiento());
			assertEquals(enlace, proveedor.getLink());
			assertEquals(descripcion, proveedor.getDescripcion());
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	void testRegistrarProveedorNickRepetido() {
		String nombre = "pepe";
		String apellido = "pepito";
		String nickname ="pipo";
		String correo = "pipito@pepin.com";
		String contrasenia = "1234";
		LocalDate fechanacDate = LocalDate.of(1974, 3, 30);
		String imagen = null;
		String enlace = "www.pipin.com";
		String descripcion = "hola nieri";
		
		Proveedor proveedor = new Proveedor(nickname, nombre, apellido, correo, contrasenia, fechanacDate, imagen, enlace, descripcion, null);
		Manejador manejador = Manejador.getInstancia();
		manejador.getUsuarios().put(nickname, proveedor);
		
		try {
			controlUser.aceptarAltaProveedor(nombre, apellido, nickname, correo, contrasenia, fechanacDate, imagen, descripcion, enlace);
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testRegistrarProveedorCorreoRepetido() {
		String nombre = "pepe";
		String apellido = "pepito";
		String nickname ="pipo";
		String correo = "pipito@pepin.com";
		String contrasenia = "1234";
		LocalDate fechanacDate = LocalDate.of(1974, 3, 30);
		String imagen = null;
		String enlace = "www.pipin.com";
		String descripcion = "hola nieri";
		
		Proveedor proveedor = new Proveedor(nickname, nombre, apellido, correo, contrasenia, fechanacDate, imagen, enlace, descripcion, null);
		Manejador manejador = Manejador.getInstancia();
		manejador.getUsuarios().put(nickname, proveedor);
		
		try {
			controlUser.aceptarAltaProveedor(nombre, apellido, "pipin", correo, contrasenia, fechanacDate, imagen, descripcion, enlace);
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
