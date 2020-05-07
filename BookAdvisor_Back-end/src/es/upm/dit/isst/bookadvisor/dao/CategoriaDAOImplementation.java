package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.CategoriaDAO;
import es.upm.dit.isst.bookadvisor.model.Categoria;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class CategoriaDAOImplementation implements CategoriaDAO{
	private static CategoriaDAOImplementation instancia = null;
	private CategoriaDAOImplementation() {
	}
	public static CategoriaDAOImplementation getInstance() {
		if(null == instancia) instancia = new CategoriaDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(Categoria categoria) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( categoria );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(Categoria categoria) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( categoria );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public Categoria read(int ID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Categoria categoria = session.load( Categoria.class, ID );
		session.getTransaction().commit();
		session.close();
		return categoria;
	}
	
	@Override
	public int getIDByName(String name) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		System.out.println(name);
		Query q = session.createQuery("select p from Categoria p where p.nombre = :name");
		q.setParameter("name",name);
		Categoria categoria = (Categoria) q.getResultList().get(0);
		int ID = categoria.getID();
		session.getTransaction().commit();
		session.close();
		return ID;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Categoria> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Categoria> categorias = session.createQuery( "from Categoria" ).list();
		session.getTransaction().commit();
		session.close();
		return categorias;
	}
	@Override
	public void update(Categoria categoria) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( categoria );
		session.getTransaction().commit();
		session.close();
	}

	/*public Categoria login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Categoria categoria = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from Categoria p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Categoria> categorias = q.getResultList();
		if (categorias.size() > 0)
			categoria = (Categoria) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return categoria;
	}*/
}
