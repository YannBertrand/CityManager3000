package com.citymanager3000.src;


/**
 * @author Yann
 *
 */
public abstract class VoieDeCommunication {
	protected String type;
	protected double prixConstruction;
	protected double prixAmelioration;
	protected double prixDestruction;
	protected int positionDebut[]=new int[2];
	protected int positionFin[]=new int[2];
	protected String image;
	protected final String messageCreation;
	
	/*
	 * Début Constructeurs
	 */
	
	/*
	 * Constructeur avec paramètres :
	 * @param prixConstruction the prixConstruction to set, 
	 * @param prixAmelioration the prixAmelioration to set, 
	 * @param prixDestruction the prixDestruction to set, 
	 * @param position the position to set,  
	 * @param image the image to set
	 */
	public VoieDeCommunication(String type,
					double prixConstruction, 
					double prixAmelioration, 
					double prixDestruction, 
					int[] positionDebut, 
					int[] positionFin, 
					String image,
					String messageCreation) {
		if(prixConstruction < 0) { throw new IllegalArgumentException("Le prix de construction est négatif."); }
		if(prixAmelioration < 0) { throw new IllegalArgumentException("Le prix d'amélioration est négatif."); }
		if(prixDestruction < 0) { throw new IllegalArgumentException("Le prix de destruction est négatif."); }
		
		if(Configuration.TYPES_VOIE_DE_COMMUNICATION.contains(type)) { this.type=type; }
		else { throw new IllegalArgumentException("Ce type de voie de communication est innexistant."); }
		
		this.setPrixConstruction(prixConstruction);
		this.setPrixAmelioration(prixAmelioration); 
		this.setPrixDestruction(prixDestruction);
		
		this.setPositionDebut(positionDebut);
		this.setPositionFin(positionFin);
		this.setImage(image);
		
		this.messageCreation=messageCreation;
		if(Configuration.MODE=="debug") { System.out.println(this.messageCreation); }
	}

	/*
	 * Fin Constructeurs
	 * Début Destructeur
	 */
	
	/*
	 * Destructeur
	 */
	public void finalize() {
		//Detruire image
	}
	
	/*
	 * Fin Destructeur
	 * Début Accesseurs et mutateurs
	 */
	
	/**
	 * @return the prixConstruction
	 */
 	public double getPrixConstruction() {
		return prixConstruction;
	}
	/**
	 * @param prixConstruction the prixConstruction to set
	 */
	public void setPrixConstruction(double prixConstruction) {
		this.prixConstruction = prixConstruction;
	}

	/**
	 * @return the prixAmelioration
	 */
	public double getPrixAmelioration() {
		return prixAmelioration;
	}
	/**
	 * @param prixAmelioration the prixAmelioration to set
	 */
	public void setPrixAmelioration(double prixAmelioration) {
		this.prixAmelioration = prixAmelioration;
	}

	/**
	 * @return the prixDestruction
	 */
	public double getPrixDestruction() {
		return prixDestruction;
	}
	/**
	 * @param prixDestruction the prixDestruction to set
	 */
	public void setPrixDestruction(double prixDestruction) {
		this.prixDestruction = prixDestruction;
	}

	/**
	 * @return the positionDebut
	 */
	public int[] getPositionDebut() {
		return positionDebut;
	}
	/**
	 * @param positionDebut the positionDebut to set
	 */
	public void setPositionDebut(int[] positionDebut) {
		this.positionDebut = positionDebut;
	}
	
	/**
	 * @return the positionFin
	 */
	public int[] getPositionFin() {
		return positionFin;
	}
	/**
	 * @param positionFin the positionFin to set
	 */
	public void setPositionFin(int[] positionFin) {
		this.positionFin = positionFin;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	/*
	 * Fin Accesseurs et mutateurs
	 */
}
