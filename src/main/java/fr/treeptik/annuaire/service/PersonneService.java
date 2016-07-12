package fr.treeptik.annuaire.service;

import java.util.List;

import fr.treeptik.annuaire.dao.PersonneDAO;
import fr.treeptik.annuaire.pojo.Personne;

public class PersonneService {

	private PersonneDAO personneDAO;

	
	public List<Personne> findByName(String patternName) {
		return personneDAO.findByName(patternName);
	}
	
	public PersonneDAO getPersonneDAO() {
		return personneDAO;
	}

	public void setPersonneDAO(PersonneDAO personneDAO) {
		this.personneDAO = personneDAO;
	}
	
}
