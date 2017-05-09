package lista;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class DefaultniModel2 extends JFrame {

    private JPanel cp;
    private DefaultListModel<Student> mod;
    
    public static void main(String[] args) {
        try {
               SwingUtilities.invokeAndWait(new Runnable(){
                 public void run() {
                    DefaultniModel2 frame = new DefaultniModel2("Defaultni model studenata");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                 }
               });
            } catch (InvocationTargetException e) {
              e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
    }

    public DefaultniModel2(String n) {
        super(n);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp = new JPanel();
        mod = new DefaultListModel<>();
        napuniModel();
        JList<Student> l1 = new JList<>(mod);
        l1.setVisibleRowCount(4);
        JScrollPane pp = new JScrollPane(l1);
            
        getContentPane().add(pp,BorderLayout.NORTH);
        getContentPane().add(cp,BorderLayout.SOUTH);
        JButton dod = new JButton("Dodaj na kraj");
        dod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s = new Student("Posljednji","Upisani");
                mod.addElement(s);
                l1.setSelectedValue(s, true);
            }
        });
        JButton dod1 = new JButton("Dodaj iza");
        dod1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s = new Student("Drugi","Upisan");
                int poz = l1.getSelectedIndex();
                mod.add(poz+1,s);
                l1.setSelectedIndex(poz+1);
            }
        });
        JButton dod2 = new JButton("Obriši");
        dod2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (l1.getSelectedIndex() > -1)
                    mod.remove(l1.getSelectedIndex());
            }
        });
        JButton dod3 = new JButton("Izmjeni");
        dod3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s = new Student("Prvi","Upisan");
                if (l1.getSelectedIndex() > -1)
                    mod.set(l1.getSelectedIndex(), s);
            }
        });
        cp.add(dod);
        cp.add(dod1);
        cp.add(dod2);
        cp.add(dod3);
    }
    private void napuniModel(){
        mod.addElement(new Student("Pero", "Perić"));
        mod.addElement(new Student("Ana", "Anić"));
        mod.addElement(new Student("Bero", "Berić"));
        mod.addElement(new Student("Vlaho", "Vlahić"));
        mod.addElement(new Student("Miki", "Mikić"));
    }
}
