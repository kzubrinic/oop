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
import hr.unidu.oop.p10.tablica.TablicaIzDatoteke;
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
		
		JMenuItem mnIzlaz = new JMenuItem("Izlaz");
		mnIzlaz.addActionListener(e -> System.exit(0));
		menuBar.add(mnIzlaz);


		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	private void napuniMenuListe(){
		JMenuItem mntmJednostavnaLista = new JMenuItem("Jednostavna lista");
		mntmJednostavnaLista.addActionListener(e -> pokreniJednostavnu());
		mnListe.add(mntmJednostavnaLista);
		
		mnListe.addSeparator();

		JMenuItem mntmNewMenuItem = new JMenuItem("Prvi primjer s defaultnim modelom");
		mntmNewMenuItem.addActionListener(e -> pokreniPrvi());
		mnListe.add(mntmNewMenuItem);

		JMenuItem mntmDrugiPrimjerS = new JMenuItem("Drugi primjer s defaultnim modelom");
		mntmDrugiPrimjerS.addActionListener(e -> pokreniDrugi());
		mnListe.add(mntmDrugiPrimjerS);

		mnListe.addSeparator();
		
		JMenuItem mntmPrimjerSaSpecifinim = new JMenuItem("Primjer sa specifičnim iscrtavanjem retka");
		mntmPrimjerSaSpecifinim.addActionListener(e-> pokreniSlike());
		mnListe.add(mntmPrimjerSaSpecifinim);
	}

	private void napuniMenuTablice(){
		JMenuItem mntmJednostavna = new JMenuItem("Jednostavna tablica");
		mntmJednostavna.addActionListener(e -> pokreniJednostavnuTab());
		mnTab.add(mntmJednostavna);

		mnTab.addSeparator();
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Prvi primjer s vlastitim modelom");
		mntmNewMenuItem.addActionListener(e -> pokreniPrviVlast());
		mnTab.add(mntmNewMenuItem);

		JMenuItem mntmDrugiPrimjerS = new JMenuItem("Drugi primjer s vlastitim modelom");
		mntmDrugiPrimjerS.addActionListener(e -> pokreniDrugiVlast());
		mnTab.add(mntmDrugiPrimjerS);

		mnTab.addSeparator();
		
		JMenuItem mntmTreciPrimjerS = new JMenuItem("Tablica iz datoteke - ažuriranje");
		mntmTreciPrimjerS.addActionListener(e -> pokreniTabDat());
		mnTab.add(mntmTreciPrimjerS);

	}   

	private void napuniMenuStabla(){
		JMenuItem mntmJednostavna = new JMenuItem("Jednostavno stablo");
		mntmJednostavna.addActionListener(e -> pokreniJednostavnoStab());
		mnStab.add(mntmJednostavna);

		mnStab.addSeparator();
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Stablo direktorija/mapa");

		mntmNewMenuItem.addActionListener(e -> pokreniStabloDir());
		mnStab.add(mntmNewMenuItem);

		mnStab.addSeparator();
		
		JMenuItem mntmDrugiPrimjerS = new JMenuItem("Stablo osoba");
		mntmDrugiPrimjerS.addActionListener(e -> pokreniStabloStud());
		mnStab.add(mntmDrugiPrimjerS);
	}


	private void pokreniJednostavnu(){
		JednostavnaLista frame = new JednostavnaLista("Jednostavna lista");
	}
	private void pokreniPrvi(){
		DefaultniModel frame = new DefaultniModel("Defaultni model");
	}
	private void pokreniDrugi(){
		DefaultniModel2 frame = new DefaultniModel2("Defaultni model studenata");
	}
	private void pokreniSlike(){
		DefaultniModelSlike frame = new DefaultniModelSlike("Model studenata s prikazom slike");
	}

	private void pokreniJednostavnuTab(){
		JednostavnaTablica frame = new JednostavnaTablica("Jednostavna tablica");
	}
	private void pokreniPrviVlast(){
		TablicaSVlastitimModelom frame = new TablicaSVlastitimModelom("Tablica s vlastitim modelom");
	}
	private void pokreniDrugiVlast(){
		TablicaSVlastitimModelom2 frame = new TablicaSVlastitimModelom2("Tablica s vlastitim modelom 2");
	}
	private void pokreniTabDat(){
		TablicaIzDatoteke frame = new TablicaIzDatoteke("Tablica iz datoteke s ažuriranjem");
	}

	private void pokreniJednostavnoStab(){
		JednostavnoStablo frame = new JednostavnoStablo("Jednostavno stablo");
	}
	private void pokreniStabloDir(){
		StabloDirektorija frame = new StabloDirektorija("Stablo direktorija/mapa");
	}
	private void pokreniStabloStud(){
		Stablo frame = new Stablo("Stablo studenata");
	}
}
