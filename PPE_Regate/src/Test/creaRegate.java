package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import java.awt.*;

public class creaRegate  extends JFrame implements ActionListener{
	private Accueil fenAccueil;
	private JButton btnSave;
	private JButton btnAccueil;
	private testCoBDD bdd;
	private JPanel panCentr;
	private JPanel panNorth;
	private JPanel panSouth;
	private JLabel lblHeureDepReg;
	private JLabel lblDistance;
	private JLabel lblDateReg;
	private JTextField tfHeureDepReg;
	private JTextField tfDistance;
	private JTextField tfDateReg;
	
	public creaRegate() {
		this.setTitle("Creation de Regate");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setResizable(false);
		bdd = new testCoBDD();
		btnSave = new JButton("Save");
		btnSave.addActionListener(this);
		btnAccueil = new JButton("Accueil");
		panCentr = new JPanel();
		panNorth = new JPanel();
		panSouth = new JPanel();
		lblHeureDepReg = new JLabel("Heure de depart de la Regate");
		lblDistance = new JLabel("Distance Regate");
		lblDateReg = new JLabel("Date de la Regate");
		tfHeureDepReg = new JTextField();
		tfDistance = new JTextField();
		tfDateReg = new JTextField();
		panSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
		panNorth.setLayout(new GridLayout(3,2));
		panSouth.add(btnAccueil);
		panSouth.add(btnSave);
		panNorth.add(lblHeureDepReg);
		panNorth.add(lblDistance);
		panNorth.add(lblDateReg);
		panNorth.add(tfHeureDepReg); 
		panNorth.add(tfDistance);
		panNorth.add(tfDateReg);
		btnSave.addActionListener(this);
		btnAccueil.addActionListener(this);
		this.getContentPane().add(panSouth, "South");
		this.getContentPane().add(panNorth, "North");
		setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if(e.getSource() == btnAccueil) {
				fenAccueil = new Accueil();
				this.dispose();
				fenAccueil.setVisible(true);
			}else if(e.getSource() == btnSave) {
				bdd.connect();
				try {
					int i = testCoBDD.getSt().executeUpdate("INSERT INTO regate (heurDepReg, classement, distance, dateReg) VALUES (" + "'" + tfHeureDepReg.getText() + "', " +  "'" + tfDistance.getText() + "', " + "'" + tfDateReg.getText() + "' )" );
				}catch (SQLException e1) {
					//TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bdd.close();
				tfHeureDepReg.setText("");
				tfDistance.setText("");
				tfDateReg.setText("");
			}
			}
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		new creaRegate();
	}
	
}