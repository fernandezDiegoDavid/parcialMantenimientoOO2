package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Ambiente;

public class AmbienteDao {

	private static Session session;
	private Transaction tx;

	private static AmbienteDao instancia=null; // Patrón Singleton
	
	protected AmbienteDao() {}
	
	public static AmbienteDao getInstance(){
		if(instancia==null)
			instancia=new AmbienteDao();
		return instancia;
	}

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public Ambiente traer(int idAmbiente) throws HibernateException {
		Ambiente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Ambiente) session.get(Ambiente.class, idAmbiente);
		} finally {
			session.close();
		}
		return objeto;
	}
}
