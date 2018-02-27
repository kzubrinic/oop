package hr.unidu.oop.p07;
import javax.swing.*;
import java.awt.BorderLayout;
public class DrugiProzorPoboljsani extends JFrame {
    public DrugiProzorPoboljsani(String t){
        super(t);
    }
    public static void main(String[] args) {
    try {
       SwingUtilities.invokeAndWait(new Runnable(){
         public void run() {
           DrugiProzorPoboljsani p = new DrugiProzorPoboljsani("Drugi pobolj�ani prozor");
           p.setLocation(100, 100);
           p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
           JLabel l = new JLabel("Korisni�ko ime");
           JTextField f = new JTextField(20);
           JButton b = new JButton("Prijava");
           JButton b1 = new JButton("Odjava");
           JPanel pan = new JPanel();
           pan.add(b);
           pan.add(b1);
           p.add(l, BorderLayout.WEST);
           p.add(f, BorderLayout.EAST);
           p.add(pan, BorderLayout.SOUTH);
           p.pack();
           p.setVisible(true);
         }
       });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
} 
