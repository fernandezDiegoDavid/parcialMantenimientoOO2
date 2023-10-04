package negocio;

import dao.AmbienteDao;
import datos.Ambiente;

public class AmbienteAbm {
	
	private static AmbienteAbm instancia=null; // Patrón Singleton
	protected AmbienteAbm() {}
	public static AmbienteAbm getInstance(){
	if(instancia==null)
	instancia=new AmbienteAbm();
	return instancia;
	}
	
	public Ambiente traer(int idAmbiente) {
		
		return AmbienteDao.getInstance().traer(idAmbiente);
	}
}
