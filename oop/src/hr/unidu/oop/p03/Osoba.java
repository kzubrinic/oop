package hr.unidu.oop.p03;
/**
 * Klasa Osoba s primjerom varijabli i metode
 * 
 * @version February 2016.
 */
public class Osoba
{
   	// Varijable koje čuvaju ime i starost
   	// Svatko im može pristupiti i promijeniti im vrijednost
    public String ime = "Ivo";
    public int starost = 0;
	/**
	 * Metoda rodjendan() povećava starost osobe za 1 godinu.
	 */
	public void cestitajRodjendan(){
		starost = starost + 1;
		System.out.println("Dobar dan " + ime + "! Sretan ti " + starost + ". ro�endan!");
	}	
}
