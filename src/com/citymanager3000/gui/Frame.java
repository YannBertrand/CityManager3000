package com.citymanager3000.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.citymanager3000.gui.panels.GamePanel;
import com.citymanager3000.gui.panels.Menu1Panel;
import com.citymanager3000.gui.panels.Menu2ContinuePanel;
import com.citymanager3000.gui.panels.Menu2CreatePanel;

import com.citymanager3000.src.Configuration;

/**
 * @author Yann
 *
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {
	private Panel container;
	
	@SuppressWarnings("static-access")
	public Frame() {
		this.setTitle(Configuration.TITLE);

		this.setMinimumSize(new Dimension(600, 338));
		int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width; 
		int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
		Dimension size = new Dimension((int) (screen_width/1.5), (int) (screen_height/1.5));
		this.setSize(size);
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setPanel(Configuration.BASE_PANEL);

		this.setVisible(true);
	}
	
	public void setPanel(String panel_name) {
		if(panel_name=="game") { container = new GamePanel(this); } 
		else if(panel_name=="menu-1") { container = new Menu1Panel(this); }
		else if(panel_name=="menu-2-creer") { container = new Menu2CreatePanel(this); }
		else if(panel_name=="menu-2-reprendre") { container = new Menu2ContinuePanel(this); }
		
		this.setContentPane(container);
		this.setVisible(true); //Refresh
	}

	/**
	 * @return the container
	 */
	public Panel getContainerPanel() {
		return container;
	}
}
