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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import es.upm.dit.isst.bookadvisor.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.bookadvisor.model.Usuario;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson json = new Gson();
	private Usuario user0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
				System.out.println(jsonObject);
				
				//Creamos un objeto Usuario para comprobar sus credenciales
				JsonObject userJson = jsonObject;
				 
		        
				String email = userJson.get("email").getAsString();;
				String password = userJson.get("pwd").getAsString();;

				
				//Hacemos login
				user0 = UsuarioDAOImplementation.getInstance().login(email, password);

				
				//Comprobamos el resultado de las credenciales recibidas
				if(user0 != null) {
					
					//La verdad es que no sé qué esperas recibir, más que un print para avisar
					response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(this.json.toJson(user0.toString()));
				} else {
					response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(this.json.toJson("{\"ID\":\"null\"}"));
				}
				
			} catch (Exception e) {
			// crash and burn
			throw new IOException("Error parsing JSON request string");
			}
	}

}
