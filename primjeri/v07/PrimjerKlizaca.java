import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class PrimjerKlizaca extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimjerKlizaca frame = new PrimjerKlizaca();
					frame.setVisible(true);
					frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PrimjerKlizaca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel vrij = new JLabel();
		contentPane.add(vrij);
		
		JSlider slider = new JSlider();
		vrij.setText(Integer.toString(slider.getValue()));
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				vrij.setText(Integer.toString(slider.getValue()));
			}
		});
		contentPane.add(slider);
		NumberFormat f = NumberFormat.getInstance(Locale.forLanguageTag("HR"));
	}
}
