/**
 * 
 */
package com.citymanager3000.gui.listeners;

import java.awt.event.ActionEvent;

import com.citymanager3000.gui.Frame;

/**
 * @author Yann
 *
 */
public class ValidateButtonListener extends ButtonListener {
	private String message;
	private String next_panel;
	
	public ValidateButtonListener(Frame frame, String message, String next_step) {
		super(frame);
		
		setMessage(message);
		setNextPanel(next_step);
	}
	
	//Redéfinition de la méthode actionPerformed()
	public void actionPerformed(ActionEvent arg) {
		System.out.println("VALIDATION : "+getMessage());
		getParent().setPanel(getNextPanel());
	}

	/**
	 * @return the message
	 */
	private String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	private void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the next_panel
	 */
	private String getNextPanel() {
		return next_panel;
	}

	/**
	 * @param next_panel the next_panel to set
	 */
	private void setNextPanel(String next_panel) {
		this.next_panel = next_panel;
	}
}
