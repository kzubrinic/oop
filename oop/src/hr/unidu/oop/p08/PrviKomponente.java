package hr.unidu.oop.p08;

import java.awt.BorderLayout;
import javax.swing.*;
/*
    Swing grafički program s komponentama
 */
public class PrviKomponente extends JFrame {
	private JLabel l;
	private JTextField t;
	private JButton b;
	public PrviKomponente(String naslov) {
		// Postavljamo naslov prozora
		super(naslov);
		// Za svaku komponentu stvaramo objekt
		l = new JLabel("Labela");
		t = new JTextField(10);
		b = new JButton("Tipka");
		// Smještamo komponente na prozor
		add(l, BorderLayout.WEST); // zapad = lijevo
		add(t, BorderLayout.EAST); // istok = desno
		add(b, BorderLayout.SOUTH); // jug = dolje

	}
    public static void main(String[] args) {
        PrviKomponente p = new PrviKomponente("Prozor"); // stvaramo objekt tipa prozor
        p.setLocation(100, 100); // smješta prozor na zadanu poziciju (x,y) uodnosu na gornji lijevi kut ekrana
        p.setLocationRelativeTo(null); // centrira prozor na ekranu
        p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // kod zatvaranja prozora izlazi iz aplikacije
        p.pack(); // podešavamo veličinu prozora veličini komponenti u njemu
        p.setVisible(true); // prozor postaje vidljiv na ekranu
    }
}
