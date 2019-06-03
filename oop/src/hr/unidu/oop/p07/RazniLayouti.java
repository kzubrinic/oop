package hr.unidu.oop.p07;
import javax.swing.*;
import java.awt.*;
public class RazniLayouti {
    private JButton b[];
  public RazniLayouti() {
      b = napuni();
  }
  public void border(){
      // BorderLayout je defaultni za kontejnere najvi�e razine
      JFrame f = new JFrame("Border Layout");
      // omogu�uje smje�tanje vi�e komponenti
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
      // omogu�uje smje�tanje vi�e komponenti
      JPanel p = new JPanel();
      p.setLayout(new FlowLayout());
      for (JButton t : b)
        p.add(t);
      // panel se dodaje na prozor
      f.add(p);  
      f.pack();
      f.setLocationRelativeTo(null);
      f.setVisible(true);
  }
  public void boxY(){
      JFrame f = new JFrame("Box Layout Y-os");
      // omogu�uje smje�tanje vi�e komponenti
      JPanel p = new JPanel();
      p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
      for (JButton t : b)
        p.add(t);
      // panel se dodaje na prozor
      f.add(p);
      f.pack();
      f.setVisible(true);
  }
  public void boxX(){
      JFrame f = new JFrame("Box Layout X-os");
      // omogu�uje smje�tanje vi�e komponenti
      JPanel p = new JPanel();
      p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
      for (JButton t : b)
        p.add(t);
      // panel se dodaje na prozor
      f.add(p);
      f.pack();
      f.setVisible(true);
  }
  public void grid(){
      JFrame f = new JFrame("Grid Layout");
      // omogu�uje smje�tanje vi�e komponenti
      JPanel p = new JPanel();
      p.setLayout(new GridLayout(2,3));
      for (JButton t : b)
        p.add(t);
      // panel se dodaje na prozor
      f.add(p);
      f.pack();
      f.setVisible(true);
  }

  


  private JButton[] napuni(){
      JButton[] t = new JButton[5];
      for (int i = 0 ; i < 5; i++)
         t[i] = new JButton("Klikni");
      return t;
  }
} 
