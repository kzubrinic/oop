package hr.unidu.oop.p08;
import javax.swing.*;
import java.awt.*;
public class PrimjerLabela extends JFrame {
    public PrimjerLabela(String t){
        super(t);
    }

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(() -> {
                PrimjerLabela p = new PrimjerLabela("Primjer labela");
                p.setLocation(100, 100);
                p.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                JLabel label1, label2, label3;
                ImageIcon slika = new ImageIcon("slike/oblak.jpg", "Oblačić");
                //labela koja sadrži tekst i sliku
                label1 = new JLabel("Slika i tekst", slika, JLabel.CENTER);
                //pozicija teksta u odnosu na sliku
                label1.setVerticalTextPosition(JLabel.BOTTOM);
                label1.setHorizontalTextPosition(JLabel.CENTER);
                //druge labele
                label2 = new JLabel("Sami tekst");
                label3 = new JLabel(slika);
                //tool tipovi
                label1.setToolTipText("Labela koja sadrži tekst i sliku");
                label2.setToolTipText("Labela koja sadrži samo tekst");
                label2.setFont(new Font("Arial", Font.BOLD, 16));
                label3.setToolTipText("Labela koja sadrži samo sliku");
                p.add(label1, BorderLayout.WEST);
                p.add(label2, BorderLayout.EAST);
                p.add(label3, BorderLayout.SOUTH);
                p.pack();
                p.setLocationRelativeTo(null);
                p.setVisible(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 