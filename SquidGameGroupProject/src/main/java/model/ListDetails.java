package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * rggeleta@dmacc.edu roman
 * CIS175-Fall2021
 * Oct 18, 2021
 */

@Entity
public class ListDetails {
	//fields
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate deathDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Game game;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Player> listOfPlayers;
	
	//properties
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListDetails(int id, String listName, LocalDate deathDate, Game game, List<Player> listOfPlayers) 
	{
		super();
		this.id = id;
		this.listName = listName;
		this.deathDate = deathDate;
		this.game = game;
		this.listOfPlayers = listOfPlayers;
	}
	
	public ListDetails(String listName, LocalDate deathDate, Game game, List<Player> listOfPlayers) 
	{
		super();
		this.listName = listName;
		this.deathDate = deathDate;
		this.game = game;
		this.listOfPlayers = listOfPlayers;
	}
	
	public ListDetails(String listName, LocalDate deathDate, Game game) 
	{
		super();
		this.listName = listName;
		this.deathDate = deathDate;
		this.game = game;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getListName() 
	{
		return listName;
	}
	
	public void setListName(String listName) 
	{
		this.listName = listName;
	}
	
	public LocalDate getDeathDate() 
	{
		return deathDate;
	}
	
	public void setDeathDate(LocalDate deathDate) 
	{
		this.deathDate = deathDate;
	}
	
	public Game getGame()
	{
		return game;
	}
	
	public void setGame(Game game) 
	{
		this.game = game;
	}
	
	public List<Player> getListOfPlayers() 
	{
		return listOfPlayers;
	}
	
	public void setListOfPlayers(List<Player> listOfPlayers) 
	{
		this.listOfPlayers = listOfPlayers;
	}
	
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", deathDate=" + deathDate + ", game=" + game + ", listOfPlayers=" + listOfPlayers + "]";
	}
}
