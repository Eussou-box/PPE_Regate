package Test;

import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Regate extends JFrame implements ActionListener {
	private JPanel panFirst;
	private JPanel panBtn;
	private JPanel panChrono;
	private JPanel panBtnChrono;
	private JButton btnRetour;
	private JButton leBtn;
	private JButton btnStart;
	private JButton btnPause;
	private JButton btnResume;
	private JButton btnStop;
	private JLabel lblChrono;
	private JLabel lblTop;
	private JTextField tfArrive;
	private Accueil fenAccueil;
	private ArrayList<String> lesVoiliers;
	private Font lblFont1;
	private Timer time;
	private TimerTask task;
	private int seconde;
	private int minute;
	private int heure;
	private DecimalFormat df;
	private testCoBDD bdd;
	
	public Regate() throws SQLException {
		this.setTitle("Régate");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700,700);
		this.setResizable(false);
		time = new Timer();
		df = new DecimalFormat("00");
		bdd = new testCoBDD(); 
		// instanciation composant graphique
		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		btnPause = new JButton("Pause Chrono");
		btnPause.addActionListener(this);
		btnResume = new JButton("Relancer le Chrono");
		btnResume.addActionListener(this);
		btnStop = new JButton("Stop");
		btnStop.addActionListener(this);
		btnRetour = new JButton("Retour à l'Accueil");
		btnRetour.addActionListener(this);
		lblChrono = new JLabel();
		lblTop = new JLabel("Bienvenue sur la page de gestion de la régate");
		lblFont1 = new Font("Arial", Font.BOLD, 20);
		panBtnChrono = new JPanel(new GridLayout(2,2));
		panChrono = new JPanel();
		panFirst = new JPanel();
		panBtn = new JPanel();
		// -----------------------------
		// Mise en place composant graphique
		lblTop.setFont(lblFont1);
		lblChrono.setFont(lblFont1);
		lblTop.setHorizontalAlignment(JLabel.CENTER);
		panBtnChrono.add(btnStart);
		panBtnChrono.add(btnStop);
		panBtnChrono.add(btnPause);
		panBtnChrono.add(btnResume);
		panChrono.setLayout(new BorderLayout());
		panChrono.add(lblChrono, BorderLayout.CENTER);
		panChrono.add(panBtnChrono, BorderLayout.SOUTH);
		panFirst.setLayout(new BorderLayout());
		// -----------------------------
		// Boucle création bouton
		lesVoiliers = new ArrayList<String>();
		addVoiliers();
		panBtn.setLayout(new GridLayout(lesVoiliers.size(),2));
		for(String rs : lesVoiliers) {
			leBtn = new JButton(rs.toString());
			panBtn.add(leBtn);
		}
		// -----------------------------
		panFirst.add(panBtn, BorderLayout.WEST);
		panFirst.add(panChrono, BorderLayout.EAST);
		panFirst.add(lblTop, BorderLayout.NORTH);
		this.getContentPane().add(panFirst);
		this.setVisible(true);
	}
	
	public void addVoiliers() throws SQLException { // ajout numVoilier de la bdd dans l'arrayList
		bdd.connect();
		ResultSet rs = testCoBDD.getSt().executeQuery("SELECT * from bateau");
		while (rs.next()) {
		lesVoiliers.add(rs.getString("numVoilier"));
		}
		bdd.close();
	}

	public void chrono() { // code du chrono
		seconde++;
		if(seconde == 60) {
			seconde = 0;
			minute++;
		}
		if(minute == 60) {
			minute = 0;
			heure++;
		}
	}
	
	public String timerEnHMS() { // conversion chrono en String
		String leTemps = "";
		if(heure > 0) {
			leTemps += df.format(heure) + " h ";
		} else {
			leTemps += "00 h ";
		}
		
		if(minute > 0) {
			leTemps += df.format(minute) + " min ";
		} else {
			leTemps += " 00 min ";
		}
		
		if(seconde > 0) {
			leTemps += df.format(seconde) + " sec ";
		} else {
			leTemps += " 00 sec ";
		}
		
		if(heure <= 0 && minute <= 0 && seconde <= 0) {
			leTemps = "00 h 00 min 00 sec";
		}
			return leTemps;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRetour) { // retour page d'accueil
			fenAccueil = new Accueil();
			this.dispose();
			fenAccueil.setVisible(true);
		} 
		if (e.getSource() == btnStart) { // mise en place du chrono
			heure = 0;
			minute = 0;
			seconde = 0;
			task = new TimerTask(){
				public void run() {
					chrono();
					lblChrono.setText(timerEnHMS());
				}
			};
			time.schedule(task,0, 1000);
		}
		if (e.getSource() == btnPause) { // pause du chrono
			//leChrono.pause();
			task.cancel();
		}
		if (e.getSource() == btnResume) { // relance le chrono
			//leChrono.resume();
			task = new TimerTask(){
				public void run() {
					chrono();
					lblChrono.setText(timerEnHMS());
				}
			};
			time.schedule(task,0, 1000);
		}
		if (e.getSource() == btnStop) { // Stop le chrono et purge la Task et reset le chrono
			//leChrono.stop();
			task.cancel();
			time.purge();
			lblChrono.setText("00 h 00 min 00 sec");
		}
		if (e.getSource() == leBtn) { // enregistre le temps du bateau dans la bdd et ajoute dans une zone txt le nom + num et temps du bateau
			
		}
	}
	
	public static void main(String[] args) throws SQLException {
		new Regate();
	}

}