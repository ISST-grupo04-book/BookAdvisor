package es.upm.dit.isst.bookadvisor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Categoria implements Serializable{
	@Id
	private int ID;

	private String nombre;
	@Lob
	private String descripcion;

	@OneToMany(mappedBy = "IDCategoria", fetch = FetchType.EAGER)
	private Collection<Libro> libros;
	
	public Categoria() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Collection<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Collection<Libro> libros) {
		this.libros = libros;
	}
	
}
