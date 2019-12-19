package Test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Classement extends JFrame implements ActionListener {
	private JPanel panneau;
	private JPanel panBtn;
	private JPanel panClassCat1;
	private JPanel panClassCat2;
	private JButton btnRetour;
	private Accueil fenAccueil;
	private JButton btnSave;
	private JPanel panLbl;
	private JLabel lblCat1SH;
	private JLabel lblCat1AH;
	private JLabel lblCat2SH;
	private JLabel lblCat2AH;
	private JTextArea classCat1SH;
	private JTextArea classCat1AH;
	private JTextArea classCat2SH;
	private JTextArea classCat2AH;
	
	public Classement() {
		panneau = new JPanel();
		panBtn = new JPanel();
		btnRetour = new JButton("Retour accueil");
		btnRetour.addActionListener(this);
		btnSave = new JButton("Sauvegarder document texte");
		btnSave.addActionListener(this);
		panLbl = new JPanel();
		lblCat1SH = new JLabel("Catégorie 1 - Sans Handicap");
		lblCat1AH = new JLabel("Catégorie 1 - Avec Handicap");
		lblCat2SH = new JLabel("Catégorie 2 - Sans Handicap");
		lblCat2AH = new JLabel("Catégorie 2 - Avec Handicap");
		panClassCat1 = new JPanel();
		panClassCat2 = new JPanel();
		classCat1SH = new JTextArea(20, 23);
		classCat1SH.setEditable(false);
		classCat1AH = new JTextArea(20, 25);
		classCat1AH.setEditable(false);
		classCat2SH = new JTextArea(20, 25);
		classCat2SH.setEditable(false);
		classCat2AH = new JTextArea(20, 25);
		classCat2AH.setEditable(false);
		panBtn.setLayout(new FlowLayout());
		panLbl.setLayout(new GridLayout(1, 4));
		panBtn.add(btnRetour);
		panBtn.add(btnSave);
		panLbl.add(lblCat1SH);
		panLbl.add(lblCat1AH);
		panClassCat1.add(classCat1SH);
		panClassCat1.add(classCat1AH);
		panLbl.add(lblCat2SH);
		panLbl.add(lblCat2AH);
		panClassCat2.add(classCat2SH);
		panClassCat2.add(classCat2AH);
		panneau.setLayout(new BorderLayout(0,0));
		panneau.add(panBtn, BorderLayout.SOUTH);
		panneau.add(panClassCat1, BorderLayout.WEST);
		panneau.add(panClassCat2, BorderLayout.EAST);
		panneau.add(panLbl, BorderLayout.NORTH);
		this.setTitle("Classement");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 500);
		this.setResizable(false);
		this.setVisible(true);
		this.getContentPane().add(panneau);
	}
	
	public void actionPerformed(ActionEvent e) { 
		if(e.getSource() == btnRetour) {
			this.dispose();
			fenAccueil = new Accueil();
			fenAccueil.setVisible(true);
		} else if(e.getSource() == btnSave) {
			// same pour save dans un doc ?
		}
	}
	
//	public String calculTempsCompose(Bateau b) {
//		int r = b.getRatingBateau; 
//		String tpsCompo = ""; //dunno the type
//		long calcultps = null;
//		double handicap = 5143 / (Math.sqrt(r) + 3,5) * distance; //voir où et comment ajouter la distance
//		calcultps = b.getTimerBateau + handicap;
//		return tpsCompo; //need le tp datetime pour tout convertir
//	}
//	
//	public void remplirClassement() { //need some getters and setters dans Régate, pas osé toucher
//		String class1 = "";
//		String class1Compo = "";
//		String class2 = "";
//		String class2Compo = "";
//		int i = 0;
//		for(Bateau b : Regate.getLesVoiliers) {
//			i++;
//			if(b.getClasseBat() == 1) {
//				class1 += i + ". " + b.getNomBateau() + " - " + b.getTimerBateau() + "\n";
//				class1Compo += i + ". " + b.getNomBateau() + " - " + calculTempsCompose(b) + "\n";
//				//prendre en compte le changement d'ordre grace au handicap
//			} else if(b.getClasseBat() == 2) {
//				class2 += i + ". " + b.getNomBateau() + " - " + b.getTimerBateau() + "\n";
//				class2Compo += i + ". " + b.getNomBateau() + " - " + calculTempsCompose(b) + "\n";
//				//prendre en compte le changement d'ordre grace au handicap
//			}
//		}
//		classCat1SH.setText(class1);
//		classCat1AH.setText(class1Compo);
//		classCat2SH.setText(class2);
//		classCat2AH.setText(class2Compo);
//	} //dunno si faire 2 méthodes pour remplir classement AH et SH ou juste une (i guess 1 plus opti
	// avec 1 methode juste pour faire le calcul du temps compense
	
	public static void main(String[] args) {
		new Classement();
	}


}
