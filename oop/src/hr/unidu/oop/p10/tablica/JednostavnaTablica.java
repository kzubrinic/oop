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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;

public class JednostavnaTablica extends JFrame {

	private JPanel cp, cp1;
	private final String PERO = "slike/pero.jpg";
    private final String BERO = "slike/bero.jpg";
    private final String VLAHO = "slike/vlaho.jpg";
    private final String IVO = "slike/ivo.jpg";
    private final String IVA = "slike/iva.jpg";
    private final String ANA = "slike/ana.jpg";
	
	public static void main(String[] args) {
		try {
		       SwingUtilities.invokeAndWait(new Runnable(){
		         public void run() {
		        	JednostavnaTablica frame = new JednostavnaTablica("Jednostavna tablica");
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

	public JednostavnaTablica(String n) {
		super(n);
		
		cp = new JPanel();
		cp1 = new JPanel();
		String[] stupci = {"Ime", "Prezime", "Slika"};

		Object[][] podaci = {{"Pero", "Perić", PERO},
		{"Ana", "Anić", ANA},
		{"Ivo", "Ivić", IVO},
		{"Bero", "Berić", BERO},
		{"Ivo", "Ivić", IVA},
		{"Vlaho", "Vlahić", VLAHO}};
		
		JTable t = new JTable(podaci, stupci);
		t.setAutoCreateRowSorter(true);
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
	    // Pretvara indeks retka u tablicu u indeks retka u modelu.
	    // Ako podaci nisu sortirani, indeksi su jednaki.
		int brSr = t.convertRowIndexToModel(t.getSelectedRow());
		int brSs = t.getSelectedColumn();
        int brRed = t.getRowCount();
        int brStup = t.getColumnCount();
        TableModel model = t.getModel();
        System.out.println("Dohvaćanje podataka iz retka " + brSr);
        for (int j=0; j < brStup; j++) {
            System.out.print("  " + model.getValueAt(brSr, j));
        }
        System.out.println();
        System.out.println("Dohvaćanje podataka iz izabrane ćelije: " + model.getValueAt(brSr, brSs));
        System.out.println("--------------------------");
	}
}
