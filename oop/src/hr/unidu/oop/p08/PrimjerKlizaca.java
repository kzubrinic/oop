package hr.unidu.oop.p08;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JSlider;

public class PrimjerKlizaca extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				PrimjerKlizaca frame = new PrimjerKlizaca();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.pack();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public PrimjerKlizaca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel vrij = new JLabel();
		contentPane.add(vrij);
		
		JSlider slider = new JSlider();
		vrij.setText(Integer.toString(slider.getValue()));
		slider.addChangeListener(e -> vrij.setText(Integer.toString(slider.getValue())));
		contentPane.add(slider);
		NumberFormat f = NumberFormat.getInstance(Locale.forLanguageTag("HR"));
	}
}
