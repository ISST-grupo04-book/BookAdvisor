package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.Biblioteca;

public interface BibliotecaDAO {
	public void create(Biblioteca biblioteca);
	public Biblioteca read(int ID);
	public void update(Biblioteca biblioteca);
	public void delete(Biblioteca biblioteca);
	public Collection<Biblioteca> readAll();
	public Biblioteca login(String email, String pwd);
}
