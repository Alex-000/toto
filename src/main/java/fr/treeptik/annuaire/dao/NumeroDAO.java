package fr.treeptik.annuaire.dao;

import java.util.List;

import fr.treeptik.annuaire.exception.DAOException;
import fr.treeptik.annuaire.pojo.Numero;
import fr.treeptik.annuaire.pojo.Personne;

public interface NumeroDAO extends GenericDAO<Numero> {

	List<Personne> findPersonneByNumero(Numero numero) throws DAOException;
	List<Numero> findAllNumeroWithoutPersonne() throws DAOException;
	List<Numero> findAllNumeroWithPersonne() throws DAOException;
	
}
