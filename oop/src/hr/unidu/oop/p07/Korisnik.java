package hr.unidu.oop.p07;

public class Korisnik {
	private int id;
	private String naziv;
	private String autor;
	public Korisnik() {
	}
	public Korisnik(int id, String naziv, String autor) {
		this.id = id;
		this.naziv = naziv;
		this.autor = autor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	// Dvije knjige su jednake ako imaju jednak id
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Korisnik))
			return false;
		Korisnik other = (Korisnik) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Knjiga [id=" + id + ", naziv=" + naziv + ", autor=" + autor + "]";
	}
	
}
