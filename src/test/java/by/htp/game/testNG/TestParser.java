package by.htp.game.testNG;

import org.testng.annotations.Test;

import by.htp.game.Parser;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.HashSet;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestParser {
	private Parser parser = null;
	private static HashSet<String> game;
	
  @Test
  public void f() {
	  	String expectedResult = "Amsterdam";
		String unexpectedResult = "Paris";
		String receivedResult = parser.parserXML("a", game);
		assertEquals(expectedResult, receivedResult, "Wrong Parser!");
		assertNotEquals(unexpectedResult, receivedResult, "Wrong Parser!");
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
	  		parser = new Parser();
  }

  @AfterTest
  public void afterTest() {
	  		parser = null;
  }

}
