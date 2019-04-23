package hr.unidu.oop.p01;
/**
 * Klasa Osoba s primjerom varijabli i metode.
 * Varijable objekta imaju pristup "public" što znači da im
 * izravno može pristupiti bilo koja metoda bilo kojeg objekta.
 * U programima se to <b>ne smije dozvoliti</b> već se razina
 * pristupa varijablama mora postaviti na <b>private</b>, a 
 * varijablama treba pristupati korištenjem public getter i
 * setter metoda.
 * Primjerice ovdje bi se to napravilo na sljedeći način:
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
public class Osoba{
	/**
	 * Varijabla koja čuva ime osobe. 
	 * Svaki objekt ima vlastitu kopiju te varijable.
	 */
    public String ime = "Ivo";
	/**
	 * Varijabla koja čuva starost osobe. 
	 * Svaki objekt ima vlastitu kopiju te varijable.
	 */
    public int starost = 0;
    /**
	 * Metoda povećava starost osobe za 1 godinu i ispisuje pozdravnu poruku.
	 */
	void cestitajRodjendan(){
		starost = starost + 1;
		System.out.println(ime + ", sretan ti " + starost + ". rođendan!");
	}	
}