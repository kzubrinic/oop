package hr.unidu.oop.razniprimjeri.jednostavnabaza;

import java.util.Objects;

public class Korisnik {
	private String korisnik;
	private String ime;
	
	public Korisnik(String korisnik, String ime) {
		this.korisnik = korisnik;
		this.ime = ime;
	}
	public String getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(String korisnik) {
		this.korisnik = korisnik;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	@Override
	public int hashCode() {
		return Objects.hash(korisnik);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Korisnik))
			return false;
		Korisnik other = (Korisnik) obj;
		return Objects.equals(korisnik, other.korisnik);
	}
	@Override
	public String toString() {
		return "Korisnik [korisnik=" + korisnik + ", ime=" + ime + "]";
	}
	
}
