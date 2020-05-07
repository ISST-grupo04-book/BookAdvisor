package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.Editorial;

public interface EditorialDAO {
	public void create(Editorial editorial);
	public Editorial read(int CIF);
	public void update(Editorial editorial);
	public void delete(Editorial editorial);
	public Collection<Editorial> readAll();
	public Editorial login(String email, String pwd);
}
