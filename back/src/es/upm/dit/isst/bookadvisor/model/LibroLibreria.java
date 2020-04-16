package es.upm.dit.isst.bookadvisor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class LibroLibreria implements Serializable{

	@Id
	private int ID;
	
	
	@ManyToOne
	private Libreria IDLibreria;
	
	@ManyToOne
	private Libro ISBN;
	
	public LibroLibreria() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Libreria getIDLibreria() {
		return IDLibreria;
	}

	public void setIDLibreria(Libreria iDLibreria) {
		IDLibreria = iDLibreria;
	}

	public Libro getISBN() {
		return ISBN;
	}

	public void setISBN(Libro iSBN) {
		ISBN = iSBN;
	}
	
}
