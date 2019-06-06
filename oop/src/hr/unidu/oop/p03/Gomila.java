package hr.unidu.oop.p03;
/**
 * Primjer stvaranja vi�e objekata, mijenjanja
 * njihovih svojstava i pozivanja metoda.
 * @author Krunoslav �ubrini�
 * velja�a 2017.
 */
public class Gomila {
	public static void main(String[] args) {
		// Stvara se objekt tipa Prijatelj
		Osoba desniSusjed = new Osoba();
		// Postavlja se ime konkretne osobe na stvorenom objektu.
		// Mijenja se vrijednost varijable pomo�u operatora "to�ka"
		// Sintaksa je: referenca to�ka imeVarijable
		desniSusjed.ime = "Maro";
		// Postavlja se starost konkretne osobe na stvorenom objektu
		desniSusjed.starost = 24;
		
		// Stvara se novi objekt tipa Osoba
		// Sada na raspolaganju imamo dva objekta tipa Osoba
		// Prvom pristupamo pomo�u reference "desniSusjed", a
		// drugom pomo�u reference "lijeviSusjed"
		Osoba lijeviSusjed = new Osoba();
		// Postavlja se ime i starost druge osobe
		lijeviSusjed.ime = "Baro";
		lijeviSusjed.starost = 15;
		
		// Stvara se jo� jedan novi objekt tipa Osoba i postavlja
		// ime i starost
		Osoba kolegicaIzSkole = new Osoba();
		kolegicaIzSkole.ime = "Mare";
		kolegicaIzSkole.starost = 20;
		// Poziva se metoda na stvorenom objektu. Sintaksa je ista
		// kao kod pristupa varijablama (pomo�u operatora "to�ka").
		kolegicaIzSkole.cestitajRodjendan();
		
		// Stvara se još jedan novi objekt tipa Osoba i postavlja
		// ime i starost
		Osoba prijateljicaIzVrtica = new Osoba();
		prijateljicaIzVrtica.ime = "Kate";
		prijateljicaIzVrtica.starost = 19; 
		
		// Ispisuju se vrijednosti varijabli svakog od �etiri stvorena objekta.
		System.out.println("Dobar dan, ja sam " + desniSusjed.ime + " i imam " + desniSusjed.starost + " godina.");
		System.out.println("Dobar dan, ja sam " + lijeviSusjed.ime + " i imam " + lijeviSusjed.starost + " godina.");
		System.out.println("Dobar dan, ja sam " + kolegicaIzSkole.ime + " i imam " + kolegicaIzSkole.starost + " godina.");
		System.out.println("Dobar dan, ja sam " + prijateljicaIzVrtica.ime + " i imam " + prijateljicaIzVrtica.starost + " godina.");
	}
}