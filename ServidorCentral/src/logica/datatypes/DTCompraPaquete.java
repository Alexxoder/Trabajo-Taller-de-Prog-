package src.logica.datatypes;

import java.time.LocalDate;

public class DTCompraPaquete {
	//atributos
		private LocalDate fecha;
		private int cantidadDeTuristas;
		private int costoTotal;
		private int vencimiento;
		private String nombrePaquete;
		private String imagenPaquete;
		
	//creates
	public DTCompraPaquete() {
			
	}	
		
	public DTCompraPaquete(LocalDate fec, int cantTur, int cosTot, int venc, String nombrePaquete, String imagenPaquete){
		fecha = fec;
		cantidadDeTuristas = cantTur;
		costoTotal = cosTot;
		vencimiento = venc;
		this.nombrePaquete = nombrePaquete;
		this.imagenPaquete = imagenPaquete;
	}
	
	//getters
	public LocalDate getFecha() {
		return fecha;
	}
		
	public int getCantidadDeTuristas() {
		return cantidadDeTuristas;
	}
		
	public int getCostoTotal() {
		return costoTotal;
	}
		
	public int getVencimiento() {
		return vencimiento;
	}
	
	public String getNombrePaquete() {
		return nombrePaquete;
	}
	
	public String getImagenPaquete() {
		return imagenPaquete;
	}
	
	//setters
	public void setFecha(LocalDate fec){
		fecha = fec;
	}
		
	public void setCantidadDeTuristas(int cantTur){
		cantidadDeTuristas = cantTur;
	}
		
	public void setCostoTotal(int costTot){
		costoTotal = costTot;
	}
		
	public void setVencimiento(int venc){
		vencimiento = venc;
	}
	
	public void setNombrePaquete(String nombrePaquete) {
		this.nombrePaquete = nombrePaquete;
	}
	
	public void setImagenPaquete(String imagenPaquete) {
		this.imagenPaquete = imagenPaquete;
	}
}
