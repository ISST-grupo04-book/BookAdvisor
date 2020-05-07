package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.IntercambioDAO;
import es.upm.dit.isst.bookadvisor.model.Intercambio;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class IntercambioDAOImplementation implements IntercambioDAO{
	private static IntercambioDAOImplementation instancia = null;
	private IntercambioDAOImplementation() {
	}
	public static IntercambioDAOImplementation getInstance() {
		if(null == instancia) instancia = new IntercambioDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(Intercambio intercambio) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( intercambio );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(Intercambio intercambio) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( intercambio );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public Intercambio read(int ID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Intercambio intercambio = session.load( Intercambio.class, ID );
		session.getTransaction().commit();
		session.close();
		return intercambio;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Intercambio> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Intercambio> intercambios = session.createQuery( "from Intercambio" ).list();
		session.getTransaction().commit();
		session.close();
		return intercambios;
	}
	@Override
	public void update(Intercambio intercambio) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( intercambio );
		session.getTransaction().commit();
		session.close();
	}

	/*public Intercambio login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Intercambio intercambio = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from Intercambio p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Intercambio> intercambios = q.getResultList();
		if (intercambios.size() > 0)
			intercambio = (Intercambio) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return intercambio;
	}*/
}
