package hr.unidu.oop.p10.lista;

import javax.swing.*;
import java.awt.*;

public class DefaultniModel extends JFrame {

	private DefaultListModel<String> mod;

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				DefaultniModel frame = new DefaultniModel("Defaultni model", true);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Kada se poziva samostalno, po zatvaranju prozora treba prekinuti aplikaciju
	public DefaultniModel(String n, boolean zatvori) {
		this(n);
		if (zatvori)
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public DefaultniModel(String n) {
		super(n);
		JPanel cp = new JPanel();
		mod = new DefaultListModel<>();
		napuniModel();
		JList<String> l1 = new JList<>(mod);
		l1.setVisibleRowCount(4);
		l1.setPrototypeCellValue("Ovo je najveća širina liste");
		JScrollPane pp = new JScrollPane(l1);

		getContentPane().add(pp,BorderLayout.NORTH);
		getContentPane().add(cp,BorderLayout.SOUTH);
		JButton dod = new JButton("Dodaj na kraj");
		dod.addActionListener(e -> {
			String s = "Osmi dan";
			mod.addElement(s);
			l1.setSelectedValue(s, true);
		});
		JButton dod1 = new JButton("Dodaj u sredinu");
		dod1.addActionListener(e -> {
			String s = "Deveti dan";
			mod.add(1,s);
			l1.setSelectedValue(s, true);
		});
		JButton dod2 = new JButton("Obriši");
		dod2.addActionListener(e -> mod.remove(1));
		JButton dod3 = new JButton("Izmjeni");

		dod3.addActionListener(e -> mod.set(0, "Prvi element"));
		cp.add(dod);
		cp.add(dod1);
		cp.add(dod2);
		cp.add(dod3);

		setVisible(true);
		setLocationRelativeTo(null);
		pack();
	}
	private void napuniModel(){
		mod.addElement("Ponedjeljak");
		mod.addElement("Utorak");
		mod.addElement("Srijeda");
		mod.addElement("Četvrtak");
		mod.addElement("Petak");
		mod.addElement("Subota");
		mod.addElement("Nedjelja");
	}
}
