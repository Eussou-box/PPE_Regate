package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class Historique extends JFrame implements ActionListener {
	private JPanel panHisto;
	private JButton btnRetour;
	private Accueil fenAccueil;
	
	public Historique() {
		this.setTitle("Historique des Régates");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,500);
		this.setResizable(false);
		panHisto = new JPanel();
		btnRetour = new JButton("Retour à l'Accueil");
		btnRetour.addActionListener(this);
		panHisto.add(btnRetour);
		this.getContentPane().add(panHisto, "Center");
		this.setVisible(true);
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
		new Historique();
	}

}
