package hr.unidu.oop.p10.lista;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingUtilities;

import hr.unidu.oop.p10.Osoba;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class DefaultniModelSlike extends JFrame {

    private JPanel cp;
    private DefaultListModel<Osoba> mod;
	private final String PERO = "slike/pero.jpg";
    private final String BERO = "slike/bero.jpg";
    private final String VLAHO = "slike/vlaho.jpg";
    private final String IVO = "slike/ivo.jpg";
    private final String IVA = "slike/iva.jpg";
    private final String ANA = "slike/ana.jpg";
    private final String MARA = "slike/mara.jpg";
    private final String VEDRANA = "slike/vedrana.jpg";
    
    public static void main(String[] args) {
        try {
               SwingUtilities.invokeAndWait(new Runnable(){
                 public void run() {
                    DefaultniModelSlike frame = new DefaultniModelSlike("Defaultni model osoba");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    frame.pack();
                 }
               });
            } catch (InvocationTargetException e) {
              e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
    }

    public DefaultniModelSlike(String n) {
        super(n);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp = new JPanel();
        mod = new DefaultListModel<>();
        napuniModel();
        JList<Osoba> l1 = new JList<>(mod);
        l1.setVisibleRowCount(4);
        l1.setCellRenderer(new CrtacRetka());
        JScrollPane pp = new JScrollPane(l1);
            
        getContentPane().add(pp,BorderLayout.NORTH);
        getContentPane().add(cp,BorderLayout.SOUTH);
        JButton dod = new JButton("Dodaj na kraj");
//        dod.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Osoba s = new Osoba("Mara", "Marić", MARA, 43);
//                mod.addElement(s);
//                l1.setSelectedValue(s, true);
//            }
//        });
        dod.addActionListener(e ->{
                Osoba s = new Osoba("Mara", "Marić", MARA, 43);
                mod.addElement(s);
                l1.setSelectedValue(s, true);
        });
        JButton dod1 = new JButton("Dodaj iza");
//        dod1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Osoba s = new Osoba("Iva", "Ivić", IVA, 26);
//                int p = l1.getSelectedIndex();
//                mod.add(p+1,s);
//                l1.setSelectedIndex(p+1);
//            }
//        });
        dod1.addActionListener(e -> {
                Osoba s = new Osoba("Iva", "Ivić", IVA, 26);
                int p = l1.getSelectedIndex();
                mod.add(p+1,s);
                l1.setSelectedIndex(p+1);
        });
        JButton dod2 = new JButton("Obriši");
//        dod2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (l1.getSelectedIndex() > -1)
//                    mod.remove(l1.getSelectedIndex());
//            }
//        });
        dod2.addActionListener(e -> {
                if (l1.getSelectedIndex() > -1)
                    mod.remove(l1.getSelectedIndex());
        });
        JButton dod3 = new JButton("Izmjeni");
//        dod3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Osoba s = new Osoba("Vedrana", "Vedrić", VEDRANA, 35);
//                if (l1.getSelectedIndex() > -1)
//                    mod.set(l1.getSelectedIndex(), s);
//            }
//        });
        dod3.addActionListener(e -> {
                Osoba s = new Osoba("Vedrana", "Vedrić", VEDRANA, 35);
                if (l1.getSelectedIndex() > -1)
                    mod.set(l1.getSelectedIndex(), s);
        });
        cp.add(dod);
        cp.add(dod1);
        cp.add(dod2);
        cp.add(dod3);
    }
    private void napuniModel(){
		mod.addElement(new Osoba("Pero", "Perić", PERO, 49));
		mod.addElement(new Osoba("Ana", "Anić", ANA, 19));
		mod.addElement(new Osoba("Bero", "Berić", BERO, 37));
		mod.addElement(new Osoba("Vlaho", "Vlahić", VLAHO, 72));
		mod.addElement(new Osoba("Ivo", "Ivić", IVO, 18));
    }
}
