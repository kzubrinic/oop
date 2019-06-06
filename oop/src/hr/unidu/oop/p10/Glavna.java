package hr.unidu.oop.p10;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hr.unidu.oop.p10.lista.DefaultniModel;
import hr.unidu.oop.p10.lista.DefaultniModel2;
import hr.unidu.oop.p10.lista.DefaultniModelSlike;
import hr.unidu.oop.p10.lista.JednostavnaLista;
import hr.unidu.oop.p10.stablo.JednostavnoStablo;
import hr.unidu.oop.p10.stablo.Stablo;
import hr.unidu.oop.p10.stablo.StabloDirektorija;
import hr.unidu.oop.p10.tablica.JednostavnaTablica;
import hr.unidu.oop.p10.tablica.TablicaSVlastitimModelom;
import hr.unidu.oop.p10.tablica.TablicaSVlastitimModelom2;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Glavna extends JFrame {

    private JMenu mnListe;
	private JMenu mnTab;
	private JMenu mnStab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Glavna frame = new Glavna("Primjeri liste, tablice i stabla");
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Glavna(String n) {
	    super(n);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnListe = new JMenu("Liste");
		mnTab = new JMenu("Tablice");
		mnStab = new JMenu("Stabla");
		
		napuniMenuListe();
		napuniMenuTablice();
		napuniMenuStabla();
		menuBar.add(mnListe);
		menuBar.add(mnTab);
		menuBar.add(mnStab);


		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	private void napuniMenuListe(){
	JMenuItem mntmJednostavnaLista = new JMenuItem("Jednostavna lista");
//		mntmJednostavnaLista.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pokreniJednostavnu();
//			}
//		});
		mntmJednostavnaLista.addActionListener(e -> pokreniJednostavnu());
		mnListe.add(mntmJednostavnaLista);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Prvi primjer s defaultnim modelom");
//		mntmNewMenuItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pokreniPrvi();
//			}
//		});
		mntmNewMenuItem.addActionListener(e -> pokreniPrvi());
		mnListe.add(mntmNewMenuItem);
		
		JMenuItem mntmDrugiPrimjerS = new JMenuItem("Drugi primjer s defaultnim modelom");
//		mntmDrugiPrimjerS.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pokreniDrugi();
//			}
//		});
		mntmDrugiPrimjerS.addActionListener(e -> pokreniDrugi());
		mnListe.add(mntmDrugiPrimjerS);
		
		JMenuItem mntmPrimjerSaSpecifinim = new JMenuItem("Primjer sa specifičnim iscrtavanjem retka");
//		mntmPrimjerSaSpecifinim.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pokreniSlike();
//			}
//		});
		mntmPrimjerSaSpecifinim.addActionListener(e-> pokreniSlike());
		mnListe.add(mntmPrimjerSaSpecifinim);
	   }
	   
	private void napuniMenuTablice(){
	JMenuItem mntmJednostavna = new JMenuItem("Jednostavna tablica");
//		mntmJednostavna.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pokreniJednostavnuTab();
//			}
//		});
		mntmJednostavna.addActionListener(e -> pokreniJednostavnuTab());
		mnTab.add(mntmJednostavna);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Prvi primjer s vlastitim modelom");
//		mntmNewMenuItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pokreniPrviVlast();
//			}
//		});
		mntmNewMenuItem.addActionListener(e -> pokreniPrviVlast());
		mnTab.add(mntmNewMenuItem);
		
		JMenuItem mntmDrugiPrimjerS = new JMenuItem("Drugi primjer s vlastitim modelom");
//		mntmDrugiPrimjerS.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pokreniDrugiVlast();
//			}
//		});
		mntmDrugiPrimjerS.addActionListener(e -> pokreniDrugiVlast());
		mnTab.add(mntmDrugiPrimjerS);

	   }   
	   
	   private void napuniMenuStabla(){
	JMenuItem mntmJednostavna = new JMenuItem("Jednostavno stablo");
//		mntmJednostavna.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pokreniJednostavnoStab();
//			}
//		});
		   mntmJednostavna.addActionListener(e -> pokreniJednostavnoStab());
		mnStab.add(mntmJednostavna);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Stablo direktorija/mapa");
//		mntmNewMenuItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pokreniStabloDir();
//			}
//		});
		   mntmNewMenuItem.addActionListener(e -> pokreniStabloDir());
		mnStab.add(mntmNewMenuItem);
		
		JMenuItem mntmDrugiPrimjerS = new JMenuItem("Stablo osoba");
//		mntmDrugiPrimjerS.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pokreniStabloStud();
//			}
//		});
		   mntmDrugiPrimjerS.addActionListener(e -> pokreniStabloStud());
		mnStab.add(mntmDrugiPrimjerS);
	   }
	   
	   
	private void pokreniJednostavnu(){
		JednostavnaLista frame = new JednostavnaLista("Jednostavna lista");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
	private void pokreniPrvi(){
		DefaultniModel frame = new DefaultniModel("Defaultni model");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
	private void pokreniDrugi(){
		DefaultniModel2 frame = new DefaultniModel2("Defaultni model studenata");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
	private void pokreniSlike(){
		DefaultniModelSlike frame = new DefaultniModelSlike("Model studenata s prikazom slike");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
	
	private void pokreniJednostavnuTab(){
		JednostavnaTablica frame = new JednostavnaTablica("Jednostavna tablica");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
	private void pokreniPrviVlast(){
		TablicaSVlastitimModelom frame = new TablicaSVlastitimModelom("Tablica s vlastitim modelom");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
	private void pokreniDrugiVlast(){
		TablicaSVlastitimModelom2 frame = new TablicaSVlastitimModelom2("Tablica s vlastitim modelom 2");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
	
	private void pokreniJednostavnoStab(){
		JednostavnoStablo frame = new JednostavnoStablo("Jednostavno stablo");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
	private void pokreniStabloDir(){
		StabloDirektorija frame = new StabloDirektorija("Stablo direktorija/mapa");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
	private void pokreniStabloStud(){
		Stablo frame = new Stablo("Stablo studenata");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
}
