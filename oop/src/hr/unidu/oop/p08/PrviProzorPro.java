package hr.unidu.oop.p08;
import javax.swing.*;

public class PrviProzorPro extends JFrame {
  public static void main(String[] args) {
    try {
      // Lambda izraz Java >= 8 jer je sučelje Runnable funkcijsko
       SwingUtilities.invokeAndWait(() -> {
         PrviProzorPro p = new PrviProzorPro();
         p.setTitle("Prvi prozor");
         p.setSize(400, 200);
         p.setLocation(100, 100);
         p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         p.setVisible(true);
       });
// Anonimna klasa
//      SwingUtilities.invokeAndWait(new Runnable(){
//        public void run() {
//          PrviProzorPro p = new PrviProzorPro();
//          p.setTitle("Prvi prozor");
//          p.setSize(400, 200);
//          p.setLocation(100, 100);
//          p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//          p.setVisible(true);
//        }
//      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
} 
