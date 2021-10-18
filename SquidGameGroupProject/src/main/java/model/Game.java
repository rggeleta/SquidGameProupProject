package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * rggeleta@dmacc.edu roman
 * CIS175-Fall2021
 * Oct 18, 2021
 */
@Entity
@Table(name="games")
public class Game {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int gameNo;
	@Column(name="GAMENAME")
	private String gameName;
	/**
	 * @param gameNo
	 * @param gameName
	 */
	
	public Game()
	{
		super();
	}
	
	public Game(int gameNo, String gameName) {
		super();
		this.gameNo = gameNo;
		this.gameName = gameName;
	}
	
	public Game(String gameName)
	{
		super();
		this.gameName = gameName;
	}
	
	/**
	 * @return the gameNo
	 */
	public int getGameNo() {
		return gameNo;
	}
	/**
	 * @param gameNo the gameNo to set
	 */
	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}
	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}
	/**
	 * @param gameName the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	
}
