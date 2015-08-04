package com.citymanager3000.gui.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.citymanager3000.gui.BatimentView;
import com.citymanager3000.gui.Button;
import com.citymanager3000.gui.Panel;
import com.citymanager3000.src.Batiment;


/**
 * @author Yann Bertrand
 *
 */
@SuppressWarnings("serial")
public class ElementButton extends Button implements MouseListener {
	private boolean mouse_hover=false;
	private Batiment batiment;
	private Panel hover_panel;
	
	public ElementButton(Panel panel, BatimentView batiment_view) {
		super(panel, batiment_view.getBatiment().getNom(), batiment_view.getBatiment().getImagePath());

		setBatiment(batiment_view.getBatiment());
		
		Panel hover_panel=new Panel(panel.getFrame());
		hover_panel.setLayout(null);
		hover_panel.setBounds( 122, 49, 18, 395) ;
		hover_panel.setPreferredSize(new Dimension(100,100));
		hover_panel.setBackground(Color.BLACK);
		
		setHoverPanel(hover_panel);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(isMouseHover()) { 
			//Affiche les infos sur le batiment si la souris est sur le bouton
		    g.fillRect(0, 0, this.getWidth(), this.getWidth());
			g.setColor(Color.WHITE);
			//g.drawString(this.getName(),5,15);
			g.drawString(batiment.getNom(), 5, 15);
			g.drawString("$"+batiment.getPrixConstruction()+" ($"+batiment.getBeneficeParMois()+"/H)", 5, 30);
			g.drawString("$"+batiment.getPrixAmelioration(), 5, 45);
			g.drawString("$"+batiment.getPrixDestruction(), 5, 60);
			
			/////////////////////// ?????????
			
			
		}
		else super.paintComponent(g);
		//g.fillRect(0, 0, this.getWidth(), this.getWidth());
	}
	
	//Méthode appelée lors du survol de la souris
	public void mouseEntered(MouseEvent event) { 
		super.mouseEntered(event);
		setMouseHover(true);
		hover_panel.getFrame().add(hover_panel);
		repaint();
	}
	
	//Méthode appelée lorsque la souris sort de la zone du bouton
	public void mouseExited(MouseEvent event) { 
		super.mouseExited(event);
		setMouseHover(false);
		repaint();
	}

	public Batiment getBatiment() {
		return batiment;
	}

	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}

	/**
	 * @return the mouse_hover
	 */
	private boolean isMouseHover() {
		return mouse_hover;
	}

	/**
	 * @param mouse_hover the mouse_hover to set
	 */
	private void setMouseHover(boolean mouse_hover) {
		this.mouse_hover = mouse_hover;
	}

	/**
	 * @param hover_panel the hover_panel to set
	 */
	private void setHoverPanel(Panel hover_panel) {
		this.hover_panel = hover_panel;
	}
}
