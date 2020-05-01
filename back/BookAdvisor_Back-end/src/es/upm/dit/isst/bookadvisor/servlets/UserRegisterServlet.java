package es.upm.dit.isst.bookadvisor.servlets;

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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Cargamos contexto de usuarios hasta este comento
		List<Usuario> usuarios = (List<Usuario>) UsuarioDAOImplementation.getInstance().readAll();
		request.getSession().setAttribute("usuarios", usuarios); //NO ESTOY SEGURO DE QUE ESTO SIRVA PARA ALGO
		
		//Convertimos el JSON recibido en un Usuario de nuestro modelo de datos
		String json = "{'email':'name@server.com','username':'user0','pwd' :'xxxx','nombre':'User Zero','telefono':'666000111'}";
		Gson json2 = new Gson(); //MÁS ELEGANTE SI ME CREO UN ATRIBUTO PRIVADO PARA LA CLASE
		Usuario user0 = json2.fromJson(json, Usuario.class);
		
		//Añadimos el ID al usuario creado
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios.addAll((List<Usuario>)         
				request.getSession().getAttribute("usuarios")); //NO ESTOY SEGURO DE QUE ESTO SIRVA PARA ALGO
		user0.setID(listaUsuarios.size());
		
		//Metemos el nuevo usuario en la base de datos y guardamos el contexto
		UsuarioDAOImplementation.getInstance().create(user0);
		listaUsuarios.add (user0);
		request.getSession().setAttribute("usuarios", listaUsuarios); //NO ESTOY SEGURO DE QUE ESTO SERVA PARA ALGO
		
		
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		String json3 = json2.toJson(user0.toString());
		//response.getWriter().print(json2);
		//response.getWriter();
        //response.setContentType("application/json");
        //response.setCharacterEncoding("UTF-8");
        response.getWriter().print(json3);
        //response.getWriter().flush();   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
