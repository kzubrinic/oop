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
public class ObradaDogadjaja extends JFrame{
	private JLabel l;
	private JButton t;
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run() {
					ObradaDogadjaja window = new ObradaDogadjaja();
					window.pack();
					window.setVisible(true);
				}
			});
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

	public ObradaDogadjaja() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l = new JLabel("0");
		// JPanel komponente centrira pa je to najjednostavniji naèin
		// da se ova labela pozicionira centrirano.
		JPanel p = new JPanel();
		p.add(l);
		// Ako nam centriranje nije važno moglobi izravno: add(l,BorderLayout.NORTH);
		add(p, BorderLayout.NORTH);
		
		t = new JButton("Poveæaj");
		add(t, BorderLayout.SOUTH);
		// Neimenovani razred koji implementira suèelje ActionListener
		t.addActionListener(new ActionListener() {
			// U suèelju ActionListener definirana je metoda actionPerformed
			public void actionPerformed(ActionEvent arg0) {
				int v = Integer.valueOf(l.getText())+1;
				l.setText(Integer.toString(v));
			} 
		});
	}
}
