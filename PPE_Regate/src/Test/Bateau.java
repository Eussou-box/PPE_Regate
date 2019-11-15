package Test;

import java.util.*;

public class Bateau {
	private String nomBateau;
	private String classeBat;
	
	public Bateau() {
		nomBateau = "";
		classeBat = "";
	}
	
	public Bateau(String leBat, String leType) {
		nomBateau = leBat;
		classeBat = leType;
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
