package fr.treeptik.annuaire.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import fr.treeptik.annuaire.exception.EntityManagerException;

/**
 * Créer la connection à la base de donnée employee_manager
 * @author ic04
 *
 */

public class JPAUtils {

	// on créer les entity à partir des pojos que l'on aura annoté
	// sample parce que dans le fichier persistence.xml
	private static EntityManager em;
	
	
	/**
	 * 
	 * @return EntityManager
	 * @throws EntityManagerException
	 */
	
	public static EntityManager getEntityManager() throws EntityManagerException {
		
		// connection à mysql
		try {
			// si la connection existe déjà on renvoie la même
			if (em == null || !em.isOpen()) {
				em = Persistence.createEntityManagerFactory("sample").createEntityManager();
			}
		} catch (PersistenceException e) {
			throw new EntityManagerException("Erreur JPAUtils getEntityManager() " + e.getMessage(), e);
		}
		
		return em;
	}
	
	
	public static void commit() throws EntityManagerException {
		
		try {
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			throw new EntityManagerException("Erreur JPAUtils commit() " + e.getMessage(), e);
		}
	}
		
		
	public static void transactionBegin() throws EntityManagerException {
			
		try {
			em.getTransaction().begin();
		} catch (PersistenceException e) {
			throw new EntityManagerException("Erreur JPAUtils transactionBegin() " + e.getMessage(), e);
		}
	}
	
	public static void transactionRollback() throws EntityManagerException {
		
		try {
			em.getTransaction().rollback();
		} catch (PersistenceException e) {
			throw new EntityManagerException("Erreur JPAUtils transactionRollback() " + e.getMessage(), e);
		}
	}
	
	public static void closeEntity() throws EntityManagerException {
		
		if (em != null) {
			
			try {
				em.close();
			} catch (PersistenceException e) {
				throw new EntityManagerException("Erreur JPAUtils closeEntity() " + e.getMessage(), e);
			}
		}
	}
	
}