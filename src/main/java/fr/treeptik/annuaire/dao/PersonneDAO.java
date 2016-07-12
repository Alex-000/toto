package fr.treeptik.annuaire.dao;

import java.util.List;

import fr.treeptik.annuaire.exception.DAOException;
import fr.treeptik.annuaire.pojo.Personne;

public interface PersonneDAO extends GenericDAO<Personne>{

	// par définition d'une interface les méthodes sont public et abstract
	
	List<Personne> findByName(String patternName) throws DAOException;
	List<Personne> findAllWithNumero() throws DAOException;
	List<Personne> findAllWithoutNumero() throws DAOException;
	
}
