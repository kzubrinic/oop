package hr.unidu.oop.p09.citac3;
 

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class PokreniSlozeniCitac2 extends JFrame {

    private JPanel cp;
    private JProgressBar progressBar;
    private SwingWorker cs;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PokreniSlozeniCitac2 frame = new PokreniSlozeniCitac2();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PokreniSlozeniCitac2() {
        String mapa = "/bin";
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JTextArea polje = new JTextArea("");
        polje.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(polje);
        getContentPane().add(scrollPane);
        JButton btnUitaj = new JButton("U\u010Ditaj");
        progressBar = new JProgressBar(0,100);
        progressBar.setStringPainted(true);
        cs = new SlozeniCitacDatoteka2(mapa, polje, progressBar);
        progressBar.addChangeListener(e -> progressBar.setValue(cs.getProgress()));
        
        
        btnUitaj.addActionListener(e -> ucitaj());
        getContentPane().add(btnUitaj, BorderLayout.SOUTH);
        getContentPane().add(progressBar, BorderLayout.NORTH);
    }
    private void ucitaj(){
        cs.execute();
    }
    
}
