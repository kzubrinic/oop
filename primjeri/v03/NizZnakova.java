import java.util.Scanner;
/**
 * Primjer metoda koje koriste niz znakova (podatak tipa String)
 * @author Krunoslav Žubrinić
 * 11. ožu 2015.
 */
public class NizZnakova {

	// Formatiranje Stringa po istim pravilima koja se koriste kada
	// se formatira ispis metodom System.out.printf
	public void formatiraj() {
		float a = 2.7189f, b = 1.122f;
		String novi = String.format("%.2f %.1f %.3f", a, b, Math.PI);
		System.out.println();
		System.out.println("String.format(\"%.2f %.1f %.3f\", a, b, Math.PI)");
		System.out.println(novi);

	}

	public void ispisiString(String s){
		System.out.println("Ispisan izvorni niz: " + s);
		System.out.println("toLowerCase(): Niz ispisan malim slovima: " + s.toLowerCase());
		System.out.println("toUpperCase(): Niz ispisan velikim slovima: " + s.toUpperCase());
	}
	
	public String[] podijeliNiz(String niz){
		String[] rez = niz.split(","); // razbija niz po zarezu
		return rez;

	}
	
	public void ispisiNiz(String[] niz){
		for (int i = 0; i < niz.length; i++)
			System.out.println(niz[i]);
	}

	public static void main(String[] args) {
		NizZnakova n = new NizZnakova();
		Scanner s = new Scanner(System.in);
		System.out.print("Unesite niz znakova: ");
		String niz = s.nextLine();
		System.out.print("Unesite drugi niz znakova: ");
		String niz2 = s.nextLine();
		s.close();

		// ispisuje niz, niz malim slovima i niz velikim slovima
		n.ispisiString(niz);
		n.ispisiString(niz2);

		// Uspoređuje duljinu dva niza 
		if (niz.length() > niz2.length())
			System.out.println("length(): Niz " + niz + " je dulji od niza " + niz2);
		else if (niz2.length() > niz.length())
			System.out.println("length(): Niz " + niz + " je kraći od niza " + niz2);
		else
			System.out.println("length(): Oba niza (" + niz + ") i (" + niz2 + ") su jednake duljine");
		// uspoređuje jednakost dva Stringa
		if (niz.equals(niz2))
			System.out.println("equals(): Oba niza (" + niz + ") i (" + niz2 + ") su jednaka!");
		else
			System.out.println("equals(): Nizovi (" + niz + ") i (" + niz2 + ") su različiti!");

		// Uspoređuje sadržaj niza "leksikografski" - po abecedi 
		// Razlikuje mala i velika slova (PERO != Pero)
		if (niz.compareTo(niz2) > 0)
			System.out.println("compareTo(): Niz " + niz + " je po abecedi smješten iza niza " + niz2);
		else if (niz.compareTo(niz2) < 0 )
			System.out.println("compareTo(): Niz " + niz + " je po abecedi smješten spred niza " + niz2);
		else
			System.out.println("compareTo(): Oba niza (" + niz + ") i (" + niz2 + ") su jednakog sadržaja");	

		// Uspoređuje sadržaj niza "leksikografski" - po abecedi 
		// NE razlikuje mala i velika slova (PERO == Pero)
		if (niz.compareToIgnoreCase(niz2) > 0)
			System.out.println("compareToIgnoreCase(): Niz " + niz + " je po abecedi smješten iza niza " + niz2);
		else if (niz.compareToIgnoreCase(niz2) < 0 )
			System.out.println("compareToIgnoreCase(): Niz " + niz + " je po abecedi smješten spred niza " + niz2);
		else
			System.out.println("compareToIgnoreCase(): Oba niza (" + niz + ") i (" + niz2 + ") su jednakog sadržaja");
		
		// Niz znakova se dijeli po delimiteru i sprema u polje
		String n3 = "Pero,Perić,12.2.2015.,Dubrovnik,178";
		String[] polje = n.podijeliNiz(n3);
		// dobiveno polje se ispisuje
		n.ispisiNiz(polje);
	}

}