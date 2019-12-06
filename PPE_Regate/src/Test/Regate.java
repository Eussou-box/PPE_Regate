package Test;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Regate extends JFrame implements ActionListener {
	private JPanel panFirst;
	private JButton btnRetour;
	private JButton leBtn;
	private Accueil fenAccueil;
	private ArrayList<Bateau> lesVoiliers;
	
	public Regate() {
		this.setTitle("Régate");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setResizable(false);
		panFirst = new JPanel();
		lesVoiliers = new ArrayList<Bateau>();
		addVoiliers();
		for(Bateau rs : lesVoiliers) {
			leBtn = new JButton(rs.getNomBateau());
			panFirst.add(leBtn);
		}
		btnRetour = new JButton("Retour à l'Accueil");
		btnRetour.addActionListener(this);
		panFirst.add(btnRetour);
		this.getContentPane().add(panFirst, "Center");
		this.setVisible(true);
	}
	
	public void addVoiliers() {
		lesVoiliers.add(new Bateau("Les Joyeux Coquins","1"));
		lesVoiliers.add(new Bateau("Le paquebotte","1"));
		lesVoiliers.add(new Bateau("Les SIO Skippers","1"));
		lesVoiliers.add(new Bateau("Fnatic Voilier","1"));
		lesVoiliers.add(new Bateau("SEND NUDES","1"));
		lesVoiliers.add(new Bateau("Les Lolis For Ever","1"));
		lesVoiliers.add(new Bateau("Nan mais Allo quoi","1"));
		lesVoiliers.add(new Bateau("I'm wet","1"));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRetour) {
			fenAccueil = new Accueil();
			this.dispose();
			fenAccueil.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new Regate();
	}

}
