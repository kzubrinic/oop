package hr.unidu.oop.p10.tablica;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import hr.unidu.oop.p10.Osoba;

public class OsobaModel extends AbstractTableModel{
    private List<Osoba> lista;

    private String[] columns ={"Ime","Prezime","Slika"}; 
    
    public OsobaModel(List<Osoba> s){
        lista = s;
    }
    public OsobaModel() {
    	
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
            return st.getSlika();
    }
    
    public void updateOsoba(Osoba podaci, int r) {
    	Osoba nova = lista.get(r);
    	nova.setIme(podaci.getIme());
    	nova.setPrezime(podaci.getPrezime());
    	nova.setSlika(podaci.getSlika());
    	fireTableRowsUpdated(r,r);
    }
    
    public void insertOsoba(Osoba podaci) {
    	lista.add(podaci);
    	int poz = lista.size() - 1;
    	fireTableRowsInserted(poz, poz);
    }
    
    public void deleteOsoba(int r) {
    	lista.remove(r);
    	fireTableRowsDeleted(r, r);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
           return String.class;
    }
    
    @Override
    public String getColumnName(int col) {
        return columns[col] ;
    }
    public List<Osoba> getKolekcija(){
    	return lista;
    }
}
