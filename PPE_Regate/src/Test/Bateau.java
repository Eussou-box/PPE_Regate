package Test;

import java.util.*;

public class Bateau {
	private int numBateau;
	private String nomBateau;
	private int classeBat; // int ou string ?
	private String timerBateau; //pas mieux de mettre en mode SimpleDateFormat("HH:mm:ss:SSSS") ?
	private int ratingBateau; //int ou string ? 
	
	public Bateau() {
		nomBateau = "";
		classeBat = 0;
		timerBateau = "";
		ratingBateau = "";
	}
	
	public Bateau(int numBa, String leBat, String timeBat) { //ajouter String rating
		numBateau = numBa;
		nomBateau = leBat;
		timerBateau = timeBat;
//		ratingBateau = rating;
	}
	
	public Bateau(String nomBa, String timerBa, int claBa, int ratBat) {
		nomBateau = nomBa;
		timerBateau = timerBa;
		classeBat = claBa;
		ratingBateau = ratBat;
	}

	public String getNomBateau() {
		return nomBateau;
	}

	public void setNomBateau(String nomBateau) {
		this.nomBateau = nomBateau;
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

	public int getClasseBat() {
		return classeBat;
	}

	public void setClasseBat(int classeBat) {
		this.classeBat = classeBat;
	}

	public int getRatingBateau() {
		return ratingBateau;
	}

	public void setRatingBateau(int ratingBateau) {
		this.ratingBateau = ratingBateau;
	}
	
	
	
}
