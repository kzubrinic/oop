package hr.unidu.oop.p08;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

import java.awt.*;

public class PrimjerJWindow extends JFrame{
	private JWindow jw;
	public static void main(String[] args){
		try {
            SwingUtilities.invokeLater(() -> {
            	new PrimjerJWindow();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	public PrimjerJWindow() {
		super("Primjer korištenja klase JWindow kao \"splash\" prozora");
		jw = new JWindow(this);
		ImageIcon slika = new ImageIcon("slike/oblak.jpg", "Oblačić");
		JLabel l1 = new JLabel(slika);
        l1.setVerticalTextPosition(JLabel.BOTTOM);
        l1.setHorizontalTextPosition(JLabel.CENTER);
		JLabel l2 = new JLabel("Ovo je najbolji program");
		jw.setLayout(new BorderLayout());
		jw.add(l1, BorderLayout.WEST);
		jw.add(l2);
		jw.pack();
        jw.setLocationRelativeTo(null);
        jw.setVisible(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
            	// Pauzira kako bi se splash ekran pokazao neko vrijeme dok ne završi inicijalna duga obrada
                pricekajTrajeObrada();
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                    	// Nastavlja s otvaranjem prozora po završetku duge obrade
                        kreni();
                    }
                });
            }
        }).start();
	
	}
	private void kreni() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setVisible(true);
        // uklanja "splash" prozor iz memorije
        jw.dispose();
	}
	private void pricekajTrajeObrada() {
	        // Pauza za prikaz "splash" ekrana dok traje neka dugačka obrada u radnoj dretvi
	        try {
	            Thread.sleep(5000);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
