package hr.unidu.oop.p11.tokovi;

import java.util.Comparator;
import java.util.Objects;

public class Osoba implements Comparable<Osoba>, Comparator<Osoba>{
	private String ime;
	private String prezime;

	public Osoba(String ime, String prezime) {
		this.ime = ime;
		this.prezime = prezime;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ime, prezime);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Osoba other = (Osoba) obj;
		return Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}



	@Override
	public String toString() {
		return "Osoba [ime=" + ime + ", prezime=" + prezime + "]";
	}


	@Override
	public int compareTo(Osoba o) {
		return compare(this, o);
	}


	@Override
	public int compare(Osoba o1, Osoba o2) {
		int i = o1.prezime.compareTo(o2.prezime);
		if(i == 0)
			return o1.ime.compareTo(o2.ime);
		return i;
	}}
