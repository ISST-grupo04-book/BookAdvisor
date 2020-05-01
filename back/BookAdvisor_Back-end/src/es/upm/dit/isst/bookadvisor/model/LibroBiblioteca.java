package es.upm.dit.isst.bookadvisor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class LibroBiblioteca implements Serializable{

	@Id
	private int ID;
	
	
	@ManyToOne
	private Biblioteca IDBiblioteca;
	
	@ManyToOne
	private Libro ISBN;
	
	public LibroBiblioteca() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Biblioteca getIDBiblioteca() {
		return IDBiblioteca;
	}

	public void setIDBiblioteca(Biblioteca iDBiblioteca) {
		IDBiblioteca = iDBiblioteca;
	}

	public Libro getISBN() {
		return ISBN;
	}

	public void setISBN(Libro iSBN) {
		ISBN = iSBN;
	}
	
}
