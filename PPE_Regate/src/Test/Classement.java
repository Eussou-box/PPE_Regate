package Test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Classement extends JFrame implements ActionListener {
	private JPanel panneau;
	private JPanel panBtn;
	private JPanel panClassCat1;
	private JPanel panClassCat2;
	private JButton btnRetour;
	private Accueil fenAccueil;
	private JPanel panLbl;
	private JLabel lblCat1SH;
	private JLabel lblCat1AH;
	private JLabel lblCat2SH;
	private JLabel lblCat2AH;
	private JTextArea classCat1SH;
	private JTextArea classCat1AH;
	private JTextArea classCat2SH;
	private JTextArea classCat2AH;
	private testCoBDD bdd;
	
	public Classement() {
		// Paramètres de base fenêtre
		this.setTitle("Classement");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 500);
		this.setResizable(false);
		// Création des composants
		bdd = new testCoBDD();
		panneau = new JPanel();
		panBtn = new JPanel();
		btnRetour = new JButton("Retour accueil");
		btnRetour.addActionListener(this);
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
		// Ajout des composants dans leurs panels respectifs
		panBtn.setLayout(new FlowLayout());
		panLbl.setLayout(new GridLayout(1, 4));
		panBtn.add(btnRetour);
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
		this.getContentPane().add(panneau);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) { 
		if(e.getSource() == btnRetour) {
			this.dispose();
			fenAccueil = new Accueil();
			fenAccueil.setVisible(true);
		}
	}
	
	public void calculTempsCompose() throws SQLException, ParseException {
		double distance = 0.0;
		int totalSec= 0;
		String tpsCompo = "";
		int r = 0; 
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		// on obtient la distance
		bdd.connect();
		ResultSet rs = testCoBDD.getSt().executeQuery("SELECT distance FROM Regate WHERE idRegate = "); //?????
		while (rs.next()) {
			distance = rs.getInt("distance");
		}
		
		//on prélève le tempsBateau et son rating
		ResultSet rs2 = testCoBDD.getSt().executeQuery("SELECT tempsBateau, ratingBateau FROM Bateau WHERE idRegate = ");
		while (rs2.next()) {
			// on fait le calcul pour avoir le temps composé
			r = rs2.getInt("ratingBateau");
			double handicap = 5143 / (Math.sqrt(r) + 3.5) * distance;
			Date tpsSec = sdf.parse(rs2.getString("tempsBateau"));
			long tpsSec2 = tpsSec.getTime() / (24 * 60 * 60); // ou juste 60 * 60 ??
			totalSec = (int) (tpsSec2 + handicap);
			int h = totalSec / 3600;
			int min = (totalSec % 3600) / 60;
			int sec = (totalSec % 3600) % 60;
			tpsCompo = h + ":" + min + ":" + sec;
			
			// on ajoute le résultat obtenu dans la bdd
			ResultSet rs3 = testCoBDD.getSt().executeQuery("UPDATE Participe tempsCompose SET tempsCompose = " + tpsCompo);
		}
		bdd.close();
	}
	
	public void remplirClassement(int classe) throws SQLException { //need some getters and setters dans Régate, pas osé toucher
		String classementSH = "";
		String classementAH = "";
		int place = 0;
		
		//on crée la requête SQL permattant de récupérer les données qui nous intéressent
		String query = "";
		query += "SELECT B.nomBateau, B.timerBateau P.tempsCompense FROM Bateau B ";
		query += "INNER JOIN Participe P ON B.numVoilier = P.numVoilier";
		query += "WHERE B.classeBateau = " + classe + " ";
		query += "AND P.idRegate = "; //?????
		query += "ORDER BY B.timerBateau";
		
		//on prélève les données nécessaires dans la bdd
		bdd.connect();
		ResultSet rs = testCoBDD.getSt().executeQuery(query);
		while (rs.next()) {
			place++;
			classementSH += place + ". " + rs.getString("B.nomBateau") + " - " + rs.getString("B.timerBateau");
			classementAH += place + ". " + rs.getString("B.nomBateau") + " - " + rs.getString("P.tempsCompense");
		}
		bdd.close();
		
		//on remplit les différents classements avec les données récupérées
		if(classe == 1) {
			classCat1SH.setText(classementSH);
			classCat1AH.setText(classementAH);
		} else if(classe == 2) {
			classCat2SH.setText(classementSH);
			classCat2AH.setText(classementAH);
		}
	}
	
	public static void main(String[] args) throws SQLException, ParseException {
		new Classement();
//		calculTempsCompose();
//		remplirClassement(1);
//		remplirClassement(2); // pb static + regarder pour idRegate et fini normalement
	}


}
