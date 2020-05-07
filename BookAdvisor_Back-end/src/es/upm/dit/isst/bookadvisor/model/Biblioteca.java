package es.upm.dit.isst.bookadvisor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Biblioteca implements Serializable{
	@Id
	private int ID;

	private String email;
	private String pwd;
	private String nombre;
	private String URL;
	
	@ManyToOne
	private Localizacion IDlocalizacion;


	@ManyToOne
	private TipoBiblioteca IDTipo;
	
	@OneToMany(mappedBy = "IDBiblioteca", fetch = FetchType.EAGER)
	private Collection<LibroBiblioteca> librobiblioteca;
		
	public Biblioteca() {		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public TipoBiblioteca getIDTipo() {
		return IDTipo;
	}

	public void setIDTipo(TipoBiblioteca iDTipo) {
		IDTipo = iDTipo;
	}

	public Collection<LibroBiblioteca> getLibrobiblioteca() {
		return librobiblioteca;
	}

	public void setLibrobiblioteca(Collection<LibroBiblioteca> librobiblioteca) {
		this.librobiblioteca = librobiblioteca;
	}
	
}
