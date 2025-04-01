package hr.unidu.oop.p06.funkcijskas;

public class Automobil implements Comparable<Automobil>{
	private String model;
	private Boja boja;
	private Kategorija kategorija;
	public Automobil(String m, Boja b, Kategorija k) {
		model = m;
		boja = b;
		kategorija = k;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Boja getBoja() {
		return boja;
	}
	public void setBoja(Boja boja) {
		this.boja = boja;
	}
	public Kategorija getKategorija() {
		return kategorija;
	}
	public void setKategorija(Kategorija k) {
		kategorija = k;
	}
	@Override
	public String toString() {
		return "Automobil [model=" + model + ", boja=" + boja + ", kategorija=" + kategorija + "]";
	}
	public static int compareByModel(Automobil a, Automobil b) {
        return a.model.compareTo(b.model);
    }
	@Override
	public int compareTo(Automobil o) {
		return kategorija.compareTo(o.kategorija);
	}
}
