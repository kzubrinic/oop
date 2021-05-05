package hr.unidu.oop.p09.citac3;
 

import java.awt.BorderLayout;
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
 * Nazivi i vrsta datoteka se prikazuju odmah tijekom obrade.
 */
public class PokreniSlozeniCitac2 extends JFrame {

    private JProgressBar progressBar;
    private SwingWorker<Void, Pomocna> cs;
    private JTextField mapa;
    private JTextArea polje;
    private JButton btnUcitaj;

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
            try {
                new PokreniSlozeniCitac2("Složeni čitač 2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PokreniSlozeniCitac2(String naslov) {
    	super(naslov);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        polje = new JTextArea("");
        polje.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(polje);
        add(scrollPane);
        JPanel pomDolje = new JPanel();
        btnUcitaj = new JButton("Učitaj");
        pomDolje.add(btnUcitaj);
        progressBar = new JProgressBar(0,100);
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
			cs = new SlozeniCitacDatoteka2(mapa.getText().trim(), this);
			// Registriraj slušač promjene postotka obrade
	        cs.addPropertyChangeListener(e-> azurirajProgressBar(e.getPropertyName(),e.getNewValue()));
			cs.execute();
		}
    }
    public void napuniTekst(String l) {
		polje.append(l);
		polje.append("\n");
	}
    public void napuniProgressBar(int vrij) {
    	progressBar.setValue(vrij);
    }
    private void azurirajProgressBar(String naziv, Object vrijednost) {
    	if ("progress".equals(naziv)) {
    		progressBar.setValue((Integer)vrijednost);
       	}
    }
    public void postaviStatusGumba(boolean v) {
    	btnUcitaj.setEnabled(v);
    }
}
