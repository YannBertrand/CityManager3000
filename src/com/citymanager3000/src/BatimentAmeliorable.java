package com.citymanager3000.src;

import java.util.LinkedList;

import com.citymanager3000.types.Dimension3D;
import com.citymanager3000.types.Position;

/**
 * @author Yann
 *
 */
public class BatimentAmeliorable extends Batiment {
	private final int NIVEAU_MAX;

	private final LinkedList<Dimension3D> DIMENSIONS;

	private final double PRIX_CONSTRUCTION;
	private final LinkedList<Double> BENEFICES_PAR_MOIS;
	private final LinkedList<Double> PRIX_AMELIORATIONS;
	private final LinkedList<Double> PRIX_DESTRUCTIONS;

	private final LinkedList<String> IMAGES;

	private int niveau;

	public BatimentAmeliorable(String type, 
			String nom, 
			Position position,
			int niveau_max,
			LinkedList<Dimension3D> dimensions, 
			double prix_construction,
			LinkedList<Double> benefices_par_mois, 
			LinkedList<Double> prix_ameliorations,
			LinkedList<Double> prix_destructions, 
			LinkedList<String> images_paths) {

		super(type,
				nom,
				position,
				dimensions.get(0),
				prix_construction,
				benefices_par_mois.get(0),
				prix_ameliorations.get(0),
				prix_destructions.get(0),
				images_paths.get(0));

		NIVEAU_MAX = niveau_max;
		DIMENSIONS = dimensions;
		PRIX_CONSTRUCTION = prix_construction;
		BENEFICES_PAR_MOIS = benefices_par_mois;
		PRIX_AMELIORATIONS = prix_ameliorations;
		PRIX_DESTRUCTIONS = prix_destructions;
		IMAGES = images_paths;

		setNiveau(0);
	}

	/*
	 * Améliorer un batiment
	 * @return true si amélioré, false sinon
	 */
	public boolean ameliorer() {
		int niveau_suivant = this.getNiveau()+1;
		updateAmeliorationPossible(niveau_suivant);
		if(isAmeliorationPossible()) {
			//Actualisation de l'image
			this.setImagePath(getImages().get(niveau_suivant));
			//Actualisation du niveau
			this.setNiveau(niveau_suivant);

			if(Configuration.MODE=="debug")
				System.out.println("BATIMENT : Amélioration du batiment "+getNom()+" à la position "+getPosition().toString()+"."); 

			return true;
		} else {
			if(Configuration.MODE=="debug")
				System.out.println("BATIMENT : Niveau maximum déjà atteint.");

			return false;
		}
	}

	/*
	 * Actualise le champ is_amelioration_possible
	 * @param le niveau suivant (int)
	 */
	private void updateAmeliorationPossible(int niveau_suivant) {
		if(isAmeliorationPossible()) {
			if(niveau_suivant <= getNiveauMax()) setIsAmeliorationPossible(true);
			else setIsAmeliorationPossible(false);
		}
	}

	/**
	 * @return the niveau
	 */
	public int getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau the niveau to set
	 */
	private void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	/**
	 * @return the niveau max
	 */
	public int getNiveauMax() {
		return NIVEAU_MAX;
	}

	/**
	 * @return the dimensions
	 */
	public LinkedList<Dimension3D> getDimensions() {
		return DIMENSIONS;
	}

	/**
	 * @return the prix_constrution
	 */
	public double getPrixConstrution() {
		return PRIX_CONSTRUCTION;
	}

	/**
	 * @return the benefices_par_mois
	 */
	public LinkedList<Double> getBeneficesParMois() {
		return BENEFICES_PAR_MOIS;
	}

	/**
	 * @return the prix_ameliorations
	 */
	public LinkedList<Double> getPrixAmeliorations() {
		return PRIX_AMELIORATIONS;
	}

	/**
	 * @return the prix_destructions
	 */
	public LinkedList<Double> getPrixDestructions() {
		return PRIX_DESTRUCTIONS;
	}

	/**
	 * @return the images
	 */
	public LinkedList<String> getImages() {
		return IMAGES;
	}


}
