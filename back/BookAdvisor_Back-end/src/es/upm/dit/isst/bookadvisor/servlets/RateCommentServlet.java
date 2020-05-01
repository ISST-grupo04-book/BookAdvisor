package es.upm.dit.isst.bookadvisor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import es.upm.dit.isst.bookadvisor.dao.ComentarioDAOImplementation;
import es.upm.dit.isst.bookadvisor.model.Comentario;

/**
 * Servlet implementation class RateCommentServlet
 */
@WebServlet("/RateCommentServlet")
public class RateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private Gson json = new Gson();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RateCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Recibimos los parámetros de la valoración y los transformamos as usual
		String receivedJson = "{'valoracion':'5','ID':'0'}";
		Comentario comment1 = this.json.fromJson(receivedJson, Comentario.class);
		int rate1 = comment1.getValoracion();
		int id = comment1.getID();
		
		//Ahora hay que comprobar si ese comentario ya tiene alguna valoración y calcularla de nuevo
		Comentario comment0 = ComentarioDAOImplementation.getInstance().read(id);
		int rate0 = comment0.getValoracion();
		int rateFinal;
		if(rate0 == 0) { //CRITERIO ARBITRARIO, NO EL MEJOR
			comment0.setValoracion(rate1);
			ComentarioDAOImplementation.getInstance().update(comment0);
			rateFinal = rate1;
		} else {
			int calc = (rate0 + rate1) / 2; //CÁLCULO TONTO, POR HACER ALGO
			comment0.setValoracion(calc);
			ComentarioDAOImplementation.getInstance().update(comment0);
			rateFinal = calc;
		}
		
		//Mostramos la nueva valoración tras el cálculo
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print("{\"Nueva Valoración\":\""+ rateFinal +"\"}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
