package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.LibroLibreriaDAO;
import es.upm.dit.isst.bookadvisor.model.LibroLibreria;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class LibroLibreriaDAOImplementation implements LibroLibreriaDAO{
	private static LibroLibreriaDAOImplementation instancia = null;
	private LibroLibreriaDAOImplementation() {
	}
	public static LibroLibreriaDAOImplementation getInstance() {
		if(null == instancia) instancia = new LibroLibreriaDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(LibroLibreria librolibreria) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( librolibreria );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(LibroLibreria librolibreria) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( librolibreria );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public LibroLibreria read(int ID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		LibroLibreria librolibreria = session.load( LibroLibreria.class, ID );
		session.getTransaction().commit();
		session.close();
		return librolibreria;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<LibroLibreria> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<LibroLibreria> librolibrerias = session.createQuery( "from LibroLibreria" ).list();
		session.getTransaction().commit();
		session.close();
		return librolibrerias;
	}
	@Override
	public void update(LibroLibreria librolibreria) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( librolibreria );
		session.getTransaction().commit();
		session.close();
	}

	public LibroLibreria login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		LibroLibreria librolibreria = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from LibroLibreria p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<LibroLibreria> librolibrerias = q.getResultList();
		if (librolibrerias.size() > 0)
			librolibreria = (LibroLibreria) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return librolibreria;
	}
}
