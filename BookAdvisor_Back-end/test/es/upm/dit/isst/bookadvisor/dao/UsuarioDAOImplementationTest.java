package es.upm.dit.isst.bookadvisor.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.bookadvisor.model.Usuario;

class UsuarioDAOImplementationTest {

	@Test
	void testCreate() {
		UsuarioDAO usuariodao = UsuarioDAOImplementation.getInstance();
		Usuario usuario = new Usuario();
		usuario.setID(501);
		usuario.setTelefono(657784673);
		usuario.setUsername("user");
		usuario.setEmail("usuario@correo.com");
		usuario.setNombre("nombre");
		usuario.setPwd("password");
		usuario.setIDlocalizacion(null);
		usuariodao.create(usuario);
		assertEquals(usuariodao.read(usuario.getID()).getID(), 501);
		assertEquals(usuariodao.read(usuario.getID()).getNombre(), "nombre");
		assertEquals(usuariodao.read(usuario.getID()).getTelefono(), 657784673);
		assertEquals(usuariodao.read(usuario.getID()).getUsername(), "user");
		assertEquals(usuariodao.read(usuario.getID()).getPwd(), "password");
		assertEquals(usuariodao.read(usuario.getID()).getEmail(), "usuario@correo.com");
		usuariodao.delete(usuario);
	}

	@Test
	void testDelete() {
		
		Assertions.assertThrows(org.hibernate.LazyInitializationException.class, () -> {

			UsuarioDAO usuariodao = UsuarioDAOImplementation.getInstance();
			Usuario usuario = new Usuario();
			usuario.setID(500);
			usuario.setTelefono(657784673);
			usuario.setUsername("user");
			usuario.setEmail("usuario@correo.com");
			usuario.setNombre("nombre");
			usuario.setPwd("password");
			usuario.setIDlocalizacion(null);
			usuariodao.create(usuario);
			
			usuariodao.delete(usuario);

			assertEquals(usuariodao.read(usuario.getID()).getEmail(), "usuario@correo.com");
		});

	}

	@Test
	void testRead() {
		UsuarioDAO usuariodao = UsuarioDAOImplementation.getInstance();
		Usuario usuario = new Usuario();
		usuario.setID(501);
		usuario.setTelefono(657784673);
		usuario.setUsername("user");
		usuario.setEmail("usuario@correo.com");
		usuario.setNombre("nombre");
		usuario.setPwd("password");
		usuario.setIDlocalizacion(null);
		usuariodao.create(usuario);
		assertEquals(usuariodao.read(usuario.getID()).getID(), 501);
		assertEquals(usuariodao.read(usuario.getID()).getNombre(), "nombre");
		assertEquals(usuariodao.read(usuario.getID()).getTelefono(), 657784673);
		assertEquals(usuariodao.read(usuario.getID()).getUsername(), "user");
		assertEquals(usuariodao.read(usuario.getID()).getPwd(), "password");
		assertEquals(usuariodao.read(usuario.getID()).getEmail(), "usuario@correo.com");
		usuariodao.delete(usuario);
	}

	@Test
	void testReadAll() {
		UsuarioDAO usuariodao = UsuarioDAOImplementation.getInstance();
		Usuario usuario = new Usuario();
		usuario.setID(400);
		usuario.setTelefono(657784673);
		usuario.setUsername("user");
		usuario.setEmail("usuario@correo.com");
		usuario.setNombre("nombre");
		usuario.setPwd("password");
		usuario.setIDlocalizacion(null);
		usuariodao.create(usuario);
		
		Usuario usuario2 = new Usuario();
		usuario2.setID(401);
		usuario2.setTelefono(636445281);
		usuario2.setUsername("user2");
		usuario2.setEmail("usuario2@correo.com");
		usuario2.setNombre("nombre2");
		usuario2.setPwd("password2");
		usuario2.setIDlocalizacion(null);
		usuariodao.create(usuario2);
		
		
		Collection<Usuario> usuarioslista = usuariodao.readAll();
		
		usuariodao.delete(usuario);
		usuariodao.delete(usuario2);
		
		assertEquals(usuarioslista.size(), 2);
		
	}

	@Test
	void testUpdate() {
		UsuarioDAO usuariodao = UsuarioDAOImplementation.getInstance();
		Usuario usuario = new Usuario();
		usuario.setID(503);
		usuario.setTelefono(657784673);
		usuario.setUsername("user");
		usuario.setEmail("usuario@correo.com");
		usuario.setNombre("nombre");
		usuario.setPwd("password");
		usuario.setIDlocalizacion(null);
		usuariodao.create(usuario);
		
		usuario.setTelefono(767448392);
		usuario.setUsername("userActualizado");
		usuario.setEmail("actualizado@correo.com");
		usuario.setNombre("nombreActualizado");
		usuario.setPwd("passwordActualizado");
		usuariodao.update(usuario);
		
		assertEquals(usuariodao.read(usuario.getID()).getNombre(), "nombreActualizado");
		assertEquals(usuariodao.read(usuario.getID()).getTelefono(), 767448392);
		assertEquals(usuariodao.read(usuario.getID()).getUsername(), "userActualizado");
		assertEquals(usuariodao.read(usuario.getID()).getPwd(), "passwordActualizado");
		assertEquals(usuariodao.read(usuario.getID()).getEmail(), "actualizado@correo.com");
		
		usuariodao.delete(usuario);
	}

	@Test
	void testLogin() {
		UsuarioDAO usuariodao = UsuarioDAOImplementation.getInstance();
		Usuario usuario = new Usuario();
		usuario.setID(504);
		usuario.setTelefono(123);
		usuario.setUsername("user");
		usuario.setEmail("usuario1");
		usuario.setNombre("nombre");
		usuario.setPwd("password");
		usuario.setIDlocalizacion(null);
		
		usuariodao.create(usuario);		
		Usuario usuario2 = usuariodao.login("usuario1", "password");
		assertEquals(usuario2.getEmail(), "usuario1");
		
		Usuario usuario3 = usuariodao.login("usuario1", "");
		assertNull(usuario3);
		usuariodao.delete(usuario);
	}

}

