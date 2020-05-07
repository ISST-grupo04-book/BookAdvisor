package es.upm.dit.isst.bookadvisor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class TipoBiblioteca implements Serializable{
	@Id
	private int ID;

	private String nombre;
	@Lob
	private String descripcion;

	@OneToMany(mappedBy = "IDTipo", fetch = FetchType.EAGER)
	private Collection<Biblioteca> bibliotecas;
	
	public TipoBiblioteca() {
		
	}
}
