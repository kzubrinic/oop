package hr.unidu.oop.p02;
public class Pjesma3 {
	String autor;
	// Static metoda ne može izravno pozivati metode koje nisu static!
	// Pokušaj izaziva grešku kod prevođenja.
	public static void sviranje(String novi) {
		int duljina = vratiDuljinuPjesme();
		System.out.println("Svira " + novi);
	}
	public int vratiDuljinuPjesme() {
		return 5;
	}
	public static void main(String[] args) {
     	Pjesma3.sviranje("Mozart");
     	Pjesma3.sviranje("Bach");
    }
}