/**
 * 
 */
package com.citymanager3000.src.voiesdecommunication;

import com.citymanager3000.src.VoieDeCommunication;

/**
 * @author Yann
 *
 */
public class Autoraute extends VoieDeCommunication {

	/**
	 * Constructeur
	 */
	public Autoraute(int[] positionDebut, int[] positionFin) {
		super("Terrien", 50, 50, 50, positionDebut, positionFin, "", "Création d'une autoroute de la position "+positionDebut.toString()+" à la position "+positionFin.toString()+".");
	}

}
