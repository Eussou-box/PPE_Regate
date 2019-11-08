package lesColis;

public class TarifColis {
	private int poidsMax;
	private double prix;
	
	public TarifColis() {
		this.poidsMax = 0;
		this.prix = 0.0;
	}
	
	public TarifColis(int poidsMax, double prix) {
		this.poidsMax = poidsMax;
		this.prix = prix;
	}

	public int getPoidsMax() {
		return poidsMax;
	}

	public void setPoidsMax(int poidsMax) {
		this.poidsMax = poidsMax;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
}
