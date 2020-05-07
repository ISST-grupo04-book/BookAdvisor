package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.LocalizacionDAO;
import es.upm.dit.isst.bookadvisor.model.Localizacion;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class LocalizacionDAOImplementation implements LocalizacionDAO{
	private static LocalizacionDAOImplementation instancia = null;
	private LocalizacionDAOImplementation() {
	}
	public static LocalizacionDAOImplementation getInstance() {
		if(null == instancia) instancia = new LocalizacionDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(Localizacion localizacion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( localizacion );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(Localizacion localizacion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( localizacion );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public Localizacion read(int ID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Localizacion localizacion = session.load( Localizacion.class, ID );
		session.getTransaction().commit();
		session.close();
		return localizacion;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Localizacion> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Localizacion> localizacions = session.createQuery( "from Localizacion" ).list();
		session.getTransaction().commit();
		session.close();
		return localizacions;
	}
	@Override
	public void update(Localizacion localizacion) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( localizacion );
		session.getTransaction().commit();
		session.close();
	}

	/*public Localizacion login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Localizacion localizacion = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from Localizacion p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Localizacion> localizacions = q.getResultList();
		if (localizacions.size() > 0)
			localizacion = (Localizacion) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return localizacion;
	}*/
}
