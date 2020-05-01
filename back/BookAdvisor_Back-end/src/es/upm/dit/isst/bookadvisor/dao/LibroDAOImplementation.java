package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.LibroDAO;
import es.upm.dit.isst.bookadvisor.model.Libro;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class LibroDAOImplementation implements LibroDAO{
	private static LibroDAOImplementation instancia = null;
	private LibroDAOImplementation() {
	}
	public static LibroDAOImplementation getInstance() {
		if(null == instancia) instancia = new LibroDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(Libro libro) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( libro );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(Libro libro) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( libro );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public Libro read(int ISBN) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Libro libro = session.load( Libro.class, ISBN );
		session.getTransaction().commit();
		session.close();
		return libro;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Libro> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Libro> libros = session.createQuery( "from Libro" ).list();
		session.getTransaction().commit();
		session.close();
		return libros;
	}
	@Override
	public void update(Libro libro) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( libro );
		session.getTransaction().commit();
		session.close();
	}

/*	public Libro login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Libro libro = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from Libro p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Libro> libros = q.getResultList();
		if (libros.size() > 0)
			libro = (Libro) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return libro;
	}*/
}
