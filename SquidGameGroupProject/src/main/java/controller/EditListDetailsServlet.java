package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.Player;
import model.Game;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper dao = new ListDetailsHelper();
		ListPlayerHelper lph = new ListPlayerHelper();
		GameHelper gh = new GameHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		String newListName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String gameName = request.getParameter("gameName");
		//find or add the new game	
		Game newGame = gh.findGame(gameName);
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year),
			Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		try {
		//players are selected in list to add
		String[] selectedPlayers = request.getParameterValues("allPlayersToAdd");
		List<Player> selectedPlayersInList = new ArrayList<Player>();
		for (int i = 0; i < selectedPlayers.length; i++) {
			System.out .println(selectedPlayers[i]);
			Player c = lph.searchForGenderById(Integer.parseInt(selectedPlayers[i]));
			selectedPlayersInList.add(c);
		}
		listToUpdate.setListOfPlayers(selectedPlayersInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Player> selectedPlayersInList = new ArrayList<Player>();
			listToUpdate.setListOfPlayers(selectedPlayersInList);
			}
			listToUpdate.setListName(newListName);
			listToUpdate.setDeathDate(ld);
			listToUpdate.setGame(newGame);
			dao.updateList(listToUpdate);
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
	}
