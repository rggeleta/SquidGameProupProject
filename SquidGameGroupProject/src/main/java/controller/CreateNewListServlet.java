package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Game;
import model.ListDetails;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		ListPlayerHelper lph = new ListPlayerHelper();
    		String listName = request.getParameter("listName");
    		System.out.println("List Name: "+ listName);
    		String month = request.getParameter("month");
    		String day = request.getParameter("day");
    		String year = request.getParameter("year");
    		String gameName = request.getParameter("gameName");
    		LocalDate ld;
    		
    		try {
    			ld = LocalDate.of(Integer.parseInt(year),
    					Integer.parseInt(month), Integer.parseInt(day));
    		}
    		catch(NumberFormatException ex) {
    			ld = LocalDate.now();
    		}
    		String[] selectedPlayers = request.getParameterValues("allPlayersToAdd");
    		List<Player> selectedPlayersInList = new ArrayList<Player>();
    		//make sure something was selected – otherwise we get a null pointer exception
    		if (selectedPlayers != null && selectedPlayers.length > 0)
    		{
	    		for(int i = 0; i<selectedPlayers.length; i++) {
		    		System.out.println(selectedPlayers[i]);
		    		Player c = lph.searchForGenderById(Integer.parseInt(selectedPlayers[i]));
		    		selectedPlayersInList.add(c);
	    		}
    		}
    		Game game = new Game(gameName);
    		ListDetails gld = new ListDetails(listName, ld, game);
    		gld.setListOfPlayers(selectedPlayersInList);
    		ListDetailsHelper glh = new ListDetailsHelper();
    		glh.insertNewListDetails(gld);
    		System.out.println("Success!");
    		System.out.println(gld.toString());
    		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
