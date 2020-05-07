package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.Usuario;

public interface UsuarioDAO {
	public void create(Usuario usuario);
	public Usuario read(int ID);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);
	public Collection<Usuario> readAll();
	public Usuario login(String email, String pwd);
}
