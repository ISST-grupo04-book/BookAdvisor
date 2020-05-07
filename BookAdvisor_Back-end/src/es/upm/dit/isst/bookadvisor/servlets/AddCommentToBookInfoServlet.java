package es.upm.dit.isst.bookadvisor.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import es.upm.dit.isst.bookadvisor.dao.ComentarioDAOImplementation;
import es.upm.dit.isst.bookadvisor.dao.LibroDAOImplementation;
import es.upm.dit.isst.bookadvisor.model.Comentario;
import es.upm.dit.isst.bookadvisor.model.Libro;

/**
 * Servlet implementation class AddReviewToBookInfoServlet
 */
@WebServlet("/AddCommentToBookInfoServlet")
public class AddCommentToBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson json = new Gson();	
	private String ISBN;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentToBookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.ISBN = request.getParameter("ISBN");
		int i = Integer.parseInt(this.ISBN);
		Libro libro0 =new Libro();
		libro0.setISBN(i);
		
		Collection<Comentario> listaComentarios = ComentarioDAOImplementation.getInstance().getCommentsByISBN(libro0);
		String str = listaComentarios.toString();
		String returnedJson = this.json.toJson(str);
		
		//Configuramos el response
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(returnedJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) { /*report an error*/ }
		
		try {
			JsonObject jsonObject = new JsonParser().parse(jb.toString()).getAsJsonObject();
			System.out.println(jsonObject);
			
			//Creamos un objeto Usuario para comprobar sus credenciales
			JsonObject comentarioJson = jsonObject;
			
			Comentario comment0 = new Comentario();
			String contenido = comentarioJson.get("comentario").getAsString();
			String ISBN = comentarioJson.get("ISBN").getAsString();
			int i = Integer.parseInt(ISBN);
			Libro libroAsociado = LibroDAOImplementation.getInstance().read(i);
			comment0.setContenido(contenido);
			comment0.setISBN(libroAsociado);
			
			ComentarioDAOImplementation.getInstance().create(comment0);
			
			response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(this.json.toJson("{\"creacion\":\"correcta\"}"));
			
		}catch (Exception e) {
			response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(this.json.toJson("{\"creacion\":\"incorrecta\"}"));
			throw new IOException("Error parsing JSON request string");
		}
	}

}
