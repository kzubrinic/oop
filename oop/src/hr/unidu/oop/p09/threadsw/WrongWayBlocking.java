package hr.unidu.oop.p09.threadsw;
/*
 * Izvor:
 * package hr.fer.oop.threads.swing;
 * https://github.com/MarioKusek/FER-OOP/blob/master/16_Dretve/src/main/java/hr/fer/oop/threads/swing/WrongWayBlocking.java
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class WrongWayBlocking extends JFrame {
	JButton btnAction = new JButton();
	JProgressBar pbProgress = new JProgressBar();

	public WrongWayBlocking(String naslov) {
		super(naslov);
		setSize(600, 80);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pbProgress.setMaximum(10);
		pbProgress.setMinimum(0);
		btnAction.setText("Start");
		btnAction.addActionListener((e) -> btnAction_actionPerformed(e));
		add(btnAction, BorderLayout.WEST);
		add(pbProgress, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			WrongWayBlocking frame = new WrongWayBlocking("Pogrešan način s blokiranjem");
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}

	private void btnAction_actionPerformed(ActionEvent e) {
		pbProgress.setValue(0);
		// POGREŠNO! dugačka obrada se izvodi u grafičkoj dretvi!
		for (int i = 0; i <= 10; i++) {
			pbProgress.setValue(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}