package hr.unidu.oop.p02;
public class Pjesma2 {
	private String autor;
	// Greška kod prevođenja jer static metoda ne može izravno 
	// koristiti varijablu "autor" koja nije static!
	// Obratno je dozvoljeno (Metoda koja nije static može
	// koristiti static, navođenjem naziva klase u kojoj je
	// varijabla deklarirana.)
	public static void sviranje(String novi) {
		//autor = novi;
		//System.out.println("Svira " + autor);
	}
	public static void main(String[] args) {
     	Pjesma2.sviranje("Mozart");
     	Pjesma2.sviranje("Bach");
    }
}