package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

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
	private testCoBDD bdd; //ceci est un test
//	private OuvreBDD connexion = new OuvreBDD("Database.db");
	
	public Inscriptions() {
		this.setTitle("Historique des R�gates");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setResizable(false);
		bdd = new testCoBDD(); //co bdd instanci�
		lePanel = new JPanel();
		lePanel.setLayout(new BorderLayout(0,0));
		panInscri = new JPanel();
		panSouth = new JPanel();
		btnRetour = new JButton("Retour � l'Accueil");
		lblNomVoil = new JLabel("Nom du Voilier :");
		tfNomVoil = new JTextField();
		lblClasse = new JLabel("Classe :");
		tfClasse = new JTextField();
		lblRating = new JLabel("Rating :");
		tfRating = new JTextField();
		lblNumVoil = new JLabel("Num�ro du Voilier :");
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
	
	public String addInfos() { //need help ;;
        String query = "";
        query += "INSERT INTO bateau (";
        query += "nomBateau, ratingBateau, nomSkipper, classeBateau, numVoilier)";
        query += " Values (";
        query += "'" + tfNomVoil.getText() + "', ";
        query += "'" + tfRating.getText() + "', ";
        query += "'" + tfNomSkip.getText() + "', ";
        query += "'" + tfClasse.getText() + "', ";
        query += "'" + tfNumVoil.getText() + "' )";// des deux pour test
//        try {
//           int i = statement.executeUpdate(query);
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        return query;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRetour) {
			fenAccueil = new Accueil();
			this.dispose();
			fenAccueil.setVisible(true);
			//tout effacer ce qui a �t� entr� dans la bdd pour cette r�gate ou cr�er statut "annul�"
		} else if(e.getSource() == btnSave) {
			bdd.connect();
			try {
				int i = testCoBDD.getSt().executeUpdate(addInfos());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			bdd.close();
			tfNomVoil.setText("");
			tfClasse.setText("");
			tfRating.setText("");
			tfNumVoil.setText("");
			tfNomSkip.setText("");
			//enregistrer toutes les infos dans la bdd -> tester tout ce bordel
		}
	}
	
	public static void main(String[] args) {
		new Inscriptions();
	}

}
