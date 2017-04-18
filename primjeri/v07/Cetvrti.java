import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cetvrti extends JFrame {

	private JPanel contentPane;
	private boolean plavo = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cetvrti frame = new Cetvrti();
					frame.setVisible(true);
					frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Cetvrti() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());
		
		JButton buttonOk = new JButton("OK");
		buttonOk.setBackground(Color.LIGHT_GRAY);
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});
		contentPane.add(buttonOk);
	}
}
