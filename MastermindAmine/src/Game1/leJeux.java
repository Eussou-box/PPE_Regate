package Game1;

import java.util.*;


public class leJeux {
	static String ch;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		ArrayList<String> couleur = new ArrayList<>();
		couleur.add("H");//Havane
		couleur.add("L");//Lavande
		couleur.add("E");//Ecry
		couleur.add("J");//Jaune
		couleur.add("G");//Gris
		couleur.add("A");//Acajou
		couleur.add("B");//Brique
		testTwo obj = new testTwo(); 
        
    		String a = obj.getRandomElement(couleur);
    		String b = obj.getRandomElement(couleur);
    		String c = obj.getRandomElement(couleur);
    		String d = obj.getRandomElement(couleur);
    		System.out.print("Code secret : "+ a + "-" + b + "-" + c + "-" + d + "\n");
    		ch = a + "" + b + "" + c + "" + d;
    		int z = 0; //rep correct
    		int count = 1; // nb essais

    		System.out.println("Trouve la combinaison \nVous avez droit a 5 essais \nCode Couleur : ABGJELH");
	
	do {
		System.out.print("> ");
		String a1= sc.nextLine();
		System.out.print("> ");
		String b1 = sc.nextLine();
		System.out.print("> ");
		String c1 = sc.nextLine();
		System.out.print("> ");
		String d1 = sc.nextLine();
		System.out.println(a1+" "+b1+" "+c1+" "+d1);
		String ch2 = a1 + "" + b1 + "" + c1 + "" + d1;
//		System.out.println("\nEssai n° " + (count+1) + "/" + " :");
//        String LettresSaisi = sc.nextLine();
		System.out.println(ch2.toString());
		System.out.println(ch.toString());
        
		if(a1 == a && b1 != b && c1 != c && d1 != d) {
			System.out.println("* * * *"); 
		}
		else if(a1 != a && b1 != b && c1 != c && d1 == d) {
			System.out.println("* * * O");
		}
		else if(a1 != a && b1 != b && c1 == c && d1 != d) {
			System.out.println("* * O *");
		}
		else if (a1 != a && b1 != b && c1 ==c && d1 == d) {
			System.out.println("* * O O");
		}
		else if(a1 != a && b1 == b && c1 != c && d1 != d) {
			System.out.println("* O * *");
		}
		else if(a1 != a && b1 == b && c1 != c && d1 ==d) {
			System.out.println("* O * O");
		}
		else if(a1 != a && b1 == b && c1 == c && d1 != d) {
			System.out.println("* O O *");
		}
		else if(a1 != a && b1 == b && c1 == c && d1 == d) {
			System.out.println("* O O O");
		}
		else if(a1 == a && b1 != b && c1 != c && d1 != d) {
			System.out.println("O * * *");
		}
		else if(a1 == a && b1 != b && c1 != c && d1 == d) {
			System.out.println("O * * O");
		}
		else if(a1 == a && b1 != b && c1 == c && d1 != d) {
			System.out.println("O * O *");
		}
		else if(a1 == a && b1 != b && c1 ==c && d1 == d) {
			System.out.println("O * O O");
		}
		else if(a1 == a && b1 == b && c1 != c && d1 != d) {
			System.out.println("O O * *");
		}
		else if(a1 == a && b1 == b && c1 != c && d1 == d) {
			System.out.println("O O * O");
		}
		else if(a1 == a && b1 == b && c1 == c && d1 != d) {
			System.out.println("O O O *");
		}else{
			System.out.println("O O O O Tu as reussi En seulement "+count+ " coups");
			z= 1;
		}
		count++;

		if(count == 5) {
			System.out.println("Flute c'est perdu pour vous la bonne combinaison etait " + ch );
		}
	}while(z != 1 && count < 6);
	
	sc.close();
}
    public String getRandomElement(List<String> couleur) 
    { 
        Random rand = new Random(); 
         return couleur.get(rand.nextInt(couleur.size())); 
     
    }
  
}

