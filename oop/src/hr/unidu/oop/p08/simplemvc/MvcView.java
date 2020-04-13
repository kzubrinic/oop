package hr.unidu.oop.p08.simplemvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MvcView extends JFrame{
	public JTextField unos;
	public JButton gumb;
	public JTextArea lista; 
	public MvcView() {
		pripremiKomponente();
		setVisible(true);
		gumb.addActionListener(new MvcController(this));
	}
	private void pripremiKomponente() {
		setTitle("Primjer MVC");
		JPanel p = new JPanel();
		unos = new JTextField(30);
		gumb = new JButton("Traži");
		lista = new JTextArea(10,10);
		lista.setEditable(false);
		lista.setLineWrap(true);
		lista.setWrapStyleWord(true);
		JScrollPane jp = new JScrollPane(lista);
		p.add(unos);
		p.add(gumb);
		add(BorderLayout.NORTH, p);
		add(jp);
		setLocationRelativeTo(null);
		pack();
	}
	public void setLista(String t) {
		lista.setText(t);
	}
	public String getUnosText() {
		return unos.getText();
	}
}
