/**
 * Primjer preotereæenja (overloadinga)
 */
public class Over {
	// metoda koja prihvaæa i ispisuje integer	
	void ispis(int niz) {
		System.out.println("Ovo je integer "+niz);
	}
	// metoda koja prihvaæa i ispisuje String	
	void ispis(String niz) {
		System.out.println("Ovo je string "+niz);
	}
  // metoda koja prihvaæa 2 broja i ispisuje produkt	
	void ispis(float a, float b) {
		System.out.println("Produkt je " + a * b);
	}
	// metoda koja prihvaæa podatak logièkog tipa
	public static void main(String[] args) {
	    Over o = new Over();
		o.ispis("Dobar dan"); // ispisuje "Ovo je string Dobar dan"
		o.ispis(7); // ispisuje "Ovo je integer 7"
		o.ispis(2.0f,3.3f); // ispisuje "Produkt je 6.6"
	}
}
