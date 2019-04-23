package hr.unidu.oop.p01;
import java.util.Scanner;
/**
 * Program koji u glavnoj metodi računa i ispisuje opseg kvadrata
 */
public class Opseg {
	public static void main(String[] args) {
		// Ispis poruke na zaslonu
		System.out.println("Unesite duljinu stranice:");	
		// Stvaranje objekta tipa Scanner za unos s tipkovnice ("System.in")
		Scanner sc = new Scanner(System.in);
		// Unos cijelog broja pomoću metode na stvorenom objektu tipa Scanner
    	int i = sc.nextInt();
    	// Ispis izračunatog opsega
		System.out.print("Opseg kvadrata je ");
		System.out.print(i*4); 
		// Zatvara tok podataka koji služi za unos sa standardnog ulaza
		sc.close();
	}
}
