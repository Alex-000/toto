package fr.treeptik.annuaire.service;

import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.treeptik.annuaire.dao.PersonneDAO;
import fr.treeptik.annuaire.exception.DAOException;
import fr.treeptik.annuaire.pojo.Personne;

public class PersonneServiceTest {

	
	@BeforeClass
	public static void initClass() {
		
		// avant même l'instanciation de la classe de test
	}
	@Before
	public void initTest() {
		
		// déclenché avant chaque test;
	}
	
	
	@Test(timeout = 214)
	public void shouldReturn2Personnes() {
		PersonneService personneService = new PersonneService();
		
		PersonneDAO mockDAO = EasyMock.mock(PersonneDAO.class);
		
		// on définit ce que fait le mock suivant les cas
		List<Personne> resultMock = Arrays.asList(new Personne(1, "nom", "prenom", null), new Personne(2, "nom2", "prenom2", null));
		// on met deux retours donc il faut tester les deux dans la méthode
		EasyMock.expect(mockDAO.findByName("dupont")).andReturn(resultMock);
		EasyMock.expect(mockDAO.findByName("toto")).andReturn(null);
		
		// on fige le mock, plus parammétré après
		EasyMock.replay(mockDAO);
		
		// un peu de la triche car on a normalement pas de setPersonneDAO
		personneService.setPersonneDAO(mockDAO);
		
		// on appelle enfin notre service que l'on veut tester avec le mock en place
		List<Personne> result = personneService.findByName("dupont");
		
		// les test
		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.size());
		
		// on appelle enfin notre service que l'on veut tester avec le mock en place
		List<Personne> result2 = personneService.findByName("toto");
		
		// les test
		Assert.assertNull(result2);
		
		// on vérifie qu'on s'est bien servi du mock
		EasyMock.verify(mockDAO);
	}
	
	@Test(expected = DAOException.class)
	public void shouldThrowException() {
		
		throw new DAOException("blabal", null);
	}
	
}
