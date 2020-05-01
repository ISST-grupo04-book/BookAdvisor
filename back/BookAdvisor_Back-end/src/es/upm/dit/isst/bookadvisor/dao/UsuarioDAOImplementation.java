package es.upm.dit.isst.bookadvisor.dao;

import org.hibernate.*;

import es.upm.dit.isst.bookadvisor.dao.UsuarioDAO;
import es.upm.dit.isst.bookadvisor.model.Usuario;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

public class UsuarioDAOImplementation implements UsuarioDAO{
	private static UsuarioDAOImplementation instancia = null;
	private UsuarioDAOImplementation() {
	}
	public static UsuarioDAOImplementation getInstance() {
		if(null == instancia) instancia = new UsuarioDAOImplementation();
		return instancia;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void create(Usuario usuario) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( usuario );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(Usuario usuario) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( usuario );
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public Usuario read(int ID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Usuario usuario = session.load( Usuario.class, ID );
		session.getTransaction().commit();
		session.close();
		return usuario;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Usuario> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Usuario> usuarios = session.createQuery( "from Usuario" ).list();
		session.getTransaction().commit();
		session.close();
		return usuarios;
	}
	@Override
	public void update(Usuario usuario) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate( usuario );
		session.getTransaction().commit();
		session.close();
	}

	public Usuario login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Usuario usuario = null;
		session.beginTransaction();
		Query q = session.createQuery("select p from Usuario p where p.email = :email and p.pwd = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Usuario> usuarios = q.getResultList();
		if (usuarios.size() > 0)
			usuario = (Usuario) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return usuario;
	}
}
