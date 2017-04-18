import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author Krunoslav Žubriniæ
 * 28. tra 2015.
 */
public class ObradaViseDogadjaja extends JFrame{
	private JLabel l;
	private JButton t1, t2;
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run() {
					ObradaViseDogadjaja window = new ObradaViseDogadjaja();
					window.pack();
					window.setVisible(true);
				}
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
		// JPanel komponente centrira pa je to najjednostavniji naèin
		// da se ova labela pozicionira centrirano.
		JPanel p1 = new JPanel();
		p1.add(l);
		// Ako nam centriranje nije važno moglobi izravno: add(l,BorderLayout.NORTH);
		add(p1, BorderLayout.NORTH);

		t1 = new JButton("Poveæaj");
		t2 = new JButton("Smanji");
		JPanel p2 = new JPanel();
		p2.add(t1);
		p2.add(t2);
		add(p2, BorderLayout.SOUTH);
		// Neimenovani razred koji implementira suèelje ActionListener
		// Obrada tipke Poveæaj
		t1.addActionListener(new ActionListener() {
			// U suèelju ActionListener definirana je metoda actionPerformed
			public void actionPerformed(ActionEvent arg0) {
				int v = Integer.valueOf(l.getText())+1;
				l.setText(Integer.toString(v));
			} 
		});

		// Neimenovani razred koji implementira suèelje ActionListener
		// Obrada tipke Smanji
		t2.addActionListener(new ActionListener() {
			// U suèelju ActionListener definirana je metoda actionPerformed
			public void actionPerformed(ActionEvent arg0) {
				int v = Integer.valueOf(l.getText())-1;
				l.setText(Integer.toString(v));
			} 
		});
	}
}
