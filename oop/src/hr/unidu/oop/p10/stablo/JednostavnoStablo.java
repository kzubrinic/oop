package hr.unidu.oop.p10.stablo;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class JednostavnoStablo extends JFrame{

	private DefaultTreeModel model;
	private JTree t;
	private JLabel izabrano;

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run() {
					JednostavnoStablo frame = new JednostavnoStablo("Jednostavno stablo");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.pack();
				}
			});
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public JednostavnoStablo(String n) {
		super(n);
		napuniModel();
		t = new JTree(model);
		t.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				izborStabla(e);
			}
		});
		JScrollPane sp = new JScrollPane(t);
		getContentPane().add(sp);
		izabrano = new JLabel();
		getContentPane().add(izabrano, BorderLayout.SOUTH);
	}
	private void napuniModel(){
	    DefaultMutableTreeNode korijen = new DefaultMutableTreeNode("Stabla");
	    DefaultMutableTreeNode l = new DefaultMutableTreeNode("Listopadno drveće");
	    DefaultMutableTreeNode c = new DefaultMutableTreeNode("Crnogorica");
	    DefaultMutableTreeNode l1 = new DefaultMutableTreeNode("Javor");
	    DefaultMutableTreeNode l2 = new DefaultMutableTreeNode("Hrast");
	    DefaultMutableTreeNode l3 = new DefaultMutableTreeNode("Bukva");
	    DefaultMutableTreeNode c1 = new DefaultMutableTreeNode("Bor");
	    DefaultMutableTreeNode c2 = new DefaultMutableTreeNode("Jela");
	    DefaultMutableTreeNode c3 = new DefaultMutableTreeNode("Smreka");
	    DefaultMutableTreeNode l11 = new DefaultMutableTreeNode("Crveni javor");
	    DefaultMutableTreeNode l12 = new DefaultMutableTreeNode("Zeleni javor");

	    model = new DefaultTreeModel(korijen);
	    model.insertNodeInto(l,korijen,0);
	    model.insertNodeInto(c,korijen,1);
	    model.insertNodeInto(l1,l,0);
	    model.insertNodeInto(l2,l,1);
	    model.insertNodeInto(l3,l,1);
	    model.insertNodeInto(c1,c,0);
	    model.insertNodeInto(c2,c,1);
	    model.insertNodeInto(c3,c,2);
	    model.insertNodeInto(l11,l1,0);
	    model.insertNodeInto(l12,l1,1);
	  }
	private void izborStabla(MouseEvent e){
		// Ako je izabran samo 1 element - onda ne treba for petlja
		//TreePath selectedPath = t.getSelectionPath();
		TreePath[] selectedPath = t.getSelectionPaths();
		if (selectedPath == null)
			return;
		String o = new String();
		for (TreePath tp: selectedPath){
			DefaultMutableTreeNode node = ((DefaultMutableTreeNode)tp.getLastPathComponent());
			o = o + " " + node.getUserObject().toString();
		}
		izabrano.setText("Izabrano je: " + o);
	}
	
}
