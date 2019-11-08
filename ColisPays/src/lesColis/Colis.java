package lesColis;

public class Colis {
	private double longueur;
	private double largeur;
	private double profondeur;
	private int poids;
	private int typeRecommande;
	
	public Colis() {
		this.longueur = 0.0;
		this.largeur = 0.0;
		this.profondeur = 0.0;
		this.poids = 0;
		this.typeRecommande = 0;
	}
	
	public Colis(double longueur, double largeur, double profondeur, int poids, int type) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.profondeur = profondeur;
		this.poids = poids;
		this.typeRecommande = type;
	}
	
	public double volume() {
		return this.largeur * this.longueur * this.profondeur;
	}
	
	public double densité() {
		return poids / volume();
	}
	
	public boolean estValide() {
		double taille = longueur + largeur + profondeur;
		if (taille <= 1.5 && longueur <= 1){
			return true;
		}else{
			return false;
		}	
	}
	
	//public double coutAffranchissement(Colis colis){
		//if(colis.estValide() == true){
			
		//}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public double getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(double profondeur) {
		this.profondeur = profondeur;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public int getTypeRecommande() {
		return typeRecommande;
	}

	public void setTypeRecommande(int typeRecommande) {
		this.typeRecommande = typeRecommande;
	}
	
}

