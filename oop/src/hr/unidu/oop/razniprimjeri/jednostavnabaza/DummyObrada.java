package hr.unidu.oop.razniprimjeri.jednostavnabaza;

import java.util.ArrayList;
import java.util.List;

public class DummyObrada implements Obrada {

	@Override
	public List<Korisnik> citanjeKorisnika() {
		List<Korisnik> k = new ArrayList<>();
		k.add(new Korisnik("pero", "Pero Perić"));
		k.add(new Korisnik("ana", "Ana Anić"));
		
		// TODO Auto-generated method stub
		return k;
	}

	@Override
	public Korisnik citanjeKorisnika(String kor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rezultat unos(Korisnik k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rezultat izmjena(Korisnik k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rezultat brisanje(String kor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
