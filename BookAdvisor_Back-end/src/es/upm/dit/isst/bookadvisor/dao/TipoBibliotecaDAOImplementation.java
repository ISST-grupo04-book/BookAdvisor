package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.TipoBibliotecaDAO;
import es.upm.dit.isst.bookadvisor.model.TipoBiblioteca;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class TipoBibliotecaDAOImplementation implements TipoBibliotecaDAO{
	private static TipoBibliotecaDAOImplementation instancia = null;
	private TipoBibliotecaDAOImplementation() {
	}
	public static TipoBibliotecaDAOImplementation getInstance() {
		if(null == instancia) instancia = new TipoBibliotecaDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(TipoBiblioteca tipobiblioteca) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( tipobiblioteca );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(TipoBiblioteca tipobiblioteca) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( tipobiblioteca );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public TipoBiblioteca read(int ID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		TipoBiblioteca tipobiblioteca = session.load( TipoBiblioteca.class, ID );
		session.getTransaction().commit();
		session.close();
		return tipobiblioteca;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<TipoBiblioteca> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<TipoBiblioteca> tipobibliotecas = session.createQuery( "from TipoBiblioteca" ).list();
		session.getTransaction().commit();
		session.close();
		return tipobibliotecas;
	}
	@Override
	public void update(TipoBiblioteca tipobiblioteca) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( tipobiblioteca );
		session.getTransaction().commit();
		session.close();
	}

	/*public TipoBiblioteca login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		TipoBiblioteca tipobiblioteca = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from TipoBiblioteca p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<TipoBiblioteca> tipobibliotecas = q.getResultList();
		if (tipobibliotecas.size() > 0)
			tipobiblioteca = (TipoBiblioteca) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return tipobiblioteca;
	}*/
}
