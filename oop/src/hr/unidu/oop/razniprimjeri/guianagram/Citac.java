package hr.unidu.oop.razniprimjeri.guianagram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Citac {
	private List<Anagram> rijeci;
	private Map<String,Boolean> pogodjene;
	private Random r;
	private int prosli = 0;
	public Citac(String dat) {
		r = new Random();
		rijeci = new ArrayList<>();
		pogodjene = new HashMap<>();
		// Odmah po stvaranju objekta učitava sve riječi iz liste i radi s listom
		SwingWorker<List<Anagram>, Void> u = new Citac.Ucitaj(dat);
		u.execute();
		while(u.isDone() == false) {
			// Čekam dok se riječi ne učitaju
		}
		try {
			rijeci = u.get(); // dohvati učitane riječi
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 
	}

	public int getBrojRijeci() {
		return rijeci.size();
	}

	public Anagram dohvatiRijec() {
		Anagram a;
		int sigurnosnaOgrada=0;
		int i;
		while(true) {
			i = r.nextInt(rijeci.size());
			a = rijeci.get(i);
			if(sigurnosnaOgrada > 100) // ograda da se ne zavrti u "beskonačnoj" petlji
				break;
			// Ako riječ nije prethodno pogođena, izaberi ju
			if(!pogodjene.containsKey(a.getRijec())) {
				if (i != prosli) {
					prosli = i;
					break;
				}else {
					continue;
				}
			} else {
				sigurnosnaOgrada++;
			}
		}
		return a;
	}


	// Bilježi pogođene riječi u mapu da se ne ponavljaju u jednoj igri
	public void azurirajPogodjene(String r) {
		pogodjene.put(r, true);
	}

	class Ucitaj extends SwingWorker<List<Anagram>, Void>{
		private String dat;
		public Ucitaj(String d) {
			dat = d;
		}
		@Override
		protected List<Anagram> doInBackground() throws Exception {
			List<Anagram> l = new ArrayList<>();
			try (Scanner s = new Scanner(new File(dat))){
				while (s.hasNextLine()) {
					String r = s.nextLine();
					l.add(new Anagram(r, shuffle(r)));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			};
			return l;
		}

		private String shuffle(String s) {
			int i = 0;
			String ana = s;
			while(i < 10) {
				ana = shuffle2(s);
				if(ana.equals(s)) {
					++i;
					continue;
				}else {
					break;
				}
			}
			return ana;
		}

		// razbacuje slova riječi - jedno rješenje
		private String shuffle1(String s) {
			List<Character> chars = new ArrayList<Character>();
			for(char c:s.toCharArray()){
				chars.add(c);
			}
			// Koristi metodu shuffle klase Collections
			Collections.shuffle(chars);
			StringBuilder out = new StringBuilder();
			for(Character c:chars){
				out.append(c);
			}
			return out.toString();
		}

		// razbacuje slova riječi - drugo rješenje bez korištenja algoritama kolekcija
		private String shuffle2(String s) {
			char[] slova = s.toCharArray();
			char pom;
			for(int i=0;i<slova.length;++i) {
				pom = slova[i];
				int j = r.nextInt(slova.length);
				slova[i] = slova[j];
				slova[j] = pom;
			}
			return new String(slova);
		}
	}
}
