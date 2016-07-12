package fr.treeptik.annuaire.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.treeptik.annuaire.dao.DAOFactory;
import fr.treeptik.annuaire.dao.PersonneDAO;
import fr.treeptik.annuaire.pojo.Personne;

public class PersonneJPADAOTest {

	@Test
	public void findByNameShouldReturn2() {
		
		PersonneDAO personneDAO = DAOFactory.getPersonneDAO();
		
		List<Personne> list = personneDAO.findByName("dupont");
		
		Assert.assertNotNull("la liste est nulle", list);
		Assert.assertEquals(2, list.size());
	}
	
}
