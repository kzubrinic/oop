package hr.unidu.oop.p10;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PrimjerPadajucegIzbornika extends JFrame {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				PrimjerPadajucegIzbornika frame = new PrimjerPadajucegIzbornika("Primjer izbornika");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
	}

	public PrimjerPadajucegIzbornika(String n) {
		super(n);
		setBounds(100, 100, 450, 300);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mPrvi = new JMenu("Prvi");
		menuBar.add(mPrvi);
		mPrvi.setMnemonic(KeyEvent.VK_P);
		
		JMenuItem mntmJednostavnaLista = new JMenuItem("Prvi 1");
//		Anonimna klasa		
//		mntmJednostavnaLista.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Izabran Prvi 1");
//			}
//		});
		// Lambda izraz
		mntmJednostavnaLista.addActionListener(e -> System.out.println("Izabran Prvi 1"));
		mPrvi.add(mntmJednostavnaLista);
		mPrvi.addSeparator();
		
		JMenu mPrvi2 = new JMenu("Prvi 2");
		mPrvi.add(mPrvi2);
		JMenuItem mntmDrugiPrimjerS = new JMenuItem("Prvi 21");
//		Anonimna klasa
//		mntmDrugiPrimjerS.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Izabran Prvi 21");
//			}
//		});
		// Lambda izraz
		mntmDrugiPrimjerS.addActionListener(e -> System.out.println("Izabran Prvi 21"));
		mPrvi2.add(mntmDrugiPrimjerS);
		JCheckBoxMenuItem mntmNewMenuItem = new JCheckBoxMenuItem("Prvi 22");

//		mntmNewMenuItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Prvi 22: " + mntmNewMenuItem.getState());
//			}
//		});
		mntmNewMenuItem.addActionListener(e -> {
			// Ispisuje stanje menu check boxa - označen (true) ili neoznačen (false)
			// Metoda getState vraća logičku vrijednost stanja menua check boxa
			System.out.println("Prvi 22: " + mntmNewMenuItem.getState());
		});
		mPrvi2.add(mntmNewMenuItem);
		
		JMenu mnDrugi = new JMenu("Drugi");
		mnDrugi.setMnemonic(KeyEvent.VK_R);
		menuBar.add(mnDrugi);
		
		// Moguć je izbor samo jednog od izgora u grupi (kao i običan radio button unutar grupe)
		ButtonGroup mGrupa = new ButtonGroup();
		JRadioButtonMenuItem g1 = new JRadioButtonMenuItem("Prvi izbor", true);
		mGrupa.add(g1);
		g1.addActionListener(e -> System.out.println("Izabran Prvi izbor grupe"));
		JRadioButtonMenuItem g2 = new JRadioButtonMenuItem("Drugi izbor");
		mGrupa.add(g2);
		g2.addActionListener(e -> System.out.println("Izabran Drugi izbor grupe"));
		
		mnDrugi.add(g1);
		mnDrugi.add(g2);

//		Izlaz iz aplikacije izborom izbornika Izlaz
		JMenuItem mnIzlaz = new JMenuItem("Izlaz");
//		mnTrei.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});
		// Lambda izraz - izlaz iz aplikacije
		mnIzlaz.addActionListener(e -> System.exit(0));
		menuBar.add(mnIzlaz);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
