package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.FormatoLibro;

public interface FormatoLibroDAO {
	public void create(FormatoLibro formatolibro);
	public FormatoLibro read(int ID);
	public void update(FormatoLibro formatolibro);
	public void delete(FormatoLibro formatolibro);
	public Collection<FormatoLibro> readAll();
	//public FormatoLibro login(String email, String psd);
}
