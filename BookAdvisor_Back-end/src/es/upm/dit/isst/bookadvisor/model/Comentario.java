package es.upm.dit.isst.bookadvisor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Comentario implements Serializable{

	@Id
	private int ID;
	
	@Lob
	private String contenido;
	
	private int valoracion;
	
	@ManyToOne
	private Usuario IDUsuario;
	
	@ManyToOne
	private Libro ISBN;
	
	public Comentario() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Usuario getIDUsuario() {
		return IDUsuario;
	}

	public void setIDUsuario(Usuario iDUsuario) {
		IDUsuario = iDUsuario;
	}

	public Libro getISBN() {
		return ISBN;
	}

	public void setISBN(Libro iSBN) {
		ISBN = iSBN;
	}
	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int Valoracion) {
		valoracion = Valoracion;
	}

	@Override
	public String toString() {
		return "{\"ID\":" + ID + ", \"contenido\":" + "\"" + contenido + "\"" + ", \"valoracion\":" + valoracion + ", \"IDUsuario\":"
				+ IDUsuario.getID() + ", \"ISBN\":" + ISBN.getISBN() + "}";
	}
}	