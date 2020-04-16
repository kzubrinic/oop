package hr.unidu.oop.p08;
import javax.swing.*;
import java.awt.*;
public class RazniLayouti {
    private JButton[] b;
  public RazniLayouti() {
      b = napuni();
  }
  public void border(){
      // BorderLayout je defaultni za kontejnere najviše razine
      JFrame f = new JFrame("Border Layout");
      // omogućuje smještanje više komponenti
      JPanel p = new JPanel();
      p.setLayout(new BorderLayout());
      p.add(b[0], BorderLayout.NORTH);
      p.add(b[1], BorderLayout.SOUTH);      
      p.add(b[2], BorderLayout.EAST);      
      p.add(b[3], BorderLayout.WEST);
      p.add(b[4], BorderLayout.CENTER);
      // panel se dodaje na prozor
      f.add(p);
      f.pack();
      f.setVisible(true);
  }
  public void flow(){
      JFrame f = new JFrame("Flow Layout");
      // omogućuje smještanje više komponenti
      JPanel p = new JPanel();
      p.setLayout(new FlowLayout());
      for (JButton t : b)
        p.add(t);
      // panel se dodaje na prozor
      f.add(p);  
      f.pack();
      f.setLocationRelativeTo(null);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      f.setVisible(true);
  }
  public void boxY(){
      JFrame f = new JFrame("Box Layout Y-os");
      // omogućuje smještanje više komponenti
      JPanel p = new JPanel();
      p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
      for (JButton t : b)
        p.add(t);
      // panel se dodaje na prozor
      f.add(p);
      f.pack();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      f.setVisible(true);
  }
  public void boxX(){
      JFrame f = new JFrame("Box Layout X-os");
      // omogućuje smještanje više komponenti
      JPanel p = new JPanel();
      p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
      for (JButton t : b)
        p.add(t);
      // panel se dodaje na prozor
      f.add(p);
      f.pack();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      f.setVisible(true);
  }
  public void grid(){
      JFrame f = new JFrame("Grid Layout");
      // omogućuje smještanje više komponenti
      JPanel p = new JPanel();
      p.setLayout(new GridLayout(2,3));
      for (JButton t : b)
        p.add(t);
      // panel se dodaje na prozor
      f.add(p);
      f.pack();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      f.setVisible(true);
  }

  
  public static void main(String[] a) {
	  RazniLayouti r = new RazniLayouti();
	  r.boxY();
  }
  

  private JButton[] napuni(){
      JButton[] t = new JButton[5];
      for (int i = 0 ; i < 5; i++)
         t[i] = new JButton("Klikni");
      return t;
  }
} 