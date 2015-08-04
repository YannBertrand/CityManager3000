package com.citymanager3000.types;

/**
 * @author Yann
 *
 */
public class Dimension3D {
	private int width;
	private int depth;
	private int height;
	/**
	 * Constructeur par défaut
	 */
	public Dimension3D() { }
	
	/**
	 * Constructeur par défaut
	 */
	public Dimension3D(Dimension3D dimension) { 
		this.setWidth(dimension.getWidth());
		this.setDepth(dimension.getDepth());
		this.setHeight(dimension.getHeight());
	}

	/**
	 * @param width
	 * @param depth
	 * @param height
	 */
	public Dimension3D(int width, int depth, int height) {
		this.setWidth(width);
		this.setDepth(depth);
		this.setHeight(height);
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
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
