package hr.unidu.oop.p08;

import javax.swing.*;
/*
Jednostavan Swing grafički program - 1 primjer - nasljeđuje klasu JFrame
*/
public class PrviProzorNaslj extends JFrame {
  public static void main(String[] args) {
	PrviProzorNaslj p = new PrviProzorNaslj();
    p.setTitle("Prvi prozor");
    p.setSize(400, 200);           
    p.setLocationRelativeTo(null);
    p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    p.setVisible(true);
  }
} 

