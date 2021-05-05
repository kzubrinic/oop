package hr.unidu.oop.p09.threadsw;
/*
 * Izvor:
 * package hr.fer.oop.threads.swing;
 * https://github.com/MarioKusek/FER-OOP/blob/master/16_Dretve/src/main/java/hr/fer/oop/threads/swing/WrongWayThread.java
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class WrongWayThread extends JFrame {
	JButton btnAction = new JButton();
	JProgressBar pbProgress = new JProgressBar();

	public WrongWayThread(String naslov) {
		super(naslov);
		setSize(600, 80);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pbProgress.setMaximum(10);
		pbProgress.setMinimum(0);
		btnAction.setText("Start");
		btnAction.addActionListener((e) -> btnAction_actionPerformed(e));
		add(btnAction, BorderLayout.WEST);
		add(pbProgress, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			WrongWayThread frame = new WrongWayThread("Pogrešan način");
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}

	private void btnAction_actionPerformed(ActionEvent e) {
		pbProgress.setValue(0);
		// Dugačka obrada se izvodi u posebnoj radnoj dretvi
		new Thread(() -> {
			for (int i = 0; i <= 10; i++) {
				// POGREŠNO! GUI komponenta se ažuriura u radnoj dretvi!
				pbProgress.setValue(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}).start();		
	}
}