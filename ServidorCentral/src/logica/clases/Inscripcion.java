package src.logica.clases;

import java.time.LocalDate;

import src.logica.datatypes.DTInscripcion;
import src.logica.datatypes.DTSalidaTuristica;

public class Inscripcion {
	// atributos
	private LocalDate fecha;
	private int cantidadDeTuristas;
	private float costoTotalInscripcion;
	private SalidaTuristica salida;

	// creates
	Inscripcion() {
		fecha = LocalDate.of(0, 0, 0);
		cantidadDeTuristas = 0;
		costoTotalInscripcion = 0;
		salida = null;
	}

	public Inscripcion(LocalDate fecha, int cantidadDeTuristas, float costoTotalInscripcion, SalidaTuristica salida) {
		this.fecha = fecha;
		this.cantidadDeTuristas = cantidadDeTuristas;
		this.costoTotalInscripcion = costoTotalInscripcion;
		this.salida = salida;
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

	public SalidaTuristica getSalida() {
		return salida;
	}

	// setters
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setCantTuristas(int cant) {
		this.cantidadDeTuristas = cant;
	}

	public void setCosto(float costo) {
		this.costoTotalInscripcion = costo;
	}
	
	public void setSalida(SalidaTuristica salida) {
		this.salida = salida;
	}

	// operaciones
	public DTSalidaTuristica obtenerDTSalida() {
		DTSalidaTuristica res = null;
		return res;
	}

	public boolean inscripto(String NombreSalida) {
		return false;
	}

	public void calcularCostoTotal() {

	}
	
	public DTInscripcion obtenerDTInscripcion() {
		DTInscripcion dtInscripcion = new DTInscripcion(this.fecha, this.cantidadDeTuristas, this.costoTotalInscripcion, this.salida.getNombre(), this.salida.getImagen());
		return dtInscripcion;
	}
	

}

