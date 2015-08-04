package com.citymanager3000.src;

import java.util.Vector;

import com.citymanager3000.gui.BatimentView;
import com.citymanager3000.gui.Frame;
import com.citymanager3000.src.threads.MoneyThread;
//import com.citymanager3000.ui;

/**
 * 
 * @author Yann Bertrand
 *
 */
public class Game {
	@SuppressWarnings("unused")
	private boolean stop;
	private static Map map;
	public static double money;
	
	/**
	 * Créé un jeu !
	 */
	public Game(String city_name, String mode, String difficulte, String environnement) {
		Configuration.init(city_name, mode, difficulte, environnement);
		if(Configuration.MODE=="debug") { 
			System.out.println(""); 
			System.out.println("---------------------------------------------------------------------"); 
			System.out.println("------------------------- MODE DEBUG ACTIVE -------------------------"); 
			System.out.println("---------------------------------------------------------------------"); 
			System.out.println(""); 
		}
		Game.map = new Map();
		Game.map.create(environnement);
		
		money = Configuration.BASE_MONEY;
	}
	
	/**
	 * Charge un jeu
	 */
	public Game(String mode, String path) {
		//String difficulte, environnement = Map.load(path);
		//Configuration.init(mode, difficulte, environnement);
		if(Configuration.MODE=="debug") { 
			System.out.println(""); 
			System.out.println("---------------------------------------------------------------------"); 
			System.out.println("------------------------- MODE DEBUG ACTIVE -------------------------"); 
			System.out.println("---------------------------------------------------------------------"); 
			System.out.println(""); 
		}
	}
	
	/**
	 * Lance le jeu
	 */
	public void start() {
		if(Configuration.MODE=="debug") { System.out.println("Lancement du jeu."); }
		
		@SuppressWarnings("unused")
		Frame frame = new Frame();
		
		MoneyThread money_thread = new MoneyThread() ;
		money_thread.start();
		this.stop=false;
		while(money_thread.isAlive() ) {
			this.go();
		}
	}
	
	public void go() {
		//showBatiments();
		//this.creerVoieDeCommunication(new Route(new int[] {10, 20}, new int[] {20, 20}));
	}
	
	public static void creerBatiment(BatimentView batiment) {
		Game.money = Game.money-batiment.getBatiment().getPrixConstruction();
		MoneyThread.calculateNewMoneyPerMonth(batiment);

		if(batiment.getBatiment().isUnique())
			batiment.getBatiment().setAlreadyLaid();
		
		Game.map.add(batiment);
		//System.out.println("Nouveau batiment");
	}
	
	public static Vector<BatimentView> getBatiments() {
		return Game.map.getListeBatimentsViews();
	}

	public void creerVoieDeCommunication(VoieDeCommunication voieDeCommunication) {
		Game.map.add(voieDeCommunication);
	}
}
