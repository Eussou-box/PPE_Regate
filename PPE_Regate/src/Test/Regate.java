package Test;

import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private Accueil fenAccueil;
	private ArrayList<Bateau> lesVoiliers;
	private Font lblFont1;
	private Timer time;
	private TimerTask task;
	private int seconde;
	private int minute;
	private int heure;
	private DecimalFormat df;
	
	public Regate() {
		this.setTitle("R�gate");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700,700);
		this.setResizable(false);
		time = new Timer();
		df = new DecimalFormat("00");
		//leChrono = new Test();
		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		btnPause = new JButton("Pause Chrono");
		btnPause.addActionListener(this);
		btnResume = new JButton("Relancer le Chrono");
		btnResume.addActionListener(this);
		btnStop = new JButton("Stop");
		btnStop.addActionListener(this);
		lblChrono = new JLabel();
		lblTop = new JLabel("Bienvenue sur la page de gestion de la r�gate");
		lblFont1 = new Font("Arial", Font.BOLD, 20);
		lblTop.setFont(lblFont1);
		lblChrono.setFont(lblFont1);
		lblTop.setHorizontalAlignment(JLabel.CENTER);
		panBtnChrono = new JPanel(new GridLayout(2,2));
		panBtnChrono.add(btnStart);
		panBtnChrono.add(btnStop);
		panBtnChrono.add(btnPause);
		panBtnChrono.add(btnResume);
		panChrono = new JPanel();
		panChrono.setLayout(new BorderLayout());
		panChrono.add(lblChrono, BorderLayout.CENTER);
		panChrono.add(panBtnChrono, BorderLayout.SOUTH);
		panFirst = new JPanel();
		panFirst.setLayout(new BorderLayout());
		panBtn = new JPanel();
		lesVoiliers = new ArrayList<Bateau>();
		addVoiliers();
		panBtn.setLayout(new GridLayout(lesVoiliers.size(),2));
		for(Bateau rs : lesVoiliers) {
			leBtn = new JButton(rs.getNomBateau());
			panBtn.add(leBtn);
		}
		btnRetour = new JButton("Retour � l'Accueil");
		btnRetour.addActionListener(this);
		panFirst.add(panBtn, BorderLayout.WEST);
		panFirst.add(panChrono, BorderLayout.EAST);
		panFirst.add(lblTop, BorderLayout.NORTH);
		this.getContentPane().add(panFirst);
		this.setVisible(true);
	}
	
	public void addVoiliers() {
		lesVoiliers.add(new Bateau("Les Joyeux Coquins","1", ""));
		lesVoiliers.add(new Bateau("Le paquebotte","1", ""));
		lesVoiliers.add(new Bateau("Les SIO Skippers","1", ""));
		lesVoiliers.add(new Bateau("Fnatic Voilier","1", ""));
		lesVoiliers.add(new Bateau("SEND NUDES","1", ""));
		lesVoiliers.add(new Bateau("Les Lolis For Ever","1", ""));
		lesVoiliers.add(new Bateau("Nan mais Allo quoi","1", ""));
		lesVoiliers.add(new Bateau("I'm wet","1", ""));
	}
	
	public void chrono() {
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
	
	public String timerEnHMS() {
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
		if(e.getSource() == btnRetour) {
			fenAccueil = new Accueil();
			this.dispose();
			fenAccueil.setVisible(true);
		} 
		if (e.getSource() == btnStart) {
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
		if (e.getSource() == btnPause) {
			//leChrono.pause();
			task.cancel();
		}
		if (e.getSource() == btnResume) {
			//leChrono.resume();
			task = new TimerTask(){
				public void run() {
					chrono();
					lblChrono.setText(timerEnHMS());
				}
			};
			time.schedule(task,0, 1000);
		}
		if (e.getSource() == btnStop) {
			//leChrono.stop();
			task.cancel();
			time.purge();
			lblChrono.setText("00 h 00 min 00 sec");
		}
		if (e.getSource() == leBtn) {
			
		}
	}
	
	public static void main(String[] args) {
		new Regate();
	}

}