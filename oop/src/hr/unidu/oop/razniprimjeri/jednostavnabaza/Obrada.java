package hr.unidu.oop.razniprimjeri.jednostavnabaza;

import java.util.List;

public interface Obrada {
	List<Korisnik> citanjeKorisnika();
	Korisnik citanjeKorisnika(String kor);
	Rezultat unos(Korisnik k);
	Rezultat izmjena(Korisnik k);
	Rezultat brisanje(String kor);
	void close();
	
}
