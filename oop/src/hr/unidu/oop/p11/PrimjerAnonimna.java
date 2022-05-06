package hr.unidu.oop.p11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PrimjerAnonimna extends JFrame{
	private int i = 77;
	private int j = 99;
	public static void main(String[] args) {
		new PrimjerAnonimna();

	}
	public PrimjerAnonimna() {
		System.out.println("Stvoren objekt tipa PrimjerAnonimna");
		setTitle("Primjer anonimne klase");
		JButton b = new JButton(" PRIMJER ANONIMNE KLASE ");
		// Parametar koji se predaje metodi addActionListener je anonimna klasa koja
		//   implementira sučelje ActionListener
		b.addActionListener(new ActionListener() {
			private int i = 44;
			@Override
			public void actionPerformed(ActionEvent e) {
				int j = 66;
				// Pristup varijabli i anonimne klase i vanjske klase
				b.setText("lokalni i=" +i + " vanjski i=" + PrimjerAnonimna.this.i);
				System.out.println("Pozvana metoda actionPerformed anonimne klase: lokalni i="+i+ " vanjski i="+PrimjerAnonimna.this.i);
				// this je referenca na anonimnu klasu
				System.out.println(this);
			}
			
		});
		add(b, BorderLayout.NORTH);
		JButton b1 = new JButton(" PRIMJER LAMBDA IZRAZA KOD FUNKCIJSKOG SUČELJA ");
		// Parametar koji se predaje metodi addActionListener je anonimna klasa koja
		//   implementira sučelje ActionListener. Sučelje ActionLIstener je funkcijso sučelje
		//   (ima samo jednu metodu) pa se može napisati sažeto pomoću "lambda" izraza.
		b1.addActionListener((ActionEvent e) -> {
				int j = 66;
				// Pristup varijabli i anonimne klase i vanjske klase
				b1.setText("lokalni j=" +j + " vanjski j=" + PrimjerAnonimna.this.j);
				System.out.println("Pozvana metoda actionPerformed anonimne klase pomoću lambda izraza: lokalni j="+j+ " vanjski j="+PrimjerAnonimna.this.j);
				// this je referenca na vanjsku klasu PrimjerAnonimna
				System.out.println(this);
		});
		add(b1, BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
