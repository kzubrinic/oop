package hr.unidu.oop.p07;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

public class TreciProzorBox extends JFrame {
	String[] s = {"Pojedina�ne poruke", "Poruke u paketu"}; 
    private JLabel l1, l2;
    private JTextField f1;
    private JCheckBox b1;
    private JRadioButton rb1, rb2;
    private JPanel buttoni;
    private JComboBox<String> cb;
    private JButton b;
	
    public TreciProzorBox(String t) {
    	super(t);
        pripremiKomponente();
        napuniKontejner();	
	}
	private void pripremiKomponente(){
        // stvori dvije nove labele
        l1 = new JLabel("E-mail");
        l1.setAlignmentX(Component.LEFT_ALIGNMENT);
        l2 = new JLabel("Oblik poruke");
        l2.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Stvori polje za unos teksta (e-mail)
        f1 = new JTextField(20);
        f1.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Stvori checkBox
        b1 =  new JCheckBox("�elim primati poruke");
        b1.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Stvori grupu radioButtona i 2 radioButtona
        ButtonGroup grupa = new ButtonGroup();
        rb1 = new JRadioButton("Jednom dnevno");
        rb1.setAlignmentX(Component.LEFT_ALIGNMENT);
        rb2 = new JRadioButton("Jednom tjedno");
        rb2.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Dodaj stvorene buttone u grupu. Grupa upravlja buttonima
        // primjerice osigurava da samo 1 button mo�e u jednom trenutku
        // biti izabran. Grupa NIJE grafi�ka komponenta!
        grupa.add(rb1);
        grupa.add(rb2); 
        // Stvori kontejner u koji �emo staviti sve radioButtone
        buttoni = new JPanel();
        buttoni.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Staviti �emo ih jedna ispod drugoga pa mijenjamo layout
        // u "okomiti" (BoxLayout po Y osi)
        buttoni.setLayout(new BoxLayout(buttoni,BoxLayout.Y_AXIS));
        // Iscrtavaamo okvir oko grupe buttona sa zadanim naslovom
        buttoni.setBorder(BorderFactory.createTitledBorder("Koliko �esto?"));
        //buttoni.setBorder(BorderFactory.createLineBorder(Color.black));
        // Ume�emo buttone u stvoreni kontejner
        buttoni.add(rb1);
        buttoni.add(rb2);
        // Stvaramo padaju�i izbornik i popunjavamo ga Stringovima iz polja.
        cb = new JComboBox<String>(s);
        cb.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Ozna�avmo prvi element polja aktivnim.
        cb.setSelectedIndex(0);
        // Stvaramo novu tipku.
        b = new JButton("U redu");
        b.setAlignmentX(Component.LEFT_ALIGNMENT);
    }
	private void napuniKontejner(){
		// Postavi ovaj prozor na zadanu lokaciju
        setLocation(100, 100);
        // Nakon �to zavtvorimo prozor, neka program zavr�i.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel lijevo = new JPanel();
        JPanel desno = new JPanel();
        lijevo.setLayout(new BoxLayout(lijevo,BoxLayout.Y_AXIS));
        desno.setLayout(new BoxLayout(desno,BoxLayout.Y_AXIS));
        
        // Lijevo ume�emo prvu labelu
        lijevo.add(l1);
        lijevo.add(new JLabel(" "));
        lijevo.add(new JLabel(" "));
        lijevo.add(new JLabel(" "));
        lijevo.add(new JLabel(" "));
        lijevo.add(new JLabel(" "));
        lijevo.add(new JLabel(" "));
        // Ume�emo drugu labelu
        lijevo.add(l2);
        
        // Desno ume�emo polja
        
        desno.add(f1);
        desno.add(b1);
        // Ume�emo panale sa svim RadioButtonima. 
        desno.add(buttoni);
        // Ume�emo padaju�i izbornik pa preska�emo �eliju.
        desno.add(cb);
        // Centiramo tipku.
        desno.add(b);
        getContentPane().add(lijevo,BorderLayout.WEST);
        getContentPane().add(desno,BorderLayout.EAST);
	}

	public static void main(String[] args) {
		try {
            SwingUtilities.invokeAndWait(new Runnable(){
                    public void run() {
                        // Stvori novi prozor (izvedi konstruktor)
                        TreciProzorBox p = new TreciProzorBox("Prijave");
                        // Prilagodi vel�i�inu prozora komponentama
                        p.pack();
                        // Prika�i prozor
                        p.setVisible(true);
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
