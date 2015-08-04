package com.citymanager3000.src;

import com.citymanager3000.types.Dimension3D;
import com.citymanager3000.types.Position;


/**
 * @author Yann Bertrand
 *
 */
public abstract class Batiment {
	private final String TYPE;
	private final String NOM;
	
	private final Position POSITION;
	private Dimension3D dimension;

	private final double PRIX_CONSTRUCTION;
	private double benefice_par_mois;
	private boolean is_amelioration_possible;
	private double prix_amelioration;
	private double prix_destruction;
	
	private String image_path;
	
	private boolean unique=false;
	private boolean already_laid=false;
	
	/*
	 * Constructeur avec paramètres :
	 * @param prixConstruction the prixConstruction to set, 
	 * @param prixAmelioration the prixAmelioration to set, 
	 * @param prixDestruction the prixDestruction to set, 
	 * @param position the position to set,  
	 * @param image the image to set
	 */
	public Batiment(String type,
					String nom,
					Position position, 
					Dimension3D dimension,
					double prix_construction, 
					double benefice_par_mois, 
					double prix_amelioration, 
					double prix_destruction, 
					String image_path) {
		this.TYPE=type;
		this.NOM=nom;
		//if(Configuration.TYPES_BATIMENT.contains(type)) { this.type=type; }
		
		this.POSITION=position;
		this.setDimension(dimension);
		
		this.PRIX_CONSTRUCTION=prix_construction;
		this.setBeneficeParMois(benefice_par_mois);
		this.setPrixAmelioration(prix_amelioration);
		this.setIsAmeliorationPossible((prix_amelioration <= 0)? false : true);
		this.setPrixDestruction(prix_destruction);
		
		this.setImagePath(image_path);
	}


	/**
	 * @return the type of batiment
	 */
	public String getType() {
		return TYPE;
	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return NOM;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return POSITION;
	}


	/**
	 * @return the construction price
	 */
	public double getPrixConstruction() {
		return PRIX_CONSTRUCTION;
	}


	/**
	 * @return the dimension
	 */
	public Dimension3D getDimension() {
		return dimension;
	}


	/**
	 * @param dimension the dimension to set
	 */
	private void setDimension(Dimension3D dimension) {
		this.dimension = dimension;
	}

	/**
	 * @param benefice_par_mois2
	 */
	private void setBeneficeParMois(double benefice_par_mois) {
		this.benefice_par_mois = benefice_par_mois;
	}

	/**
	 * @param benefice_par_mois the benefice_par_mois to set
	 */
	public double getBeneficeParMois() {
		return benefice_par_mois;
	}

	/**
	 * @return the is_amelioration_possible
	 */
	public boolean isAmeliorationPossible() {
		return is_amelioration_possible;
	}

	/**
	 * @param is_amelioration_possible the is_amelioration_possible to set
	 */
	protected void setIsAmeliorationPossible(boolean is_amelioration_possible) {
		this.is_amelioration_possible = is_amelioration_possible;
	}
	
	/**
	 * @return the prix_amelioration
	 */
	public double getPrixAmelioration() {
		return prix_amelioration;
	}


	/**
	 * @param prix_amelioration the prix_amelioration to set
	 */
	protected void setPrixAmelioration(double prix_amelioration) {
		this.prix_amelioration = prix_amelioration;
	}


	/**
	 * @return the prix_destruction
	 */
	public double getPrixDestruction() {
		return prix_destruction;
	}


	/**
	 * @param prix_destruction the prix_destruction to set
	 */
	protected void setPrixDestruction(double prix_destruction) {
		this.prix_destruction = prix_destruction;
	}


	/**
	 * @param image_path the image_path to set
	 */
	protected void setImagePath(String image_path) {
		this.image_path = image_path;
	}


	/**
	 * @return the image
	 */
	public String getImagePath() {
		return image_path;
	}
	
	public String toString() {
		String to_string; String new_line = System.getProperty("line.separator");
		to_string  = NOM+new_line;
		to_string += "$"+PRIX_CONSTRUCTION+new_line;
		return to_string;
	}


	/**
	 * @return if unique
	 */
	public boolean isUnique() { return unique; }

	protected void setUnique(boolean unique) {
		this.unique = unique;
	}

	/**
	 * @return if already laid
	 */
	public boolean isAlreadyLaid() { return already_laid; }


	/**
	 * @param
	 */
	public void setAlreadyLaid() { already_laid=true; }
}
