package lista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import java.awt.GridLayout;

public class JednostavnaLista extends JFrame {

	private JPanel contentPane;
	private JTextArea l1, l2, l3;
	
	public static void main(String[] args) {
		try {
		       SwingUtilities.invokeAndWait(new Runnable(){
		         public void run() {
		        	JednostavnaLista frame = new JednostavnaLista("Jednostavna lista");
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.pack();
		         }
		       });
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}

	public JednostavnaLista(String t) {
	    super(t);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3,1));
		String[] model = {"Ponedjeljak", "Utorak", "Srijeda", "Četvrtak", "Petak", "Subota", "Nedjelja"};
		JList<String> list1 = new JList<>(model);
		list1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list1.setVisibleRowCount(4);
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list1.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				// Akcija izbora mišem stvara DVA događaja:
				//	- prvi je pritisak tipke miša kod izbora (prepoznaje se tako što je e.getValueIsAdjusting() = true)
				//  - drugi je otpuštanje tipke kod izbora (prepoznaje se tako što je e.getValueIsAdjusting() = false)
				// Obično nas zanima samo jedan od  ta dva događaja pa ih filtriramo provjerom povratne
				//  vrijednosti metode e.getValueIsAdjusting()
				if (e.getValueIsAdjusting())
					return;
				// Obrada izabranih elemenata liste
				izbor(list1, l1);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(list1);
		contentPane.add(scrollPane);
		
		l1 = new JTextArea(4,20);
		l1.setLineWrap(true);
		contentPane.add(l1);

		JList<String> list2 = new JList<>(model);
		list2.setVisibleRowCount(4);
		list2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list2.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				// Vidi komentar kod poziva ove metode na komponenti list1!
				if (e.getValueIsAdjusting())
					return;
				izbor(list2, l2);
			}
		});
		JScrollPane scrollPane_1 = new JScrollPane(list2);
		contentPane.add(scrollPane_1);
		
		l2 = new JTextArea(4,20);
		l2.setLineWrap(true);
		contentPane.add(l2);

		JList<String> list3 = new JList<>(model);
		list3.setVisibleRowCount(4);
		list3.setLayoutOrientation(JList.VERTICAL_WRAP);
		list3.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list3.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				// Vidi komentar kod poziva ove metode na komponenti list1!
				if (e.getValueIsAdjusting())
					return;
				izbor(list3, l3);
			}
		});
		JScrollPane scrollPane_2 = new JScrollPane(list3);
		contentPane.add(scrollPane_2);
		
		l3 = new JTextArea(4,20);
		l3.setLineWrap(true);
		contentPane.add(l3);
		
	}
	private void izbor(JList<String> s, JTextArea l){
		if (s.getSelectedIndex() == -1){
			System.out.println("Niti jedan element nije označen!");
			l.setText("");
			return;
		}
		String prvi = s.getSelectedValue();
		System.out.println("Prvi izabrani element je " + prvi);
		StringBuilder text = new StringBuilder("Izabrano: ");
		for (String value : s.getSelectedValuesList()){
			text.append(value);
			text.append(" ");
		}
		l.setText(text.toString());
	}
}
