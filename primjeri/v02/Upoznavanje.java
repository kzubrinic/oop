/**
 * Primjer stvaranja jednog objekta, pristup varijablama
 * i metodama stvorenog objekta.
 * @author Krunoslav Žubriniæ
 * veljaèa 2017.
 */
public class Upoznavanje {
	public static void main(String[] args) {
		// Deklarira se varijabla referenca za pristup
		// objektu tipa Osoba
		Osoba susjed;
		// Stvara se novi objekt tipa Osoba pomoæu operatora new.
		// Prethodno deklarirana referenca susjed povezuje se sa
		// stvorenim objektom.
		susjed = new Osoba();
		// Napomena: Objekt možemo stvoriti i kraæe u 1 retku
		// Osoba susjed = new Osoba();
		
		// Vrijednost varijable objekta mijenja se pomoæu operatora "toèka"
		// Sintaksa je: referenca toèka imeVarijable.
		susjed.ime = "Ivo";
		susjed.starost = 37;
		// Ispisuje se ime prijatelja (sadržaj varijable ime objekta).
		System.out.println("Dobar dan, ja sam " + susjed.ime);
		// Metode se na stvorenom objektu pozivaju na isti naèin kao
		// što se pristupa varijablama (pomoæu operatora "toèka").
		// Poziva se metoda rodjendan() koja mijenja starost susjeda.
		susjed.rodjendan();
		// Ispisuje se starost prijatelja (sadržaj varijable starost objekta).
		System.out.println("Danas mi je roðendan i imam " + susjed.starost+" godina.");
	}
}