package hr.unidu.oop.p07;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Peti extends JFrame {

	private JPanel contentPane;
	private JTextField idPrvi;
	private JButton butZbroji;
	private JTextField idDrugi;
	private JLabel label;
	private JLabel idRez;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Peti frame = new Peti();
					frame.setVisible(true);
					//frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Peti() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 70);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		idPrvi = new JTextField();
		contentPane.add(idPrvi);
		idPrvi.setColumns(6);
		
		butZbroji = new JButton("+");
		butZbroji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float b1, b2, r=0;
				try{
					b1 = Float.parseFloat(idPrvi.getText());
					b2 = Float.parseFloat(idDrugi.getText());
					r = b1 + b2;
				} catch (NumberFormatException e1){
					r = 0;
				} finally{
					idRez.setText(new Float(r).toString());
				}
				
			}
		});
		contentPane.add(butZbroji);
		
		idDrugi = new JTextField();
		contentPane.add(idDrugi);
		idDrugi.setColumns(6);
		
		label = new JLabel("=");
		contentPane.add(label);
		
		idRez = new JLabel("0.0");
		contentPane.add(idRez);
	}

}
