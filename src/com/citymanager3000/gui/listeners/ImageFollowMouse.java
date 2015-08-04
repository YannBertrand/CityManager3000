package com.citymanager3000.gui.listeners;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import com.citymanager3000.gui.BatimentView;
import com.citymanager3000.gui.Frame;
import com.citymanager3000.gui.Panel;
import com.citymanager3000.src.Configuration;
import com.citymanager3000.types.Image;

/**
 * @author Yann Bertrand
 *
 */
@SuppressWarnings("serial")
public class ImageFollowMouse extends Panel implements MouseMotionListener {
	private BufferedImage image=null;
	private int width;
	private int depth;
	private int x = 20;
	private int y = 20;
	private boolean repaint=false;

	public ImageFollowMouse(Frame frame) { 
		super(frame);
	}
	
	public ImageFollowMouse(Frame frame, BatimentView batiment_view) {
		super(frame);
		setRepaint(true);
		
		setImage(new Image(batiment_view.getBatiment().getImagePath()).getImage());
		//setDimension = batiment_view.getBatiment().getDimension();
		setWidth(batiment_view.getBatiment().getDimension().getWidth());
		setDepth(batiment_view.getBatiment().getDimension().getHeight());
		
		frame.addMouseMotionListener(this);
		frame.add(this);
		this.setPreferredSize(getFrame().getMaximumSize());
		frame.setVisible(true);
		
		go();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		if(getImage() != null) {
			g.drawImage(getImage(), 
					getX(), 
					getY(), 
					getWidth(), 
					getDepth(), 
					this);
			if(isRepaint())
				repaint();
		}
	}

	public void go() { repaint(); }

	@Override
	public void mouseMoved(MouseEvent evt) {
		//Mise à jour des coordonnées
		setX(evt.getX()-evt.getX()%Configuration.TILE_SIZE-8);
		setY((int) (evt.getY()-evt.getY()%Configuration.TILE_SIZE-getFrame().getContainerPanel().getBarSize().getHeight()-28));
	}

	@Override
	public void mouseDragged(MouseEvent arg0) { }
	
	/**
	 * Supprime le mouse motion follower
	 */
	public void remove() {
		repaint=false;
		this.removeMouseMotionListener(this);
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
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	private void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	private void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the repaint
	 */
	private boolean isRepaint() {
		return repaint;
	}
	/**
	 * @param repaint the repaint to set
	 */
	private void setRepaint(boolean repaint) {
		this.repaint = repaint;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	private void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the depth
	 */
	private int getDepth() {
		return depth;
	}

	/**
	 * @param depth the depth to set
	 */
	private void setDepth(int depth) {
		this.depth = depth;
	}
}
