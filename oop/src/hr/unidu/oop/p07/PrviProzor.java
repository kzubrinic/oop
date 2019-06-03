package hr.unidu.oop.p07;

import javax.swing.*;
/*
    Najjednostavniji Swing grafički program
 */
public class PrviProzor extends JFrame {
    public static void main(String[] args) {
        PrviProzor p = new PrviProzor();
        p.setTitle("Prvi prozor");
        p.setSize(400, 200);
        //p.setLocation(100, 100); // smješta prozor na zadanu poziciju
        p.setLocationRelativeTo(null); // centrira prozor na ekranu
        p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        p.setVisible(true);
    }
}
