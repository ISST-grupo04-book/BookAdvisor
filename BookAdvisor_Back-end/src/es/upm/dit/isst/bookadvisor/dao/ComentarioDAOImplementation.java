package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.ComentarioDAO;
import es.upm.dit.isst.bookadvisor.model.Comentario;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class ComentarioDAOImplementation implements ComentarioDAO{
	private static ComentarioDAOImplementation instancia = null;
	private ComentarioDAOImplementation() {
	}
	public static ComentarioDAOImplementation getInstance() {
		if(null == instancia) instancia = new ComentarioDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(Comentario comentario) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( comentario );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(Comentario comentario) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( comentario );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public Comentario read(int ID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Comentario comentario = session.load( Comentario.class, ID );
		session.getTransaction().commit();
		session.close();
		return comentario;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Comentario> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Comentario> comentarios = session.createQuery( "from Comentario" ).list();
		session.getTransaction().commit();
		session.close();
		return comentarios;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Comentario> getCommentsByISBN(Libro ISBN) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Comentario> comentarios = session.createQuery( "select p from Comentario p where p.ISBN = :ISBN" ).setParameter("ISBN",ISBN).list();
		session.getTransaction().commit();
		session.close();
		return comentarios;
	}
	
	@Override
	public void update(Comentario comentario) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( comentario );
		session.getTransaction().commit();
		session.close();
	}

	/*public Comentario login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Comentario comentario = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from Comentario p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Comentario> comentarios = q.getResultList();
		if (comentarios.size() > 0)
			comentario = (Comentario) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return comentario;
	}*/
}
