package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.LibroBibliotecaDAO;
import es.upm.dit.isst.bookadvisor.model.LibroBiblioteca;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class LibroBibliotecaDAOImplementation implements LibroBibliotecaDAO{
	private static LibroBibliotecaDAOImplementation instancia = null;
	private LibroBibliotecaDAOImplementation() {
	}
	public static LibroBibliotecaDAOImplementation getInstance() {
		if(null == instancia) instancia = new LibroBibliotecaDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(LibroBiblioteca librobiblioteca) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( librobiblioteca );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(LibroBiblioteca librobiblioteca) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( librobiblioteca );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public LibroBiblioteca read(int ID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		LibroBiblioteca librobiblioteca = session.load( LibroBiblioteca.class, ID );
		session.getTransaction().commit();
		session.close();
		return librobiblioteca;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<LibroBiblioteca> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<LibroBiblioteca> librobibliotecas = session.createQuery( "from LibroBiblioteca" ).list();
		session.getTransaction().commit();
		session.close();
		return librobibliotecas;
	}
	@Override
	public void update(LibroBiblioteca librobiblioteca) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( librobiblioteca );
		session.getTransaction().commit();
		session.close();
	}

	/*public LibroBiblioteca login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		LibroBiblioteca librobiblioteca = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from LibroBiblioteca p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<LibroBiblioteca> librobibliotecas = q.getResultList();
		if (librobibliotecas.size() > 0)
			librobiblioteca = (LibroBiblioteca) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return librobiblioteca;
	}*/
}
