package hr.unidu.oop.p10;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import hr.unidu.oop.p09.citac2.SlozeniCitacDatoteka;
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
	private JMenu mnIzbor;
	private JTextArea polje;
	private JLabel slika;
	private final int SIRINA_SLIKE = 300;
	private final int VISINA_SLIKE = 300;

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

		mnIzbor = new JMenu("Izbor datoteke");
		mnListe = new JMenu("Liste");
		mnTab = new JMenu("Tablice");
		mnStab = new JMenu("Stabla");

		napuniMenuIzboraDat();
		napuniMenuListe();
		napuniMenuTablice();
		napuniMenuStabla();
		
		menuBar.add(mnIzbor);
		menuBar.add(mnListe);
		menuBar.add(mnTab);
		menuBar.add(mnStab);
		
		JMenuItem mnIzlaz = new JMenuItem("Izlaz");
		mnIzlaz.addActionListener(e -> System.exit(0));
		menuBar.add(mnIzlaz);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(splitPane);
		JPanel txtPanel = new JPanel();
		splitPane.setLeftComponent(txtPanel);
		JPanel picPanel = new JPanel();
		splitPane.setRightComponent(picPanel);
		polje = new JTextArea(10,20);
		polje.setEditable(false);
		JScrollPane pn = new JScrollPane(polje);
		txtPanel.add(pn);
		slika = new JLabel();
		slika.setSize(300, 300);
		picPanel.add(slika);
		//add(splitPane, BorderLayout.CENTER);
		setSize(700, 400);
	}
	
	private void napuniMenuIzboraDat(){
		JMenuItem mntmIzborTxt = new JMenuItem("Izbor tekstualne datoteke");
		mntmIzborTxt.addActionListener(e -> izaberiTxt());
		mnIzbor.add(mntmIzborTxt);
		
		mnIzbor.addSeparator();

		JMenuItem mntmIzborPic = new JMenuItem("Izbor grafičke datoteke");
		mntmIzborPic.addActionListener(e -> izaberiPic());
		mnIzbor.add(mntmIzborPic);
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
	private void izaberiTxt() {
		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt files", "txt");
        fc.addChoosableFileFilter(filter);
		int rez = fc.showOpenDialog(this);
		if(rez == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			RadnikTxt rt = new RadnikTxt(f);
			rt.execute();
		}
	}
	private void izaberiPic() {
		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Pictures", "jpg", "jpeg", "png", "gif");
        fc.addChoosableFileFilter(filter);
		int rez = fc.showOpenDialog(this);
		if(rez == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			RadnikPic rp = new RadnikPic(f);
			rp.execute();
		}
		
	}
class RadnikTxt extends SwingWorker<String,Void>{
	private File f;
	public RadnikTxt(File f) {
		this.f = f;
	}
	@Override
	protected String doInBackground() throws Exception {
		String s = ""; 
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br=new BufferedReader(new FileReader(f))){    
	        while((s = br.readLine()) != null){
	        	sb.append(s);
	        	sb.append("\n");
	        }    
        }catch (Exception ex) {
        	ex.printStackTrace();  
        } 
		return sb.toString();
	}
	protected void done() {
		try {
			polje.setText(get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}

class RadnikPic extends SwingWorker<BufferedImage,Void>{
	private File f;
	public RadnikPic(File f) {
		this.f = f;
	}
	@Override
	protected BufferedImage doInBackground() throws Exception {
		// Čita sliku s diska
		BufferedImage x = ImageIO.read(f);
		// skaliranje slike na dostupni prostor SIRINA_SLIKE * VISINA_SLIKE
		int orgW = x.getWidth();
		int orgH = x.getHeight();
		int omjer = (orgW > orgH) ? orgW / SIRINA_SLIKE : orgH / VISINA_SLIKE;
		omjer = (omjer <= 0) ? 1 : omjer;
		Image nova = x.getScaledInstance(orgW/omjer, orgH/omjer, Image.SCALE_SMOOTH);
		BufferedImage bSkalirana = new BufferedImage(nova.getWidth(null), nova.getHeight(null), BufferedImage.TYPE_INT_RGB);
		bSkalirana.getGraphics().drawImage(nova, 0, 0, null);
		return bSkalirana;
	}
	protected void done() {
		try {
			slika.setIcon(new ImageIcon(get()));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
}
