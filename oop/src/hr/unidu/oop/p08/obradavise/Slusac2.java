package hr.unidu.oop.p08.obradavise;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Slusac2 implements ActionListener {
	ObradaViseDogadjaja2 pozivatelj;
	public Slusac2(ObradaViseDogadjaja2 o){
		pozivatelj = o;
	}
	public void actionPerformed(ActionEvent e) {
		// Grafički program je zadužen za izmjenu GUI komponenti
		int v = pozivatelj.getLabelValue() - 1;
		pozivatelj.setLabelValue(v);
	}
}
