package hr.unidu.oop.p10.tablica;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import hr.unidu.oop.p10.Osoba;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TablicaIzDatoteke extends JFrame {
	private SwingWorker<List<Osoba>, Void> cs;
	private SwingWorker<Boolean, Void> cd;
	private OsobaModel sm = new OsobaModel();
	private TablicaIzDatotekeObrada to = new TablicaIzDatotekeObrada();
	private JTable t;
	private JTextField fime, fprezime, fslika;
	public static void main(String[] args) {
		try {
		       SwingUtilities.invokeAndWait(() -> {
		    	   TablicaIzDatoteke frame = new TablicaIzDatoteke("Tablica s vlastitim modelom", true);
			   });
		    } catch (Exception e){
		    	e.printStackTrace();
		    }
	}
	public TablicaIzDatoteke(String n, boolean zatvori) {
		this(n);
		if (zatvori) setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public TablicaIzDatoteke(String n) {
		super(n);
		JPanel cp = new JPanel();
		JPanel cp1 = new JPanel();
		JPanel lijevi = new JPanel();
		lijevi.setLayout(new BorderLayout());
		JPanel desni = new JPanel();
		napuniDesniPanel(desni);
		t = new JTable();
		t.setAutoCreateRowSorter(true);
		
		t.setPreferredScrollableViewportSize(new Dimension(300, 100));
        t.setFillsViewportHeight(true);
        t.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                izaberiRedak(t);
            }
        });
    
        JScrollPane pp = new JScrollPane(t);
		cp.add(pp);
		lijevi.add(cp,BorderLayout.NORTH);
		JButton doh = new JButton("Učitaj");
		JButton dos = new JButton("Spremi");

		doh.addActionListener(e -> {
			ucitaj();
		});
		dos.addActionListener(e -> {
			spremi();
		});
		cp1.add(doh);
		cp1.add(dos);
		lijevi.add(cp1,BorderLayout.SOUTH);
		add(lijevi,BorderLayout.WEST);
		add(desni,BorderLayout.EAST);
		
		setVisible(true);
		setLocationRelativeTo(null);
		//setSize(340, 200);
		pack();
	}
	private void napuniDesniPanel(JPanel p) {
		JLabel l1 = new JLabel("Ime");
		JLabel l2 = new JLabel("Prezime");
		JLabel l3 = new JLabel("Slika");
		fime = new JTextField(20);
		fprezime = new JTextField(20);
		fslika = new JTextField(20);
		JButton bInsert = new JButton("Dodaj");
		bInsert.addActionListener(e -> {
			dodaj(t);
		});
		JButton bAzur = new JButton("Spremi");
		bAzur.addActionListener(e -> {
			azuriraj(t);
		});
		JButton bBrisi = new JButton("Briši");
		bBrisi.addActionListener(e -> {
			brisi(t);
		});
		JButton bOci = new JButton("Očisti");
		bOci.addActionListener(e -> {
			fime.setText("");
			fprezime.setText("");
			fslika.setText("");
		});
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(l1);
		p.add(fime);
		p.add(l2);
		p.add(fprezime);
		p.add(l3);
		p.add(fslika);
		JPanel tipke = new JPanel();
		tipke.add(bInsert);
		tipke.add(bAzur);
		tipke.add(bBrisi);
		tipke.add(bOci);
		p.add(tipke);
	}
	public void napuniModel(List<Osoba> l) {
		sm = new OsobaModel(l);
		t.setModel(sm);
	}
	public void spremanjeZavrsilo(boolean b) {
		String poruka = b?"Spremanje uspješno":"Greška kod spremanja!";
		JOptionPane.showMessageDialog(this,poruka);  
	}

	private void izaberiRedak(JTable t){
        Osoba o = to.izaberiRedak(t);
        fime.setText(o.getIme());
        fprezime.setText(o.getPrezime());
   		fslika.setText(o.getSlika());
	}
	private void azuriraj(JTable t) {
		Osoba nova = new Osoba();
        nova.setIme(fime.getText());
        nova.setPrezime(fprezime.getText());
        nova.setSlika(fslika.getText());
        to.azuriraj(t, nova);
	}
	private void dodaj(JTable t) {
		Osoba nova = new Osoba();
        nova.setIme(fime.getText());
        nova.setPrezime(fprezime.getText());
        nova.setSlika(fslika.getText());
        to.dodaj(t, nova);

	}
	private void brisi(JTable t) {
		to.brisi(t);
	}
	private void ucitaj() {
		cs = new CitacDatoteke("baza/osobe.txt", this);
		cs.execute();
	}
	private void spremi() {
		if(sm != null && sm.getKolekcija() != null) {
			cd = new SpremacDatoteke("baza/osobe.bak", sm.getKolekcija(), this);
			cd.execute();
		}else {
			spremanjeZavrsilo(false);
		}
	}
}
