package by.htp.game;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParserTest {

	private Parser parser = null;
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
		parser = new Parser();
	}
	
	@After
	public void clearService(){
		parser = null;
	}
	

	@Test
	public void testParserXMLCorrect() {
		String expectedResult = "Amsterdam";
		String unexpectedResult = "Paris";
		String receivedResult = parser.parserXML("a", game);
		assertEquals("Wrong Parser!", expectedResult, receivedResult);
		assertNotEquals("Wrong Parser!", unexpectedResult, receivedResult);
	}
}
