/**
 * Klasa Osoba s primjerom varijabli i metode
 * 
 * @version February 2016.
 */
public class Osoba
{
   	// Varijable koje èuvaju ime i starost
   	// Svatko im može pristupiti i promijeniti im vrijednost
    public String ime = "Ivo";
    public int starost = 0;
	/**
	 * Metoda rodjendan() poveæava starost osobe za 1 godinu.
	 */
	void rodjendan(){
		starost = starost + 1;
		System.out.println("Dobar dan " + ime + "! Sretan ti " + starost + ". roðendan!");
	}	
}
