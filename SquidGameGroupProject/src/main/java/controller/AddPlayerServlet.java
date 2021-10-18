package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;

/**
 * Servlet implementation class AddPlayerServlet
 */
@WebServlet("/addPlayerServlet")
public class AddPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String playerName = request.getParameter("playerName");
		String gender = request.getParameter("gender");
		
		Player p1 = new Player(playerName, gender);
		ListPlayerHelper dao = new ListPlayerHelper();
		dao.insertPlayer(p1);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
