package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.Localizacion;

public interface LocalizacionDAO {
	public void create(Localizacion localizacion);
	public Localizacion read(int ID);
	public void update(Localizacion localizacion);
	public void delete(Localizacion localizacion);
	public Collection<Localizacion> readAll();
	//public Localizacion login(String email, String psd);
}
