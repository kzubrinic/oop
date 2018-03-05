package hr.unidu.oop.p02;

/**
 * Primjer stvaranja jednog objekta, pristup varijablama
 * i metodama stvorenog objekta.
 */
public class Upoznavanje {
	public static void main(String[] args) {
		// Deklarira se varijabla referenca za pristup
		// objektu tipa Osoba
		Osoba susjed;
		// Stvara se novi objekt tipa Osoba pomo�u operatora new.
		// Prethodno deklarirana referenca susjed povezuje se sa
		// stvorenim objektom.
		susjed = new Osoba();
		// Napomena: Objekt možemo stvoriti i kraće u 1 retku
		// Osoba susjed = new Osoba();
		
		// Vrijednost varijable objekta mijenja se pomoću operatora "točka"
		// Sintaksa je: referenca točka imeVarijable.
		susjed.ime = "Ivo";
		susjed.starost = 37;
		// Ispisuje se ime prijatelja (sadr�aj varijable ime objekta).
		System.out.println("Dobar dan, ja sam " + susjed.ime);
		// Metode se na stvorenom objektu pozivaju na isti način kao
		// �to se pristupa varijablama (pomoću operatora "točka").
		// Poziva se metoda rodjendan() koja mijenja starost susjeda.
		susjed.rodjendan();
		// Ispisuje se starost prijatelja (sadržaj varijable starost objekta).
		System.out.println("Danas mi je ro�endan i imam " + susjed.starost+" godina.");
	}
}