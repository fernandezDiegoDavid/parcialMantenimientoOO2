package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.OrdenDeMantenimientoDao;
import datos.Ambiente;
import datos.OrdenMantenimiento;

public class OrdenDeMantenimientoAbm {
	
	private static OrdenDeMantenimientoAbm instancia=null; // Patrón Singleton
	protected OrdenDeMantenimientoAbm() {}
	public static OrdenDeMantenimientoAbm getInstance(){
	if(instancia==null)
	instancia=new OrdenDeMantenimientoAbm();
	return instancia;
	}
	
	public List<OrdenMantenimiento> traer(Ambiente ambiente){
		return OrdenDeMantenimientoDao.getInstance().traer(ambiente);
		
	}

	
	public List<OrdenMantenimiento> traer(Ambiente ambiente,boolean terminada){
		List<OrdenMantenimiento> lista = OrdenDeMantenimientoDao.getInstance().traer(ambiente);
		List<OrdenMantenimiento> salida= new ArrayList<OrdenMantenimiento>();
		for (OrdenMantenimiento ordenMantenimiento : lista) {
			
			if ((ordenMantenimiento.isTerminada()) == terminada) {
				salida.add(ordenMantenimiento);
			}
		}
		return salida;
		
	}
	
	public List<OrdenMantenimiento> traer(boolean pagada){
		return OrdenDeMantenimientoDao.getInstance().traer(pagada);
		
	}
	
	public Informe traerInforme(boolean pagada) {
		Informe informe = new Informe();
		List<OrdenMantenimiento> ordenes = OrdenDeMantenimientoDao.getInstance().traer(pagada);
		double total=0;
		for (OrdenMantenimiento ordenMantenimiento : ordenes) {
			
			total = total+ordenMantenimiento.getCostoDeReparacion();
		}
		informe.setOrdenes(ordenes);
		informe.setTotal(total);
		
		
		return informe;
		
	}

}
