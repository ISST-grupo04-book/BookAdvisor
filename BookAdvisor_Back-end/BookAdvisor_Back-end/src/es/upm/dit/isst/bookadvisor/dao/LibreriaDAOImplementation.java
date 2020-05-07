package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.LibreriaDAO;
import es.upm.dit.isst.bookadvisor.model.Libreria;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class LibreriaDAOImplementation implements LibreriaDAO{
	private static LibreriaDAOImplementation instancia = null;
	private LibreriaDAOImplementation() {
	}
	public static LibreriaDAOImplementation getInstance() {
		if(null == instancia) instancia = new LibreriaDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(Libreria libreria) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( libreria );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(Libreria libreria) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( libreria );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public Libreria read(int CIF) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Libreria libreria = session.load( Libreria.class, CIF );
		session.getTransaction().commit();
		session.close();
		return libreria;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Libreria> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Libreria> librerias = session.createQuery( "from Libreria" ).list();
		session.getTransaction().commit();
		session.close();
		return librerias;
	}
	@Override
	public void update(Libreria libreria) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( libreria );
		session.getTransaction().commit();
		session.close();
	}

	public Libreria login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Libreria libreria = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from Libreria p where p.email = :email and p.pwd = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Libreria> librerias = q.getResultList();
		if (librerias.size() > 0)
			libreria = (Libreria) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return libreria;
	}
}
