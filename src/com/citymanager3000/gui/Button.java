package com.citymanager3000.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

import com.citymanager3000.types.Image;

/**
 * @author Yann
 *
 */
@SuppressWarnings("serial")
public class Button extends JButton implements MouseListener {
	private final String name;
	private BufferedImage icon=null;

	private Color background_color = Color.WHITE;
	private Color border_color = Color.BLACK;
	private Color text_color = Color.BLACK;

	/**
	 * Création d'un bouton sans image
	 */
	public Button(Panel panel, String name) {
		this.name=name;
		
		this.addMouseListener(this);
	}

	/**
	 * @param panel
	 * Création d'un bouton avec image de fond 
	 */
	public Button(Panel panel, String name, String icon_path) {
		this.name=name;
		setIcon(new Image(icon_path).getImage());

		this.addMouseListener(this);
	}

	/**
	 * @return the icon
	 */
	public BufferedImage getImage() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	private void setIcon(BufferedImage icon) {
		this.icon = icon;
	}

	/*
	 * @param g2d
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;

		if(icon==null) { //Bouton avec couleurs
			g2d.setColor(this.background_color);
			g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

			g2d.setColor(this.border_color);
			g2d.fillRect(0, 0, 5, this.getHeight());
			g2d.fillRect(0, 0, this.getWidth(), 5);
			g2d.fillRect(this.getWidth()-5, 0, 5, this.getHeight());
			g2d.fillRect(0, this.getHeight()-5, this.getWidth(), 5);

			g2d.setColor(this.text_color);
			g2d.drawString(this.name, (int) (this.getWidth()/2 - (this.name.length()*2.5)), (this.getHeight()/2) + 5);
		} else { //Bouton image
			g2d.drawImage(this.icon, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}

	//Méthode appelée lors du clic de souris
	public void mouseClicked(MouseEvent event) { 
		this.background_color = Color.LIGHT_GRAY;
	}

	//Méthode appelée lors du survol de la souris
	public void mouseEntered(MouseEvent event) { 
		this.background_color = Color.LIGHT_GRAY;
	}

	//Méthode appelée lorsque la souris sort de la zone du bouton
	public void mouseExited(MouseEvent event) { 
		this.background_color = Color.WHITE;
	}

	//Méthode appelée lorsque l'on presse le bouton gauche de la souris
	public void mousePressed(MouseEvent event) { 
		this.background_color = Color.GRAY;
	}

	//Méthode appelée lorsque l'on relâche le clic de souris
	public void mouseReleased(MouseEvent event) { 
		if((event.getY() > 0 && event.getY() < this.getHeight()) && (event.getX() > 0 && event.getX() < this.getWidth())){
			this.background_color = Color.LIGHT_GRAY;
		}
		//Si on se trouve à l'extérieur, on dessine le fond par défaut
		else{
			this.background_color = Color.WHITE;
		}    
	}
	
	public String getName() {
		return name;
	}
}
