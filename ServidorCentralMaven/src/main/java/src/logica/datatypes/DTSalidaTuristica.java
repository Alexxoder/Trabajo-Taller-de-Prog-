package src.logica.datatypes;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTSalidaTuristica {
	//atributos
	private String nombre;
	private int topeTuristas, cuposDisponibles;
	private LocalDate fechaAlta, fechaSalida;
	private LocalTime horaSalida;
	private String lugarSalida;
	private String imagen;
	private String fechaAltaString, fechaSalidaString;
	private String horaSalidaString;
	
	//creates
	public DTSalidaTuristica() {
		
	}
		
	public DTSalidaTuristica(String nombre, int topeTuristas, int cuposDisponibles, LocalDate fechaAlta, LocalDate fechaSalida, LocalTime horaSalida, String lugarSalida, String imagen) {
		this.nombre = nombre;
		this.topeTuristas = topeTuristas;
		this.cuposDisponibles = cuposDisponibles;
		this.fechaAlta = fechaAlta;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.lugarSalida = lugarSalida;
		this.imagen = imagen;
		this.fechaAltaString = fechaAlta.toString();
		this.fechaSalidaString = fechaSalida.toString();
		this.horaSalidaString = horaSalida.toString();
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
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
	public void setTopeTuristas(int topeTuristas) {
		this.topeTuristas = topeTuristas;
	}
		
	public void setCuposDisponibles(int cuposDisponibles) {
		this.cuposDisponibles = cuposDisponibles;
	}
		
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
		
	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
		
	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}
		
	public void setLugarSalida(String lugarSalida) {
		this.lugarSalida = lugarSalida;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getFechaSalidaString() {
		return fechaSalidaString;
	}

	public void setFechaSalidaString(String fechaSalidaString) {
		this.fechaSalidaString = fechaSalidaString;
	}

	public String getFechaAltaString() {
		return fechaAltaString;
	}

	public void setFechaAltaString(String fechaAltaString) {
		this.fechaAltaString = fechaAltaString;
	}

	public String getHoraSalidaString() {
		return horaSalidaString;
	}

	public void setHoraSalidaString(String horaSalidaString) {
		this.horaSalidaString = horaSalidaString;
	}
}