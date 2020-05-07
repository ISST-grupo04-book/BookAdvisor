package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.Categoria;

public interface CategoriaDAO {
	public void create(Categoria categoria);
	public Categoria read(int id);
	public int getIDByName(String name);
	public void update(Categoria categoria);
	public void delete(Categoria categoria);
	public Collection<Categoria> readAll();
	//public Categoria login(String email, String psd);
}
