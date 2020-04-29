package hr.unidu.oop.p10.lista;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingUtilities;

import hr.unidu.oop.p10.Osoba;

import java.awt.BorderLayout;

public class DefaultniModelSlike extends JFrame {

	private DefaultListModel<Osoba> mod;
	private final String IVA = "slike/iva.jpg";
	private final String MARA = "slike/mara.jpg";
	private final String VEDRANA = "slike/vedrana.jpg";

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				DefaultniModelSlike frame = new DefaultniModelSlike("Defaultni model osoba - sa slikama", true);
			});
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public DefaultniModelSlike(String n, boolean zatvori) {
		this(n);
		if (zatvori)
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public DefaultniModelSlike(String n) {
		super(n);
		JPanel cp = new JPanel();
		mod = new DefaultListModel<>();
		napuniModel();
		JList<Osoba> l1 = new JList<>(mod);
		l1.setVisibleRowCount(4);
		// Vlastito iscrtavanje retka jer se pored teksta treba prikazati i slika
		l1.setCellRenderer(new CrtacRetka());

		JScrollPane pp = new JScrollPane(l1);

		getContentPane().add(pp,BorderLayout.NORTH);
		getContentPane().add(cp,BorderLayout.SOUTH);
		JButton dod = new JButton("Dodaj na kraj");

		dod.addActionListener(e ->{
			Osoba s = new Osoba("Mara", "Marić", MARA, 43);
			mod.addElement(s);
			l1.setSelectedValue(s, true);
		});
		JButton dod1 = new JButton("Dodaj iza");

		dod1.addActionListener(e -> {
			Osoba s = new Osoba("Iva", "Ivić", IVA, 26);
			int p = l1.getSelectedIndex();
			mod.add(p+1,s);
			l1.setSelectedIndex(p+1);
		});
		JButton dod2 = new JButton("Obriši");

		dod2.addActionListener(e -> {
			if (l1.getSelectedIndex() > -1)
				mod.remove(l1.getSelectedIndex());
		});
		JButton dod3 = new JButton("Izmjeni");

		dod3.addActionListener(e -> {
			Osoba s = new Osoba("Vedrana", "Vedrić", VEDRANA, 35);
			if (l1.getSelectedIndex() > -1)
				mod.set(l1.getSelectedIndex(), s);
		});
		cp.add(dod);
		cp.add(dod1);
		cp.add(dod2);
		cp.add(dod3);

		setVisible(true);
		setLocationRelativeTo(null);
		pack();
	}
	private void napuniModel(){
		String PERO = "slike/pero.jpg";
		mod.addElement(new Osoba("Pero", "Perić", PERO, 49));
		String ANA = "slike/ana.jpg";
		mod.addElement(new Osoba("Ana", "Anić", ANA, 19));
		String BERO = "slike/bero.jpg";
		mod.addElement(new Osoba("Bero", "Berić", BERO, 37));
		String VLAHO = "slike/vlaho.jpg";
		mod.addElement(new Osoba("Vlaho", "Vlahić", VLAHO, 72));
		String IVO = "slike/ivo.jpg";
		mod.addElement(new Osoba("Ivo", "Ivić", IVO, 18));
	}
}
