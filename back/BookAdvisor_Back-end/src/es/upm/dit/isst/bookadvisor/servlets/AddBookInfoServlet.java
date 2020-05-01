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
 * Servlet implementation class AddBookInfoServlet
 */
@WebServlet("/AddBookInfoServlet")
public class AddBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson json = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Convertimos el JSON recibido en un Libro de nuestro modelo de datos
		String receivedJson = "{'ISBN':'01793','autor':'Miguel Mihura','titulo' :'Tres Sombreros de Copa','edicion':'2007','valoracion':'0'}";
		Libro libro0 =this. json.fromJson(receivedJson, Libro.class);
		
		//Metemos el nuevo libro en la base de datos
		LibroDAOImplementation.getInstance().create(libro0);
		
		//Devuelvo la info introducida en la base de datos
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
