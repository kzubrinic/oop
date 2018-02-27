package hr.unidu.oop.p10.tablica;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import hr.unidu.oop.p10.Osoba;

public class OsobaModel2 extends AbstractTableModel{
	private List<Osoba> lista;

	private String[] columns ={"Ime","Prezime","Slika"}; 
	
	public OsobaModel2(List<Osoba> s){
		lista = s;
	}
	
	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int r, int s) {
		Osoba st = lista.get(r);
		if (s==0)
			return st.getIme();
		else if (s==1)
			return st.getPrezime();
		else
			return new ImageIcon(st.getSlika());
	}
	@Override
    public Class<?> getColumnClass(int c) {
		if (c < 2)
			return String.class;
		else
			return ImageIcon.class;
    }
	@Override
	public String getColumnName(int col) {
	    return columns[col] ;
	}
	
	public void addRow(Osoba st) {
		lista.add(st);
	}
	public void removeRow(int red) {
		lista.remove(red);
	}
}

