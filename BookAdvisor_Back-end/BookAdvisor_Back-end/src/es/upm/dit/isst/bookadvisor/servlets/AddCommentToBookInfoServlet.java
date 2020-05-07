package es.upm.dit.isst.bookadvisor.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import es.upm.dit.isst.bookadvisor.dao.ComentarioDAOImplementation;
import es.upm.dit.isst.bookadvisor.model.Comentario;

/**
 * Servlet implementation class AddReviewToBookInfoServlet
 */
@WebServlet("/AddCommentToBookInfoServlet")
public class AddCommentToBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson json = new Gson();
       
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Convertimos el JSON recibido en un Comentario de nuestro modelo de datos
		String receivedJson = "{'contenido':'Me ha encantado.','IDUsuario':{'ID':'0','telefono':'666000111'},'ISBN':{'ISBN':'97884','edicion':'1997'}}";
		//Collection collection = new ArrayList();
		Comentario comment0 =this.json.fromJson(receivedJson, Comentario.class);
		
		//Añado también el ID que le corresponda al comentario
		List<Comentario> comentarios = (List<Comentario>) ComentarioDAOImplementation.getInstance().readAll();
		comment0.setID(comentarios.size());
		
		//Metemos el nuevo comentario en la base de datos
		ComentarioDAOImplementation.getInstance().create(comment0);
		
		//Devuelvo la info introducida en la base de datos
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		String returnedJson = this.json.toJson(comment0.toString());
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
