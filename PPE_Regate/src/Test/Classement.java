package Test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Classement extends JFrame implements ActionListener {
	private JPanel panneau;
	private JPanel panBtn;
	private JPanel panClass;
	private JButton btnRetour;
	private Accueil fenAccueil;
	private JButton btnImprPdf;
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
		btnImprPdf = new JButton("Imprimer en PDF");
		btnImprPdf.addActionListener(this);
		btnSave = new JButton("Sauvegarder le PDF");
		btnSave.addActionListener(this);
		panLbl = new JPanel();
		lblCat1SH = new JLabel("Catégorie 1 - Sans Handicap");
		lblCat1AH = new JLabel("Catégorie 1 - Avec Handicap");
		lblCat2SH = new JLabel("Catégorie 2 - Sans Handicap");
		lblCat2AH = new JLabel("Catégorie 2 - Avec Handicap");
		panClass = new JPanel();
		classCat1SH = new JTextArea(20, 10);
		classCat1SH.setEditable(false);
		classCat1AH = new JTextArea(20, 10);
		classCat1AH.setEditable(false);
		classCat2SH = new JTextArea(20, 10);
		classCat2SH.setEditable(false);
		classCat2AH = new JTextArea(20, 10);
		classCat2AH.setEditable(false);
		panBtn.setLayout(new FlowLayout());
		panLbl.setLayout(new FlowLayout());
		panBtn.add(btnRetour);
		panBtn.add(btnImprPdf);
		panBtn.add(btnSave);
		panLbl.add(lblCat1SH);
		panLbl.add(lblCat1AH);
		panClass.add(classCat1SH);
		panClass.add(classCat1AH);
		panLbl.add(lblCat2SH);
		panLbl.add(lblCat2AH);
		panClass.add(classCat2SH);
		panClass.add(classCat1AH);
		panneau.setLayout(new BorderLayout(0,0));
		panneau.add(panBtn, BorderLayout.SOUTH);
		panneau.add(panClass, BorderLayout.CENTER);
		panneau.add(panLbl, BorderLayout.NORTH);
		this.setTitle("Classement");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 500);
		this.setResizable(false);
		this.setVisible(true);
		this.getContentPane().add(panneau);
	}
	
	public void actionPerformed(ActionEvent e) { 
		if(e.getSource() == btnRetour) {
			this.dispose();
			fenAccueil = new Accueil();
			fenAccueil.setVisible(true);
		} else if(e.getSource() == btnImprPdf) {
			
		} else if(e.getSource() == btnSave) {
			
		}
	}
	
	public static void main(String[] args) {
		new Classement();
		
	}


}
