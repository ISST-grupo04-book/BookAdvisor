package es.upm.dit.isst.bookadvisor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Libro implements Serializable{
	@Id
	private int ISBN;
	
	@Lob
	private String titulo;
	
	private String autor;
	
	private int valoracion;
	
	@Lob
	private String resena;
	private int edicion;
	@Lob
	private String foto;
	
	@ManyToOne
	private Editorial CIFEditorial;
	
	@ManyToOne
	private FormatoLibro IDFormato;
	
	@ManyToOne
	private Categoria IDCategoria;
	
	@OneToMany(mappedBy = "ISBN", fetch = FetchType.EAGER)
	private Collection<Comentario> comentarios;
	
	@OneToMany(mappedBy = "ISBN", fetch = FetchType.EAGER)
	private Collection<Intercambio> intercambios;
	
	@OneToMany(mappedBy = "ISBN", fetch = FetchType.EAGER)
	private Collection<LibroLibreria> librolibreria;
	
	@OneToMany(mappedBy = "ISBN", fetch = FetchType.EAGER)
	private Collection<LibroBiblioteca> librobiblioteca;
	
	@OneToMany(mappedBy = "ISBN", fetch = FetchType.EAGER)
	private Collection<Reedicion> reedicion;
	
	public Libro() {
		
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public String getResena() {
		return resena;
	}

	public void setResena(String resena) {
		this.resena = resena;
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

	public Categoria getIDCategoria() {
		return IDCategoria;
	}

	public void setIDCategoria(Categoria iDCategoria) {
		IDCategoria = iDCategoria;
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

	public Collection<LibroLibreria> getLibrolibreria() {
		return librolibreria;
	}

	public void setLibrolibreria(Collection<LibroLibreria> librolibreria) {
		this.librolibreria = librolibreria;
	}

	public Collection<LibroBiblioteca> getLibrobiblioteca() {
		return librobiblioteca;
	}

	public void setLibrobiblioteca(Collection<LibroBiblioteca> librobiblioteca) {
		this.librobiblioteca = librobiblioteca;
	}

	@Override

	public String toString() {
		return "{\"ISBN\":" + ISBN + ", \"titulo\":" + "\"" + titulo + "\"" + ", \"autor\":" + "\"" + autor + "\"" +", \"valoracion\":" 
				+ valoracion + ", \"resena\":" + "\"" + resena + "\"" +", \"edicion\":" + edicion + ", \"foto\":" + "\"" + foto + "\""
				+ ", \"editorial\":" + "\"" + CIFEditorial.getNombre() + "\"" + ", \"formato\":" + "\"" +IDFormato.getNombre() + "\""  
				+", \"categoria\":" + "\"" + IDCategoria.getNombre() + "\"" + ", \"comentarios\":" + "\"" +comentarios + "\"" 
				+ ", \"intercambios\":" + "\"" +intercambios + "\"" + ", \"librolibreria\":" + "\"" +librolibreria + "\"" 
				+ ", \"librobiblioteca\":"+ "\"" + librobiblioteca + "\"" + ", \"reedicion\":" + "\"" + reedicion +"\"" + "}";
		
	}
	
}
