package hr.unidu.oop.p08;

import javax.swing.*;
/*
    Jednostavan Swing grafički program - 2 primjer - kompozicija
    Koristi komponentu tipa JFrame
 */
public class PrviProzorKomp{
    public static void main(String[] args) {
        JFrame p = new JFrame("Prvi prozor");
        p.setTitle("Prvi prozor");
        p.setSize(400, 200);           
        p.setLocationRelativeTo(null);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setVisible(true);
    }
}
