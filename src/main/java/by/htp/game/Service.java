package by.htp.game;

import java.util.HashSet;
import java.util.Scanner;

public class Service {
	public Service(){
		
	}
	
	public void game(){
		HashSet<String> game = new HashSet<String>();
		beginGame(game);
		printAllCorrectCities(game);
	}
	
	public void beginGame(HashSet<String> game){
		System.out.println("Input your city, if you want to finish a game enter 'stop': ");
		String cityUser = inputCity();
		if (!cityUser.isEmpty()){
			continueGame(cityUser, game);
		} else {
			System.out.println("Good bye! Begin once again!");
		}	
	}

	public void printAllCorrectCities(HashSet<String> game) {
		System.out.print("All correct cities of game: ");
		for(String city: game){
			System.out.print(city + " ");
		}
	}
	
	public void continueGame(String cityUser, HashSet<String> game){
		char lastSymbol;
		lastSymbol = cityUser.toLowerCase().charAt(0);
		while(!cityUser.equals("stop")){
			if (checkInputCity(cityUser, lastSymbol)){
				if (addCityToHashSet(cityUser, game)) {
					String name = lastSymbol(cityUser);
					Parser ps = new Parser();
					String cityXML = ps.parserXML(name, game);
					if (!cityXML.isEmpty()) {
						System.out.println("Our turn: " + cityXML);
						lastSymbol = cityXML.charAt(cityXML.length() - 1); 
						cityUser = inputCity();
					} else {
						System.out.println("You have won!");
						System.out.println("I don't know more cities on letter '" + name + "'");
						break;
					}
				} else {
					cityUser = inputCity();
				}	
			} else {
				System.out.println("You have lost!");
				break;
			}
		}
	}
	
	public String inputCity(){
		System.out.print("Your turn: ");
		Scanner sc = new Scanner(System.in);
		String cityUser = "";
		if (sc.hasNext()){
			cityUser = sc.nextLine();
		} 	
		return cityUser;
	}
	
	public boolean checkInputCity(String cityUser, char lastSymbol){
		boolean result = false;
		if (!cityUser.isEmpty() && lastSymbol != 0){
			char firstSymbol = cityUser.charAt(0);
			if(Character.toLowerCase(firstSymbol) != lastSymbol){
				System.out.println("Wrong city!");
			} else {
				result = true;
			}
		}
		return result;
	}
	
	public boolean addCityToHashSet(String cityUser, HashSet<String> game){
		boolean result = false;
		if (!cityUser.isEmpty()){
			if (game.contains(cityUser) == false) {
				game.add(cityUser);
				result = true;
			} else {
				System.out.println("Impossible to repeat! Try again:  ");
			}	
		}
		return result;
	}
	

	public String lastSymbol (String cityUser){
		String name = "";
		if (!cityUser.isEmpty()){
			char ch = cityUser.charAt(cityUser.length()-1);
			name = String.valueOf(ch).toLowerCase();
		}
		return name;
	}
}
