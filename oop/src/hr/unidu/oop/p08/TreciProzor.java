package hr.unidu.oop.p08;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;
public class TreciProzor extends JFrame {
    String[] s = {"Pojedinačne poruke", "Poruke u paketu"}; 
    private JLabel l1, l2;
    private JTextField f1;
    private JCheckBox b1;
    private JPanel buttoni;
    private JComboBox<String> cb;
    private JButton b;
    public TreciProzor(String t){
        super(t);
        pripremiKomponente();
        napuniKontejner();
    }

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(() -> {
                // Stvori novi prozor (izvedi konstruktor)
                TreciProzor p = new TreciProzor("Prijave");
                // Prilagodi veličinu prozora komponentama
                p.pack();
                p.setLocationRelativeTo(null);
                // Prikaži prozor
                p.setVisible(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pripremiKomponente(){
        // stvori dvije nove labele
        l1 = new JLabel("E-mail");
        l2 = new JLabel("Oblik poruke");
        // Stvori polje z aunos teksta (e-mail)
        f1 = new JTextField(20);
        // Stvori checkBox
        b1 =  new JCheckBox("Želim primati poruke");
        // Stvori grupu radioButtona i 2 radioButtona
        ButtonGroup grupa = new ButtonGroup();
        JRadioButton rb1 = new JRadioButton("Jednom dnevno");
        JRadioButton rb2 = new JRadioButton("Jednom tjedno");
        // Dodaj stvorene buttone u grupu. Grupa upravlja buttonima
        // primjerice osigurava da samo 1 button može u jednom trenutku
        // biti izabran. Grupa NIJE grafička komponenta!
        grupa.add(rb1);
        grupa.add(rb2); 
        // Stvori kontejner u koji ćemo staviti sve radioButtone
        buttoni = new JPanel();
        // Staviti ćemo ih jedna ispod drugoga pa mijenjamo layout
        // u "okomiti" (BoxLayout po Y osi)
        buttoni.setLayout(new BoxLayout(buttoni,BoxLayout.Y_AXIS));
        // Iscrtavaamo okvir oko grupe buttona sa zadanim naslovom
        buttoni.setBorder(BorderFactory.createTitledBorder("Koliko često?"));
        //buttoni.setBorder(BorderFactory.createLineBorder(Color.black));
        // Umećemo buttone u stvoreni kontejner
        buttoni.add(rb1);
        buttoni.add(rb2);
        // Stvaramo padajući izbornik i popunjavamo ga Stringovima iz polja.
        cb = new JComboBox<>(s);
        // Označavmo prvi element polja aktivnim.
        cb.setSelectedIndex(0);
        // Stvaramo novu tipku.
        b = new JButton("U redu");
    }
    private void napuniKontejner(){
        // Postavi ovaj prozor na zadanu lokaciju
        setLocation(100, 100);
        // Nakon što zavtvorimo prozor, neka program završi.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Postavljamo Miglayout (nije standardni layout. da bi se mogao
        // koristiti moramo skinuti jar paket s adrese http://www.migcalendar.com/miglayout/versions/4.0/miglayout-4.0-swing.jar
        // nakon toga uključiti paket zajedno s drugim importima na početku programa
        //   import net.miginfocom.swing.MigLayout;
        setLayout(new MigLayout());
        // Na prozor umećmo prvu labelu
        add(l1);
        // Umećemo polje za unos teksta, pa prelazimo u novi red (wrap)
        add(f1, "wrap");
        // Preskačemo 1. stupac (skip 1), pa u drugi umećemo CheckBox. Nakon toga prelazimo u novi red.
        add(b1, "skip 1, wrap");
        // Preskačemo 1. stupac (skip 1), pa u drugi umećemo panale sa svim RadioButtonima. Nakon toga prelazimo u novi red.
        add(buttoni, "skip 1, wrap");
        // Umećemo drugu labelu
        add(l2);
        // Umećemo padajući izbornik pa prelazimo u novi red.
        add(cb, "wrap ");
        // Centiramo tipku.
        add(b, "spanx 2, align center");
    }
} 