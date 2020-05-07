package es.upm.dit.isst.bookadvisor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Editorial implements Serializable{
	@Id
	private int CIF;

	private String email;
	private String pwd;
	private String nombre;
	private String URL;

	@OneToMany(mappedBy = "CIFEditorial", fetch = FetchType.EAGER)
	private Collection<Libro> libros;
	
	@OneToMany(mappedBy = "CIFEditorial", fetch = FetchType.EAGER)
	private Collection<Reedicion> reedicion;
	
	public Editorial() {
		
	}

	public int getCIF() {
		return CIF;
	}


	public void setCIF(int cIF) {
		CIF = cIF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public Collection<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Collection<Libro> libros) {
		this.libros = libros;
	}
	
	public Collection<Reedicion> getReedicion() {
		return reedicion;
	}

	public void setReedicion(Collection<Reedicion> reedicion) {
		this.reedicion = reedicion;
	}
	
	@Override
	public String toString() {
		return "{\"CIF\":" + CIF + ", \"email\":" + "\"" + email + "\"" + ", \"pwd\":" + "\"" + pwd + "\"" +", \"nombre\":" 
				+ nombre + ", \"URL\":" + "\"" + URL + "\"" +", \"libros\":" + libros + ", \"reedicion\":" + "\"" + reedicion + "}";
		
	}
}
