package es.upm.dit.isst.bookadvisor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Libreria implements Serializable{
	@Id
	private int CIF;

	private String email;
	private String pwd;
	private String nombre;
	private String URL;
	
	@ManyToOne
	private Localizacion IDlocalizacion;
	
	@OneToMany(mappedBy = "IDLibreria", fetch = FetchType.EAGER)
	private Collection<LibroLibreria> librolibreria;
		
	public Libreria() {		
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

	public Localizacion getIDlocalizacion() {
		return IDlocalizacion;
	}

	public void setIDlocalizacion(Localizacion iDlocalizacion) {
		IDlocalizacion = iDlocalizacion;
	}

	public Collection<LibroLibreria> getLibrolibreria() {
		return librolibreria;
	}

	public void setLibrolibreria(Collection<LibroLibreria> librolibreria) {
		this.librolibreria = librolibreria;
	}
	
}
