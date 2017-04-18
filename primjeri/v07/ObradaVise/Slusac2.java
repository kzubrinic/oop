package ObradaVise;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Krunoslav Žubriniæ
 * 28. tra 2015.
 */
public class Slusac2 implements ActionListener {
	ObradaViseDogadjaja2 pozivatelj;
	public Slusac2(ObradaViseDogadjaja2 o){
		pozivatelj = o;
	}
	public void actionPerformed(ActionEvent e) {
			int v = Integer.valueOf(pozivatelj.getL().getText()) - 1;
			pozivatelj.getL().setText(Integer.toString(v));
	}
}
