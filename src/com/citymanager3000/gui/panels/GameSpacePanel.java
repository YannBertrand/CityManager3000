package com.citymanager3000.gui.panels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

import com.citymanager3000.gui.BatimentView;
import com.citymanager3000.gui.Frame;
import com.citymanager3000.gui.Panel;
import com.citymanager3000.src.Batiment;
import com.citymanager3000.src.Configuration;
import com.citymanager3000.src.Game;

/**
 * @author Yann Bertrand
 *
 */
@SuppressWarnings("serial")
public class GameSpacePanel extends Panel {
	
	public GameSpacePanel(Frame frame) {
		super(frame);
		
		setBackground("img/"+Configuration.ENVIRONNEMENT+"/background.gif", true);
	}
	
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		
		Vector<BatimentView> liste_batiments = Game.getBatiments();
		if(liste_batiments != null) { 
			Batiment batiment;
			for(BatimentView batiment_view: liste_batiments) { 
				batiment = batiment_view.getBatiment();
				g.drawImage(getImageFromPath(batiment.getImagePath()), 
						batiment.getPosition().getX(), 
						batiment.getPosition().getY(), 
						batiment.getDimension().getWidth(), 
						batiment.getDimension().getDepth(), 
						this);
			}
		}
		
		this.repaint();
	}

	public BufferedImage getImageFromPath(String path) {
		BufferedImage image=null;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
}
