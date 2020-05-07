package es.upm.dit.isst.bookadvisor.dao;

import java.util.Collection;

import es.upm.dit.isst.bookadvisor.model.Comentario;
import es.upm.dit.isst.bookadvisor.model.Libro;

public interface ComentarioDAO {
	public void create(Comentario comentario);
	public Comentario read(int ID);
	public void update(Comentario comentario);
	public void delete(Comentario comentario);
	public Collection<Comentario> readAll();
	public Collection<Comentario> getCommentsByISBN(Libro ISBN);
	//public Comentario login(String email, String psd);
}
