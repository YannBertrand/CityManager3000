package com.citymanager3000.src.batiments;

import com.citymanager3000.src.Batiment;
import com.citymanager3000.src.Configuration;
import com.citymanager3000.types.Dimension3D;
import com.citymanager3000.types.Position;

/**
 * @author Yann + Corentin
 *
 */
public class CabinetMedical extends Batiment {
	private static final int NIVEAU_MAX = 1;

	private static final Dimension3D[] DIMENSIONS = {new Dimension3D(80,80,20), new Dimension3D(80,80,40)};

	private static final double PRIX_CONSTRUCTION = 50000000;
	private static final double[] BENEFICE_PAR_MOIS = {0,0};
	private static final double[] PRIX_AMELIORATIONS = {200000000};
	private static final double[] PRIX_DESTRUCTIONS = {5000000,15000000};

	private static final String[] IMAGES = {Configuration.COMPLETE_BATIMENTS_DIR+"CabinetMedical.gif", "CabinetMedical-1"};

	private int niveau=0;

	public CabinetMedical(Position position) {
		super("Utilité Publique",
				"Cabinet Médical",
				position,
				DIMENSIONS[0],
				PRIX_CONSTRUCTION,
				BENEFICE_PAR_MOIS[0],
				PRIX_AMELIORATIONS[0],
				PRIX_DESTRUCTIONS[0],
				IMAGES[0]);
	}

	/*
	 * Améliorer un batiment
	 * @return true si amélioré, false sinon
	 */
	public boolean ameliorer() {
		int niveau_suivant = this.getNiveau()+1;
		update_amelioration_possible(niveau_suivant);
		if(isAmeliorationPossible()) {
			//Actualisation de l'image
			this.setImagePath(CabinetMedical.IMAGES[niveau_suivant]);
			//Actualisation du niveau
			this.setNiveau(niveau_suivant);

			if(Configuration.MODE=="debug")
				System.out.println("CABINET MEDICAL : Amélioration du cabinet médical à la position "+this.getPosition().toString()+"."); 

			return true;
		} else {
			if(Configuration.MODE=="debug")
				System.out.println("CABINET MEDICAL : Niveau maximum déjà atteint.");

			return false;
		}
	}

	/*
	 * Actualise le champ is_amelioration_possible
	 * @param le niveau suivant (int)
	 */
	private void update_amelioration_possible(int niveau_suivant) {
		if(isAmeliorationPossible()) {
			if(niveau_suivant <= CabinetMedical.NIVEAU_MAX) setIsAmeliorationPossible(true);
			else setIsAmeliorationPossible(false);
		}
	}

	/**
	 * @return le niveau
	 */
	public int getNiveau() {
		return niveau;
	}

	/**
	 * @param le niveau à mettre (int)
	 */
	private void setNiveau(int niveau) {
		this.niveau = niveau;
	}
}
