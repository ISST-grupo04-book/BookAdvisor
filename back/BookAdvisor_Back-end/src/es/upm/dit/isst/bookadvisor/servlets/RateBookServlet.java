package es.upm.dit.isst.bookadvisor.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import es.upm.dit.isst.bookadvisor.dao.ComentarioDAOImplementation;
import es.upm.dit.isst.bookadvisor.dao.LibroDAOImplementation;
import es.upm.dit.isst.bookadvisor.model.Comentario;
import es.upm.dit.isst.bookadvisor.model.Libro;

/**
 * Servlet implementation class RateBookServlet
 */
@WebServlet("/RateBookServlet")
public class RateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson json = new Gson();
	private Libro libro = new Libro();
	private int rate;
	private int ISBN;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RateBookServlet() {
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
		String receivedJson = "{'valoracion':'1','ISBN':'97884'}";
		this.libro = this.json.fromJson(receivedJson, Libro.class);
		this.rate = libro.getValoracion();
	    this.ISBN = libro.getISBN();
	    libro = LibroDAOImplementation.getInstance().read(ISBN);
	    int previousRate = libro.getValoracion();
	    int rateFinal;
		if(previousRate == 0) { //CRITERIO ARBITRARIO, NO EL MEJOR
			libro.setValoracion(rate);
			LibroDAOImplementation.getInstance().update(libro);
			rateFinal = rate;
		} else {
			int calc = (rate + previousRate) / 2; //CÁLCULO TONTO, POR HACER ALGO
			libro.setValoracion(calc);
			LibroDAOImplementation.getInstance().update(libro);
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
