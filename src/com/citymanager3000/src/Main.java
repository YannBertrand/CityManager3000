package com.citymanager3000.src;

/**
 * @author Yann Bertrand
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Bienvenue dans City Manager 3000 !");
		
		Game cityManager3000 = new Game("Méga-Ville", "debug", "Normal", "Campagne");
		cityManager3000.start();
	}
}
