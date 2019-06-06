package hr.unidu.oop.p08.obradavise;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;

import javax.swing.JButton;

/**
 * @author Krunoslav �ubrini�
 * 28. tra 2015.
 */
public class ObradaViseDogadjaja2 extends JFrame{
	private JLabel l;
	private JButton t1, t2;
	// getter i setter metode za pristuip private varijablama
	public JLabel getL(){
		return l;
	}
	public void setL(JLabel l1){
		l = l1;
	}
	public JButton getT1(){
		return t1;
	}
	public JButton getT2(){
		return t2;
	}
	public void setT1(JButton t){
		t1 = t;
	}
	public void setT2(JButton t){
		t2 = t;
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
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l = new JLabel("0");
		// JPanel komponente centrira pa je to najjednostavniji na�in
		// da se ova labela pozicionira centrirano.
		JPanel p1 = new JPanel();
		p1.add(l);
		// Ako nam centriranje nije va�no moglobi izravno: add(l,BorderLayout.NORTH);
		add(p1, BorderLayout.NORTH);

		t1 = new JButton("Pove�aj");
		t2 = new JButton("Smanji");
		JPanel p2 = new JPanel();
		p2.add(t1);
		p2.add(t2);
		add(p2, BorderLayout.SOUTH);
		// Obrada tipke Pove�aj
		// Razred Slusac1 implementira su�elje ActionListener. Razredu se �alje
		// referenca na ovaj razred da bi se moglo pristupiti ekranskim poljima.
		t1.addActionListener(new Slusac1(this));

		// Obrada tipke Smanji
		// Razred Slusac2 implementira su�elje ActionListener. Razredu se �alje
		// referenca na ovaj razred da bi se moglo pristupiti ekranskim poljima.
		t2.addActionListener(new Slusac2(this));
	}
}
