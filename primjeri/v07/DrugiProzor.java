import javax.swing.*;
import java.awt.BorderLayout;
public class DrugiProzor extends JFrame {
    public DrugiProzor(String t){
        super(t);
    }
    public static void main(String[] args) {
    try {
       SwingUtilities.invokeAndWait(new Runnable(){
         public void run() {
           DrugiProzor p = new DrugiProzor("Drugi prozor");
           p.setLocation(100, 100);
           p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
           JLabel l = new JLabel("Korisnièko ime");
           JTextField f = new JTextField(20);
           JButton b = new JButton("Prijava");
           p.add(l, BorderLayout.WEST);
           p.add(f, BorderLayout.EAST);
           p.add(b, BorderLayout.SOUTH);
           p.pack();
           p.setVisible(true);
         }
       });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
} 
