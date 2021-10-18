package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;

/**
 * Servlet implementation class EditPlayerServlet
 */
@WebServlet("/editPlayerServlet")
public class EditPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListPlayerHelper dao = new ListPlayerHelper();
		
		String playerName = request.getParameter("playerName");
		String gender = request.getParameter("gender");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Player genderToUpdate = dao.searchForGenderById(tempId);
		genderToUpdate.setGender(gender);
		genderToUpdate.setPlayerName(playerName);
		
		dao.updateGender(genderToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
	}

}
