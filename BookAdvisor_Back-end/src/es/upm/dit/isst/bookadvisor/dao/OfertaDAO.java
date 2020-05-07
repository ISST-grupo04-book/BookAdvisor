package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.Oferta;

public interface OfertaDAO {
	public void create(Oferta oferta);
	public Oferta read(int ID);
	public void update(Oferta oferta);
	public void delete(Oferta oferta);
	public Collection<Oferta> readAll();
	//public Oferta login(String email, String psd);
}
