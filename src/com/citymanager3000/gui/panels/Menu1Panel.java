package com.citymanager3000.gui.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import com.citymanager3000.gui.Button;
import com.citymanager3000.gui.Frame;
import com.citymanager3000.gui.Panel;
import com.citymanager3000.gui.listeners.ValidateButtonListener;

/**
 * @author Yann
 *
 */
@SuppressWarnings("serial")
public class Menu1Panel extends Panel {
	
	public Menu1Panel(Frame frame) {
		super(frame);
		
		//Panel container = new Panel(this);
		this.setLayout(new GridLayout(5,5,5,5));
		this.setBackground("img/bourg_palette.jpg");

		Panel panel = new Panel(frame);
		panel.setLayout(new GridLayout(2,1,5,5));
		
		Button b_creer = new Button(panel, "Créer une partie");
		b_creer.addActionListener(new ValidateButtonListener(frame, "Créer une partie", "menu-2-creer"));
		Button b_reprendre = new Button(panel, "Reprendre une partie");
		b_reprendre.addActionListener(new ValidateButtonListener(frame, "Reprendre une partie", "menu-2-reprendre"));
		panel.add(b_creer); panel.add(b_reprendre);
		
		for(int i=0; i<5+2;i++) { this.add(new Panel(frame)); }
		this.add(panel, BorderLayout.CENTER);
		for(int i=0; i<5+2;i++) { this.add(new Panel(frame)); }
	}
}
