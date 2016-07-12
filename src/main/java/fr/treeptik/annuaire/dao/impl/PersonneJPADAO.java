package fr.treeptik.annuaire.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.treeptik.annuaire.dao.PersonneDAO;
import fr.treeptik.annuaire.exception.DAOException;
import fr.treeptik.annuaire.pojo.Personne;
import fr.treeptik.annuaire.utils.JPAUtils;

public class PersonneJPADAO implements PersonneDAO {

	@Override
	public Personne add(Personne personne) throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			em.persist(personne);
			
			return personne;
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur PersonneDAO add " + e.getMessage(), e);
		}
	}

	@Override
	public void remove(Personne personne) throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			em.remove(personne);
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur PersonneDAO remove " + e.getMessage(), e);
		}
		
	}

	@Override
	public List<Personne> findAll() throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			TypedQuery<Personne> query = em.createNamedQuery("findAll", Personne.class);

			return query.getResultList();
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur PersonneDAO findAll " + e.getMessage(), e);
		}
	}

	@Override
	public Personne update(Personne personne) throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			em.merge(personne);
			
			return personne;
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur PersonneDAO update " + e.getMessage(), e);
		}
	}

	@Override
	public List<Personne> find(Personne personne) throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			TypedQuery<Personne> query = em.createNamedQuery("find", Personne.class);
			query.setParameter("nom", personne.getNom());
			query.setParameter("prenom", personne.getPrenom());
			
			return query.getResultList();
			
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur PersonneDAO find " + e.getMessage(), e);
		}
	}

	@Override
	public List<Personne> findByName(String patternName) throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			TypedQuery<Personne> query = em.createNamedQuery("findByName", Personne.class);
			query.setParameter("nom", patternName);

			return query.getResultList();
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur PersonneDAO findByName " + e.getMessage(), e);
		}
	}

	@Override
	public List<Personne> findAllWithNumero() throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
//			TypedQuery<Personne> query = em.createNamedQuery("findAllWithNumero", Personne.class);
			TypedQuery<Personne> query = em.createNamedQuery("findAllWithNumero", Personne.class);

			return query.getResultList();
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur PersonneDAO findAllWithNumero " + e.getMessage(), e);
		}
	}

	@Override
	public List<Personne> findAllWithoutNumero() throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			TypedQuery<Personne> query = em.createNamedQuery("findAllWithoutNumero", Personne.class);

			return query.getResultList();
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur PersonneDAO findAllWithoutNumero " + e.getMessage(), e);
		}
	}

	@Override
	public List<Personne> findGeneric(Map<String, Object> map) throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			String requete = "SELECT p FROM Personne p WHERE ";
			
			Set<String> cle = map.keySet();
			for (String string : cle) {
				requete += "p." + string + " = :" + string + " AND ";
			}
			
			TypedQuery<Personne> query = em.createQuery(requete.substring(0, requete.lastIndexOf(" AND ")), Personne.class);
			for (String string : cle) {
				query.setParameter(string, map.get(string));
			}
			
			return query.getResultList();
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur PersonneDAO findGeneric " + e.getMessage(), e);
		}
	}

}
