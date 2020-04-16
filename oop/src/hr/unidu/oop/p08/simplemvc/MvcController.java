package hr.unidu.oop.p08.simplemvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MvcController implements ActionListener{
	private MvcModel model;
	private MvcView view;

	public MvcController(MvcView v) {
		model = new MvcModel();
		view = v;
		view.setLista(setTekst());
	}
	private String setTekst() {
		StringBuilder sb = new StringBuilder();
		for(String s: model.getPodaci()) {
			sb.append(s);
			sb.append("\n");
		}
		return sb.toString();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		trazi(view.getUnosText());
	}
	private void trazi(String niz) {
		StringBuilder sb = new StringBuilder();
		for(String s: model.getPodaci()) {
			if(s.indexOf(niz) >= 0) {
				sb.append(s);
				sb.append("\n");
			}
		}
		view.setLista(sb.toString());
	}
}
