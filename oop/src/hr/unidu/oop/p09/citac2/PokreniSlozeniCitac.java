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

/*
 * Obrada prikazuje napredovanje koristeći komponentu tipa JProgressBar.
 * Nazivi datoteka se prikazuju tek po završetku obrade.
 */

public class PokreniSlozeniCitac extends JFrame {
    private JProgressBar progressBar;
    private SwingWorker<List<String>, Integer> cs;
    private JTextField mapa;
    private JTextArea polje;
    private JButton btnUcitaj;

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
        add(scrollPane);
        JPanel pomDolje = new JPanel();
        btnUcitaj = new JButton("Učitaj");
        pomDolje.add(btnUcitaj);
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        JPanel gornji = new JPanel();
        JLabel l = new JLabel("Mapa:");
		mapa = new JTextField(30);
        gornji.setLayout(new BorderLayout());
        gornji.add(BorderLayout.WEST, l);
        gornji.add(BorderLayout.EAST, mapa);
        gornji.add(BorderLayout.NORTH, progressBar);
        btnUcitaj.addActionListener(e -> ucitaj());
        add(pomDolje, BorderLayout.SOUTH);
        add(gornji, BorderLayout.NORTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void ucitaj(){
    	if (mapa.getText().trim().length() > 0) {
    		postaviStatusGumba(false);
    		polje.setText("");
			cs = new SlozeniCitacDatoteka(mapa.getText().trim(), this);
			cs.addPropertyChangeListener(e-> azurirajProgressBar(e.getPropertyName(),e.getNewValue()));
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
    public void postaviStatusGumba(boolean v) {
    	btnUcitaj.setEnabled(v);
    }
    private void azurirajProgressBar(String naziv, Object vrijednost) {
    	if ("progress".equals(naziv)) {
    		progressBar.setValue((Integer)vrijednost);
       	}
    }
}
