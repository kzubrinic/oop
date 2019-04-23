package hr.unidu.oop.p01;
/**
 * Primjer stvaranja objekata i pristupa varijablama i metodama
 */
public class Cestitanje {
	public static void main(String[] args) {
		// stvaramo objekt "ovog" tipa (Cestitanje)
		Cestitanje program = new Cestitanje();
		// Stvaramo jedan objekt tipa Osoba
		Osoba ivo = new Osoba();
		// Pristupamo varijablama prvog stvorenog objekta i
		// mijenjamo im vrijednost.
		ivo.ime = "Ivo";
		ivo.starost = 37;
		// Pozivamo metodu na "ovom" objektu
		program.upoznavanje(ivo.ime);
		// pozivamo metodu cestitajRodjendan() na objektu prve stvorene osobe
		ivo.cestitajRodjendan();
		// Stvaramo drugi objekt tipa Osoba
		Osoba ana = new Osoba();
		// Pristupamo varijablama drugog stvorenog objekta i
		// mijenjamo im vrijednost. Vrijednost varijabli prvog objekta
		// tipa Osoba je ostala nepromijenjena.
		ana.ime = "Ana";
		ana.starost = 29;
		// Pozivamo metodu na "ovom" objektu
		program.upoznavanje(ana.ime);
		// pozivamo metodu cestitajRodjendan() na objektu druge stvorene osobe
		ana.cestitajRodjendan();
		// Preusmjeravamo varijablu referencu miki da pokazuje na drugi
		// stvoreni objekt.
		Osoba miki = ana;
		// Sada reference "ana" i "miki" pokazuju na isti objekt tipa Osoba
		// Tom objektu se može pristupiti putem jedne ili druge reference.
		// U ovom slučaju pozivamo metodu cestitajRodjendan() na objektu druge 
		// stvorene osobe
		miki.cestitajRodjendan();
		// Nakon ove naredbe, prvom stvorenom objektu se više ne može pristupiti.
		// Sustav za čišćenje memorije će nakon nekog vremena (ako niti jedna
		// druga referenca ne pokazuje na taj objekt) očistiti memoriju alociranu
		// za taj objekt tipa Osoba.
		ivo = null;
		// Naredba 
		//   ivo.cestitajRodjendan();
		// bi uzrokovala grešku kod izvođenja jer prvi stvoreni objekt 
		// tipa Osoba više ne postoji.
	}
	/**
	 * Ispisuje pozdravnu poruku osobe
	 * @param ime - ime osobe s kojom se uspoznajemo
	 */
	private void upoznavanje(String ime) {
		System.out.println("Dobar dan " + ime + ", drago mi je da smo se upoznali!");
	}
}
