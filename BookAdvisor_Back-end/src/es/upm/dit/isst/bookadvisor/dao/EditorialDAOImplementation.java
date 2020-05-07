package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.EditorialDAO;
import es.upm.dit.isst.bookadvisor.model.Editorial;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class EditorialDAOImplementation implements EditorialDAO{
	private static EditorialDAOImplementation instancia = null;
	private EditorialDAOImplementation() {
	}
	public static EditorialDAOImplementation getInstance() {
		if(null == instancia) instancia = new EditorialDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(Editorial editorial) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( editorial );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(Editorial editorial) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( editorial );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public Editorial read(int CIF) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Editorial editorial = session.load( Editorial.class, CIF );
		session.getTransaction().commit();
		session.close();
		return editorial;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Editorial> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Editorial> editorials = session.createQuery( "from Editorial" ).list();
		session.getTransaction().commit();
		session.close();
		return editorials;
	}
	@Override
	public void update(Editorial editorial) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( editorial );
		session.getTransaction().commit();
		session.close();
	}

	public Editorial login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Editorial editorial = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from Editorial p where p.email = :email and p.pwd = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Editorial> editorials = q.getResultList();
		if (editorials.size() > 0)
			editorial = (Editorial) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return editorial;
	}
}
