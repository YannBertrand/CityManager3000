package com.citymanager3000.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.citymanager3000.types.Image;

/**
 * @author Yann
 *
 */
@SuppressWarnings("serial")
public class Panel extends JPanel {
	private Frame frame;
	private Dimension bar_size;
	private BufferedImage background_image;
	private boolean repetitive_background=false;
	
	public Panel(Frame frame) {
		this.setFrame(frame);
		this.setBackground(Color.ORANGE);
	}
	
	/*
	 * Mets l'image de fond répétitive grâce au chemin de l'image
	 */
	public void setBackground(String background_image_name, boolean repetitive_background) {
		if(repetitive_background)
			setRepetitiveBackground(true);
		setBackgroundImage(new Image(background_image_name).getImage());
	}
	
	/*
	 * Mets l'image de fond grâce au chemin de l'image
	 */
	public void setBackground(String background_image_name) {
		setBackgroundImage(new Image(background_image_name).getImage());
	}

	public void paintComponent(Graphics g) {
		//Mise à jour des dimensions
		int jframe_width = this.getWidth(); int jframe_height = this.getHeight();
		
		//Affichage de l'arrière plan
		if(isRepetitiveBackground()) {
			//Répétitif
			for(int i=0; i<this.getWidth()/32+1; i++) {
				for(int j=0; j<=this.getHeight()/32; j++) {
					g.drawImage(getBackgroundImage(), i*32, j*32, 32, 32, this);
				}
			}
		} else {
			//Ou pas
			g.drawImage(getBackgroundImage(), 0, 0, jframe_width, jframe_height, this);
		}
	}
	
	/**
	 * @return the frame
	 */
	public Frame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
	/**
	 * @param background image
	 */
	private void setBackgroundImage(BufferedImage background) {
		this.background_image = background;
	}

	/**
	 * @return the repetitive_background
	 */
	private boolean isRepetitiveBackground() {
		return repetitive_background;
	}

	/**
	 * @param repetitive_background the repetitive_background to set
	 */
	private void setRepetitiveBackground(boolean repetitive_background) {
		this.repetitive_background = repetitive_background;
	}

	/**
	 * @return the background
	 */
	public BufferedImage getBackgroundImage() {
		return background_image;
	}
	
	/**
	 * @return the bar_size
	 */
	public Dimension getBarSize() {
		return bar_size;
	}

	/**
	 * @param bar_size the bar_size to set
	 */
	public void setBarSize(Dimension bar_size) {
		this.bar_size = bar_size;
	}
}
