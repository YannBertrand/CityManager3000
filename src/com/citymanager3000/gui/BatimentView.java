package com.citymanager3000.gui;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.citymanager3000.src.Batiment;
import com.citymanager3000.types.Position;

/**
 * @author Yann Bertrand
 *
 */
public class BatimentView {
	private Batiment batiment;
	private Position top_left_hand_corner; 
	private Position bottom_right_hand_corner=null; 
	
	/*
	 * Créer un Batiment qui ne sera pas ajouté à la map (besoin des infos sur le Batiment)
	 */
	@SuppressWarnings("unchecked")
	public BatimentView(String name) {
		try {
			Class<? extends Batiment> batiment_class = (Class<? extends Batiment>) Class.forName("com.citymanager3000.src.batiments."+name);
			Constructor<?> batiment_constructor = batiment_class.getDeclaredConstructors()[0];

			setBatiment((Batiment) batiment_constructor.newInstance(new Object[] { new Position(0,0) }));
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Création d'un Batiment avec une position définie, 
	 * sert pour ajouter un Batiment à la map
	 */
	@SuppressWarnings("unchecked")
	public BatimentView(String name, Position position) {
		top_left_hand_corner = position;

		try {
			Class<? extends Batiment> batiment_class=(Class<? extends Batiment>) Class.forName("com.citymanager3000.src.batiments."+name);
			Constructor<?> batiment_constructor = batiment_class.getDeclaredConstructors()[0];
			setBatiment((Batiment) batiment_constructor.newInstance(new Object[] { position }));

			setBottomRightHandCorner(new Position(position.getX() + batiment.getDimension().getWidth(),
					position.getY() + batiment.getDimension().getDepth()));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the batiment
	 */
	public Batiment getBatiment() {
		return batiment;
	}

	/**
	 * @param batiment the batiment to set
	 */
	private void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}

	/**
	 * @return the top_left_hand_corner
	 */
	public Position getTopLeftHandCorner() {
		return top_left_hand_corner;
	}

	/**
	 * @return the bottom_right_hand_corner
	 */
	public Position getBottomRightHandCorner() {
		return bottom_right_hand_corner;
	}

	/**
	 * @param bottom_right_hand_corner the bottom_right_hand_corner to set
	 */
	private void setBottomRightHandCorner(Position bottom_right_hand_corner) {
		this.bottom_right_hand_corner = bottom_right_hand_corner;
	}


}
