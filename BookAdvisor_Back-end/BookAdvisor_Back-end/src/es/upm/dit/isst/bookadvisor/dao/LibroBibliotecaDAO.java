package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.LibroBiblioteca;

public interface LibroBibliotecaDAO {
	public void create(LibroBiblioteca librobiblioteca);
	public LibroBiblioteca read(int ID);
	public void update(LibroBiblioteca librobiblioteca);
	public void delete(LibroBiblioteca librobiblioteca);
	public Collection<LibroBiblioteca> readAll();
	//public LibroBiblioteca login(String email, String psd);
}
