package es.upm.dit.isst.bookadvisor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import es.upm.dit.isst.bookadvisor.dao.LibroDAOImplementation;
import es.upm.dit.isst.bookadvisor.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.bookadvisor.model.Libro;

/**
 * Servlet implementation class ViewBookInfoServlet
 */
@WebServlet("/ViewBookInfoServlet")
public class ViewBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson json = new Gson();
       
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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Simulo el JSON recibido
		String receivedJson = "{'ISBN':'97884'}";
		
		//Lo transformo en un objeto Libro y obtengo el resto de información de la BD
		Libro libro0 = this.json.fromJson(receivedJson, Libro.class);
		int isbn0 = libro0.getISBN();
		libro0 = LibroDAOImplementation.getInstance().read(isbn0);
		
		//Devuelvo toda la info extaída
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		String returnedJson = this.json.toJson(libro0.toString());
		response.getWriter().print(returnedJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
