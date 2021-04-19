package hr.unidu.oop.p10;

import java.util.ArrayList;
import java.util.List;

public class PunjacSlika {
    public static final String OSOBA1 = "oop/slike/mara.jpg";
    public static final String OSOBA2 = "oop/slike/iva.jpg";
    public static final String OSOBA3 = "oop/slike/vedrana.jpg";
	public static List<Osoba> napuniListuOsoba(){
		List<Osoba> st = new ArrayList<>();
		String PERO = "oop/slike/pero.jpg";
		st.add(new Osoba("Pero", "Perić", PERO, 49));
		String ANA = "oop/slike/ana.jpg";
		st.add(new Osoba("Ana", "Anić", ANA, 19));
		String BERO = "oop/slike/bero.jpg";
		st.add(new Osoba("Bero", "Berić", BERO, 37));
		String VLAHO = "oop/slike/vlaho.jpg";
		st.add(new Osoba("Vlaho", "Vlahić", VLAHO, 72));
		String IVO = "oop/slike/ivo.jpg";
		st.add(new Osoba("Ivo", "Ivić", IVO, 18));
		return st;
	}
}
