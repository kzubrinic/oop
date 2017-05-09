package tablica;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class StudentModel2 extends AbstractTableModel{
	private List<Student2> lista;

	private String[] columns ={"Ime","Prezime","Slika"}; 
	
	public StudentModel2(List<Student2> s){
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
		Student2 st = lista.get(r);
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
	
	public void addRow(Student2 st) {
		lista.add(st);
	}
	public void removeRow(int red) {
		lista.remove(red);
	}
}

