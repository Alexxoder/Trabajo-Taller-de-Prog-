package src.logica.clases;

import java.time.LocalDate;
import java.time.LocalTime;

import src.logica.datatypes.DTSalidaTuristica;

public class SalidaTuristica {
	//atributos
	private String nombre;
	private int topeTuristas, cuposDisponibles;
	private LocalDate fechaAlta, fechaSalida;
	private LocalTime horaSalida;
	private String lugarSalida;
	private String imagen;
	
	//creates
	public SalidaTuristica(){
		nombre = "";
		topeTuristas = cuposDisponibles = 0;
		lugarSalida = "";
		imagen = null;
	}
	
	public SalidaTuristica(String nombre, int topeTuristas, LocalDate fechaAlta, LocalDate fechaSalida, LocalTime horaSalida, String lugarSalida, String imagen){
		this.nombre = nombre;
		this.topeTuristas = topeTuristas;
		this.cuposDisponibles = topeTuristas;
		this.fechaAlta = fechaAlta;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.lugarSalida = lugarSalida;
		this.imagen = imagen;
	}
	
	//getters
	public String getNombre() {
		return nombre;
	}
	
	public int getTopeTuristas() {
		return topeTuristas;
	}
	
	public int getCuposDisponibles() {
		return cuposDisponibles;
	}
	
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}
	
	public LocalTime getHoraSalida() {
		return horaSalida;
	}
	
	public String getLugarSalida() {
		return lugarSalida;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	//setters
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setTopeTuristas(int topeTuristas){
		this.topeTuristas = topeTuristas;
	}
	
	public void setCuposDisponibles(int cuposDisponibles){
		this.cuposDisponibles = cuposDisponibles;
	}
	
	public void setFechaAlta(LocalDate fechaAlta){
		this.fechaAlta = fechaAlta;
	}
	
	public void setFechaSalida(LocalDate fechaSalida){
		this.fechaSalida = fechaSalida;
	}
	
	public void setHoraSalida(LocalTime horaSalida){
		this.horaSalida = horaSalida;
	}
	
	public void setLugarSalida(String lugarSalida){
		this.lugarSalida = lugarSalida;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	//opts DC
	public DTSalidaTuristica obtenerDT(){
		DTSalidaTuristica res = new DTSalidaTuristica(nombre, topeTuristas, cuposDisponibles, fechaAlta, fechaSalida, horaSalida, lugarSalida, imagen);
		return res;
	}
	
	public Boolean estaVigente(){
		return fechaSalida.isAfter(LocalDate.now());
	}
	
	public Boolean hayCupo(int cantidadTurista){
		return true;
	}
	
	public int obtenerCosto(){
		return 0;
	}
	
	public void disminuirCuposSalida(int cantidadTuristas){
		
	}
	
	public void modificarDatosSalida(String nombreActividad, String nombreSal, LocalDate salida, LocalDate alta, int topeTuristas){
		
	}
}
