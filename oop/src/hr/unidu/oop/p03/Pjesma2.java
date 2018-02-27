package hr.unidu.oop.p03;
public class Pjesma2 {
	private String autor;
	// Gre�ka kod prevo�enja jer static metoda ne mo�e koristiti
	// varijablu "autor" koja nije static!
	
	// Obratno je dozvoljeno (Metoda koja nije static mo�e
	// koristiti static)
	public static void sviranje(String novi) {
		autor = novi;
		System.out.println("Svira " + autor);
	}
}
