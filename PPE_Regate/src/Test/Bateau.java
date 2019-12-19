package Test;

import java.util.*;

public class Bateau {
	private int numBateau;
	private String nomBateau;
	private String classeBat; // int ou string ?
	private String timerBateau; //pas mieux de mettre en mode SimpleDateFormat("HH:mm:ss:SSSS") ?
//	private String ratingBateau; //int ou string ? 
	
	public Bateau() {
		nomBateau = "";
		classeBat = 0;
		timerBateau = "";
//		ratingBateau = "";
	}
	
	public Bateau(int numBa, String leBat, String timeBat) { //ajouter String rating
		numBateau = numBa;
		nomBateau = leBat;
		timerBateau = timeBat;
//		ratingBateau = rating;
	}

	public String getNomBateau() {
		return nomBateau;
	}

	public void setNomBateau(String nomBateau) {
		this.nomBateau = nomBateau;
	}

	public String getClasseBat() {
		return classeBat;
	}

	public void setClasseBat(String classeBat) {
		this.classeBat = classeBat;
	}

	public String getTimerBateau() {
		return timerBateau;
	}

	public void setTimerBateau(String timerBateau) {
		this.timerBateau = timerBateau;
	}

	public int getNumBateau() {
		return numBateau;
	}

	public void setNumBateau(int numBateau) {
		this.numBateau = numBateau;
	}
	
//	public String getRatingBateau() {
//		return ratingBateau;	
//	}
//	
//	public void setRatingBateau(String ratingBateau) {
//		this.ratingBateau = ratingBateau;
//	}
	
}
