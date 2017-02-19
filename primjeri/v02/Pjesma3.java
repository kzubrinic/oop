public class Pjesma3 {
	String autor;
	// Static metoda ne može pozivati metode koje nisu static!
	// Pokušaj izaziva grešku kod prevoðenja.
	public static void sviranje(String novi) {
		int duljina = vratiDuljinu();
		System.out.println("Svira " + novi);
	}
	public int vratiDuljinu() {
		return 5;
	}	
}
