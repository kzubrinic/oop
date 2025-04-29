package hr.unidu.oop.p08;
import javax.swing.*;
import java.awt.BorderLayout;
public class DrugiProzorPoboljsani extends JFrame {
	private JLabel l;
	private JTextField f;
	private JButton b, b1;
    public DrugiProzorPoboljsani(String t){
        super(t);
        l = new JLabel("Korisničko ime");
		f = new JTextField(20);
		b = new JButton("Prijava");
		b1 = new JButton("Odjava");
		JPanel pan = new JPanel();
        pan.add(b);
        pan.add(b1);
		add(l, BorderLayout.WEST);
        add(f, BorderLayout.EAST);
        add(pan, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
    try {
       SwingUtilities.invokeLater(() -> {
         DrugiProzorPoboljsani p = new DrugiProzorPoboljsani("Drugi poboljšani prozor");
         p.setLocation(100, 100);
         p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         p.setLocationRelativeTo(null);
         p.pack();
         p.setVisible(true);
       });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
} 
