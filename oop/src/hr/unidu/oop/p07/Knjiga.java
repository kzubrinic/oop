package hr.unidu.oop.p07;

public class Knjiga {
	private int id;
	private String naziv;
	private String autor;
	public Knjiga() {
	}
	public Knjiga(int id, String naziv, String autor) {
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
	public String toString() {
		return "Knjiga [id=" + id + ", naziv=" + naziv + ", autor=" + autor + "]";
	}
	
}
