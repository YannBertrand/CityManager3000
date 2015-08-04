package com.citymanager3000.gui.panels;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.citymanager3000.gui.Button;
import com.citymanager3000.gui.Frame;
import com.citymanager3000.gui.Panel;
import com.citymanager3000.gui.listeners.ValidateButtonListener;
import com.citymanager3000.src.Configuration;

/**
 * @author Yann
 *
 */
@SuppressWarnings("serial")
public class Menu2CreatePanel extends Panel {
	
	public Menu2CreatePanel(Frame frame) {
		super(frame);

		this.setLayout(new GridLayout(3,3,5,5));
		this.setBackground("img/bourg_palette.jpg");

		//Bouton retour
		Panel back_panel = new Panel(frame);
		back_panel.setLayout(new GridLayout(4,3,5,5));

		Button b_back = new Button(back_panel, "Retour");
		b_back.addActionListener(new ValidateButtonListener(frame, "Retour au menu", "menu-1"));
		back_panel.add(new Panel(frame)); back_panel.add(new Panel(frame)); back_panel.add(new Panel(frame));
		back_panel.add(new Panel(frame)); back_panel.add(new Panel(frame)); back_panel.add(new Panel(frame));
		back_panel.add(new Panel(frame)); back_panel.add(new Panel(frame)); back_panel.add(new Panel(frame));
		back_panel.add(b_back); back_panel.add(new Panel(frame));  back_panel.add(new Panel(frame));

		//Formulaire
		Panel form_panel = new Panel(frame);
		form_panel.setLayout(new GridLayout(3,2,5,5));

		JLabel name = new JLabel("Nom : ");
		name.setForeground(Color.WHITE);
		JTextField name_field = new JTextField();
		form_panel.add(name); form_panel.add(name_field);

		JLabel environnement = new JLabel("Environnement : ");
		environnement.setForeground(Color.WHITE);
		JComboBox<String> environnement_choice = new JComboBox<String>(Configuration.LISTE_ENVIRONNEMENTS);
		form_panel.add(environnement); form_panel.add(environnement_choice);

		JLabel difficulty = new JLabel("Difficulté : ");
		difficulty.setForeground(Color.WHITE);
		JComboBox<String> difficulty_choice = new JComboBox<String>(Configuration.LISTE_DIFFICULTES);
		form_panel.add(difficulty); form_panel.add(difficulty_choice);

		//Validation
		Panel validation_panel = new Panel(frame);
		validation_panel.setLayout(new GridLayout(3,1,5,5));
		Button b_valider = new Button(validation_panel, "Valider");
		if(name_field.getText() != "")
			b_valider.addActionListener(new ValidateButtonListener(frame, "Lancement du jeu", "game"));
		validation_panel.add(b_valider); validation_panel.add(new Panel(frame)); validation_panel.add(new Panel(frame));


		//Create the container
		this.add(new Panel(frame)); this.add(back_panel); this.add(new Panel(frame));
		this.add(new Panel(frame)); this.add(form_panel); this.add(new Panel(frame)); 
		this.add(new Panel(frame)); this.add(validation_panel); this.add(new Panel(frame));
	}


}
