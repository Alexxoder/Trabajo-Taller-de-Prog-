package src.logica.clases;

import java.util.Map;


import src.excepciones.UsuarioRepetidoException;
import src.logica.datatypes.DTInscripcion;
import src.logica.datatypes.DTProveedor;
import src.logica.datatypes.DTTurista;
import src.logica.datatypes.DTUsuario;
import src.logica.datatypes.DTUsuarioExtendido;
import src.excepciones.InscripcionCapacidadExcedidaException;
import src.excepciones.InscripcionYaExisteException;
import src.excepciones.UsuarioNoExisteException;

import java.time.LocalDate;

public interface IUsuario {
	public Map<String, DTUsuario> obtenerDTUsuarios();
	public DTUsuarioExtendido obtenerDTUsuarioExtendido(String nickNameUsuario);
	public Map<String, DTTurista> obtenerDTTuristas();
	public void aceptarInscripcion(String nickTurista, String nombreSalida, String nombreActividad, int cantidadTuristas, LocalDate fechaInscripcion) throws InscripcionYaExisteException, InscripcionCapacidadExcedidaException;
	public void cancelarInscripcion();
	public Map<String, DTProveedor> obtenerDTProveedores();
	public Usuario obtenerUsuarioPorNick(String nickName);
	public Usuario obtenerUsuarioPorCorreo(String correo);
	public DTUsuarioExtendido obtenerUsuarioPorID(String nickOCorreo) throws UsuarioNoExisteException;
	public void aceptarAltaTurista(String nickname, String nombre, String apellido, String correo, String contrasenia, LocalDate fechaNacimiento, String imagen, String nacionalidad) throws UsuarioRepetidoException;
	public void aceptarAltaProveedor(String nombre, String apellido, String nickname, String correo, String contrasenia, LocalDate fechaNacimento, String imagen, String descripcion, String link) throws UsuarioRepetidoException;
	public Map<String, DTInscripcion> obtenerDTInscripcionesAsociadasTurista(String nombreTurista);
	public void seguirONoAUsuario(String nickNameUsuario, String nickNameASeguir);
}



