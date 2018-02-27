package hr.unidu.oop.p10.tablica;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

import hr.unidu.oop.p10.Osoba;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class TablicaSVlastitimModelom extends JFrame {

	private JPanel cp, cp1;
	private final String PERO = "slike/pero.jpg";
    private final String BERO = "slike/bero.jpg";
    private final String VLAHO = "slike/vlaho.jpg";
    private final String IVO = "slike/ivo.jpg";
    private final String ANA = "slike/ana.jpg";
	
	public static void main(String[] args) {
		try {
		       SwingUtilities.invokeAndWait(new Runnable(){
		         public void run() {
		        	TablicaSVlastitimModelom frame = new TablicaSVlastitimModelom("Tablica s vlastitim modelom");
		        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					frame.pack();
		         }
		       });
		    } catch (InvocationTargetException e) {
		      e.printStackTrace();
		    } catch (Exception e){
		    	e.printStackTrace();
		    }
	}

	public TablicaSVlastitimModelom(String n) {
		super(n);
		cp = new JPanel();
		cp1 = new JPanel();
		JTable t = new JTable();
		t.setAutoCreateRowSorter(true);
		List<Osoba> studenti = new ArrayList<>();
		napuniPolje(studenti);
		OsobaModel sm = new OsobaModel(studenti);
		t.setModel(sm);
		t.setPreferredScrollableViewportSize(new Dimension(300, 80));
        t.setFillsViewportHeight(true);
        t.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                obradiCeliju(t);
            }
        });
        
        JScrollPane pp = new JScrollPane(t);
		cp.add(pp);
		getContentPane().add(cp,BorderLayout.NORTH);
		JButton doh = new JButton("Obradi");
		doh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				obradiTablicu(t);
			}
		});
		cp1.add(doh);
		getContentPane().add(cp1,BorderLayout.SOUTH);
	}
	private void obradiTablicu(JTable t){
		int brRed = t.getRowCount();
        int brStup = t.getColumnCount();
        TableModel model = t.getModel();
        System.out.println("Dohvaćanje podataka iz tablice: ");
        for (int i=0; i < brRed; i++) {
            System.out.print("    redak " + i + ":");
            for (int j=0; j < brStup; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
	}
	private void obradiCeliju(JTable t){
        TableModel model = t.getModel();
        int brRed = model.getRowCount();
        int brStup = model.getColumnCount();
        // Povezuje indeks retka tablice s indeksom retka u modelu
        // Ako podaci nisu sortirani, indeksi su jednaki!
		int brSr = t.convertRowIndexToModel(t.getSelectedRow());
		int brSs = t.getSelectedColumn();
        System.out.println("Dohvaćanje podataka iz retka " + brSr);
        for (int j=0; j < brStup; j++) {
            System.out.print("  " + model.getValueAt(brSr, j));
        }
        System.out.println();
        System.out.println("Dohvaćanje podataka iz izabrane ćelije: " + model.getValueAt(brSr, brSs));
        System.out.println("--------------------------");
	}
	private void napuniPolje(List<Osoba> st){
		st.add(new Osoba("Pero", "Perić", PERO, 49));
		st.add(new Osoba("Ana", "Anić", ANA, 19));
		st.add(new Osoba("Bero", "Berić", BERO, 37));
		st.add(new Osoba("Vlaho", "Vlahić", VLAHO, 72));
		st.add(new Osoba("Ivo", "Ivić", IVO, 18));
	}
}
