package hr.unidu.oop.p08;
import java.awt.*;
import javax.swing.*;

public class Izbori extends JFrame {
    private boolean isBold = false, isItalic = false;
    private JComboBox<String> jComboBox1;
    private JRadioButton jDa;
    private JRadioButton jNe;
    private JTextField tekst;
    private JSlider jSlider1;

    public Izbori() {
        ButtonGroup buttonGroup1 = new ButtonGroup();
        JPanel jPanel1 = new JPanel();
        JCheckBox jBold = new JCheckBox();
        JCheckBox jItalic = new JCheckBox();
        JPanel jPanel2 = new JPanel();
        jDa = new JRadioButton();
        jNe = new JRadioButton();
        JPanel jPanel3 = new JPanel();
        JLabel jLabel1 = new JLabel("Veli�ina");
        JLabel jLabel2 = new JLabel();
        jSlider1 = new JSlider(4, 40, 12);
        String[] m = { "Crna", "Crvena", "Plava", "Zelena" };
        jComboBox1 = new JComboBox<>(m);
        tekst = new JTextField();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // check boxovi
        jBold.setText("Bold");
        jBold.addActionListener(evt -> {
            isBold = !isBold;
                promijeniFont();
        });
        jPanel1.add(jBold);
        jItalic.setText("Italic");
        jItalic.addActionListener(evt -> {
            isItalic = !isItalic;
                promijeniFont();
        });
        jPanel1.add(jItalic);
        add(jPanel1, BorderLayout.PAGE_START);
        jPanel1.add(jLabel1);
        // slider za izbor veli�ine slova
        jSlider1.addChangeListener(evt -> {
            float vrij = (float)jSlider1.getValue();
            Font f = tekst.getFont();
            f = f.deriveFont(vrij);
            tekst.setFont(f);
        });
        jPanel1.add(jSlider1);

        // radio buttoni u grupi
        buttonGroup1.add(jDa);
        jDa.setText("Velika slova");
        jDa.addActionListener(evt -> {
            if (jDa.isSelected())
                tekst.setText(tekst.getText().toUpperCase());
        });
        
        jPanel2.add(jDa);
        buttonGroup1.add(jNe);
        jNe.setText("Mala slova");
        jNe.addActionListener(evt -> {
            if (jNe.isSelected())
                tekst.setText(tekst.getText().toLowerCase());
        });
        
        jPanel2.add(jNe);
        add(jPanel2, BorderLayout.PAGE_END);
        // box layout u vi�e redaka
        jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.Y_AXIS));
        jLabel2.setText("Boja");
        jPanel3.add(jLabel2);
        // padaju�a lista s vi�e izbora
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Crna", "Crvena", "Plava", "Zelena" }));
        jComboBox1.addActionListener(evt -> {
            String izab = (String)jComboBox1.getSelectedItem();
            if ("Crna".equals(izab))
                tekst.setForeground(Color.BLACK);
            else if ("Crvena".equals(izab))
                tekst.setForeground(Color.RED);
            else if ("Plava".equals(izab))
                tekst.setForeground(Color.BLUE);
            else if ("Zelena".equals(izab))
                tekst.setForeground(Color.GREEN);
                });
        jPanel3.add(jComboBox1);
        add(jPanel3, BorderLayout.LINE_END);
        tekst.setText("Ovo je probni tekst za oblikovanje");
        add(tekst, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
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

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new Izbori().setVisible(true));
    }
}
