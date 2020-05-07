package es.upm.dit.isst.bookadvisor.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import es.upm.dit.isst.bookadvisor.dao.CategoriaDAOImplementation;
import es.upm.dit.isst.bookadvisor.dao.LibroDAOImplementation;
import es.upm.dit.isst.bookadvisor.model.Categoria;
import es.upm.dit.isst.bookadvisor.model.Libro;

/**
 * Servlet implementation class ViewCategoryBooksServlet
 */
@WebServlet("/ViewCategoryBooksServlet")
public class ViewCategoryBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson json = new Gson();
	private int ID;
	private Categoria categoria0;
	private String categoriaName;
	private Collection<Libro> librosCategoria;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCategoryBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//No sé cómo me lo vas a pasar, así que cambialo a tu gusto, supongo que como parámetro
	    this.categoriaName = request.getParameter("categoria");
	    int i = Integer.parseInt(this.categoriaName);
	    categoria0 = new Categoria();
	    categoria0.setID(i);
		
		//Obtengo la información de la BD
	    //this.ID = CategoriaDAOImplementation.getInstance().getIDByName(nombre);
	    System.out.println("2");
		this.librosCategoria = LibroDAOImplementation.getInstance().getLibrosByCategoria(categoria0);
		System.out.println(this.librosCategoria.toString());
		
		//Devuelvo toda la info extaída
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		String returnedJson = this.json.toJson(librosCategoria.toString());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(returnedJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}