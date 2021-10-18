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
@Table(name="players")
public class Player {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="PLAYERNAME")
	private String playerName;
	@Column(name="GENDER")
	private String gender;
	
	public Player()
	{
		super();
	}
	
	public Player(int id, String playerName, String gender)
	{
		super();
		this.id = id;
		this.playerName = playerName;
		this.gender = gender;
	}

	public Player(int id, String playerName) {
		super();
		this.id = id;
		this.playerName = playerName;
	}
	
	public Player( String playerName, String gender) {
		super();
		this.gender = gender;
		this.playerName = playerName;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getPlayerName()
	{
		return playerName;
	}
	
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public String toString()
	{
		return "Player [id=" + id + ", playerName=" + playerName + ", gender= " + gender + "]";
	}
	
	public String returnPlayerDetails()
	{
		return this.playerName + ": " + this.gender;
	}
}
