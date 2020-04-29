package hr.unidu.oop.p10.tablica;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import hr.unidu.oop.p10.Osoba;

public class TablicaIzDatotekeObrada {
	public Osoba izaberiRedak(JTable t){
        TableModel model = t.getModel();
        int brStup = model.getColumnCount();
        // Povezuje indeks retka tablice s indeksom retka u modelu
        // Ako su podaci sortirani, indeksi nisu jednaki!
		int brSr = t.convertRowIndexToModel(t.getSelectedRow());
		// Povezuje indeks stupca tablice s indeksom stupca u modelu
		// Indeksi su različiti ako im je promijenjen redosljed!
		int brSs = t.convertColumnIndexToModel(t.getSelectedColumn());
		Osoba o = new Osoba();
        for (int j=0; j <= brStup; j++) {
            System.out.print("  " + model.getValueAt(brSr, j));
            switch(j) {
            	case 0:
            		o.setIme((String)model.getValueAt(brSr, j));
            		break;
            	case 1:
            		o.setPrezime((String)model.getValueAt(brSr, j));
            		break;
            	case 2:
            		o.setSlika((String)model.getValueAt(brSr, j));
            		break;
            }
        }
        return o;
	}
	public void azuriraj(JTable t, Osoba nova) {
		if (!(t.getModel() instanceof OsobaModel)) return;
		OsobaModel model = (OsobaModel)t.getModel();
		int brSr = t.convertRowIndexToModel(t.getSelectedRow());
        model.updateOsoba(nova, brSr);
	}
	public void dodaj(JTable t, Osoba nova) {
		if (!(t.getModel() instanceof OsobaModel)) return;
		OsobaModel model = (OsobaModel)t.getModel();
        model.insertOsoba(nova);

	}
	public void brisi(JTable t) {
		if (!(t.getModel() instanceof OsobaModel)) return;
		OsobaModel model = (OsobaModel)t.getModel();
		int brSr = t.convertRowIndexToModel(t.getSelectedRow());
        model.deleteOsoba(brSr);
	}

}
