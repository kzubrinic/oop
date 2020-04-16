package hr.unidu.oop.p08;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;

public class PrimjerViseRedaka extends JFrame {

    private JPanel cp;
    private JTextArea polje;
    private JProgressBar progressBar;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PrimjerViseRedaka frame = new PrimjerViseRedaka();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PrimjerViseRedaka() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 120);
        polje = new JTextArea("");
        //polje.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(polje);
        add(scrollPane);
        //add(polje);
        JButton btnUitaj = new JButton("Učitaj");
        
//        btnUitaj.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                ucitaj();
//            }
//        });
        btnUitaj.addActionListener(e ->  {
        	System.out.println(e.getActionCommand());
        	ucitaj();
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

