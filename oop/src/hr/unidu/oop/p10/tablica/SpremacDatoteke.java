package hr.unidu.oop.p10.tablica;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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

public class SpremacDatoteke extends SwingWorker<Boolean, Void> {
	private String dat;
	private List<Osoba> osobe;
	// referenca na GUI klasu kako bismo mogli ažurirati GUI komponentu
	private TablicaIzDatoteke app; 
	// u konstruktoru se vrši inicijalizacija "radnika"
	public SpremacDatoteke(String d, List<Osoba> o, TablicaIzDatoteke p){
		dat = d;
		app = p;
		osobe = o;
	}
	@Override
	// Obrada koja se vrši u pozadini
	public Boolean doInBackground() {
		if (osobe == null) return false;
		try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(dat))) {
			// read the first line from the text file
			for(Osoba o : osobe) {
				bw.write(o.getIme()+","+o.getPrezime()+","+o.getSlika()+","+o.getStarost()+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	// obrada konačnih rezultata
	public void done() {
		try {
			Boolean b = get();
			app.spremanjeZavrsilo(b);
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		} 
	}
}
