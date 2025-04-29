package hr.unidu.oop.razniprimjeri.guianagram;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class IgraAnagram extends JFrame{
	private JLabel izabrana, bodovi;
	private JTextField pogadjanje;
	private Citac c;
	private String rijec;
	private int maxBodova;
	// Inicijalno dohvaća anagrame imena
	private String datoteka = "baza/rijeci-imena.txt";
	public IgraAnagram(String t){
		super(t);
		setLayout(new GridLayout(5,2));
		JLabel lVrsta = new JLabel("Vrsta riječi: ");
		String[] m = { "Imena", "Pojmovi"};
		JComboBox<String> vrsta = new JComboBox<>(m);
		// Može se promijeniti vrsta riječi za anagrame
		vrsta.addActionListener(evt -> {
			int i = vrsta.getSelectedIndex();
			if (i == 0) {
				datoteka = "baza/rijeci-imena.txt";
				setTitle("Anagrami - imena");
			}
			else {
				datoteka = "baza/rijeci-pojmovi.txt";
				setTitle("Anagrami - pojmovi");
			}
			iniIgra();
		});
		izabrana = new JLabel("");
		JLabel labIza = new JLabel("Anagram");
		bodovi = new JLabel("0");
		JLabel labBodovi = new JLabel("Broj bodova: ");
		JLabel labRijec = new JLabel("Riječ: ");
		pogadjanje = new JTextField(20);
		JButton nova = new JButton("Nova igra");
		// primjer - anonimna klasa
		nova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novaIgra();
			}
		});
		JButton provjeri = new JButton("Provjeri");
		// primjer - lambda izraz
		provjeri.addActionListener(e -> {
			if(rijec.equals(pogadjanje.getText() )) {
				JOptionPane.showMessageDialog(this, "Bravo! Pogodili ste!");
				int bb = Integer.valueOf(bodovi.getText()) + 1;
				bodovi.setText(String.valueOf(bb));
				c.azurirajPogodjene(rijec);
				if(bb == maxBodova) {
					JOptionPane.showMessageDialog(this, "Ostvarili ste maksimalan broj bodova!");
					iniIgra();
				}
				novaIgra();
			}else {
				JOptionPane.showMessageDialog(this, "Pogrešno!");
			}
		});
		add(lVrsta);
		add(vrsta);
		add(labIza);
		add(izabrana);
		add(labRijec);
		add(pogadjanje);
		add(labBodovi);
		add(bodovi);
		add(nova);
		add(provjeri);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		iniIgra();
	}
	
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeLater(() -> {
				IgraAnagram p = new IgraAnagram("Anagrami - imena");
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Sljedeća riječ u jednoj igri
	private void novaIgra() {
		Anagram a = c.dohvatiRijec();
		izabrana.setText(a.getAnagram());
		rijec = a.getRijec();
		pogadjanje.setText("");
	}
	
	// Nova igra (bodovanje kreće od nule)
	private void iniIgra() {
		c = new Citac(datoteka);
		maxBodova = c.getBrojRijeci();
		bodovi.setText("0");
		novaIgra();
	}
}

