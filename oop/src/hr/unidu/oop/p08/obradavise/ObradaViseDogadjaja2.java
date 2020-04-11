package hr.unidu.oop.p08.obradavise;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;

import javax.swing.JButton;

/*
 * Listeneri se nalaze u vanjskim klasama. Slusac1 i Slusac2
 * Ovo je dobar način za razdvajanje obrade od operacija po grafičkom sučelju.
 * Nedostatak je što za svaki Listener treba praviti posebnu klasu.
 */
public class ObradaViseDogadjaja2 extends JFrame{
	private JLabel l;
	private JButton t1, t2;
	// metode za pristup i promjenu vrijednosti labela.
	// Koriste ih vanjske klase kada žele promijeniti labelu.
	public int getLabelValue(){
		return Integer.valueOf(l.getText());
	}
	public void setLabelValue(int v){
		l.setText(Integer.toString(v));
	}
	
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				ObradaViseDogadjaja2 window = new ObradaViseDogadjaja2();
				window.pack();
				window.setLocationRelativeTo(null);
				window.setVisible(true);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ObradaViseDogadjaja2() {
		super("Brojač");
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

		t1 = new JButton("Povećaj");
		t2 = new JButton("Smanji");
		JPanel p2 = new JPanel();
		p2.add(t1);
		p2.add(t2);
		add(p2, BorderLayout.SOUTH);
		// Obrada tipke Povećaj
		// Razred Slusac1 implementira sučelje ActionListener. Razredu se šalje
		// referenca na ovaj razred da bi se moglo pristupiti ekranskim poljima.
		t1.addActionListener(new Slusac1(this));

		// Obrada tipke Smanji
		// Razred Slusac2 implementira sučelje ActionListener. Razredu se šalje
		// referenca na ovaj razred da bi se moglo pristupiti ekranskim poljima.
		t2.addActionListener(new Slusac2(this));
	}
}
