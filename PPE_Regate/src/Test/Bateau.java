package Test;

import java.util.*;

public class Bateau {
	private String nomBateau;
	private String classeBat;
	private String timerBateau;
	
	public Bateau() {
		nomBateau = "";
		classeBat = "";
		timerBateau = "";
	}
	
	public Bateau(String leBat, String leType, String timeBat) {
		nomBateau = leBat;
		classeBat = leType;
		timerBateau = timeBat;
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
	
	
}
