package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//problem 1 - The Toss
public class Main {
	
	String weatherCondition;
	String dayLightCondition;
	
	Main(String weather,String climate){
		
		this.weatherCondition = weather;
		this.dayLightCondition = climate;
	}
	
	 /*@printResult - to print the toss result
	  * @parameter 
	  * teamName -Team that won the toss 
	  * teamPlan - TeamPlan based on weather and dayLight condition
	  * */
	private void printResult(String teamName, Map<String, String> teamPlan) {
		
		if(teamPlan.get(weatherCondition).equals(teamPlan.get(dayLightCondition))) {
		
			System.out.println(teamName+" wins the toss and "+teamPlan.get(weatherCondition).toLowerCase());
		}
		else{
		
			System.out.println(teamName+" wins the toss and bats");
		}
		
	}
	
	public static void main(String[] args) {
		
		//Random toss generator
		
		int toss = new Random().nextInt(2);
		
		Main instance = new Main(args[0],args[1]);
		
		String [] teams = {"Lengaburu","Enchai"};
		
		String tossTeam = teams[toss];
		
		Map<String,String> lengaburu = new HashMap<>();
			lengaburu.put("Clear","Bats");
			lengaburu.put("Cloudy","Bowls");
			lengaburu.put("Day","Bats");
			lengaburu.put("Night","Bowls");
		
		Map<String,String> enchai = new HashMap<>();
			enchai.put("Clear","Bowls");
			enchai.put("Cloudy","Bats");
			enchai.put("Day","Bowls");
			enchai.put("Night","Bats");
			
		if(teams[toss].equals("Lengaburu"))
			instance.printResult(tossTeam,lengaburu);
		else 
			instance.printResult(tossTeam,enchai);
	}

}
