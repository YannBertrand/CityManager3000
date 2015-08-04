package com.citymanager3000.src.batiments;

import com.citymanager3000.src.Batiment;
import com.citymanager3000.src.Configuration;
import com.citymanager3000.types.Dimension3D;
import com.citymanager3000.types.Position;

/**
 * @author Yann + Corentin
 *
 */
public class CaserneDePompiers extends Batiment {
	private static final int NIVEAU_MAX = 1;

	private static final Dimension3D[] DIMENSIONS = {new Dimension3D(80,56,20), new Dimension3D(80,56,40)};

	private static final double PRIX_CONSTRUCTION = 8000000;
	private static final double[] BENEFICE_PAR_MOIS = {0,0};
	private static final double[] PRIX_AMELIORATIONS = {35000000};
	private static final double[] PRIX_DESTRUCTIONS = {1000000,5000000};

	private static final String[] IMAGES = {Configuration.COMPLETE_BATIMENTS_DIR+"CaserneDePompiers.gif", "CaserneDePompiers-1"};

	private int niveau=0;

	public CaserneDePompiers(Position position) {
		super("Utilit� Publique",
				"CaserneDePompiers",
				position,
				DIMENSIONS[0],
				PRIX_CONSTRUCTION,
				BENEFICE_PAR_MOIS[0],
				PRIX_AMELIORATIONS[0],
				PRIX_DESTRUCTIONS[0],
				IMAGES[0]);
	}

	/*
	 * Am�liorer un batiment
	 * @return true si am�lior�, false sinon
	 */
	public boolean ameliorer() {
		int niveau_suivant = this.getNiveau()+1;
		update_amelioration_possible(niveau_suivant);
		if(isAmeliorationPossible()) {
			//Actualisation de l'image
			this.setImagePath(CaserneDePompiers.IMAGES[niveau_suivant]);
			//Actualisation du niveau
			this.setNiveau(niveau_suivant);

			if(Configuration.MODE=="debug")
				System.out.println("CASERNE DE POMPIERS : Am�lioration de la caserne de pompiers � la position "+this.getPosition().toString()+"."); 

			return true;
		} else {
			if(Configuration.MODE=="debug")
				System.out.println("CASERNE DE POMPIERS : Niveau maximum d�j� atteint.");

			return false;
		}
	}

	/*
	 * Actualise le champ is_amelioration_possible
	 * @param le niveau suivant (int)
	 */
	private void update_amelioration_possible(int niveau_suivant) {
		if(isAmeliorationPossible()) {
			if(niveau_suivant <= CaserneDePompiers.NIVEAU_MAX) setIsAmeliorationPossible(true);
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
	 * @param le niveau � mettre (int)
	 */
	private void setNiveau(int niveau) {
		this.niveau = niveau;
	}
}
