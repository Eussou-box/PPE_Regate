package Test;

import javax.swing.*;

import java.awt.*;

public class Classement extends JFrame {
	private JPanel panneau;
	private JPanel panBtn;
	private JButton btnSave;
	private JButton btnImpr;
	private JButton btnRetour;
	
	public Classement() {
		panneau = new JPanel();
		panBtn = new JPanel();
		btnSave = new JButton("Save");
		btnImpr = new JButton("Imprimer");
		btnRetour = new JButton("Retour accueil");
		panBtn.setLayout(new FlowLayout());
		panBtn.add(btnSave);
		panBtn.add(btnImpr);
		panBtn.add(btnRetour);
		panneau.setLayout(new BorderLayout(0,0));
		panneau.add(panBtn, BorderLayout.SOUTH);
		this.setTitle("Classement");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setResizable(false);
		this.setVisible(true);
		this.getContentPane().add(panneau);
	}
	
	public static void main(String[] args) {
		new Classement();
		
	}
}
