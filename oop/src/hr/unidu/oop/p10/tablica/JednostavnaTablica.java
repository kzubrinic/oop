package hr.unidu.oop.p10.tablica;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JednostavnaTablica extends JFrame {

	public static void main(String[] args) {
		try {
		       SwingUtilities.invokeAndWait(() -> {
				  JednostavnaTablica frame = new JednostavnaTablica("Jednostavna tablica");
				  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				  frame.setVisible(true);
				  frame.setLocationRelativeTo(null);
				  frame.pack();
			   });
		    } catch (Exception e){
		    	e.printStackTrace();
		    }
	}

	public JednostavnaTablica(String n) {
		super(n);

		JPanel cp = new JPanel();
		JPanel cp1 = new JPanel();
		String[] stupci = {"Ime", "Prezime", "Slika"};

		String ANA = "slike/ana.jpg";
		String IVA = "slike/iva.jpg";
		String IVO = "slike/ivo.jpg";
		String VLAHO = "slike/vlaho.jpg";
		String BERO = "slike/bero.jpg";
		String PERO = "slike/pero.jpg";
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
//		doh.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				obradiTablicu(t);
//			}
//		});
		doh.addActionListener(e -> obradiTablicu(t));
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
