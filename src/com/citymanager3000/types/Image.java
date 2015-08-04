package com.citymanager3000.types;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Yann
 *
 */
public class Image {
	private String image_path;
	private BufferedImage image=null;
	
	/**
	 * Créer une image grâce à son chemin
	 */
	public Image(String image_path) { 
		setImagePath(image_path);
		setImageFromImagePath();
	}
	
	/*
	 * Crééé l'image grâce au chemin du fichier (si existant)
	 */
	private void setImageFromImagePath() {
		try {
			setImage(ImageIO.read(new File(image_path)));
		} catch (IOException e) {
			System.out.println("IMAGE : erreur");
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the image_path
	 */
	public String getImagePath() {
		return image_path;
	}

	/**
	 * @param image_path the image_path to set
	 */
	private void setImagePath(String image_path) {
		this.image_path = image_path;
	}

	/**
	 * @return the image
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	private void setImage(BufferedImage image) {
		this.image = image;
	}
}
