package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Ambiente;
import datos.OrdenMantenimiento;

public class OrdenDeMantenimientoDao {

	private static Session session;
	private Transaction tx;

	private static OrdenDeMantenimientoDao  instancia=null; // Patrón Singleton

	protected OrdenDeMantenimientoDao () {}

	public static OrdenDeMantenimientoDao getInstance(){
		if(instancia==null)
			instancia=new OrdenDeMantenimientoDao();
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
	

	
	@SuppressWarnings("unchecked")
	public List<OrdenMantenimiento> traer(Ambiente c) throws HibernateException {
		List<OrdenMantenimiento> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from OrdenMantenimiento o inner join fetch o.ambiente a where a.nroDeAmbiente=" + c.getNroDeAmbiente();
			lista = session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<OrdenMantenimiento> traer(boolean pagada) throws HibernateException {
		List<OrdenMantenimiento> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from OrdenMantenimiento o inner join fetch o.ambiente a where o.pagada="+pagada;
			lista = session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	

}

