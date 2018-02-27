package hr.unidu.oop.p10;
public class Osoba {
	
	private String ime;
	private String prezime;
	private int starost;
	private String slika;
	public Osoba(String i, String p, String s, int t){
		ime = i;
		prezime = p;
		slika = s;
		starost = t;
	}
	public Osoba(String i, String p){
		ime = i;
		prezime = p;
		slika = "slike/noimage.jpg";
		starost = 0;
	}
	public String getIme() {
		return ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public String getSlika() {
		return slika;
	}
	public int getStarost() {
		return starost;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
 			return true;
		if ((obj == null) || (!(obj instanceof Osoba)))
			return false;
		Osoba other = (Osoba) obj;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		return true;
	}
	
	public String toString(){
		return ime + " " + prezime ;
	}
	
}
