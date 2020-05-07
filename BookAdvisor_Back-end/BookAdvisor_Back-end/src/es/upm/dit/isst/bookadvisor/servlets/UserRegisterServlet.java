package es.upm.dit.isst.bookadvisor.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.bookadvisor.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.bookadvisor.model.*;
import com.google.gson.*;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson json = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
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
		  
			//Ahora que tenemos el JSON extraído y en el formato que queremos lo transformamos en un objeto Usuario
			Usuario user0 = this.json.fromJson(jsonObject, Usuario.class);
		
			//Añadimos el ID al Usuario creado
			List<Usuario> listaUsuarios = (List<Usuario>) UsuarioDAOImplementation.getInstance().readAll();
			user0.setID(listaUsuarios.size());
			//Metemos el nuevo usuario en la base de datos
			UsuarioDAOImplementation.getInstance().create(user0);

			//La verdad es que no sé qué esperas recibir, más que un print para avisar
			response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(this.json.toJson("{\"login\":\"correcto\"}"));

		
		}catch (Exception e) {
			response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(this.json.toJson("{\"login\":\"incorrecto\"}"));
		  throw new IOException("Error parsing JSON request string");
		}
		
		
	}

}
