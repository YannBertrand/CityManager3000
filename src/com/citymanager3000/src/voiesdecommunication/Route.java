/**
 * 
 */
package com.citymanager3000.src.voiesdecommunication;

import com.citymanager3000.src.VoieDeCommunication;

/**
 * @author Yann
 *
 */
public class Route extends VoieDeCommunication {

	/**
	 * Constructeur
	 */
	public Route(int[] positionDebut, int[] positionFin) {
		super("Terrien", 50, 50, 50, positionDebut, positionFin, "", "Cr�ation d'une route de la position "+positionDebut.toString()+" � la position "+positionFin.toString()+".");
	}

}
