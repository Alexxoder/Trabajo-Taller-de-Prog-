package src.logica.datatypes;

import java.time.LocalDate;

public class DTInscripcion {
	// atributos
	private LocalDate fecha;
	private int cantidadDeTuristas;
	private float costoTotalInscripcion;
	private String nombreSalida;
	private String imagenSalida;
	private String fechaString;

	//creates
	
	public DTInscripcion() {
		
	}
	
	public DTInscripcion(LocalDate fecha, int cantidadDeTuristas, float costoTotalInscripcion, String nombreSalida, String imagenSalida) {
		this.fecha = fecha;
		this.cantidadDeTuristas = cantidadDeTuristas;
		this.costoTotalInscripcion = costoTotalInscripcion;
		this.nombreSalida = nombreSalida;
		this.imagenSalida = imagenSalida;
		this.fechaString = fecha.toString();
	}
	
	// getters
	public LocalDate getFecha() {
		return this.fecha;
	}
		
	public int getCantTuristas() {
		return this.cantidadDeTuristas;
	}

	public float getCostoInscripcion() {
		return this.costoTotalInscripcion;
	}
	
	public String getNombreSalida() {
		return nombreSalida;
	}
	
	public String getImagenSalida() {
		return imagenSalida;
	}
	
	// setters
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setCantTuristas(int cant) {
		this.cantidadDeTuristas = cant;
	}
	
	public void setCostoInscripcion(float costo) {
		this.costoTotalInscripcion = costo;
	}
	
	public void setNombreSalida(String nombreSalida) {
		this.nombreSalida = nombreSalida;
	}
	
	public void setImagenSalida(String imagenSalida) {
		this.imagenSalida = imagenSalida;
	}

	public String getFechaString() {
		return fechaString;
	}

	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}
}