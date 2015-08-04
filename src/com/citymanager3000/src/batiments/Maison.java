package com.citymanager3000.src.batiments;

import com.citymanager3000.src.Batiment;
import com.citymanager3000.src.Configuration;
import com.citymanager3000.types.Dimension3D;
import com.citymanager3000.types.Position;

/**
 * @author Yann + Corentin
 *
 */
public class Maison extends Batiment {
	private static final int NIVEAU_MAX = 1;

	private static final Dimension3D[] DIMENSIONS = {new Dimension3D(80,56,20), new Dimension3D(80,56,40)};

	private static final double PRIX_CONSTRUCTION = 150000;
	private static final double[] BENEFICE_PAR_MOIS = {250,500};
	private static final double[] PRIX_AMELIORATIONS = {100000};
	private static final double[] PRIX_DESTRUCTIONS = {25000,50000};

	private static final String[] IMAGES = {Configuration.COMPLETE_BATIMENTS_DIR+"Maison.gif", "maison-1"};

	private int niveau=0;

	public Maison(Position position) {
		super("Habitation",
				"Maison",
				position,
				DIMENSIONS[0],
				PRIX_CONSTRUCTION,
				BENEFICE_PAR_MOIS[0],
				PRIX_AMELIORATIONS[0],
				PRIX_DESTRUCTIONS[0],
				IMAGES[0]);
	}
}
