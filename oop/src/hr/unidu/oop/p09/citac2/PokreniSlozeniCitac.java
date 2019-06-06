package hr.unidu.oop.p09.citac2;
 

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class PokreniSlozeniCitac extends JFrame {

    private JPanel cp;
    private JProgressBar progressBar;
    private SwingWorker cs;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PokreniSlozeniCitac frame = new PokreniSlozeniCitac();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PokreniSlozeniCitac() {
        String mapa = "/bin";
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JTextArea polje = new JTextArea("");
        polje.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(polje);
        getContentPane().add(scrollPane);
        JButton btnUitaj = new JButton("U\u010Ditaj");
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        cs = new SlozeniCitacDatoteka(mapa, polje, progressBar);
        progressBar.addChangeListener(e -> progressBar.setValue(cs.getProgress()));
        
        
        btnUitaj.addActionListener(e -> ucitaj());
        getContentPane().add(btnUitaj, BorderLayout.SOUTH);
        getContentPane().add(progressBar, BorderLayout.NORTH);
    }
    private void ucitaj(){
        cs.execute();
    }
    
}
