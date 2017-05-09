package lista;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class DefaultniModel extends JFrame {

	private JPanel cp;
	private DefaultListModel<String> mod;
	
	public static void main(String[] args) {
		try {
		       SwingUtilities.invokeAndWait(new Runnable(){
		         public void run() {
		        	DefaultniModel frame = new DefaultniModel("Defaultni model");
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

	public DefaultniModel(String n) {
		super(n);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp = new JPanel();
		mod = new DefaultListModel<>();
		napuniModel();
		JList<String> l1 = new JList<>(mod);
		l1.setVisibleRowCount(4);
		JScrollPane pp = new JScrollPane(l1);
			
		getContentPane().add(pp,BorderLayout.NORTH);
		getContentPane().add(cp,BorderLayout.SOUTH);
		JButton dod = new JButton("Dodaj na kraj");
		dod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = "Osmi dan";
				mod.addElement(s);
				l1.setSelectedValue(s, true);
			}
		});
		JButton dod1 = new JButton("Dodaj u sredinu");
		dod1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = "Deveti dan";
				mod.add(1,s);
				l1.setSelectedValue(s, true);
			}
		});
		JButton dod2 = new JButton("Obriši");
		dod2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mod.remove(1);
			}
		});
		JButton dod3 = new JButton("Izmjeni");
		dod3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mod.set(0, "Prvi element");
			}
		});
		cp.add(dod);
		cp.add(dod1);
		cp.add(dod2);
		cp.add(dod3);
	}
	private void napuniModel(){
		mod.addElement("Ponedjeljak");
		mod.addElement("Utorak");
		mod.addElement("Srijeda");
		mod.addElement("Četvrtak");
		mod.addElement("Petak");
		mod.addElement("Subota");
		mod.addElement("Nedjelja");
	}
}
