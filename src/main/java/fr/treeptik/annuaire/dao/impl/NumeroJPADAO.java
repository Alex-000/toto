package fr.treeptik.annuaire.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.treeptik.annuaire.dao.NumeroDAO;
import fr.treeptik.annuaire.exception.DAOException;
import fr.treeptik.annuaire.pojo.Numero;
import fr.treeptik.annuaire.pojo.Personne;
import fr.treeptik.annuaire.utils.JPAUtils;

public class NumeroJPADAO implements NumeroDAO {

	@Override
	public Numero add(Numero numero) throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			em.persist(numero);
						
		} catch (PersistenceException e) {
			throw new DAOException("Erreur NumeroDAO add " + e.getMessage(), e);
		}
		return numero;
	}

	@Override
	public void remove(Numero numero) throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			em.remove(numero);
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur NumeroDAO remove " + e.getMessage(), e);
		}
		
	}

	@Override
	public Numero update(Numero numero) throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			em.merge(numero);
			
			return numero;
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur NumeroeDAO update " + e.getMessage(), e);
		}
	}

	@Override
	public List<Numero> find(Numero numero) throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			TypedQuery<Numero> query = em.createNamedQuery("findNumero", Numero.class);
			query.setParameter("numero", numero.getNumero());
			
			return query.getResultList();
			
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur NumeroDAO find " + e.getMessage(), e);
		}
	}

	@Override
	public List<Numero> findAll() throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			TypedQuery<Numero> query = em.createNamedQuery("findAllNumero", Numero.class);

			return query.getResultList();
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur NumeroDAO findAll " + e.getMessage(), e);
		}
	}

	@Override
	public List<Personne> findPersonneByNumero(Numero numero) throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			TypedQuery<Personne> query = em.createNamedQuery("findPersonneByNumero", Personne.class);
			query.setParameter("numero", numero.getNumero());

			return query.getResultList();
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur NumeroDAO findPersonneByNumero " + e.getMessage(), e);
		}
	}

	@Override
	public List<Numero> findAllNumeroWithoutPersonne() throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			TypedQuery<Numero> query = em.createNamedQuery("findAllNumeroWithoutPersonne", Numero.class);

			return query.getResultList();
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur NumeroDAO findAllNumeroWithoutPersonne " + e.getMessage(), e);
		}
	}

	@Override
	public List<Numero> findAllNumeroWithPersonne() throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			TypedQuery<Numero> query = em.createNamedQuery("findAllNumeroWithPersonne", Numero.class);

			return query.getResultList();
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur NumeroDAO findAllNumeroWithPersonne " + e.getMessage(), e);
		}
	}

	@Override
	public List<Numero> findGeneric(Map<String, Object> map) throws DAOException {
		
		EntityManager em = JPAUtils.getEntityManager();
		try {
			String requete = "SELECT n FROM Numero n WHERE ";
			
			Set<String> cle = map.keySet();
			for (String param : cle) {
				requete += "n." + param + " = :" + param + " AND ";
			}
			
			TypedQuery<Numero> query = em.createQuery(requete.substring(0, requete.lastIndexOf(" AND ")), Numero.class);
			for (String param : cle) {
				query.setParameter(param, map.get(param));
			}
			
			return query.getResultList();
			
		} catch (PersistenceException e) {
			throw new DAOException("Erreur NumeroDAO findGeneric " + e.getMessage(), e);
		}
	}

}
