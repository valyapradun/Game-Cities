package by.htp.game.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import by.htp.game.Service;

public class ServiceTest {
	private Service sv = null;
	private static HashSet<String> game;
	
	@BeforeClass
	public static void initHashSet(){
		game = new HashSet<String>();
		game.add("Kiev");
		game.add("Moscow");
		game.add("Minsk");
	}
	
	@AfterClass
	public static void clearHashSet(){
		game.clear();
		game = null;
	}
	
	@Before
	public void setupService(){
		sv = new Service();
	}
	
	@After
	public void clearService(){
		sv = null;
	}
	
	@Test
	public void testLastSymbolCorrect() {
		assertTrue("Wrong Last Symbol!", (sv.lastSymbol("Moscow")).equals("w"));
	}
	
	@Test
	public void testLastSymbolEmpty() {
		assertTrue("Wrong Last Symbol!", (sv.lastSymbol("")).equals(""));
	}
	
	@Test
	public void testLastSymbolNotCorrect() {
		assertFalse("Wrong Last Symbol", (sv.lastSymbol("Moscow")).equals(""));
	}
	
	@Test
	public void testCheckInputCityCorrect() {
		assertTrue("Wrong Last and First Symbol!", sv.checkInputCity("Moscow", 'm'));
	}
	
	@Test
	public void testCheckInputCityNotCorrect() {
		assertFalse("Wrong Last and First Symbol!", sv.checkInputCity("Moscow", 'R'));
	}

	@Test
	public void testAddCityToHashSetCorrect() {
		assertTrue("Can't add city to HashSet!", sv.addCityToHashSet("Warsaw", game));
	}
	
	@Test
	public void testAddCityToHashSetNotCorrect() {
		assertFalse("Can't add city to HashSet!", sv.addCityToHashSet("Moscow", game));
	}
	
	@Test
	public void testContinueGameCorrectEnd() {
		sv.continueGame("stop", game);
		assertEquals("Wrong", game, game);	
	}
}
