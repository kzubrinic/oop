package hr.unidu.oop.p07;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
public class Izbori extends JFrame {
    private boolean isBold = false, isItalic = false;
    private ButtonGroup buttonGroup1;
    private JCheckBox jBold;
    private JComboBox<String> jComboBox1;
    private JRadioButton jDa;
    private JCheckBox jItalic;
    private JLabel jLabel2;
    private JLabel jLabel1;
    private JRadioButton jNe;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JTextField tekst;
    private JSlider jSlider1;

    public Izbori() {
        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        jBold = new JCheckBox();
        jItalic = new JCheckBox();
        jPanel2 = new JPanel();
        jDa = new JRadioButton();
        jNe = new JRadioButton();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel("Veli�ina");
        jLabel2 = new JLabel();
        jSlider1 = new JSlider(4, 40, 12);
        String[] m = { "Crna", "Crvena", "Plava", "Zelena" };
        jComboBox1 = new JComboBox<>(m);
        tekst = new JTextField();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // check boxovi
        jBold.setText("Bold");
        jBold.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                isBold = !isBold;
                    promijeniFont();
            }
        });
        jPanel1.add(jBold);
        jItalic.setText("Italic");
        jItalic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                isItalic = !isItalic;
                    promijeniFont();
            }
        });
        jPanel1.add(jItalic);
        add(jPanel1, BorderLayout.PAGE_START);
        jPanel1.add(jLabel1);
        // slider za izbor veli�ine slova
        jSlider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                float vrij = (float)jSlider1.getValue();
                Font f = tekst.getFont();
                f = f.deriveFont(vrij);
                tekst.setFont(f);
            }
        });
        jPanel1.add(jSlider1);

        // radio buttoni u grupi
        buttonGroup1.add(jDa);
        jDa.setText("Velika slova");
        jDa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (jDa.isSelected())
                    tekst.setText(tekst.getText().toUpperCase());
            }
        });
        
        jPanel2.add(jDa);
        buttonGroup1.add(jNe);
        jNe.setText("Mala slova");
        jNe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (jNe.isSelected())
                    tekst.setText(tekst.getText().toLowerCase());
            }
        });
        
        jPanel2.add(jNe);
        add(jPanel2, BorderLayout.PAGE_END);
        // box layout u vi�e redaka
        jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.Y_AXIS));
        jLabel2.setText("Boja");
        jPanel3.add(jLabel2);
        // padaju�a lista s vi�e izbora
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Crna", "Crvena", "Plava", "Zelena" }));
        jComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String izab = (String)jComboBox1.getSelectedItem();
                if (izab.equals("Crna"))
                    tekst.setForeground(Color.BLACK);
                else if (izab.equals("Crvena"))
                    tekst.setForeground(Color.RED);
                else if (izab.equals("Plava"))
                    tekst.setForeground(Color.BLUE);
                else if (izab.equals("Zelena"))
                    tekst.setForeground(Color.GREEN);
                    }
        });
        jPanel3.add(jComboBox1);
        add(jPanel3, BorderLayout.LINE_END);
        tekst.setText("Ovo je probni tekst za oblikovanje");
        add(tekst, BorderLayout.CENTER);
        pack();
    }                                      

    private void promijeniFont(){
        Font f = tekst.getFont();
        if (isBold && isItalic)
            f = f.deriveFont(Font.BOLD+Font.ITALIC);
        else if (isBold && !isItalic)
            f = f.deriveFont(Font.BOLD);
        else if (!isBold && isItalic)
            f = f.deriveFont(Font.ITALIC);
        else
            f = f.deriveFont(Font.PLAIN);
        //f = new Font(ime, stil, velicina);
        tekst.setFont(f);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Izbori().setVisible(true);
            }
        });
    }
}
