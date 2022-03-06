package model;

import java.time.LocalDate;

public class Record {

	private double monto;
	private String tipo;
	private LocalDate fecha;
	private String informacion;

	public Record(double monto, String tipo, LocalDate fecha,String informacion) {
		this.monto = monto;
		this.tipo = tipo;
		this.fecha = fecha;
		this.informacion = informacion;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getInformacion() {
		return informacion;
	}
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	
	
	
}
