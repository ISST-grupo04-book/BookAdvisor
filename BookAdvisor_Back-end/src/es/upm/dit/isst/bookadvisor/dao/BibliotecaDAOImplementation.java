package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.BibliotecaDAO;
import es.upm.dit.isst.bookadvisor.model.Biblioteca;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class BibliotecaDAOImplementation implements BibliotecaDAO{
	private static BibliotecaDAOImplementation instancia = null;
	private BibliotecaDAOImplementation() {
	}
	public static BibliotecaDAOImplementation getInstance() {
		if(null == instancia) instancia = new BibliotecaDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(Biblioteca biblioteca) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( biblioteca );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(Biblioteca biblioteca) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( biblioteca );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public Biblioteca read(int ID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Biblioteca biblioteca = session.load( Biblioteca.class, ID );
		session.getTransaction().commit();
		session.close();
		return biblioteca;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Biblioteca> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Biblioteca> bibliotecas = session.createQuery( "from Biblioteca" ).list();
		session.getTransaction().commit();
		session.close();
		return bibliotecas;
	}
	@Override
	public void update(Biblioteca biblioteca) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( biblioteca );
		session.getTransaction().commit();
		session.close();
	}

	public Biblioteca login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Biblioteca biblioteca = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from Biblioteca p where p.email = :email and p.pwd = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Biblioteca> bibliotecas = q.getResultList();
		if (bibliotecas.size() > 0)
			biblioteca = (Biblioteca) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return biblioteca;
	}
}
