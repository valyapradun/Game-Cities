package by.htp.game;

import java.io.IOException;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {
	public Parser(){
		
	}
	
	public Document setDocumentXML(){
		Document document = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse("src/main/resources/cities.xml");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();}
		return document;	
	}
	
	
	
	public String parserXML(String name, HashSet<String> game){
		String city = "";
		Document document = setDocumentXML();
		document.getDocumentElement().normalize();
		Element root = document.getDocumentElement();
		NodeList letters = root.getElementsByTagName("letter");
		boolean result = false;
		for (int i = 0; i < letters.getLength(); i++){   
			String atr = ((Element)letters.item(i)).getAttribute("name").toString();
			if (atr.equals(name)){
				result = true;
				Node correctLetter = letters.item(i);
				NodeList cities = ((Element)correctLetter).getElementsByTagName("city");
				for (int j = 0; j < cities.getLength(); j++){
					city = cities.item(j).getTextContent();
					if (!game.contains(city)){
						game.add(city);
						return city;
					} 
				}
				city = "";
			} 
		}
		if (result == false){
			System.out.println("There is no city on a letter '" + name + "' in list!");
		}
		return city;
	}
	
	
}
