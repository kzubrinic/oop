package hr.unidu.oop.p07;


import javax.swing.*;
/*
    Najjednostavniji Swing grafički program - 2 primjer
 */
public class PrviProzor2{
    public static void main(String[] args) {
        JFrame f = new JFrame("Prvi prozor");
        f.setSize(400, 200);
        //f.setLocation(100, 100); // smješta prozor na zadanu poziciju
        f.setLocationRelativeTo(null); // centrira prozor na ekranu
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
