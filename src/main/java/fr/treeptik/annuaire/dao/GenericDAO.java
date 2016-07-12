package fr.treeptik.annuaire.dao;

import java.util.List;
import java.util.Map;

import fr.treeptik.annuaire.exception.DAOException;

public interface GenericDAO<T> {

	// par définition d'une interface les méthodes sont public et abstract
	
	T add(T entite) throws DAOException;
	void remove(T entite) throws DAOException;
	T update(T entite) throws DAOException;
	List<T> find(T entite) throws DAOException;
	List<T> findAll() throws DAOException;
	List<T> findGeneric(Map<String, Object> map) throws DAOException;
	
}
