package es.upm.dit.isst.bookadvisor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Reedicion implements Serializable{
	@Id
	private int ISBN;
	
	@Lob
	private String descripcion;
	
	private int edicion;
	
	@Lob
	private String foto;
	
	@ManyToOne
	private Editorial CIFEditorial;
	
	@ManyToOne
	private FormatoLibro IDFormato;
	
	@ManyToOne
	private Libro FichaLibro;
	
	public Reedicion() {
		
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEdicion() {
		return edicion;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Editorial getCIFEditorial() {
		return CIFEditorial;
	}

	public void setCIFEditorial(Editorial cIFEditorial) {
		CIFEditorial = cIFEditorial;
	}

	public FormatoLibro getIDFormato() {
		return IDFormato;
	}

	public void setIDFormato(FormatoLibro iDFormato) {
		IDFormato = iDFormato;
	}

	public Libro getFichaLibro() {
		return FichaLibro;
	}

	public void setFichaLibro(Libro fichaLibro) {
		FichaLibro = fichaLibro;
	}
	
	

}	