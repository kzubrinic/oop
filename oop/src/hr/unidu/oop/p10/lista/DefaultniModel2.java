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

public class DefaultniModel2 extends JFrame {

	private DefaultListModel<Osoba> mod;

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				DefaultniModel2 frame = new DefaultniModel2("Defaultni model osoba", true);
			});
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	// Kada se poziva samostalno, po zatvaranju prozora treba prekinuti aplikaciju
	public DefaultniModel2(String n, boolean zatvori) {
		this(n);
		if (zatvori)
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public DefaultniModel2(String n) {
		super(n);
		JPanel cp = new JPanel();
		mod = new DefaultListModel<>();
		napuniModel();
		JList<Osoba> l1 = new JList<>(mod);
		l1.setVisibleRowCount(4);
		JScrollPane pp = new JScrollPane(l1);

		getContentPane().add(pp,BorderLayout.NORTH);
		getContentPane().add(cp,BorderLayout.SOUTH);
		JButton dod = new JButton("Dodaj na kraj");
		dod.addActionListener(e -> {
			Osoba s = new Osoba("Posljednji","Upisani");
			mod.addElement(s);
			l1.setSelectedValue(s, true);
		});
		JButton dod1 = new JButton("Dodaj iza");
		dod1.addActionListener(e -> {
			Osoba s = new Osoba("Drugi","Upisan");
			int poz = l1.getSelectedIndex();
			mod.add(poz+1,s);
			l1.setSelectedIndex(poz+1);
		});
		JButton dod2 = new JButton("Obriši");
		dod2.addActionListener(e -> {
			if (l1.getSelectedIndex() > -1)
				mod.remove(l1.getSelectedIndex());
		});
		JButton dod3 = new JButton("Izmjeni");
		dod3.addActionListener(e -> {
			Osoba s = new Osoba("Prvi","Upisan");
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
		mod.addElement(new Osoba("Pero", "Perić"));
		mod.addElement(new Osoba("Ana", "Anić"));
		mod.addElement(new Osoba("Bero", "Berić"));
		mod.addElement(new Osoba("Vlaho", "Vlahić"));
		mod.addElement(new Osoba("Miki", "Mikić"));
	}
}
