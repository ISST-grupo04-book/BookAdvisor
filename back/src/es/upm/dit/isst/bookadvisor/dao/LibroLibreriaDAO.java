package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.LibroLibreria;

public interface LibroLibreriaDAO {
	public void create(LibroLibreria librolibreria);
	public LibroLibreria read(int ID);
	public void update(LibroLibreria librolibreria);
	public void delete(LibroLibreria librolibreria);
	public Collection<LibroLibreria> readAll();
	//public LibroLibreria login(String email, String psd);
}
