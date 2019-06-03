package hr.unidu.oop.p07;
import javax.swing.*;
public class PrviProzorPro extends JFrame {
  public static void main(String[] args) {
    try {
       SwingUtilities.invokeAndWait(new Runnable(){
         public void run() {
           PrviProzorPro p = new PrviProzorPro();
           p.setTitle("Prvi prozor");
           p.setSize(400, 200);           
           p.setLocation(100, 100);
           p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
           p.setVisible(true);
         }
       });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
} 
