package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.ReedicionDAO;
import es.upm.dit.isst.bookadvisor.model.Reedicion;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class ReedicionDAOImplementation implements ReedicionDAO{
	private static ReedicionDAOImplementation instancia = null;
	private ReedicionDAOImplementation() {
	}
	public static ReedicionDAOImplementation getInstance() {
		if(null == instancia) instancia = new ReedicionDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(Reedicion reedicion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( reedicion );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(Reedicion reedicion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( reedicion );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public Reedicion read(int ID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Reedicion reedicion = session.load( Reedicion.class, ID );
		session.getTransaction().commit();
		session.close();
		return reedicion;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Reedicion> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Reedicion> reedicions = session.createQuery( "from Reedicion" ).list();
		session.getTransaction().commit();
		session.close();
		return reedicions;
	}
	@Override
	public void update(Reedicion reedicion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( reedicion );
		session.getTransaction().commit();
		session.close();
	}

	/*public Reedicion login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Reedicion reedicion = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from Reedicion p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Reedicion> reedicions = q.getResultList();
		if (reedicions.size() > 0)
			reedicion = (Reedicion) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return reedicion;
	}*/
}
