package hr.unidu.oop.p07;
import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
public class TreciProzor extends JFrame {
    String[] s = {"Pojedina�ne poruke", "Poruke u paketu"}; 
    private JLabel l1, l2;
    private JTextField f1;
    private JCheckBox b1;
    private JRadioButton rb1, rb2;
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
            SwingUtilities.invokeAndWait(new Runnable(){
                    public void run() {
                        // Stvori novi prozor (izvedi konstruktor)
                        TreciProzor p = new TreciProzor("Prijave");
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

    private void pripremiKomponente(){
        // stvori dvije nove labele
        l1 = new JLabel("E-mail");
        l2 = new JLabel("Oblik poruke");
        // Stvori polje z aunos teksta (e-mail)
        f1 = new JTextField(20);
        // Stvori checkBox
        b1 =  new JCheckBox("�elim primati poruke");
        // Stvori grupu radioButtona i 2 radioButtona
        ButtonGroup grupa = new ButtonGroup();
        rb1 = new JRadioButton("Jednom dnevno");
        rb2 = new JRadioButton("Jednom tjedno");
        // Dodaj stvorene buttone u grupu. Grupa upravlja buttonima
        // primjerice osigurava da samo 1 button mo�e u jednom trenutku
        // biti izabran. Grupa NIJE grafi�ka komponenta!
        grupa.add(rb1);
        grupa.add(rb2); 
        // Stvori kontejner u koji �emo staviti sve radioButtone
        buttoni = new JPanel();
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
        // Ozna�avmo prvi element polja aktivnim.
        cb.setSelectedIndex(0);
        // Stvaramo novu tipku.
        b = new JButton("U redu");
    }
    private void napuniKontejner(){
        // Postavi ovaj prozor na zadanu lokaciju
        setLocation(100, 100);
        // Nakon �to zavtvorimo prozor, neka program zavr�i.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Postavljamo Miglayout (nije standardni layout. da bi se mogao
        // koristiti moramo skinuti jar paket s adrese http://www.migcalendar.com/miglayout/versions/4.0/miglayout-4.0-swing.jar
        // nakon toga uklju�iti paket zajedno s drugim importima na po�etku programa
        //   import net.miginfocom.swing.MigLayout;
        setLayout(new MigLayout());
        // Na prozor ume�mo prvu labelu
        add(l1);
        // Ume�emo polje za unos teksta, pa prelazimo u novi red (wrap)
        add(f1, "wrap");
        // Preska�emo 1. stupac (skip 1), pa u drugi ume�emo CheckBox. Nakon toga prelazimo u novi red.
        add(b1, "skip 1, wrap");
        // Preska�emo 1. stupac (skip 1), pa u drugi ume�emo panale sa svim RadioButtonima. Nakon toga prelazimo u novi red.
        add(buttoni, "skip 1, wrap");
        // Ume�emo drugu labelu
        add(l2);
        // Ume�emo padaju�i izbornik pa prelazimo u novi red.
        add(cb, "wrap ");
        // Centiramo tipku.
        add(b, "spanx 2, align center");
    }
} 
