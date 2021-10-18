package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;


/**
 * rggeleta@dmacc.edu roman
 * CIS175-Fall2021
 * Oct 18, 2021
 */

public class ListPlayerHelper {
	public static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SquidGameGroupProject");
	
	public void insertPlayer(Player p1)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p1);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Player>showAllPlayers()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Player> allPlayers = em.createQuery("SELECT p FROM Player p").getResultList();
		return allPlayers;
	}
	
	public void deletePlayer(Player toDelete)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player>typedQuery = em.createQuery("select p1 from Player p1 where p1.playerName = :selectedPlayerName and p1.gender = :selectedGender", Player.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedPlayerName", toDelete.getPlayerName());
		typedQuery.setParameter("selectedGender", toDelete.getGender());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Player result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Player> searchForGenderByPlayerName(String playerName)
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player>typedQuery = em.createQuery("select p1 form ListGender p1 where p1.playerName = :selectedPlayerName", Player.class);
		typedQuery.setParameter("selectedPlayerName", playerName);
		
		List<Player> foundGenders = typedQuery.getResultList();
		em.close();
		return foundGenders;
	}
	
	public List<Player> searchForGenderByGender(String gender)
	{
		//TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select p1 from ListGender p1 where p1.gender = :selectedGender", Player.class);
		typedQuery.setParameter("selectedGender", gender);
		
		List<Player> foundGender = typedQuery.getResultList();
		em.close();
		return foundGender;
	}
	
	public Player searchForGenderById(int idToEdit)
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Player found = em.find(Player.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateGender(Player toEdit)
	{
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp()
	{
		emfactory.close();
	}
}
