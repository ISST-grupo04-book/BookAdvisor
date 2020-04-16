package es.upm.dit.isst.bookadvisor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Oferta implements Serializable{
	@Id
	private int ID;

	private String nombre;
	@Lob
	private String descripcion;

	private Libreria CIF;
	
	public Oferta() {
		
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

	public Libreria getCIF() {
		return CIF;
	}

	public void setCIF(Libreria cIF) {
		CIF = cIF;
	}
	
}
