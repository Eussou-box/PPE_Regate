package Test;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Accueil extends JFrame implements ActionListener {
	private JPanel panNord;
	private JPanel panMid;
	private JPanel panSud;
	private JButton btnInscri;
	private JButton btnLancer;
	private JButton btnQuit;
	private JButton btnHisto;
	private JLabel lblAccueil;
	
	public Accueil() {
		this.setTitle("Accueil");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setResizable(false);
		panNord = new JPanel();
		panMid = new JPanel();
		panSud = new JPanel();
		btnInscri = new JButton("Inscriptions");
		btnLancer = new JButton("Lancer la Régate");
		btnQuit = new JButton("Quitter");
		btnHisto = new JButton("Historique");
		lblAccueil = new JLabel("Bienvenue");
		btnInscri.addActionListener(this);
		panMid.add(btnInscri);
		btnLancer.addActionListener(this);
		panMid.add(btnLancer);
		btnQuit.addActionListener(this);
		panSud.add(btnQuit);
		btnHisto.addActionListener(this);
		panSud.add(btnHisto);
		panNord.add(lblAccueil);
		this.getContentPane().add(panNord, "North");
		this.getContentPane().add(panMid, "Center");
		this.getContentPane().add(panSud, "South");
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnInscri) {
			
		} else if(e.getSource() == btnLancer) {
			
		} else if(e.getSource() == btnQuit) {
			
		} else if(e.getSource() == btnHisto) {
			
		}
		
	}
	
	public static void main(String[] args) {
		new Accueil();
	}




}
