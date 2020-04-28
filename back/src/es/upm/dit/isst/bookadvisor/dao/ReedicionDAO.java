<<<<<<< HEAD
package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.Reedicion;

public interface ReedicionDAO {
	public void create(Reedicion reedicion);
	public Reedicion read(int ISBN);
	public void update(Reedicion reedicion);
	public void delete(Reedicion reedicion);
	public Collection<Reedicion> readAll();
	//public Oferta login(String email, String psd);
=======
package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.Reedicion;

public interface ReedicionDAO {
	public void create(Reedicion reedicion);
	public Reedicion read(int ISBN);
	public void update(Reedicion reedicion);
	public void delete(Reedicion reedicion);
	public Collection<Reedicion> readAll();
	//public Oferta login(String email, String psd);
>>>>>>> 28d0303b7b3b2136a5a45bb046b0672ae29d53df
}