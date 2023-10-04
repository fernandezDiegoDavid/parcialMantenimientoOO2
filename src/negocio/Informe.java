package negocio;

import java.util.List;

import datos.OrdenMantenimiento;

public class Informe {
	
	private List<OrdenMantenimiento> ordenes;
	private double total;
	
	public Informe() {}
	public Informe(List<OrdenMantenimiento> ordenes, double total) {
		super();
		this.ordenes = ordenes;
		this.total = total;
	}
	public List<OrdenMantenimiento> getOrdenes() {
		return ordenes;
	}
	public void setOrdenes(List<OrdenMantenimiento> ordenes) {
		this.ordenes = ordenes;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Informe [ordenes=" + ordenes + "\n, total=" +Funciones.pasarDoubleACadena(total) + "]";
	}
	
	
	

}
