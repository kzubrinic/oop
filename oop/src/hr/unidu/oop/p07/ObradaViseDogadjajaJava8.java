package hr.unidu.oop.p07;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author Krunoslav �ubrini�
 * 28. tra 2015.
 */
public class ObradaViseDogadjajaJava8 extends JFrame{
    private JLabel l;
    private JButton t1, t2;
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(new Runnable(){
                public void run() {
                    ObradaViseDogadjajaJava8 window = new ObradaViseDogadjajaJava8();
                    window.pack();
                    window.setVisible(true);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObradaViseDogadjajaJava8() {
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l = new JLabel("0");
        // JPanel komponente centrira pa je to najjednostavniji na�in
        // da se ova labela pozicionira centrirano.
        JPanel p1 = new JPanel();
        p1.add(l);
        // Ako nam centriranje nije va�no moglobi izravno: add(l,BorderLayout.NORTH);
        add(p1, BorderLayout.NORTH);

        t1 = new JButton("Pove�aj");
        t2 = new JButton("Smanji");
        JPanel p2 = new JPanel();
        p2.add(t1);
        p2.add(t2);
        add(p2, BorderLayout.SOUTH);
        // Java 8 - lambda izraz - Obrada tipke Pove�aj
        t1.addActionListener(e -> {
            int v = Integer.valueOf(l.getText())+1;
			l.setText(Integer.toString(v));
          });

        // Java 8 - lambda izraz - Obrada tipke Smanji
        t2.addActionListener(e -> {
            int v = Integer.valueOf(l.getText())-1;
			l.setText(Integer.toString(v));
        });
    }
}