package hr.unidu.oop.p08;

import javax.swing.*;
import java.awt.*;

public class Cetvrti extends JFrame {

	private boolean plavo = false;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				Cetvrti frame = new Cetvrti();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.pack();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}


	public Cetvrti() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());
		
		JButton buttonOk = new JButton("OK");
		buttonOk.setBackground(Color.LIGHT_GRAY);
		// Java ver. < 8
//		buttonOk.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (!plavo){
//					buttonOk.setBackground(Color.BLUE);
//					buttonOk.setForeground(Color.WHITE);
//					plavo = true;
//				}
//				else {
//					buttonOk.setBackground(Color.LIGHT_GRAY);
//					buttonOk.setForeground(Color.BLACK);
//					plavo = false;
//				}
//			}
//		});
		// Java ver. <= 8
		buttonOk.addActionListener(e -> {
				if (!plavo){
					buttonOk.setBackground(Color.BLUE);
					buttonOk.setForeground(Color.WHITE);
					plavo = true;
				}
				else {
					buttonOk.setBackground(Color.LIGHT_GRAY);
					buttonOk.setForeground(Color.BLACK);
					plavo = false;
				}
		});
		contentPane.add(buttonOk);
	}
}
