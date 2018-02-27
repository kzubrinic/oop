package hr.unidu.oop.p10;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrimjerIzbornika extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimjerIzbornika frame = new PrimjerIzbornika("Primjer izbornika");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrimjerIzbornika(String n) {
		super(n);
		setBounds(100, 100, 450, 300);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mPrvi = new JMenu("Prvi");
		menuBar.add(mPrvi);
		
		JMenuItem mntmJednostavnaLista = new JMenuItem("Prvi 1");
		mntmJednostavnaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Izabran Prvi 1");
			}
		});
		mPrvi.add(mntmJednostavnaLista);
		mPrvi.addSeparator();

		
		JMenu mPrvi2 = new JMenu("Prvi 2");
		mPrvi.add(mPrvi2);
		JMenuItem mntmDrugiPrimjerS = new JMenuItem("Prvi 21");
		mntmDrugiPrimjerS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Izabran Prvi 21");
			}
		});
		mPrvi2.add(mntmDrugiPrimjerS);
		JMenuItem mntmNewMenuItem = new JMenuItem("Prvi 22");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Izabran Prvi 22");
			}
		});
		mPrvi2.add(mntmNewMenuItem);
		
		JMenu mnDrugi = new JMenu("Drugi");
		menuBar.add(mnDrugi);
		JMenuItem mnD1 = new JMenuItem("Drugi 1");
		mnD1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Izabran Drugi 1");
			}
		});
		mnDrugi.add(mnD1);
		JMenuItem mnTrei = new JMenuItem("Treći");
		mnTrei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Izabran Treći");
			}
		});
		menuBar.add(mnTrei);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}