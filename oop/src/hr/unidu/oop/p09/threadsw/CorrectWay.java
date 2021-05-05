package hr.unidu.oop.p09.threadsw;
/*
 * Izvor:
 * package hr.fer.oop.threads.swing;
 * https://github.com/MarioKusek/FER-OOP/blob/master/16_Dretve/src/main/java/hr/fer/oop/threads/swing/CorrectWay.java
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class CorrectWay extends JFrame {
	JButton btnAction = new JButton();
	JProgressBar pbProgress = new JProgressBar();

	public CorrectWay(String naslov) {
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
			CorrectWay frame = new CorrectWay("Ispravan način");
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}

	private void btnAction_actionPerformed(ActionEvent e) {
		btnAction.setEnabled(false);
		pbProgress.setValue(0);
		// Dugačka obrada se izvodi u posebnoj radnoj dretvi
		new Thread(() -> {
			for (int i = 0; i <= 10; i++) {
				int progressValue = i;
				// GUI komponenta se ažurira u grafičkoj dretvi
				SwingUtilities.invokeLater(() -> pbProgress.setValue(progressValue));
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
			// GUI komponenta se ažurira u grafičkoj dretvi
			SwingUtilities.invokeLater(() -> btnAction.setEnabled(true));
		}).start();
	}
}