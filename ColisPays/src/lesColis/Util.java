package lesColis;

import java.util.*;

public class Util {
	private ArrayList<TarifColis> mesTarifsColis;
	private ArrayList<Double> lesRecommandations;
	final double longueurMax;
	final double sommeDesLongMax;
	
	public Util() {
		mesTarifsColis = new ArrayList<>();
		lesRecommandations = new ArrayList<>();
		this.longueurMax = 1.0;
		this.sommeDesLongMax = 1.5;
	}
	
	public void ajouteTarif(int poidsMax, double prix) {
		mesTarifsColis.add(new TarifColis(poidsMax, prix));
	}
	public void ajouteRecom(Double recomm) {
		lesRecommandations.add(recomm);
	}
	public void initTarifs() {
		ajouteTarif(250,5.50);
		ajouteTarif(500,6.10);
		ajouteTarif(750,6.90);
		ajouteTarif(1000,7.50);
		ajouteTarif(2000,8.50);
		ajouteTarif(3000,9.70);
		ajouteTarif(5000,11.90);
		ajouteTarif(7000,14.10);
		ajouteTarif(10000,17.40);
		ajouteTarif(15000,20.15);
		ajouteTarif(20000,28.35);
	}
	public void afficheTarif() {
		System.out.println("Poids" + " \t" + "Prix");
		for(TarifColis tf : mesTarifsColis) {
			System.out.println(tf.getPoidsMax() + "g" + "\t" + tf.getPrix() + "€");
		}
	}
	public void initRecomm() {
		ajouteRecom(2.50);
		ajouteRecom(3.40);
		ajouteRecom(4.60);
		ajouteRecom(5.80);
		ajouteRecom(7.00);
	}
	public void afficheRecomm() {
		int i = 0;
		System.out.println("Types" + " \t " + "Supplèment");
		for(Double d : lesRecommandations) {
			i++;
			System.out.println("  " + i + " \t    " + d + "€");
		}
	}
	public double calcPrixBase(int poidsEnGr) {
		double d = 0.0;
		int i = 0;
		for(TarifColis tc : mesTarifsColis) {
			if(poidsEnGr >= mesTarifsColis.get(i).getPoidsMax() && poidsEnGr < mesTarifsColis.get(i + 1).getPoidsMax()) {
				d = tc.getPrix();
			}
		i++;
		}
	return d;
	}
	public ArrayList<TarifColis> getMesTarifsColis() {
		return mesTarifsColis;
	}
	public void setMesTarifsColis(ArrayList<TarifColis> mesTarifsColis) {
		this.mesTarifsColis = mesTarifsColis;
	}
	public ArrayList<Double> getLesRecommandations() {
		return lesRecommandations;
	}
	public void setLesRecommandations(ArrayList<Double> lesRecommandations) {
		this.lesRecommandations = lesRecommandations;
	}
	public double getLongueurMax() {
		return longueurMax;
	}
	public double getSommeDesLongMax() {
		return sommeDesLongMax;
	}
	
}
