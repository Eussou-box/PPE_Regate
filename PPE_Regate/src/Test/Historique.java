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
//	private JTextField tfSearch;
//	private JButton btnSearch;
	// peut etre ajouter un truc de recherche des anciens classements de regate ? (selon date, skipper, etc ?)
	// ou juste marquer un historique des dernières régates qui ont eu lieu ?
	
	public Historique() {
		this.setTitle("Historique des Régates");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setResizable(false);
		panHisto = new JPanel();
		btnRetour = new JButton("Retour à l'Accueil");
		btnRetour.addActionListener(this);
//		tfSearch = new JTextField();
//		btnSearch = new JButton("Rechercher une régate");
//		btnSearch.addActionListener(this);
		panHisto.add(btnRetour);
//		panHisto.add(tfSearch);
//		panHisto.add(btnSearch);
		this.getContentPane().add(panHisto, "Center");
		this.setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRetour) {
			fenAccueil = new Accueil();
			this.dispose();
			fenAccueil.setVisible(true);
//		} else if(e.getSource() == btnSearch) {
//			tfSearch.setText("");
		}
		
	}
	
	public static void main(String[] args) {
		new Historique();
	}

}
