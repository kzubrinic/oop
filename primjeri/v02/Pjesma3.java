public class Pjesma3 {
	String autor;
	// Static metoda ne mo�e pozivati metode koje nisu static!
	// Poku�aj izaziva gre�ku kod prevo�enja.
	public static void sviranje(String novi) {
		int duljina = vratiDuljinu();
		System.out.println("Svira " + novi);
	}
	public int vratiDuljinu() {
		return 5;
	}	
}
