/**
 * 
 */
package com.citymanager3000.src;

import java.util.Vector;

import com.citymanager3000.gui.BatimentView;
import com.citymanager3000.gui.panels.GamePanel;

/**
 * @author Yann
 *
 */
public class Map {
	//private Vector<Batiment> liste_batiments;
	private Vector<BatimentView> liste_batiments_views;
	private Vector<VoieDeCommunication> voiesDeCommunication;
	public String environnement;

	/**
	 * Constructeur
	 */
	public Map() {
		//this.liste_batiments = new Vector<Batiment>();
		this.liste_batiments_views = new Vector<BatimentView>();
		this.voiesDeCommunication = new Vector<VoieDeCommunication>();
	}

	public void create(String environnement) {
		this.environnement=environnement;

	}

	public static void save(String path) {

	}

	public static String load(String path) {
		String difficulte;
		difficulte="Normal";
		return difficulte;
	}

	public void add(BatimentView batiment_view) {
		if(Configuration.MODE == "debug") {
			System.out.println("MAP : - "+batiment_view.getBatiment().getNom()+" ajouté(e) à la position ("+batiment_view.getBatiment().getPosition().getX()+","+batiment_view.getBatiment().getPosition().getY()+")");
			System.out.println("      - Il reste $"+Game.money+" au joueur");
			}
		//this.liste_batiments.add(batiment);
		this.liste_batiments_views.add(batiment_view);
		GamePanel.getMoneyLabel().setText("Argent restant : $"+Double.toString(Game.money));
	}

	public void add(VoieDeCommunication voieDeCommunication) {
		this.voiesDeCommunication.add(voieDeCommunication);
	}
	
	public Vector<BatimentView> getListeBatimentsViews() {
		return this.liste_batiments_views;
	}

	/*public void add(VoieDeCommunicationView voie_de_communication_view) {
		if(Configuration.MODE == "debug") {
			System.out.println("MAP : - "+voie_de_communication_view.getBatiment().NOM+" ajouté(e) à la position ("+voie_de_communication_view.getBatiment().POSITION.getX()+","+voie_de_communication_view.getBatiment().POSITION.getY()+")");
			System.out.println("      - Il reste $"+Game.money+" au joueur");
			}
		//this.liste_batiments.add(batiment);
		this.liste_batiments_views.add(batiment_view);
	}

	public void add(VoieDeCommunication voieDeCommunication) {
		this.voiesDeCommunication.add(voieDeCommunication);
	}
	
	public Vector<BatimentView> getListeBatimentsViews() {
		return this.liste_batiments_views;
	}*/
}
