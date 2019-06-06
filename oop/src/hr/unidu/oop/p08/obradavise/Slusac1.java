package hr.unidu.oop.p08.obradavise;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Krunoslav Žubrinić
 * 28. tra 2015.
 */
public class Slusac1 implements ActionListener {
	ObradaViseDogadjaja2 pozivatelj;
	public Slusac1(ObradaViseDogadjaja2 o){
		pozivatelj = o;
	}
	public void actionPerformed(ActionEvent e) {
			int v = Integer.valueOf(pozivatelj.getL().getText()) + 1;
			pozivatelj.getL().setText(Integer.toString(v));
	}
}