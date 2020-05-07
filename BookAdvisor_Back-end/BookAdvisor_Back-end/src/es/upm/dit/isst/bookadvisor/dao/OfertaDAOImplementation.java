package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.OfertaDAO;
import es.upm.dit.isst.bookadvisor.model.Oferta;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class OfertaDAOImplementation implements OfertaDAO{
	private static OfertaDAOImplementation instancia = null;
	private OfertaDAOImplementation() {
	}
	public static OfertaDAOImplementation getInstance() {
		if(null == instancia) instancia = new OfertaDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(Oferta oferta) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( oferta );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(Oferta oferta) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( oferta );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public Oferta read(int ID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Oferta oferta = session.load( Oferta.class, ID );
		session.getTransaction().commit();
		session.close();
		return oferta;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Oferta> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Oferta> ofertas = session.createQuery( "from Oferta" ).list();
		session.getTransaction().commit();
		session.close();
		return ofertas;
	}
	@Override
	public void update(Oferta oferta) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( oferta );
		session.getTransaction().commit();
		session.close();
	}

	/*public Oferta login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Oferta oferta = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from Oferta p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Oferta> ofertas = q.getResultList();
		if (ofertas.size() > 0)
			oferta = (Oferta) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return oferta;
	}*/
}
