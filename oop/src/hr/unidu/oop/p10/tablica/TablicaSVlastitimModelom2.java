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
import java.util.Collections;
import java.util.List;

public class TablicaSVlastitimModelom2 extends JFrame {

    private JTable t;
    private boolean prva = true;
    private OsobaModel2 sm;


    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(() -> {
                TablicaSVlastitimModelom2 frame = new TablicaSVlastitimModelom2("Tablica s vlastitim modelom 2", true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public TablicaSVlastitimModelom2(String n, boolean zatvori) {
		this(n);
		if (zatvori) setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public TablicaSVlastitimModelom2(String n) {
        super(n);
        JPanel cp = new JPanel();
        JPanel cp1 = new JPanel();
        t = new JTable();
        t.setAutoCreateRowSorter(true);
        t.setRowHeight(120);
        sm = new OsobaModel2(PunjacSlika.napuniListuOsoba());

        sm.addTableModelListener(e -> {
                if (t.getSelectedRow() < 0)
                    return;
                System.out.println("TR: " + t.getSelectedRow());
                // Povezuje indeks retka tablice s indeksom retka u modelu
                // Ako su podaci sortirani, indeksi nisu jednaki!
                int brSr = t.convertRowIndexToModel(t.getSelectedRow());
                // Povezuje indeks stupca tablice s indeksom stupca u modelu
                // Indeksi su različiti ako im j epromijenjen redosljed!
                int brSs = t.convertColumnIndexToModel(t.getSelectedColumn());
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
        getContentPane().add(cp, BorderLayout.NORTH);
        JButton doh = new JButton("Obradi");

        doh.addActionListener(e -> obradiTablicu(t));
        cp1.add(doh);
        JButton dod = new JButton("Dodaj novi red");

        dod.addActionListener(e -> {
                if (prva) {
                    sm.addRow(new Osoba("Mara", "Marić", PunjacSlika.OSOBA1, 43));
                } else {
                    sm.addRow(new Osoba("Iva", "Ivić", PunjacSlika.OSOBA2, 26));
                }
                prva = !prva;
                // Ažuriraj tablicu nakon promjene modela
                sm.fireTableDataChanged();
        });
        JButton obr = new JButton("Obriši izabrane");

        obr.addActionListener(e -> {
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
                for (Integer i : selection)
                    sm.removeRow(i);
                // Ažuriraj tablicu nakon promjene modela
                sm.fireTableDataChanged();
        });
        cp1.add(doh);
        cp1.add(dod);
        cp1.add(obr);
        getContentPane().add(cp1, BorderLayout.SOUTH);
        
        setVisible(true);
		setLocationRelativeTo(null);
		pack();
    }

    private void obradiTablicu(JTable t) {
        int brRed = t.getRowCount();
        int brStup = t.getColumnCount();
        // Povezuje indeks retka tablice s indeksom retka u modelu
        // Ako su podaci sortirani, indeksi nisu jednaki!
        int brSr = t.convertRowIndexToModel(t.getSelectedRow());
        // Povezuje indeks stupca tablice s indeksom stupca u modelu
        // Indeksi su različiti ako im j epromijenjen redosljed!
        int brSs = t.convertColumnIndexToModel(t.getSelectedColumn());

        TableModel model = t.getModel();
        System.out.println("Dohvaćanje podataka iz tablice: ");
        for (int i = 0; i < brSr; i++) {
            System.out.print("    redak " + i + ":");
            for (int j = 0; j < brSs; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    private void obradiCeliju(JTable t) {
        TableModel model = t.getModel();
        int brRed = model.getRowCount();
        int brStup = model.getColumnCount();
        // Povezuje indeks retka tablice s indeksom retka u modelu
        // Ako su podaci sortirani, indeksi nisu jednaki!
        int brSr = t.convertRowIndexToModel(t.getSelectedRow());
        // Povezuje indeks stupca tablice s indeksom stupca u modelu
        // Indeksi su različiti ako im j epromijenjen redosljed!
        int brSs = t.convertColumnIndexToModel(t.getSelectedColumn());
        System.out.println("Dohvaćanje podataka iz retka " + brSr);
        for (int j = 0; j < brSs; j++) {
            System.out.print("  " + model.getValueAt(brSr, j));
        }
        System.out.println();
        System.out.println("Dohvaćanje podataka iz izabrane ćelije: " + model.getValueAt(brSr, brSs));
        System.out.println("--------------------------");
    }

}
