package hr.unidu.oop.p08;
import javax.swing.*;
import java.awt.BorderLayout;
public class DrugiProzor extends JFrame {
	private JLabel l;
	private JTextField f;
	private JButton b;
    public DrugiProzor(String t){
        super(t);
        l = new JLabel("Korisničko ime");
		f = new JTextField(20);
		b = new JButton("Prijava");
		add(l, BorderLayout.WEST);
        add(f, BorderLayout.EAST);
        add(b, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
    try {
       SwingUtilities.invokeLater(() -> {
         DrugiProzor p = new DrugiProzor("Drugi prozor");
         p.setLocation(100, 100);
         p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         p.pack();
         p.setLocationRelativeTo(null);
         p.setVisible(true);
       });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
} 
