package hr.unidu.oop.p10.lista;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingUtilities;

import hr.unidu.oop.p10.Osoba;
import hr.unidu.oop.p10.PunjacSlika;

import java.awt.BorderLayout;
import java.util.List;

public class DefaultniModelSlike extends JFrame {

	private DefaultListModel<Osoba> mod;

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
		mod.addAll(PunjacSlika.napuniListuOsoba());
		JList<Osoba> l1 = new JList<>(mod);
		l1.setVisibleRowCount(4);
		// Vlastito iscrtavanje retka jer se pored teksta treba prikazati i slika
		l1.setCellRenderer(new CrtacRetka());

		JScrollPane pp = new JScrollPane(l1);

		getContentPane().add(pp,BorderLayout.NORTH);
		getContentPane().add(cp,BorderLayout.SOUTH);
		JButton dod = new JButton("Dodaj na kraj");

		dod.addActionListener(e ->{
			Osoba s = new Osoba("Mara", "Marić", PunjacSlika.OSOBA2, 43);
			mod.addElement(s);
			l1.setSelectedValue(s, true);
		});
		JButton dod1 = new JButton("Dodaj iza");

		dod1.addActionListener(e -> {
			Osoba s = new Osoba("Iva", "Ivić", PunjacSlika.OSOBA1, 26);
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
			Osoba s = new Osoba("Vedrana", "Vedrić", PunjacSlika.OSOBA3, 35);
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
	
}
