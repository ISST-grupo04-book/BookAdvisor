package es.upm.dit.isst.bookadvisor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.bookadvisor.dao.*;
import es.upm.dit.isst.bookadvisor.model.*;

import java.util.*;

/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ADMIN_EMAIL = "admin";
	private final String ADMIN_PASSWORD = "admin";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		//List<Libreria> librerias = (List<Libreria>) LibreriaDAOImplementation.getInstance().readAll();
		List<Usuario> usuarios = (List<Usuario>) UsuarioDAOImplementation.getInstance().readAll();
		Usuario usuario = UsuarioDAOImplementation.getInstance().login(email, password);
		//Libreria libreria = LibreriaDAOImplementation.getInstance().login(email, password);
		if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {
			req.getSession().setAttribute("admin", true);
			//req.getSession().setAttribute("librerias", librerias);
			req.getSession().setAttribute("usuarios", usuarios);
			getServletContext().getRequestDispatcher("/admin.jsp").forward(req,resp);
		} else if ( null != usuario ) {
			req.getSession().setAttribute("usuario", usuario);
			getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
		/*} else if ( null != libreria ) {
			req.getSession().setAttribute("libreria", LibreriaDAOImplementation.getInstance().read(libreria.getCIF()));
			getServletContext().getRequestDispatcher("/index.html").forward(req,resp);*/
		} else {
			getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
		}
	}
}