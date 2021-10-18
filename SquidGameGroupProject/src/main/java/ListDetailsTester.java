

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import controller.ListDetailsHelper;
import model.ListDetails;
import model.Player;
import model.Game;

/**
 *@author Jake Soulinthavong - jakesoul
 *CIS175 - Fall 2021
 *September 23, 2021
 */
public class ListDetailsTester {
	
	public static void main(String[] args) {
		Game rlgl = new Game("Red Light, Green Light");
		ListDetailsHelper ldh = new ListDetailsHelper();
		Player js = new Player("Jake Soul", "Male");
		Player jm = new Player("Jake Meyer", "Male");
		
		List<Player> players = new ArrayList<Player>();
		players.add(js);
		players.add(jm);
		
		ListDetails playersList = new ListDetails("List of Players", LocalDate.now(), rlgl);
		playersList.setListOfPlayers(players);
		
		ldh.insertNewListDetails(playersList);
		List<ListDetails> allLists = ldh.getLists();
		
		for(ListDetails a: allLists) 
		{
		System.out.println(a.toString());
		}
	}
}
