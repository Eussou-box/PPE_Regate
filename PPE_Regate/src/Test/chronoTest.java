package Test;

public class chronoTest {
	private double starterTime;
	private double endTimer;
	private double timer;
	private double totalTimer;
	private double pauseDeb;
	private double pauseFin;
	
	public chronoTest() {
		starterTime = 0.0;
		endTimer = 0.0;
		timer = 0.0;
		totalTimer = 0.0;
		pauseDeb = 0.0;
		pauseFin = 0.0;
		
	}
	
	public void start() {
		starterTime = System.currentTimeMillis();
		timer = starterTime;
	}
	
	public void pause() {
		pauseDeb = System.currentTimeMillis();
	}
	
	public void resume() {
		pauseFin = System.currentTimeMillis();
		timer += pauseFin - pauseDeb;
		pauseFin = 0.0;
		pauseDeb = 0.0;
	}
	
	public void stop() {
		endTimer = System.currentTimeMillis();
		totalTimer = endTimer - timer;
	}
	
	public double timerSec() {
		return timer/1000;
	}
	
	public String afficheLeTemps() {
		return timerEnHMS(timer);
	}
	
	public String timerEnHMS(double temps) {
		String leTemps = "";
		int h = (int)(temps / 3600);
		int m = (int)((temps % 3600) / 60);
		int s = (int)(temps % 3600);
		
		if(h > 0) {
			leTemps += h + " h ";
		} else {
			leTemps += " 00 h";
		}
		
		if(m > 0) {
			leTemps += m + " min ";
		} else {
			leTemps += " 00 min ";
		}
		
		if(s > 0) {
			leTemps += s + " sec ";
		} else {
			leTemps += " 00 sec ";
		}
		
		if(h <= 0 && m <= 0 && s <= 0) {
			leTemps = "00 h 00 min 00 sec";
		}
			return leTemps;
	}

	public double getStarterTime() {
		return starterTime;
	}

	public void setStarterTime(double starterTime) {
		this.starterTime = starterTime;
	}

	public double getEndTimer() {
		return endTimer;
	}

	public void setEndTimer(double endTimer) {
		this.endTimer = endTimer;
	}

	public double getTimer() {
		return timer;
	}

	public void setTimer(double timer) {
		this.timer = timer;
	}

	public double getTotalTimer() {
		return totalTimer;
	}

	public void setTotalTimer(double totalTimer) {
		this.totalTimer = totalTimer;
	}

	public double getPauseDeb() {
		return pauseDeb;
	}

	public void setPauseDeb(double pauseDeb) {
		this.pauseDeb = pauseDeb;
	}

	public double getPauseFin() {
		return pauseFin;
	}

	public void setPauseFin(double pauseFin) {
		this.pauseFin = pauseFin;
	}
	
	
}
