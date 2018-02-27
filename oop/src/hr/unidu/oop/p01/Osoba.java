package hr.unidu.oop.p01;
/**
 * Klasa Osoba s primjerom varijabli i metode
 */
public class Osoba
{
   	// Varijable koje čuvaju ime i starost
   	// Svatko im moče pristupiti i promijeniti im vrijednost
    public String ime = "Ivo";
    public int starost = 0;
	/**
	 * Metoda rodjendan() povećava starost osobe za 1 godinu.
	 */
	void cestitajRodjendan(){
		starost = starost + 1;
		System.out.println(ime + ", sretan ti " + starost + ". rođendan!");
	}	
}
