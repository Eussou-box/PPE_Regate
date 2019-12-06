package Test;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class Inscriptions extends JFrame implements ActionListener {
	private JPanel panInscri;
	private JButton btnRetour;
	private Accueil fenAccueil;
	
	public Inscriptions() {
		panInscri = new JPanel();
		btnRetour = new JButton("Retour à l'Accueil");
		
	}

}
