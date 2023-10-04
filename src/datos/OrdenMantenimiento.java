package datos;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class OrdenMantenimiento {
	
	private int idOrdenMantenimiento;
	private String nroOrdenMantenimiento;
	private Ambiente ambiente;
	private String motivo;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double costoDeReparacion;
	private boolean terminada;
	private boolean pagada;
	private String estadoDeReparacion;
	public OrdenMantenimiento() {
		super();
	}
	public OrdenMantenimiento(String nroDeorden, Ambiente ambiente, String motivo, LocalDate fechaInicio,
			LocalDate fechaFin, double costoDeReparacion, boolean terminada, boolean pagada,
			String estadoDeReparacion) {
		super();
		this.nroOrdenMantenimiento = nroDeorden;
		this.ambiente = ambiente;
		this.motivo = motivo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costoDeReparacion = costoDeReparacion;
		this.terminada = terminada;
		this.pagada = pagada;
		this.estadoDeReparacion = estadoDeReparacion;
	}
	
	
	
	public int getIdOrdenMantenimiento() {
		return idOrdenMantenimiento;
	}
	protected void setIdOrdenMantenimiento(int idOrdenMantenimiento) {
		this.idOrdenMantenimiento = idOrdenMantenimiento;
	}
	public String getNroOrdenMantenimiento() {
		return nroOrdenMantenimiento;
	}
	public void setNroOrdenMantenimiento(String nroDeorden) {
		this.nroOrdenMantenimiento = nroDeorden;
	}
	public Ambiente getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public double getCostoDeReparacion() {
		return costoDeReparacion;
	}
	public void setCostoDeReparacion(double costoDeReparacion) {
		this.costoDeReparacion = costoDeReparacion;
	}
	public boolean isTerminada() {
		return terminada;
	}
	public void setTerminada(boolean terminada) {
		this.terminada = terminada;
	}
	public boolean isPagada() {
		return pagada;
	}
	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}
	public String getEstadoDeReparacion() {
		return estadoDeReparacion;
	}
	public void setEstadoDeReparacion(String estadoDeReparacion) {
		this.estadoDeReparacion = estadoDeReparacion;
	}
	@Override
	public String toString() {
		return "\nOrdenMantenimiento [idOrdenMantenimiento=" + idOrdenMantenimiento + ", nroOrdenMantenimiento="
				+ nroOrdenMantenimiento + ", ambiente=" + ambiente + ", motivo=" + motivo + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", costoDeReparacion=" + costoDeReparacion + ", terminada="
				+ terminada + ", pagada=" + pagada + ", estadoDeReparacion=" + estadoDeReparacion + "]\n";
	}
	
	public long tiempoDeEjecucion() {
		return DAYS.between(fechaInicio, fechaFin);
	}
	

}
