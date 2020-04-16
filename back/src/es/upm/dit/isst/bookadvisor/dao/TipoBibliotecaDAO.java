package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.TipoBiblioteca;

public interface TipoBibliotecaDAO {
	public void create(TipoBiblioteca tipobiblioteca);
	public TipoBiblioteca read(int ID);
	public void update(TipoBiblioteca tipobiblioteca);
	public void delete(TipoBiblioteca tipobiblioteca);
	public Collection<TipoBiblioteca> readAll();
	//public TipoBiblioteca login(String email, String psd);
}
