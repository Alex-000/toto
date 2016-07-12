package fr.treeptik.annuaire.dao;

import fr.treeptik.annuaire.dao.impl.NumeroJPADAO;
import fr.treeptik.annuaire.dao.impl.PersonneJPADAO;

public class DAOFactory {

	private static PersonneDAO personneDAO;
	private static NumeroDAO numeroDAO;

	public static PersonneDAO getPersonneDAO() {

		if (personneDAO == null) {
			personneDAO = new PersonneJPADAO();
		}
		return personneDAO;

	}

	public static NumeroDAO getNumeroDAO() {

		if (numeroDAO == null) {
			numeroDAO = new NumeroJPADAO();
		}
		return numeroDAO;

	}

}