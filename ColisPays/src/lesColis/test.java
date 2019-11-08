package lesColis;

public class test {
	
	public static void main(String[] args) {
		Util ut = new Util();
		ut.initTarifs();
		ut.initRecomm();
		//System.out.println(ut.toString());
		ut.afficheTarif();
		ut.afficheRecomm();
		System.out.println(ut.calcPrixBase(1300));
	}
}
