package hr.unidu.oop.p02;
/**
 * Klasa Osoba s primjerom varijabli i metode
 * Varijable objekta imaju pristup "public" što znači da im
 * izravno može pristupiti bilo koja metoda bilo kojeg objekta.
 * U programima se to <b>ne smije dozvoliti</b> već se razina
 * pristupa varijablama mora postaviti na <b>private</b>, a 
 * varijablama treba pristupati public getter/setter metodama.
 * Primjerice ovdje bi to bilo:
 * <code>String getIme(){
 * 		return ime;
 * }
 * </code>
 * i
 * <code>void setIme(String ime){
 * 		this.ime = ime;
 * }
 * </code> 
 */
public class Osoba
{
<<<<<<< HEAD
	/**
	 * Varijabla koja čuva ime osobe. Svaki objekt ima svoju vlastitu
	 * kopiju te varijable.
	 */
=======
   	// Varijable koje čuvaju ime i starost
   	// Svatko im može pristupiti i promijeniti im vrijednost
>>>>>>> branch 'master' of https://github.com/kzubrinic/oop.git
    public String ime = "Ivo";
	/**
	 * Varijabla koja čuva starost osobe. Svaki objekt ima svoju vlastitu
	 * kopiju te varijable.
	 */
    public int starost = 0;
	/**
<<<<<<< HEAD
	 * Metoda povećava starost osobe za 1 godinu i ispisuje pozdravnu poruku.
=======
	 * Metoda rodjendan() povećava starost osobe za 1 godinu.
>>>>>>> branch 'master' of https://github.com/kzubrinic/oop.git
	 */
	public void upoznavanje(){
		starost = starost + 1;
		System.out.println("Dobar dan " + ime + "!");
	}	
	
	public static void main(String[] args) {
    	// Stvaranje prvog objekta tipa Osoba inicijalnim (defaultnim) konstruktorom 
    	Osoba o1 = new Osoba();
    	// Stvaranje drugog objekta tipa Osoba inicijalnim (defaultnim) konstruktorom
    	Osoba o2 = new Osoba();
    	// Promjena vrijednosti varijable ime na prvom i na drugom objektu tipa Osoba.
    	o1.ime="Ana";
    	o2.ime="Ivo";
    	// Ispis imena jedne i drugo osobe
    	System.out.println(o1.ime);
    	System.out.println(o2.ime);
    }
}
