package hr.unidu.oop.p10.tablica;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import hr.unidu.oop.p10.Osoba;

public class CitacDatoteke extends SwingWorker<List<Osoba>, Void> {
	private String dat;
	private List<Osoba> list;
	// referenca na GUI klasu kako bismo mogli ažurirati GUI komponentu
	private TablicaIzDatoteke app; 
	// u konstruktoru se vrši inicijalizacija "radnika"
	public CitacDatoteke(String d, TablicaIzDatoteke p){
		dat = d;
		list = new ArrayList<>();
		app = p;
	}
	@Override
	// Obrada koja se vrši u pozadini
	public List<Osoba> doInBackground() {
		try (BufferedReader br = Files.newBufferedReader(Paths.get(dat))) {
			// read the first line from the text file
			String l = br.readLine();
			
			// loop until all lines are read
			while (l != null) {
				String[] el = l.split(",");
				Osoba o = new Osoba(el);
				list.add(o);
				l = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	// obrada konačnih rezultata
	public void done() {
		try {
			List<Osoba> rez = get();
			app.napuniModel(rez);
			// model.napuniTekst(rez); // ažurira GUI polje pozivom metode iz GUI klase
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		} 
	}
}
