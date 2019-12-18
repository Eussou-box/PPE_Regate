package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class Inscriptions extends JFrame implements ActionListener {
	private JPanel lePanel;
	private JPanel panInscri;
	private JPanel panSouth;
	private JButton btnRetour;
	private Accueil fenAccueil;
	private JLabel lblNomVoil;
	private JTextField tfNomVoil;
	private JLabel lblClasse;
	private JTextField tfClasse;
	private JLabel lblRating;
	private JTextField tfRating;
	private JLabel lblNumVoil;
	private JTextField tfNumVoil;
	private JLabel lblNomSkip;
	private JTextField tfNomSkip;
	private JButton btnSave;
//	private OuvreBDD connexion = new OuvreBDD("Database.db");
	
	public Inscriptions() {
		this.setTitle("Historique des Régates");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setResizable(false);
		lePanel = new JPanel();
		lePanel.setLayout(new BorderLayout(0,0));
		panInscri = new JPanel();
		panSouth = new JPanel();
		btnRetour = new JButton("Retour à l'Accueil");
		lblNomVoil = new JLabel("Nom du Voilier :");
		tfNomVoil = new JTextField();
		lblClasse = new JLabel("Classe :");
		tfClasse = new JTextField();
		lblRating = new JLabel("Rating :");
		tfRating = new JTextField();
		lblNumVoil = new JLabel("Numéro du Voilier :");
		tfNumVoil = new JTextField();
		lblNomSkip = new JLabel("Nom du Skipper :");
		tfNomSkip = new JTextField();
		btnSave = new JButton("Enregistrer");
		panInscri.setLayout(new GridLayout(5,2));
		panInscri.add(lblNomVoil);
		panInscri.add(tfNomVoil);
		panInscri.add(lblClasse);
		panInscri.add(tfClasse);
		panInscri.add(lblRating);
		panInscri.add(tfRating);
		panInscri.add(lblNumVoil);
		panInscri.add(tfNumVoil);
		panInscri.add(lblNomSkip);
		panInscri.add(tfNomSkip);
		btnRetour.addActionListener(this);
		panSouth.add(btnRetour);
		btnSave.addActionListener(this);
		panSouth.add(btnSave);
		lePanel.add(panInscri, BorderLayout.WEST);
		lePanel.add(panSouth, BorderLayout.SOUTH);
		this.getContentPane().add(lePanel);
		this.setVisible(true);
	}
	
//	public void addInfos() { //need help ;;
//        String query = "";
//        query += "INSERT INTO TABLE VALUES (";
//        query += "'" + tfNomVoil.getText() + "', ";
//        query += "'" + tfClasse.getText() + "', ";
//        query += "'" + tfRating.getText() + "', ";
//        query += "'" + tfNumVoil.getText() + "', ";
//        query += "'" + tfNomSkip.getText() + "' )";
//        try {
//            statement.executeUpdate(query);
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRetour) {
			fenAccueil = new Accueil();
			this.dispose();
			fenAccueil.setVisible(true);
			//tout effacer ce qui a été entré dans la bdd pour cette régate ou créer statut "annulé"
		} else if(e.getSource() == btnSave) {
//			connexion.connect();
//			this.addInfos();
//			connexion.close();
			tfNomVoil.setText("");
			tfClasse.setText("");
			tfRating.setText("");
			tfNumVoil.setText("");
			tfNomSkip.setText("");
			//enregistrer toutes les infos dans la bdd -> j'ai essayé un truc XD
		}
	}
	
	public static void main(String[] args) {
		new Inscriptions();
	}

}
