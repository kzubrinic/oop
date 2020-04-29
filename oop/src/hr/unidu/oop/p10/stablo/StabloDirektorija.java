package hr.unidu.oop.p10.stablo;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class StabloDirektorija extends JFrame{

	private DefaultTreeModel model;
	private File pocetnaDat;

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				StabloDirektorija frame = new StabloDirektorija("Stablo direktorija", true);
			});
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public StabloDirektorija(String n, boolean zatvori) {
		this(n);
		if (zatvori) setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public StabloDirektorija(String n) {
		super(n);
		String pocetniDir = ".";
		pocetnaDat = new File(pocetniDir);
		citajRekurzivno(pocetnaDat);
		JTree t = new JTree(model);
		JScrollPane sp = new JScrollPane(t);
		getContentPane().add(sp);
		
		setVisible(true);
		setLocationRelativeTo(null);
		pack();
	}

	public DefaultMutableTreeNode citajRekurzivno(File trenutna) {
		DefaultMutableTreeNode cvor = new DefaultMutableTreeNode(trenutna.getName());
		if(trenutna.equals(pocetnaDat)) {
			model = new DefaultTreeModel(cvor);
		}
		if(trenutna.isDirectory()){
			File[] files = trenutna.listFiles();
			if(files == null)
				return null;
			for (File f: files) {
				model.insertNodeInto(citajRekurzivno(f),cvor,0);
			}
		}
		return(cvor);
	}
}
