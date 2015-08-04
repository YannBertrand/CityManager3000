package com.citymanager3000.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.Normalizer;
import java.util.Vector;

import com.citymanager3000.gui.BatimentView;
import com.citymanager3000.gui.Frame;
import com.citymanager3000.src.Configuration;
import com.citymanager3000.src.Game;
import com.citymanager3000.types.Position;

/**
 * @author Yann
 *
 */
public class TabListener extends ButtonListener implements MouseListener {
	private String name;
	private static MouseListener mouse_listener;
	private static ImageFollowMouse mouse_follower;
	private BatimentView batiment_view;
	private boolean is_ok=true;

	/*** 
	 * @param frame
	 */
	public TabListener(Frame frame, BatimentView batiment_view) {
		super(frame);
		setBatimentView(batiment_view);
		setName(batiment_view.getBatiment().getNom());
		setMouseFollower(new ImageFollowMouse(getParent()));
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(batiment_view.getBatiment().isUnique() && batiment_view.getBatiment().isAlreadyLaid()) {
			//Batiment unique déjà posé
			if(Configuration.MODE == "debug")
				System.out.println("Batiment unique déjà posé !");
		} else {
			//CLIC SUR UN BATIMENT
			getParent().removeMouseListener(mouse_listener);
			getParent().addMouseListener(this);

			getMouseFollower().remove();
			setMouseFollower(new ImageFollowMouse(getParent(), batiment_view));

			setMouseListener(getParent().getMouseListeners()[getParent().getMouseListeners().length-1]);
		}
	}

	@Override
	public void mousePressed(MouseEvent evt) { verifierEtCreerBatiment(evt); }

	private void verifierEtCreerBatiment(MouseEvent evt) {
		//Calcul de la position de départ
		int top_left_x = evt.getX()-evt.getX()%Configuration.TILE_SIZE-8;	
		int top_left_y = (int) (evt.getY()-evt.getY()%Configuration.TILE_SIZE-getParent().getContainerPanel().getBarSize().getHeight()-28);
		Position top_left_hand_corner = new Position(top_left_x, top_left_y);

		String normalised_name=Normalizer.normalize(name, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll("\\s", "");
		setBatimentView(new BatimentView(normalised_name, top_left_hand_corner));

		//Vérification que l'argent est suffisant
		verifyMoney();

		//Vérification que l'espace est disponible
		verifySpace(top_left_x, top_left_y);
		
		//Ajouter le batiment si tout est ok
		
		if(isOk()) {
			//Création du Batiment
			Game.creerBatiment(batiment_view);

			//Suppression du suiveur de curseur
			getMouseFollower().remove();
			getParent().removeMouseListener(getMouseListener());
		}
		setIsOk(true);
	}

	/*
	 * Vérifie que l'argent est suffisant pour créer le batiment
	 */
	private void verifyMoney() {
		double prix_construction = getBatimentView().getBatiment().getPrixConstruction();
		if(Game.money < prix_construction) {
			setIsOk(false);
			System.out.println("Batiment trop cher ! $"+prix_construction);
		}
	}

	/*
	 * Vérifie que l'espace est disponible pour créer le batiment
	 */
	private void verifySpace(int top_left_x, int top_left_y) {
		if(isOk()) {
			Vector<BatimentView> liste_batiments = Game.getBatiments();
			if(liste_batiments != null) { 
				BatimentView batiment;
				Position top_left_hand_corner_position; Position bottom_right_hand_corner_position;
				int left_x; int top_y;
				int right_x; int bottom_y;
				
				int width = getBatimentView().getBatiment().getDimension().getWidth();
				int depth = getBatimentView().getBatiment().getDimension().getDepth();
				for(int i=0; i<liste_batiments.size(); i++) { 
					//Récupération des trucs intéressants
					batiment = liste_batiments.get(i);
					top_left_hand_corner_position = batiment.getTopLeftHandCorner();
					bottom_right_hand_corner_position = batiment.getBottomRightHandCorner();
	
					left_x = top_left_hand_corner_position.getX() - width; 
					top_y = top_left_hand_corner_position.getY() - depth;
					right_x = bottom_right_hand_corner_position.getX()-1; 
					bottom_y = bottom_right_hand_corner_position.getY();
					
					//Vérification
					if(top_left_x > left_x && 
							top_left_x < right_x && 
							top_left_y > top_y && 
							top_left_y < bottom_y) {
						setIsOk(false);
						break;
					}
				}
			}
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mouse_listener
	 */
	private static MouseListener getMouseListener() {
		return mouse_listener;
	}

	/**
	 * @param mouse_listener the mouse_listener to set
	 */
	private static void setMouseListener(MouseListener mouse_listener) {
		TabListener.mouse_listener = mouse_listener;
	}

	/**
	 * @return the mouse_follower
	 */
	private static ImageFollowMouse getMouseFollower() {
		return mouse_follower;
	}

	/**
	 * @param mouse_follower the mouse_follower to set
	 */
	private static void setMouseFollower(ImageFollowMouse mouse_follower) {
		TabListener.mouse_follower = mouse_follower;
	}

	/**
	 * @return the batiment_view
	 */
	public BatimentView getBatimentView() {
		return batiment_view;
	}

	/**
	 * @param batiment_view the batiment_view to set
	 */
	public void setBatimentView(BatimentView batiment_view) {
		this.batiment_view = batiment_view;
	}

	/**
	 * @return the is_ok
	 */
	private boolean isOk() {
		return is_ok;
	}

	/**
	 * @param is_ok the is_ok to set
	 */
	private void setIsOk(boolean is_ok) {
		this.is_ok = is_ok;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) { }
	@Override
	public void mouseClicked(MouseEvent arg0) { }
	@Override
	public void mouseEntered(MouseEvent arg0) { }
	@Override
	public void mouseExited(MouseEvent arg0) { }
}
