package hr.unidu.oop.p10.stablo;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import hr.unidu.oop.p10.Osoba;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Stablo extends JFrame {

	private JPanel cp, cp1;
	private JTree t;
	private JTextField tPrezime;
	private JTextField tIme;
	private JTextField tStarost;
	private JLabel lblSlika;
	private final String PERO = "slike/pero.jpg";
    private final String BERO = "slike/bero.jpg";
    private final String VLAHO = "slike/vlaho.jpg";
    private final String IVO = "slike/ivo.jpg";
    private final String ANA = "slike/ana.jpg";


	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run() {
					Stablo frame = new Stablo("Stablo");
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

	public Stablo(String n) {
		super(n);
		cp = new JPanel();
		cp1 = new JPanel();

		List<Osoba> studenti = new ArrayList<>();
		napuniPolje(studenti);
		DefaultMutableTreeNode m = napuniModel(studenti);
		t = new JTree(m);
		t.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				izborStudenta(e);
			}
		});
		JScrollPane pp = new JScrollPane(t);
		cp1.add(pp);
		getContentPane().add(cp1,BorderLayout.WEST);
		getContentPane().add(cp);
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		JLabel lblIme = new JLabel("Ime");
		JLabel lblPrezime = new JLabel("Prezime");
		JLabel lblSt = new JLabel("Starost");
		cp.add(lblIme);
		tIme = new JTextField(30);
		tIme.setMaximumSize( tIme.getPreferredSize() );
		cp.add(tIme);
		cp.add(lblPrezime);
		tPrezime = new JTextField(30);
		tPrezime.setMaximumSize( tPrezime.getPreferredSize() );
		cp.add(tPrezime);
		cp.add(lblSt);
		tStarost = new JTextField(10);
		tStarost.setMaximumSize(tStarost.getPreferredSize() );
		cp.add(tStarost);
		lblSlika = new JLabel();
		cp.add(lblSlika);

	}

	private void napuniPolje(List<Osoba> st){
		st.add(new Osoba("Pero", "Perić", PERO, 49));
		st.add(new Osoba("Ana", "Anić", ANA, 19));
		st.add(new Osoba("Bero", "Berić", BERO, 37));
		st.add(new Osoba("Vlaho", "Vlahić", VLAHO, 72));
		st.add(new Osoba("Ivo", "Ivić", IVO, 18));
	}
	private DefaultMutableTreeNode napuniModel(List<Osoba> st ){
		DefaultMutableTreeNode korijen = new DefaultMutableTreeNode("Studenti");
		for (Osoba s: st){
			DefaultMutableTreeNode l = new DefaultMutableTreeNode(s);
			l.add(new DefaultMutableTreeNode(s.getIme()));
			l.add(new DefaultMutableTreeNode(s.getPrezime()));
			l.add(new DefaultMutableTreeNode(s.getStarost()));
			l.add(new DefaultMutableTreeNode(s.getSlika()));
			korijen.add(l);
		}
		return korijen;
	}
	private void izborStudenta(MouseEvent e){
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)t.getLastSelectedPathComponent();
		if (node == null)
			return;
		int level = node.getDepth();
		if (level < 2){
			Object o = node.getUserObject();
			if (o instanceof Osoba){
				Osoba s = (Osoba)o;
				tIme.setText(s.getIme());
				tPrezime.setText(s.getPrezime());
				tStarost.setText(String.valueOf(s.getStarost()));
				lblSlika.setIcon(new ImageIcon(s.getSlika()));
			}
		}
	}
}