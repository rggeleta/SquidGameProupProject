package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Game;


/**
 * rggeleta@dmacc.edu roman
 * CIS175-Fall2021
 * Oct 18, 2021
 */
public class GameHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SquidGameGroupProject");
	
	public void insertGame(Game g) 
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Game> showAllGames()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Game> allGames = em.createQuery("SELECT g FROM Game g").getResultList();
		return allGames;
	}
	
	public Game findGame(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Game> typedQuery = em.createQuery("select ga from Game ga where ga.gameName = :selectedName",
		Game.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Game foundGame;
		try {
		foundGame = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
		foundGame = new Game(nameToLookUp);
		}
		em.close();
		return foundGame;
		}
}

