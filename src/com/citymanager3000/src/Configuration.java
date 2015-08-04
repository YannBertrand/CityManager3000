package com.citymanager3000.src;

import java.util.LinkedHashMap;
import java.util.Vector;

import com.citymanager3000.src.batiments.CabinetMedical;
import com.citymanager3000.src.batiments.Centrale;
import com.citymanager3000.src.batiments.ExploitationAgricole;
import com.citymanager3000.src.batiments.Immeuble;
import com.citymanager3000.src.batiments.Mairie;
import com.citymanager3000.src.batiments.Maison;
import com.citymanager3000.src.batiments.Piscine;
import com.citymanager3000.src.batiments.Route;
import com.citymanager3000.src.batiments.Supermarche;


/**
* 
* @author Yann Bertrand
*
*/
public final class Configuration {
	public final static String TITLE="City Manager 3000";
	public final static String BASE_PANEL = "game";
	public final static long MONTH_DURATION=10000;
	public final static int TILE_SIZE = 16;
	
	public static String CITY_NAME;
	public static String MODE;
	public static String DIFFICULTE;
	public static double BASE_MONEY;
	public static String ENVIRONNEMENT;
	
	public final static String IMG_DIR="img/";
	public final static String BATIMENTS_DIR="batiments/";
	public static String COMPLETE_BATIMENTS_DIR;
	
	public static Vector<String> LISTE_DIFFICULTES = new Vector<String>();
	public static Vector<String> LISTE_ENVIRONNEMENTS = new Vector<String>();
	
	@SuppressWarnings("rawtypes")
	public static LinkedHashMap<String, LinkedHashMap<String, Class>> LISTE_BATIMENTS = new LinkedHashMap<String, LinkedHashMap<String, Class>>();
	public static Vector<String> TYPES_BATIMENT = new Vector<String>();
	public static Vector<String> TYPES_VOIE_DE_COMMUNICATION = new Vector<String>();

	public static void init(String city_name, String mode, String difficulte, String environnement) {
		Configuration.setListes();
		
		Configuration.CITY_NAME=city_name;
		Configuration.MODE=mode;
		
		Configuration.setDIFFICULTE(difficulte);
		Configuration.BASE_MONEY=10000000;
		
		Configuration.setENVIRONNEMENT(environnement);
		
		COMPLETE_BATIMENTS_DIR = IMG_DIR+Configuration.ENVIRONNEMENT+"/"+BATIMENTS_DIR;
	}
	
	public static void setListes() {
		Configuration.LISTE_DIFFICULTES.add("Facile");
		Configuration.LISTE_DIFFICULTES.add("Normal");
		Configuration.LISTE_DIFFICULTES.add("Hardcore");
		
		Configuration.LISTE_ENVIRONNEMENTS.add("Campagne");
		Configuration.LISTE_ENVIRONNEMENTS.add("Côte");
		Configuration.LISTE_ENVIRONNEMENTS.add("Montagne");
		Configuration.LISTE_ENVIRONNEMENTS.add("Désert");
		
		Configuration.setLISTE_BATIMENTS();
		
		Configuration.TYPES_BATIMENT.add("Habitation");
		Configuration.TYPES_BATIMENT.add("Commerce");
		Configuration.TYPES_BATIMENT.add("Industrie");
		Configuration.TYPES_BATIMENT.add("Utilité Publique");
		
		Configuration.TYPES_VOIE_DE_COMMUNICATION.add("Terrien");
		Configuration.TYPES_VOIE_DE_COMMUNICATION.add("Aérien");
		Configuration.TYPES_VOIE_DE_COMMUNICATION.add("Maritime");
	}
	
	public static void setDIFFICULTE(String difficulte) {
		if(Configuration.LISTE_DIFFICULTES.contains(difficulte)) { Configuration.DIFFICULTE=difficulte; }
		else { Configuration.DIFFICULTE="Normal"; }
		System.out.println("Difficulté \""+Configuration.DIFFICULTE+"\" activée.");
	}
	
	public static void setENVIRONNEMENT(String environnement) {
		if(Configuration.LISTE_ENVIRONNEMENTS.contains(environnement)) { Configuration.ENVIRONNEMENT=environnement; }
		else { Configuration.ENVIRONNEMENT="Campagne"; }
		System.out.println("Environnement \""+Configuration.ENVIRONNEMENT+"\" activé.");
	}
	
	public static void setLISTE_BATIMENTS() {
		@SuppressWarnings("rawtypes")
		LinkedHashMap<String, Class> liste_habitations = new LinkedHashMap<String, Class>();
		liste_habitations.put("Maison", Maison.class);
		liste_habitations.put("Immeuble", Immeuble.class);
		Configuration.LISTE_BATIMENTS.put("Habitation", liste_habitations);
		
		@SuppressWarnings("rawtypes")
		LinkedHashMap<String, Class> liste_industries = new LinkedHashMap<String, Class>();
		liste_industries.put("Exploitation Agricole", ExploitationAgricole.class);
		liste_industries.put("Centrale", Centrale.class);
		Configuration.LISTE_BATIMENTS.put("Industrie", liste_industries);
		
		@SuppressWarnings("rawtypes")
		LinkedHashMap<String, Class> liste_commerces = new LinkedHashMap<String, Class>();
		liste_commerces.put("Supermarché", Supermarche.class);
		liste_commerces.put("Piscine", Piscine.class);
		Configuration.LISTE_BATIMENTS.put("Commerce", liste_commerces);
		
		@SuppressWarnings("rawtypes")
		LinkedHashMap<String, Class> liste_utilites_publiques = new LinkedHashMap<String, Class>();
		liste_utilites_publiques.put("Mairie", Mairie.class);
		liste_utilites_publiques.put("Cabinet Médical", CabinetMedical.class);
		Configuration.LISTE_BATIMENTS.put("Utilité Publique", liste_utilites_publiques);
		
		@SuppressWarnings("rawtypes")
		LinkedHashMap<String, Class> liste_voies_de_communication = new LinkedHashMap<String, Class>();
		liste_voies_de_communication.put("Route", Route.class);
		Configuration.LISTE_BATIMENTS.put("Voies de Communication", liste_voies_de_communication);
	}
}
