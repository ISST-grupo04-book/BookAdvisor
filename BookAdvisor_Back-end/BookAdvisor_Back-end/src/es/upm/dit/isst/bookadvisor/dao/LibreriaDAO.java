package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.Libreria;

public interface LibreriaDAO {
	public void create(Libreria libreria);
	public Libreria read(int CIF);
	public void update(Libreria libreria);
	public void delete(Libreria libreria);
	public Collection<Libreria> readAll();
	public Libreria login(String email, String pwd);
}
