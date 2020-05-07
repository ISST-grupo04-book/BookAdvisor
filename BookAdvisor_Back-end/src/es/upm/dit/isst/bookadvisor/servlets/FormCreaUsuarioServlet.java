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
import es.upm.dit.isst.bookadvisor.model.Usuario;
/**
 * Servlet implementation class FormCreaProfesorServlet
 */
@WebServlet("/FormCreaUsuarioServlet")
public class FormCreaUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCreaUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
           throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		int telefono = Integer.parseInt(req.getParameter("telefono"));
		String username = req.getParameter("username");
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPwd(password);
		usuario.setNombre(name);
		usuario.setTelefono(telefono);
		usuario.setUsername(username);
		List<Usuario> lu = new ArrayList<Usuario>();
		lu.addAll((List<Usuario>)         
                          req.getSession().getAttribute("usuarios"));
		usuario.setID(lu.size());
		UsuarioDAOImplementation.getInstance().create(usuario);

		lu.add (usuario);
		req.getSession().setAttribute("usuarios", lu);
		getServletContext().getRequestDispatcher("/admin.jsp").forward(req,resp);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
