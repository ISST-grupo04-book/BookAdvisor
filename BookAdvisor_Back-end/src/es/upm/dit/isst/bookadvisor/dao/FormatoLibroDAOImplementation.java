package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.FormatoLibroDAO;
import es.upm.dit.isst.bookadvisor.model.FormatoLibro;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class FormatoLibroDAOImplementation implements FormatoLibroDAO{
	private static FormatoLibroDAOImplementation instancia = null;
	private FormatoLibroDAOImplementation() {
	}
	public static FormatoLibroDAOImplementation getInstance() {
		if(null == instancia) instancia = new FormatoLibroDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(FormatoLibro formatolibro) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( formatolibro );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(FormatoLibro formatolibro) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( formatolibro );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public FormatoLibro read(int ID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		FormatoLibro formatolibro = session.load( FormatoLibro.class, ID );
		session.getTransaction().commit();
		session.close();
		return formatolibro;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<FormatoLibro> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<FormatoLibro> formatolibros = session.createQuery( "from FormatoLibro" ).list();
		session.getTransaction().commit();
		session.close();
		return formatolibros;
	}
	@Override
	public void update(FormatoLibro formatolibro) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( formatolibro );
		session.getTransaction().commit();
		session.close();
	}

	/*public FormatoLibro login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		FormatoLibro formatolibro = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from FormatoLibro p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<FormatoLibro> formatolibros = q.getResultList();
		if (formatolibros.size() > 0)
			formatolibro = (FormatoLibro) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return formatolibro;
	}*/
}
