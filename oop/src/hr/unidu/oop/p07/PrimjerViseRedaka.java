package hr.unidu.oop.p07;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PrimjerViseRedaka extends JFrame {

    private JPanel cp;
    private JTextArea polje;
    private JProgressBar progressBar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PrimjerViseRedaka frame = new PrimjerViseRedaka();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PrimjerViseRedaka() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 120);
        polje = new JTextArea("");
        polje.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(polje);
        getContentPane().add(scrollPane);
        JButton btnUitaj = new JButton("Učitaj");

        btnUitaj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ucitaj();
            }
        });
        getContentPane().add(btnUitaj, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
    }
    private void ucitaj(){
        polje.append("Prvi redak\n");
        polje.append("Drugi redak\n");
        polje.append("Treći redak\n");
        polje.append("Četvrti redak\n");
        polje.append("Peti redak\n");
    }

}

