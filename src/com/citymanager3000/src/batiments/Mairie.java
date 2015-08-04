package com.citymanager3000.src.batiments;

import com.citymanager3000.src.Batiment;
import com.citymanager3000.src.Configuration;
import com.citymanager3000.types.Dimension3D;
import com.citymanager3000.types.Position;

/**
 * @author Yann + Corentin
 *
 */
public class Mairie extends Batiment {
	private static final int NIVEAU_MAX = 1;

	private static final Dimension3D[] DIMENSIONS = {new Dimension3D(80,90,20)};

	private static final double PRIX_CONSTRUCTION = 8000000;
	private static final double[] BENEFICE_PAR_MOIS = {0};
	private static final double[] PRIX_AMELIORATIONS = {0};
	private static final double[] PRIX_DESTRUCTIONS = {1000000};

	private static final String[] IMAGES = {Configuration.COMPLETE_BATIMENTS_DIR+"Mairie.gif"};

	private int niveau=0;

	/**
	 * Constructeur
	 * @param position
	 * @throws Exception 
	 */
	public Mairie(Position position) {
		super("Utilité Publique",
				"Mairie",
				position,
				DIMENSIONS[0],
				PRIX_CONSTRUCTION,
				BENEFICE_PAR_MOIS[0],
				PRIX_AMELIORATIONS[0],
				PRIX_DESTRUCTIONS[0],
				IMAGES[0]);
		setUnique(true);
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
			this.setImagePath(Mairie.IMAGES[niveau_suivant]);
			//Actualisation du niveau
			this.setNiveau(niveau_suivant);

			if(Configuration.MODE=="debug")
				System.out.println("MAIRIE : Amélioration de la mairie à la position "+this.getPosition().toString()+"."); 

			return true;
		} else {
			if(Configuration.MODE=="debug")
				System.out.println("MAIRIE : Niveau maximum déjà atteint.");

			return false;
		}
	}

	/*
	 * Actualise le champ is_amelioration_possible
	 * @param le niveau suivant (int)
	 */
	private void update_amelioration_possible(int niveau_suivant) {
		if(isAmeliorationPossible()) {
			if(niveau_suivant <= Mairie.NIVEAU_MAX) setIsAmeliorationPossible(true);
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
