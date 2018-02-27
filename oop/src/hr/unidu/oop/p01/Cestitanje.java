package hr.unidu.oop.p01;
/**
 * Primjer stvaranja objekata i pristupa varijablama i metodama
 */
public class Cestitanje {

	public static void main(String[] args) {
		// stvaramo objekt "ovog" tipa (Cestitanje)
		Cestitanje program = new Cestitanje();
		// Stvaramo objekt tipa Osoba
		Osoba ivo = new Osoba();
		// pristupamo varijablama konkretne osobe
		ivo.ime = "Ivo";
		ivo.starost = 37;
		// pozivamo metodu na "ovom" objektu
		program.upoznavanje(ivo.ime);
		// pozivamo metodu cestitrajRodjendan konkretne osobe
		ivo.cestitajRodjendan();
		Osoba ana = new Osoba();
		ana.ime = "Ana";
		ana.starost = 29;
		// pozivamo metodu na "ovom" objektu
		program.upoznavanje(ana.ime);
		ana.cestitajRodjendan();
		Osoba miki = ana;
		// Reference ana i miki pokazuju a istu osobu
		// Tom objektu se može pristupiti putem bilo koje reference
		miki.cestitajRodjendan();
		// Nakon ove naredbe, ovom objektu se više ne može pristupiti
		ivo = null;
		// Ova naredba bi uzrokovala grešku kod izvođenja
		//ivo.cestitajRodjendan();
	}
	
	private void upoznavanje(String ime) {
		System.out.println("Dobar dan " + ime + ", drago mi je da smo se upoznali!");
	}
}
