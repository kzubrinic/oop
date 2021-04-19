package hr.unidu.oop.p08;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuItem;

public class PrimjerSkocnogIzbornika extends JFrame {
	private PrimjerSkocnogIzbornika f;
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				PrimjerSkocnogIzbornika frame = new PrimjerSkocnogIzbornika("Primjer skocnog izbornika");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
	}

	public PrimjerSkocnogIzbornika(String n) {
		super(n);
		f = this;
		setBounds(100, 100, 450, 300);
		JPopupMenu menuBar = new JPopupMenu();
		add(menuBar);
		JMenuItem mPrvi = new JMenuItem("Prvi");
		menuBar.add(mPrvi);
		mPrvi.addActionListener(e -> System.out.println("Izabran Prvi"));
		
		JMenu mDrugi = new JMenu("Drugi");
		JMenuItem mDrugi1 = new JMenuItem("Drugi 1");
		mDrugi1.addActionListener(e -> System.out.println("Izabran Drugi 1"));
		mDrugi.add(mDrugi1);
		JCheckBoxMenuItem mDrugi2 = new JCheckBoxMenuItem("Drugi 2");
		mDrugi2.addActionListener(e -> System.out.println("Izabran Drugi 2"));
		mDrugi.add(mDrugi2);
		menuBar.add(mDrugi);
 
		menuBar.addSeparator();
		
		JMenuItem mnIzlaz = new JMenuItem("Izlaz");
		mnIzlaz.addActionListener(e -> System.exit(0));
		menuBar.add(mnIzlaz);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {
            	// Skočni izbornik aktiviramo samo na desni klik
            	if (SwingUtilities.isRightMouseButton(e)) {
            		menuBar.show(f , e.getX(), e.getY());
            	}
            }                 
         }); 
	}

}
