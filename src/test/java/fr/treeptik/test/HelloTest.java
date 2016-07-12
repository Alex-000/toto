package fr.treeptik.test;

import org.junit.Test;

import junit.framework.Assert;

public class HelloTest {

	
	@Test
	public void testIfOk() {
		
		// on fait échouer le test ==> failure
		Assert.fail("Test failure");
	}
	
	@Test
	public void testIfOk2() {
		
		// on met le test en erreur ==> error
		throw new NullPointerException();
	}
}
