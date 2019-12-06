package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class Inscriptions extends JFrame implements ActionListener {
	private JPanel panInscri;
	private JButton btnRetour;
	private Accueil fenAccueil;
	
	public Inscriptions() {
		this.setTitle("Historique des Régates");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setResizable(false);
		panInscri = new JPanel();
		btnRetour = new JButton("Retour à l'Accueil");
		btnRetour.addActionListener(this);
		panInscri.add(btnRetour);
		panInscri.add(btnRetour);
		this.getContentPane().add(panInscri, "Center");
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRetour) {
			if(e.getSource() == btnRetour) {
				fenAccueil = new Accueil();
				this.dispose();
				fenAccueil.setVisible(true);
			}
		}
		
	}

}
