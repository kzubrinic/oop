package hr.unidu.oop.p10;

import java.util.ArrayList;
import java.util.List;

public class PunjacSlika {
    public static final String OSOBA1 = "slike/mara.jpg";
    public static final String OSOBA2 = "slike/iva.jpg";
    public static final String OSOBA3 = "slike/vedrana.jpg";
	public static List<Osoba> napuniListuOsoba(){
		List<Osoba> st = new ArrayList<>();
		String PERO = "slike/pero.jpg";
		st.add(new Osoba("Pero", "Perić", PERO, 49));
		String ANA = "slike/ana.jpg";
		st.add(new Osoba("Ana", "Anić", ANA, 19));
		String BERO = "slike/bero.jpg";
		st.add(new Osoba("Bero", "Berić", BERO, 37));
		String VLAHO = "slike/vlaho.jpg";
		st.add(new Osoba("Vlaho", "Vlahić", VLAHO, 72));
		String IVO = "slike/ivo.jpg";
		st.add(new Osoba("Ivo", "Ivić", IVO, 18));
		return st;
	}
}
