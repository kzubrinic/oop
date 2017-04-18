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
import java.awt.GridLayout;

public class TreciProzorGrid extends JFrame {
	String[] s = {"Pojedinaène poruke", "Poruke u paketu"}; 
    private JLabel l1, l2;
    private JTextField f1;
    private JCheckBox b1;
    private JRadioButton rb1, rb2;
    private JPanel buttoni;
    private JComboBox<String> cb;
    private JButton b;
	
    public TreciProzorGrid(String t) {
    	super(t);
        pripremiKomponente();
        napuniKontejner();	
	}
	private void pripremiKomponente(){
        // stvori dvije nove labele
        l1 = new JLabel("E-mail");
        l2 = new JLabel("Oblik poruke");
        // Stvori polje za unos teksta (e-mail)
        f1 = new JTextField(20);
        // Stvori checkBox
        b1 =  new JCheckBox("Želim primati poruke");
        // Stvori grupu radioButtona i 2 radioButtona
        ButtonGroup grupa = new ButtonGroup();
        rb1 = new JRadioButton("Jednom dnevno");
        rb2 = new JRadioButton("Jednom tjedno");
        // Dodaj stvorene buttone u grupu. Grupa upravlja buttonima
        // primjerice osigurava da samo 1 button može u jednom trenutku
        // biti izabran. Grupa NIJE grafièka komponenta!
        grupa.add(rb1);
        grupa.add(rb2); 
        // Stvori kontejner u koji æemo staviti sve radioButtone
        buttoni = new JPanel();
        // Staviti æemo ih jedna ispod drugoga pa mijenjamo layout
        // u "okomiti" (BoxLayout po Y osi)
        buttoni.setLayout(new BoxLayout(buttoni,BoxLayout.Y_AXIS));
        // Iscrtavaamo okvir oko grupe buttona sa zadanim naslovom
        buttoni.setBorder(BorderFactory.createTitledBorder("Koliko èesto?"));
        //buttoni.setBorder(BorderFactory.createLineBorder(Color.black));
        // Umeæemo buttone u stvoreni kontejner
        buttoni.add(rb1);
        buttoni.add(rb2);
        // Stvaramo padajuæi izbornik i popunjavamo ga Stringovima iz polja.
        cb = new JComboBox<String>(s);
        // Oznaèavmo prvi element polja aktivnim.
        cb.setSelectedIndex(0);
        // Stvaramo novu tipku.
        b = new JButton("U redu");
    }
	private void napuniKontejner(){
		// Postavi ovaj prozor na zadanu lokaciju
        setLocation(100, 100);
        // Nakon što zavtvorimo prozor, neka program završi.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Postavljamo GridLayout
        getContentPane().setLayout(new GridLayout(5, 2));
        // Na prozor umeæmo prvu labelu
        add(l1);
        // Umeæemo polje za unos teksta, pa umeæemo praznu labelu da preskoèimo na sljedeæi element
        add(f1);
        add(new JLabel());
        // Umeæemo CheckBox. Nakon toga preskaèemo æeliju.
        add(b1);
        add(new JLabel());
        // Umeæemo panale sa svim RadioButtonima. 
        add(buttoni);
        // Umeæemo drugu labelu
        add(l2);
        // Umeæemo padajuæi izbornik pa preskaèemo æeliju.
        add(cb);
        add(new JLabel());
        // Centiramo tipku.
        add(b);
	}

	public static void main(String[] args) {
		try {
            SwingUtilities.invokeAndWait(new Runnable(){
                    public void run() {
                        // Stvori novi prozor (izvedi konstruktor)
                        TreciProzorGrid p = new TreciProzorGrid("Prijave");
                        // Prilagodi velèièinu prozora komponentama
                        p.pack();
                        // Prikaži prozor
                        p.setVisible(true);
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
