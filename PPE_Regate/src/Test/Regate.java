package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Regate extends JFrame implements ActionListener {
	private JPanel panFirst;
	private JButton btnRetour;
	private Accueil fenAccueil;
	
	public Regate() {
		this.setTitle("Régate");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setResizable(false);
		panFirst = new JPanel();
		btnRetour = new JButton("Retour à l'accueil");
		btnRetour.addActionListener(this);
		panFirst.add(btnRetour);
		this.getContentPane().add(panFirst, "Center");
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //
		if(e.getSource() == btnRetour) {
			fenAccueil = new Accueil();
			this.dispose();
			fenAccueil.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new Regate();
	}

}
