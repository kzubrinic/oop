package lista;
public class Student {
	private String ime;
	private String prezime;
	public Student(String i, String p){
		ime = i;
		prezime = p;
	}
	public String getIme() {
		return ime;
	}
	public String getPrezime() {
		return prezime;
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
		if ((obj == null) || (!(obj instanceof Student)))
			return false;
		Student other = (Student) obj;
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
