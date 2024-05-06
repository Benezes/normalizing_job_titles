package com.main;

public class App {

	public static void main(String[] args) {
		
		Normaliser n = new Normaliser();
		
		String normalisedTitle = n.normalise("Java engineer"); 
		
		System.out.println(normalisedTitle);
	}

}
