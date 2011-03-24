package kata.test;

import static org.junit.Assert.*;
import kata.code.StringEquation;

import org.junit.Test;


public class StringEquationTest {

	@Test
	public void shouldRemoveQuotesAndAnds() throws Exception {
		StringEquation equation = new StringEquation("'hi'&'man'=='hello'");
		assertEquals(2, (equation.split()).length);
	}
	
	@Test
	public void shouldConsiderWord() throws Exception {
		StringEquation equation = new StringEquation("'hi'&'man'=='hello'");
		assertTrue(equation.isWordConsidered("hello"));		
	}

	@Test
	public void shouldNotConsiderWord() throws Exception {
		StringEquation equation = new StringEquation("'hi'&'man'=='hello'");
		assertFalse(equation.isWordConsidered("h*e*llo*"));		
	}

	@Test
	public void shouldReturnTrueForPalindrome() throws Exception {
		StringEquation equation = new StringEquation("'i'&'am'&'lord'&'voldemort' == 'tom'&'marvolo'&'riddle'");

		assertTrue(equation.isEqual());
	}
	
	StringEquation stringEquation = new StringEquation("");

	@Test
	public void shouldReturnTrueForAnagramWords() throws Exception {
		assertTrue(stringEquation.isAnagram("iceman", "cinema"));
	}
	
	@Test
	public void shouldReturnFalseForNonAnagramWords() throws Exception {
		assertFalse(stringEquation.isAnagram("iceman", "ciyema"));
	}

	@Test
	public void shouldReturnNonEqual() throws Exception {
		StringEquation equation = new StringEquation("'hi'&'man'=='hello'");
		assertFalse(equation.isEqual());		
	}

}
