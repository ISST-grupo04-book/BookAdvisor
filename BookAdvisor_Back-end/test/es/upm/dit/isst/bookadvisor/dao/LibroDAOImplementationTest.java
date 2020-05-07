package es.upm.dit.isst.bookadvisor.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.bookadvisor.model.Libro;

class LibroDAOImplementationTest {

	@Test
	void testCreate() {
		LibroDAO librodao = LibroDAOImplementation.getInstance();
		Libro libro = new Libro();
		libro.setISBN(1234);
		libro.setTitulo("Titulo del libro");
		libro.setAutor("Pepe");
		libro.setValoracion(4);
		libro.setResena("Esto es una reseña del libro");
		libro.setEdicion(3);
		libro.setFoto("/directorio/foto.png");
		libro.setCIFEditorial(null);
		libro.setIDCategoria(null);
		libro.setIDFormato(null);
		librodao.create(libro);
		
		assertEquals(librodao.read(libro.getISBN()).getISBN(), 1234);
		assertEquals(librodao.read(libro.getISBN()).getTitulo(), "Titulo del libro");
		assertEquals(librodao.read(libro.getISBN()).getAutor(), "Pepe");
		assertEquals(librodao.read(libro.getISBN()).getValoracion(), 4);
		assertEquals(librodao.read(libro.getISBN()).getResena(), "Esto es una reseña del libro");
		assertEquals(librodao.read(libro.getISBN()).getEdicion(), 3);
		assertEquals(librodao.read(libro.getISBN()).getFoto(), "/directorio/foto.png");
		
		librodao.delete(libro);
	}

	@Test
	void testDelete() {
		
		Assertions.assertThrows(org.hibernate.LazyInitializationException.class, () -> {
			LibroDAO librodao = LibroDAOImplementation.getInstance();
			Libro libro = new Libro();
			libro.setISBN(1243);
			libro.setTitulo("Titulo del libro");
			libro.setAutor("Pepe");
			libro.setValoracion(4);
			libro.setResena("Esto es una reseña del libro");
			libro.setEdicion(3);
			libro.setFoto("/directorio/foto.png");
			libro.setCIFEditorial(null);
			libro.setIDCategoria(null);
			libro.setIDFormato(null);
			librodao.create(libro);
			
			librodao.delete(libro);
			
			assertEquals(librodao.read(libro.getISBN()).getTitulo(), "Titulo del libro");

		});
	}

	@Test
	void testRead() {
		LibroDAO librodao = LibroDAOImplementation.getInstance();
		Libro libro = new Libro();
		libro.setISBN(2134);
		libro.setTitulo("Titulo del libro");
		libro.setAutor("Pepe");
		libro.setValoracion(4);
		libro.setResena("Esto es una reseña del libro");
		libro.setEdicion(3);
		libro.setFoto("/directorio/foto.png");
		libro.setCIFEditorial(null);
		libro.setIDCategoria(null);
		libro.setIDFormato(null);
		librodao.create(libro);
		
		assertEquals(librodao.read(libro.getISBN()).getISBN(), 2134);
		assertEquals(librodao.read(libro.getISBN()).getTitulo(), "Titulo del libro");
		assertEquals(librodao.read(libro.getISBN()).getAutor(), "Pepe");
		assertEquals(librodao.read(libro.getISBN()).getValoracion(), 4);
		assertEquals(librodao.read(libro.getISBN()).getResena(), "Esto es una reseña del libro");
		assertEquals(librodao.read(libro.getISBN()).getEdicion(), 3);
		assertEquals(librodao.read(libro.getISBN()).getFoto(), "/directorio/foto.png");
		
		librodao.delete(libro);
	}

	@Test
	void testReadAll() {
		LibroDAO librodao = LibroDAOImplementation.getInstance();
		Libro libro = new Libro();
		libro.setISBN(1122);
		libro.setTitulo("Titulo del libro");
		libro.setAutor("Pepe");
		libro.setValoracion(4);
		libro.setResena("Esto es una reseña del libro");
		libro.setEdicion(3);
		libro.setFoto("/directorio/foto.png");
		libro.setCIFEditorial(null);
		libro.setIDCategoria(null);
		libro.setIDFormato(null);
		librodao.create(libro);
		
		Libro libro2 = new Libro();
		libro2.setISBN(4321);
		libro2.setTitulo("Titulo del libro2");
		libro2.setAutor("Pepe2");
		libro2.setValoracion(4);
		libro2.setResena("Esto es una reseña del libro2");
		libro2.setEdicion(3);
		libro2.setFoto("/directorio/foto.png2");
		libro2.setCIFEditorial(null);
		libro2.setIDCategoria(null);
		libro2.setIDFormato(null);
		librodao.create(libro2);
		
		Collection<Libro> libroslista = librodao.readAll();
		
		librodao.delete(libro);
		librodao.delete(libro2);
		
		assertEquals(libroslista.size(), 2);
		
	}

	@Test
	void testUpdate() {
		LibroDAO librodao = LibroDAOImplementation.getInstance();
		Libro libro = new Libro();
		libro.setISBN(1432);
		libro.setTitulo("Titulo del libro");
		libro.setAutor("Pepe");
		libro.setValoracion(4);
		libro.setResena("Esto es una reseña del libro");
		libro.setEdicion(3);
		libro.setFoto("/directorio/foto.png");
		libro.setCIFEditorial(null);
		libro.setIDCategoria(null);
		libro.setIDFormato(null);
		librodao.create(libro);
		
		libro.setTitulo("Titulo del libro Actualizado");
		libro.setAutor("Pepe Actualizado");
		libro.setValoracion(5);
		libro.setResena("Esto es una reseña del libro Actualizado");
		libro.setEdicion(4);
		libro.setFoto("/directorio/fotoActualizado.png");
		librodao.update(libro);
		
		assertEquals(librodao.read(libro.getISBN()).getTitulo(), "Titulo del libro Actualizado");
		assertEquals(librodao.read(libro.getISBN()).getAutor(), "Pepe Actualizado");
		assertEquals(librodao.read(libro.getISBN()).getValoracion(), 5);
		assertEquals(librodao.read(libro.getISBN()).getResena(), "Esto es una reseña del libro Actualizado");
		assertEquals(librodao.read(libro.getISBN()).getEdicion(), 4);
		assertEquals(librodao.read(libro.getISBN()).getFoto(), "/directorio/fotoActualizado.png");
		
		librodao.delete(libro);
	}
}