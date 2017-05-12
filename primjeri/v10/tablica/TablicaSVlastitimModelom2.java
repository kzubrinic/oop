package tablica;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TablicaSVlastitimModelom2 extends JFrame {

	private JPanel cp, cp1;
	private JTable t;
	private StudentModel2 sm;
	
	public static void main(String[] args) {
		try {
		       SwingUtilities.invokeAndWait(new Runnable(){
		         public void run() {
		        	TablicaSVlastitimModelom2 frame = new TablicaSVlastitimModelom2("Tablica s vlastitim modelom 2");
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

	public TablicaSVlastitimModelom2(String n) {
		super(n);
		cp = new JPanel();
		cp1 = new JPanel();
		t = new JTable();
		t.setAutoCreateRowSorter(true);
		t.setRowHeight(120);
		List<Student2> studenti = new ArrayList<>();
		napuniPolje(studenti);
		sm = new StudentModel2(studenti);
		sm.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
			    // Povezivanje indeksa retka na koji je kliknuto s retkom u modelu
			    // Ako podaci nisu sortirani, indeksi su isti!
				int brSr = t.convertRowIndexToModel(t.getSelectedRow());
				int brSs = t.getSelectedColumn();
				
				
			}
		});
		t.setModel(sm);
		t.setPreferredScrollableViewportSize(new Dimension(360, 300));
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
		JButton dod = new JButton("Dodaj novi red");
		dod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sm.addRow(new Student2("Novi", "Student", "1.jpg"));
				// Ažuriraj tablicu nakon promjene modela
				sm.fireTableDataChanged();
			}
		});
		JButton obr = new JButton("Obriši izabrane");
		obr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Brišemo sve izabrane retke
				int[] izabrani = t.getSelectedRows();
				// indekse moramo sortirati u silaznom redosljedu jer sa svakim brisanjem
				//	kolekcija ima jedan element manje. Jedini ispravan rezultat je ako se
				//	elementi brišu jednapo jedan počevši od zadnjeg prema prvom.
				List<Integer> selection = new ArrayList<>(izabrani.length);
                for (int row : izabrani) {
                    selection.add(t.convertRowIndexToModel(row));
                }
                Collections.sort(selection);
                Collections.reverse(selection);
                // Brišemo jedan po jedan element
				for (Integer i: selection)
					sm.removeRow(i);
				// Ažuriraj tablicu nakon promjene modela
				sm.fireTableDataChanged();
			}
		});
		cp1.add(doh);
		cp1.add(dod);
		cp1.add(obr);
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
	private void napuniPolje(List<Student2> st){
		st.add(new Student2("Pero", "Perić", "1.jpg"));
        st.add(new Student2("Ana", "Anić", "2.jpg"));
        st.add(new Student2("Bero", "Berić", "3.jpg"));
        st.add(new Student2("Vlaho", "Vlahić", "4.jpg"));
        st.add(new Student2("Miki", "Mikić", "2.jpg"));
	}
}
