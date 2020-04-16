package es.upm.dit.isst.bookadvisor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Usuario implements Serializable{
	@Id
	private int ID;

	private String email;
	private String pwd;
	private String username;
	private String nombre;
	private int telefono;
	private Localizacion IDlocalizacion;



	@OneToMany(mappedBy = "IDUsuario", fetch = FetchType.EAGER)
	private Collection<Comentario> comentarios;
	
	@OneToMany(mappedBy = "IDUsuario", fetch = FetchType.EAGER)
	private Collection<Intercambio> intercambios;
	
	public Usuario() {		
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Localizacion getIDlocalizacion() {
		return IDlocalizacion;
	}

	public void setIDlocalizacion(Localizacion iDlocalizacion) {
		IDlocalizacion = iDlocalizacion;
	}

	public Collection<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Collection<Intercambio> getIntercambios() {
		return intercambios;
	}

	public void setIntercambios(Collection<Intercambio> intercambios) {
		this.intercambios = intercambios;
	}
	
}
