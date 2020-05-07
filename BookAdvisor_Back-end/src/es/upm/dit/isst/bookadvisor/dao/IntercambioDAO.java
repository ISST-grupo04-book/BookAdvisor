package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.Intercambio;

public interface IntercambioDAO {
	public void create(Intercambio intercambio);
	public Intercambio read(int ID);
	public void update(Intercambio intercambio);
	public void delete(Intercambio intercambio);
	public Collection<Intercambio> readAll();
	//public Intercambio login(String email, String psd);
}
