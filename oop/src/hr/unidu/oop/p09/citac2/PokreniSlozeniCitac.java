package hr.unidu.oop.p09.citac2;
 

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

@SuppressWarnings("serial")
public class PokreniSlozeniCitac extends JFrame {
    private JProgressBar progressBar;
    private SwingWorker<List<String>, Integer> cs;
    private JTextField mapa;
    private JTextArea polje;

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
            try {
                new PokreniSlozeniCitac("Složeni čitač");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PokreniSlozeniCitac(String naslov) {
    	super(naslov);
    	mapa = new JTextField(30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        polje = new JTextArea("");
        polje.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(polje);
        getContentPane().add(scrollPane);
        JButton btnUitaj = new JButton("Učitaj");
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        JPanel gornji = new JPanel();
        JLabel l = new JLabel("Mapa:");
		mapa = new JTextField(30);
        gornji.setLayout(new BorderLayout());
        gornji.add(BorderLayout.WEST, l);
        gornji.add(BorderLayout.EAST, mapa);
        gornji.add(BorderLayout.NORTH, progressBar);
        btnUitaj.addActionListener(e -> ucitaj());
        getContentPane().add(btnUitaj, BorderLayout.SOUTH);
        getContentPane().add(gornji, BorderLayout.NORTH);
        setVisible(true);
    }
    private void ucitaj(){
    	if (mapa.getText().trim().length() > 0) {
			cs = new SlozeniCitacDatoteka(mapa.getText().trim(), this);
			cs.execute();
		}
    }
    public void napuniTekst(List<String> lista) {
		for (String s : lista) {
			polje.append(s);
			polje.append("\n");
		}
	}
    public void napuniProgressBar(int vrij) {
    	progressBar.setValue(vrij);
    }
}
