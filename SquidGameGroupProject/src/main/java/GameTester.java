

import java.util.List;

import controller.GameHelper;
import model.Game;

/**
 *@author Jake Soulinthavong - jakesoul
 *CIS175 - Fall 2021
 *September 23, 2021
 */
public class GameTester {
	public static void main(String[] args) {
		Game rlgl = new Game("Red Light, Green Light");
		Game squid = new Game("Squid Game");
		GameHelper ga = new GameHelper();
		ga.insertGame(rlgl);
		ga.insertGame(squid);
		List<Game> allGames = ga.showAllGames();
		for(Game a: allGames) {
		System.out.println(a.toString());
		}
		}
}
