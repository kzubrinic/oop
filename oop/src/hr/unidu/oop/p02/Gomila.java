package hr.unidu.oop.p02;

public class Gomila {
	public static void main(String[] args) {
		Osoba desniSusjed = new Osoba();
		desniSusjed.ime = "Maro";
		Osoba lijeviSusjed = new Osoba();
		lijeviSusjed.ime = "Baro";
		Osoba kolegicaIzSkole = new Osoba();
		kolegicaIzSkole.ime = "Mare";
		kolegicaIzSkole.upoznavanje();
		Osoba prijateljicaIzVrtica = new Osoba();
		prijateljicaIzVrtica.ime = "Kate";
		Osoba prijateljIzVrtica = new Osoba();
		prijateljIzVrtica.ime = "Ivo";
	}
}
