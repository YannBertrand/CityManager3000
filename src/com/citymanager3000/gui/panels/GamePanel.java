package com.citymanager3000.gui.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.text.Normalizer;
import java.util.LinkedHashMap;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import com.citymanager3000.gui.BatimentView;
import com.citymanager3000.gui.Frame;
import com.citymanager3000.gui.Panel;
import com.citymanager3000.gui.buttons.ElementButton;
import com.citymanager3000.gui.listeners.TabListener;
import com.citymanager3000.src.Configuration;
import com.citymanager3000.src.Game;

/**
 * @author Yann
 *
 */
@SuppressWarnings("serial")
public class GamePanel extends Panel {
	private JTabbedPane constructions;
	private static JLabel money_label;
	
	/**
	 * Constructeur par défaut
	 */
	public GamePanel(final Frame frame) {
		super(frame);

		this.setLayout(new BorderLayout());
		this.setBackground("img/bourg_palette.jpg");
		
		//BARRE
		JTabbedPane bar = new JTabbedPane(JTabbedPane.TOP);

		//INFOS
		Panel infos = new Panel(frame);
		infos.setLayout(new GridLayout(5,1));
		infos.add(new JLabel(Configuration.CITY_NAME));
		setMoneyLabel(new JLabel("Argent : $"+Game.money));
		infos.add(money_label);
		infos.add(new JLabel(""));
		infos.add(new JLabel(""));
		infos.add(new JLabel(""));

		bar.add("Infos", infos);

		//BATIMENTS
		setConstructions(new JTabbedPane(JTabbedPane.TOP));

		for(String type_batiment : Configuration.LISTE_BATIMENTS.keySet()) {
			Panel type_batiment_panel;
			type_batiment_panel = calculateFinalTabPanels(Configuration.LISTE_BATIMENTS.get(type_batiment));
			
			getConstructions().add(type_batiment, type_batiment_panel);
		}
		
		bar.add("Constructions", getConstructions());

		//Jeu
		GameSpacePanel game=new GameSpacePanel(frame);

		this.add(bar, BorderLayout.NORTH);
		this.add(game, BorderLayout.CENTER);
		
		setBarSize(bar.getPreferredSize());
	}

	@SuppressWarnings("rawtypes")
	private Panel calculateFinalTabPanels(LinkedHashMap<String, Class> tabs) {
		Panel tab_panel = new Panel(getFrame());
		tab_panel.setLayout(null);
		
		int i=0;
		for(String tab : tabs.keySet()) {
			//Récupération de l'image du batiment
			String normalised_tab=Normalizer.normalize(tab, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll("\\s", "");
			BatimentView batiment_view = new BatimentView(normalised_tab);
			
			//Ajout à la barre
			ElementButton tab_button = new ElementButton(this, batiment_view);
			Dimension new_dimension = calculateDimensionForBar(tab_button.getImage());
			
			tab_button.setBounds(i,0,(int) new_dimension.getWidth(),80);
			
			tab_button.addActionListener(new TabListener(getFrame(), batiment_view));
			tab_panel.add(tab_button); i=i+(int) new_dimension.getWidth() + 5;
		}

		return tab_panel;
	}

	private Dimension calculateDimensionForBar(BufferedImage image) {
		double width = image.getWidth();
		double height = image.getHeight();

		double factor = 80/height;
		if(height!=80) height=80; width=factor*width;

		Dimension new_dimension = new Dimension();
		new_dimension.setSize(width, height);
		return new_dimension;
	}

	/**
	 * @return the batiments
	 */
	private JTabbedPane getConstructions() {
		return constructions;
	}

	/**
	 * @param batiments the batiments to set
	 */
	private void setConstructions(JTabbedPane constructions) {
		this.constructions = constructions;
	}

	/**
	 * @return the money_label
	 */
	public static JLabel getMoneyLabel() {
		return money_label;
	}

	/**
	 * @param money_label the money_label to set
	 */
	private static void setMoneyLabel(JLabel money_label) {
		GamePanel.money_label = money_label;
	}
}
