package com.citymanager3000.src;

import java.awt.Dimension;

/**
 * @author Yann
 *
 */
@SuppressWarnings("serial")
public class Position extends Dimension {
	private int x;
	private int y;

	/**
	 * 
	 */
	public Position() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public Position(Position arg0) {
		super((Dimension) arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public Position(int arg0, int arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
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
	public void setX(int x) {
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
	public void setY(int y) {
		this.y = y;
	}
}
