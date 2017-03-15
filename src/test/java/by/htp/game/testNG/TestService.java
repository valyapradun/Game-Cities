package by.htp.game.testNG;

import org.testng.annotations.Test;

import by.htp.game.Service;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.HashSet;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestService {
	private Service sv = null;
	private static HashSet<String> game;
	
	@Test
	public void testLastSymbolCorrect() {
		assertTrue((sv.lastSymbol("Moscow")).equals("w"), "Wrong Last Symbol!");
	}
	
	@Test
	public void testLastSymbolEmpty() {
		assertTrue((sv.lastSymbol("")).equals(""), "Wrong Last Symbol!");
	}
	
	@Test
	public void testLastSymbolNotCorrect() {
		assertFalse((sv.lastSymbol("Moscow")).equals(""), "Wrong Last Symbol");
	}
	
	@Test
	public void testCheckInputCityCorrect() {
		assertTrue(sv.checkInputCity("Moscow", 'm'), "Wrong Last and First Symbol!");
	}
	
	@Test
	public void testCheckInputCityNotCorrect() {
		assertFalse(sv.checkInputCity("Moscow", 'R'), "Wrong Last and First Symbol!");
	}

	@Test
	public void testAddCityToHashSetCorrect() {
		assertTrue(sv.addCityToHashSet("Warsaw", game), "Can't add city to HashSet!");
	}
	
	@Test
	public void testAddCityToHashSetNotCorrect() {
		assertFalse(sv.addCityToHashSet("Moscow", game), "Can't add city to HashSet!");
	}
	
	@Test
	public void testContinueGameCorrectEnd() {
		sv.continueGame("stop", game);
		assertEquals(game, game);	
	}
	
  @BeforeClass
  public void beforeClass() {
	  	game = new HashSet<String>();
		game.add("Kiev");
		game.add("Moscow");
		game.add("Minsk");
  }

  @AfterClass
  public void afterClass() {
	  	game.clear();
		game = null;
  }

  @BeforeTest
  public void beforeTest() {
	  sv = new Service();
  }

  @AfterTest
  public void afterTest() {
	  sv = null;
  }

}
