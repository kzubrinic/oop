package hr.unidu.oop.p09.citac;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class PokreniCitac extends JFrame{
	private JTextField mapa;
	private JTextArea rez;
	public PokreniCitac(String naslov) {
		super(naslov);
		JLabel l = new JLabel("Mapa:");
		mapa = new JTextField(30);
		JPanel pom = new JPanel();
		pom.add(l);
		pom.add(mapa);
		rez = new JTextArea(30, 10);
		rez.setEditable(false);
		JScrollPane sp = new JScrollPane(rez);
		JButton b = new JButton("Čitaj");
		b.addActionListener((e)->{
			if (mapa.getText().length() > 0) {
				SwingWorker<List<String>, Void> cs = new CitacDatoteka(mapa.getText(), this);  
				cs.execute();
			}
		});
		JPanel pom2 = new JPanel();
		pom2.add(b);
		add(BorderLayout.NORTH, pom);
		add(BorderLayout.SOUTH, pom2);
		add(sp);
		pack();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void napuniTekst(List<String> lista) {
		for (String s : lista) {
			rez.append(s);
			rez.append("\n");
		}
	}
    public static void main(String[] args){
    	SwingUtilities.invokeLater(() -> {
            try {
            	new PokreniCitac("Čitač datoteka");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
