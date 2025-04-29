package hr.unidu.oop.razniprimjeri.jednostavnabaza;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import net.miginfocom.swing.MigLayout;

public class Evidencija extends JFrame{
	// Ovdje deklariramo samo one varijable koje trebajubiti dostupne iz
	// više metoda. Inače je dovoljno da komponente budu lokalne varijable.
	private JTextField korisnik, ime;
	private JTextArea korisnici;
	private JButton bNovi, bIzmjeni, bObrisi, bCitajSve, bCitajJedan;

	public Evidencija(){
		setTitle("Evidencija korisnika");
		// Forma je organizirana pomoću nestandardnog Mig Layouta
		setLayout(new MigLayout());
		
		// Stvaranje GUI komponenti
		JLabel lKorisnik = new JLabel("Korisničko ime");
		JLabel lIme = new JLabel("Ime i prezime");
		JLabel lKorisnici = new JLabel("Korisnici");
		korisnik = new JTextField(10);
		ime = new JTextField(25);
		korisnici = new JTextArea(10, 25);
		// POlje za prikaz teksta (ne može se mijenjati)
		korisnici.setEditable(false);
		// U polje teksta dodajemo klizače
		JScrollPane pK = new JScrollPane(korisnici);
		bNovi = new JButton("Dodaj");
		bIzmjeni = new JButton("Izmjeni");
		bObrisi = new JButton("Obriši");
		bCitajSve = new JButton("Pročitaj");
		bCitajJedan = new JButton("Dohvati");
		//JButton provjeri = new JButton("Provjeri");
		
		// Definiranje akcija na svakom gumbu
		bNovi.addActionListener(e -> {
			dodajKorisnika();
		});
		bIzmjeni.addActionListener(e -> {
			izmjeniKorisnika();
		});
		bObrisi.addActionListener(e -> {
			obrisiKorisnika();
		});
		bCitajSve.addActionListener(e -> {
			procitajKorisnike();
		});
		bCitajJedan.addActionListener(e -> {
			procitajKorisnike(true);
		});
		
		// Grafičke komponente dodajemo u kontejner
		// 1. red: - korisničko ime
		add(lKorisnik);
		add(korisnik);
		add(bCitajJedan, "wrap");
		// 2. red - ime i prezime
		add(lIme);
		add(ime,"spanx 2, growx, wrap");
		// 3. red - labela iznad polja za prikaz svih korisnika
		add(lKorisnici, "spanx 2, growx, wrap");
		// 4. red - polje zaprikaz svih korisnika
		add(pK, "spanx 3, growx, wrap");
		// 5. red - gumbi/tipke
		// Gumbi idu u panel (da bi bili lijepo centrirani)
		JPanel gumbi = new JPanel();
		gumbi.add(bNovi);
		gumbi.add(bIzmjeni);
		gumbi.add(bObrisi);
		gumbi.add(bCitajSve);
		add(gumbi,"spanx 3, align center");
		
		// Završno podešavanje i prikaz forme
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	// JEDNOSTAVAN primjer rada s bazom koji sve operacije odrađuje
	//  u glavnoj grafičkoj dretvi. NEMOJTE koristiti ovakav pristup u
	//  aplikacijama jer mogu dovesti do blokiranja/usporenja tijekom
	//  rada!
	// Ovo je DEMONSTRACIJSKI primjer!!!!
	
	// Dohvat svih korisnika iz baze
	private void procitajKorisnike() {
		// Povezivanje na bazu
		Obrada o = new SqlObrada();
		//Obrada o = new DummyObrada();
		// Dohvat podataka
		List<Korisnik> lk = o.citanjeKorisnika();
		// Ne zaboravite prekinuti konekciju na bazu
		o.close();
		// Dohvaćeni podaci iz liste se prikazuju u ekranskom polju
		korisnici.setText("");
		for(Korisnik k : lk) {
			String redak = String.format("%-10s %-25s\n",k.getKorisnik(), k.getIme() );
			korisnici.append(redak);
		}
	}
	
	// Dohvat korisnika po primarnom ključu (korisničkom imenu)
	private void procitajKorisnike(boolean jedan) {
		// Izvodi se samo ako je korisničko ime uneseno u formi
		if (korisnik == null || korisnik.getText().trim().length() == 0)
			return;
		Obrada o = new SqlObrada();
		Korisnik k = o.citanjeKorisnika(korisnik.getText().trim());
		o.close();
		if (k == null) return;
		ime.setText(k.getIme());
	}

	// Brisanje korisnika po primarnom ključu (korisničkom imenu)
	private void obrisiKorisnika() {
		// Izvodi se samo ako je korisničko ime uneseno u formi
		if (korisnik == null || korisnik.getText().trim().length() == 0){
			JOptionPane.showMessageDialog(null, "Korisničko ime mora biti popunjeno!", "Brisanje korisnika", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		Obrada o = new SqlObrada();
		Rezultat g = o.brisanje(korisnik.getText().trim());
		o.close();

		// Prikaz poruke o izvršenoj operaciji
		JOptionPane.showMessageDialog(null, g.getGreska(), "Brisanje korisnika", JOptionPane.PLAIN_MESSAGE);
		if (g.isGreska()) return;
		ime.setText("");
		korisnik.setText("");
		korisnik.requestFocus();
	}

	// Izmjena korisnika 
	private void izmjeniKorisnika() {
		// Korisničko ime je not null podatak u bazi
		if (korisnik == null || korisnik.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "Korisničko ime mora biti popunjeno!", "Izmjena korisnika", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		Korisnik k = new Korisnik(korisnik.getText().trim(), ime.getText().trim());
		Obrada o = new SqlObrada();
		Rezultat g = o.izmjena(k);
		o.close();
		JOptionPane.showMessageDialog(null, g.getGreska(), "Izmjena korisnika", JOptionPane.PLAIN_MESSAGE);
		if (g.isGreska()) return;
		korisnik.requestFocus();
	}

	// Dodavanje novog korisnika
	private void dodajKorisnika() {
		// Korisničko ime je not null podatak u bazi
		if (korisnik == null || korisnik.getText().trim().length() == 0){
			JOptionPane.showMessageDialog(null, "Korisničko ime mora biti popunjeno!", "Dodavanje korisnika", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		Korisnik k = new Korisnik(korisnik.getText().trim(), ime.getText().trim());
		Obrada o = new SqlObrada();
		Rezultat g = o.unos(k);
		o.close();
		JOptionPane.showMessageDialog(null, g.getGreska(), "Unos korisnika", JOptionPane.PLAIN_MESSAGE);
		if (g.isGreska()) return;
		korisnik.requestFocus();
	}

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeLater(() -> {
				Evidencija p = new Evidencija ();
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


