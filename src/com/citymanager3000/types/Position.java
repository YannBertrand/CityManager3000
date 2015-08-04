package com.citymanager3000.types;

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
	 * @param arg0
	 */
	public Position(Position position) {
		this.setX(position.getX());
		this.setY(position.getY());
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public Position(int x, int y) {
		this.setX(x);
		this.setY(y);
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
