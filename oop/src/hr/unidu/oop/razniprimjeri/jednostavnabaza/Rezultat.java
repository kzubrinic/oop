package hr.unidu.oop.razniprimjeri.jednostavnabaza;

public class Rezultat {
	private String opis;
	private boolean greska;
	public Rezultat(String o, boolean g) {
		greska = g;
		opis = o;
	}
	public Rezultat(boolean g) {
		greska = g;
	}
	public String getGreska() {
		return opis;
	}
	public boolean isGreska() {
		return greska;
	}
}
