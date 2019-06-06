package hr.unidu.oop.p08;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class Peti extends JFrame {

	private JTextField idPrvi;
	private JTextField idDrugi;
	private JLabel idRez;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Peti frame = new Peti();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				//frame.pack();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Peti() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 70);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		idPrvi = new JTextField();
		contentPane.add(idPrvi);
		idPrvi.setColumns(6);

		JButton butZbroji = new JButton("+");
		butZbroji.addActionListener(e -> {
			float b1, b2, r=0;
			try{
				b1 = Float.parseFloat(idPrvi.getText());
				b2 = Float.parseFloat(idDrugi.getText());
				r = b1 + b2;
			} catch (NumberFormatException e1){
				r = 0;
			} finally{
				idRez.setText(Float.toString(r));
			}

		});
		contentPane.add(butZbroji);
		
		idDrugi = new JTextField();
		contentPane.add(idDrugi);
		idDrugi.setColumns(6);

		JLabel label = new JLabel("=");
		contentPane.add(label);
		
		idRez = new JLabel("0.0");
		contentPane.add(idRez);
	}

}
