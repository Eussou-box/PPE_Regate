package Test;

import java.util.*;

public class Bateau {
	private String nomBateau;
	private String classeBat;
	private ArrayList<String> lesBateaux;
	
	public Bateau() {
		lesBateaux = new ArrayList<String>();
		nomBateau = "";
		classeBat = "";
	}
	
	public Bateau(String leBat, String leType) {
		nomBateau = leBat;
		classeBat = leType;
	}
	
	public void ajouteBateaux() {
		lesBateaux.
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
	
	
}
