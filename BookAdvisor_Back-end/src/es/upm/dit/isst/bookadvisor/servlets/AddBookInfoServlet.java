package es.upm.dit.isst.bookadvisor.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import es.upm.dit.isst.bookadvisor.dao.CategoriaDAOImplementation;
import es.upm.dit.isst.bookadvisor.dao.LibroDAOImplementation;
import es.upm.dit.isst.bookadvisor.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.bookadvisor.model.Categoria;
import es.upm.dit.isst.bookadvisor.model.Libro;
import es.upm.dit.isst.bookadvisor.model.Usuario;

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
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Primero tenemos que leer el body del request al ser una petición POST
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) { /*report an error*/ }
	
		try {
			JsonObject jsonObject = new JsonParser().parse(jb.toString()).getAsJsonObject();
			
			JsonElement categoriaName = jsonObject.get("categoria");
			String nombreCategoria = categoriaName.toString();
			
			int id = CategoriaDAOImplementation.getInstance().getIDByName(nombreCategoria.substring(1, nombreCategoria.length()-1));
			Libro libro0 =this. json.fromJson(jsonObject, Libro.class);
			Categoria categoria = CategoriaDAOImplementation.getInstance().read(id);
			libro0.setIDCategoria(categoria);
			
			//Metemos el nuevo libro en la base de datos
			LibroDAOImplementation.getInstance().create(libro0);

			//Enviamos respuesta
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
