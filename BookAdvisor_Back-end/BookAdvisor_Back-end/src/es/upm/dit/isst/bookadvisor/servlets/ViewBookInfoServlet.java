package es.upm.dit.isst.bookadvisor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import es.upm.dit.isst.bookadvisor.dao.LibroDAOImplementation;
import es.upm.dit.isst.bookadvisor.model.Libro;

/**
 * Servlet implementation class ViewBookInfoServlet
 */
@WebServlet("/ViewBookInfoServlet")
public class ViewBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson json = new Gson();
	private String ISBN;
	private Libro libro0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//No sé cómo me lo vas a pasar, así que cambialo a tu gusto, supongo que como parámetro
	    this.ISBN = request.getParameter("ISBN");
	    int i = Integer.parseInt(this.ISBN);
		
		//Obtengo la información de la BD
		libro0 = LibroDAOImplementation.getInstance().read(i);
		
		//Devuelvo toda la info extaída
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(this.json.toJson(libro0.toString()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
