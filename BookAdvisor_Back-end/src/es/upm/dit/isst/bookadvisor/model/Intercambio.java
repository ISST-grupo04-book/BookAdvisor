package es.upm.dit.isst.bookadvisor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Intercambio implements Serializable{

	@Id
	private int ID;
	
	private int Estado;
	
	@ManyToOne
	private Usuario IDUsuario;
	
	@ManyToOne
	private Libro ISBN;
	
	public Intercambio() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
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

}	