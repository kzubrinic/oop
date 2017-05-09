package tablica;
import java.util.List;
import javax.swing.ImageIcon;

import javax.swing.table.AbstractTableModel;

public class StudentModel extends AbstractTableModel{
	List<Student2> lista;

	private String[] columns ={"Ime","Prezime","Slika"}; 
	
	public StudentModel(List<Student2> s){
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
			//return st.getSlika();
	}
	@Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
	@Override
	public String getColumnName(int col) {
	    return columns[col] ;
	  }

}
