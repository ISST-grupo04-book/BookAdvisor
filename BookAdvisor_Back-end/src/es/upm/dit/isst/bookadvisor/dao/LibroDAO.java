package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.Categoria;
import es.upm.dit.isst.bookadvisor.model.Libro;

public interface LibroDAO {
	public void create(Libro libro);
	public Libro read(int ISBN);
	public void update(Libro libro);
	public void delete(Libro libro);
	public Collection<Libro> readAll();
	public Collection<Libro> getLibrosByCategoria(Categoria object);
	//public Libro login(String email, String psd);
}
