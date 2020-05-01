package es.upm.dit.isst.bookadvisor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import es.upm.dit.isst.bookadvisor.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.bookadvisor.model.Usuario;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson json = new Gson();
       
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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Simulamos el JSON recibido tanto con credenciales válidas como incorrectas
		//String receivedJson = "{'email':'name@server.com','pwd' :'xxxx'}";
		String receivedJson = "{'email':'name@server.com','pwd' :'1111'}";
		
		//Lo transformamos en un objeto Usuario y extraemos lo que nos interesa
		Usuario user0 = this.json.fromJson(receivedJson, Usuario.class);
		String email = user0.getEmail();
		String password = user0.getPwd();
		
		//Hacemos login
		user0 = UsuarioDAOImplementation.getInstance().login(email, password);
		
		//Comprobamos el resultado de las credenciales recibidas
		if(user0 != null) {
			response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
			response.getWriter().print("{\"login\":\"correcto\"}");
		} else {
			response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
			response.getWriter().print("{\"login\":\"incorrecto\"}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
