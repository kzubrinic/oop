package lista;
public class Student2 {
	private String ime;
	private String prezime;
	private String slika;
	public Student2(String i, String p, String s){
		ime = i;
		prezime = p;
		slika = s;
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
		if ((obj == null) || (!(obj instanceof Student2)))
			return false;
		Student2 other = (Student2) obj;
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
		return prezime + ", " + ime;
	}
	
}
