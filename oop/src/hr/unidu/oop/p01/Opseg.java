package hr.unidu.oop.p01;
import java.util.Scanner;
/**
 * Klasa koja u glavnoj metodi računa opseg kvadrata
 *
 */
public class Opseg {
	public static void main(String[] args) {
		// Ispis poruke na zaslonu
		System.out.println("Unesite duljinu:");	
		// Stvaranje objekta tipa Scanner za unos s tipkovnice ("System.in")
		Scanner sc = new Scanner(System.in);
		// Unos cijelog broja poomoću metode na stvorenom objektu tipa Scanner
    	int i = sc.nextInt();
    	// Ispis izračunatog opsega
		System.out.println("Opseg kvadrata je ");
		System.out.print(i*4); 
		// Prekida unos podataka sa standardnog ulaza
		sc.close();
	}
}
