package hr.unidu.oop.p02;
/**
 * Klasa pokazuje stvaranje više objekata istog tipa
 */
public class Gomila {
	public static void main(String[] args) {
		// Stvori jedan objekt tipa Osoba
		Osoba desniSusjed = new Osoba();
		// Postavi vrijednost varijable prvog objekta (varijable instance)
		desniSusjed.ime = "Maro";
		// Stvori drugi objekt tipa Osoba
		Osoba lijeviSusjed = new Osoba();
		// Postavi vrijednost varijable drugog objekta (varijable instance)
		lijeviSusjed.ime = "Baro";
		// Stvori treći objekt tipa Osoba
		Osoba kolegicaIzSkole = new Osoba();
		// Postavi vrijednost varijable trećeg objekta (varijable instance)
		kolegicaIzSkole.ime = "Mare";
		// Pozovi metodu na trećem objektu
		kolegicaIzSkole.upoznavanje();
		// Stvori četvrti objekt tipa Osoba
		Osoba prijateljicaIzVrtica = new Osoba();
		// Postavi vrijednost varijable četvrtog objekta (varijable instance)
		prijateljicaIzVrtica.ime = "Kate";
		// Stvori peti objekt tipa Osoba
		Osoba prijateljIzVrtica = new Osoba();
		// Postavi vrijednost varijable petog objekta (varijable instance)
		prijateljIzVrtica.ime = "Ivo";
		// Ispiši stanje objekata
		System.out.println(desniSusjed.ime);
		System.out.println(lijeviSusjed.ime);
		System.out.println(kolegicaIzSkole.ime);
		System.out.println(prijateljicaIzVrtica.ime);
		System.out.println(prijateljIzVrtica.ime);
	}
}
