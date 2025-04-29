package hr.unidu.oop.p10.tablica;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

import hr.unidu.oop.p10.Osoba;
import hr.unidu.oop.p10.PunjacSlika;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TablicaSVlastitimModelom extends JFrame {

	public static void main(String[] args) {
		try {
		       SwingUtilities.invokeLater(() -> {
				  TablicaSVlastitimModelom frame = new TablicaSVlastitimModelom("Tablica s vlastitim modelom", true);
			   });
		    } catch (Exception e){
		    	e.printStackTrace();
		    }
	}
	public TablicaSVlastitimModelom(String n, boolean zatvori) {
		this(n);
		if (zatvori) setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public TablicaSVlastitimModelom(String n) {
		super(n);
		JPanel cp = new JPanel();
		JPanel cp1 = new JPanel();
		JTable t = new JTable();
		t.setAutoCreateRowSorter(true);
		OsobaModel sm = new OsobaModel(PunjacSlika.napuniListuOsoba());
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

		doh.addActionListener(e -> obradiTablicu(t));
		cp1.add(doh);
		getContentPane().add(cp1,BorderLayout.SOUTH);
		
		setVisible(true);
		setLocationRelativeTo(null);
		pack();
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
        // Ako su podaci sortirani, indeksi nisu jednaki!
		int brSr = t.convertRowIndexToModel(t.getSelectedRow());
		// Povezuje indeks stupca tablice s indeksom stupca u modelu
		// Indeksi su različiti ako im je promijenjen redosljed!
		int brSs = t.convertColumnIndexToModel(t.getSelectedColumn());
        System.out.println("Dohvaćanje podataka iz retka " + brSr);
        for (int j=0; j < brSs; j++) {
            System.out.print("  " + model.getValueAt(brSr, j));
        }
        System.out.println();
        System.out.println("Dohvaćanje podataka iz izabrane ćelije: " + model.getValueAt(brSr, brSs));
        System.out.println("--------------------------");
	}

}
