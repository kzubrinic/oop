package hr.unidu.oop.p10;
public class Osoba {
	
	private String ime;
	private String prezime;
	private int starost;
	private String slika;
	public Osoba() {}
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
	public Osoba(String[] podaci){
		ime = podaci[0];
		prezime = podaci[1];
		slika = podaci[2];
		starost = Integer.valueOf(podaci[3]);
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
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public void setStarost(int starost) {
		this.starost = starost;
	}
	public void setSlika(String slika) {
		this.slika = slika;
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
		if (!(obj instanceof Osoba))
			return false;
		Osoba other = (Osoba) obj;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime)) {
			return false;
		}
		return (prezime != null || other.prezime == null) && (prezime.equals(other.prezime));
	}
	
	public String toString(){
		return ime + " " + prezime ;
	}
	
}
