package hr.unidu.oop.p08;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author Krunoslav Žubrinić
 * 28. tra 2015.
 */
public class ObradaViseDogadjaja extends JFrame{
	private JLabel l;

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				ObradaViseDogadjaja window = new ObradaViseDogadjaja();
				window.pack();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ObradaViseDogadjaja() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l = new JLabel("0");
		// JPanel komponente centrira pa je to najjednostavniji način
		// da se ova labela pozicionira centrirano.
		JPanel p1 = new JPanel();
		p1.add(l);
		// Ako nam centriranje nije važno moglo bi izravno: add(l,BorderLayout.NORTH);
		add(p1, BorderLayout.NORTH);

		JButton t1 = new JButton("Povećaj");
		JButton t2 = new JButton("Smanji");
		JPanel p2 = new JPanel();
		p2.add(t1);
		p2.add(t2);
		add(p2, BorderLayout.SOUTH);
		// Neimenovani razred koji implementira sučelje ActionListener
		// Obrada tipke Povećaj
		t1.addActionListener(new ActionListener() {
			// U sučelju ActionListener definirana je metoda actionPerformed
			public void actionPerformed(ActionEvent arg0) {
				int v = Integer.valueOf(l.getText())+1;
				l.setText(Integer.toString(v));
			} 
		});

		// Neimenovani razred koji implementira sučelje ActionListener
		// Obrada tipke Smanji
		t2.addActionListener(new ActionListener() {
			// U sučelju ActionListener definirana je metoda actionPerformed
			public void actionPerformed(ActionEvent arg0) {
				int v = Integer.valueOf(l.getText())-1;
				l.setText(Integer.toString(v));
			} 
		});
	}
}
