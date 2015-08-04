package com.citymanager3000.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.citymanager3000.gui.Frame;

/**
 * @author Yann
 *
 */
public class ButtonListener implements ActionListener {
	private Frame parent;

	/*** 
	 * @param frame
	 */
	public ButtonListener(Frame frame) {
		this.setParent(frame);
	}

	//Redéfinition de la méthode actionPerformed()
	public void actionPerformed(ActionEvent arg) { }
	
	/**
	 * @return the parent
	 */
	public Frame getParent() {
		return parent;
	}
	
	/**
	 * @param parent the parent to set
	 */
	private void setParent(Frame parent) {
		this.parent = parent;
	}
}
