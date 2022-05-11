package hr.unidu.oop.p11.tokovi;

import java.util.Objects;

public class SlozeniObjekt {
	private String naziv;
	private int cijeliBroj;
	private long dugacakCijeliBroj;
	private double realniBroj;
	public SlozeniObjekt(String naziv, int cijeliBroj, long dugacakCijeliBroj, double realniBroj) {
		this.naziv = naziv;
		this.cijeliBroj = cijeliBroj;
		this.dugacakCijeliBroj = dugacakCijeliBroj;
		this.realniBroj = realniBroj;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getCijeliBroj() {
		return cijeliBroj;
	}
	public void setCijeliBroj(int cijeliBroj) {
		this.cijeliBroj = cijeliBroj;
	}
	public long getDugacakCijeliBroj() {
		return dugacakCijeliBroj;
	}
	public void setDugacakCijeliBroj(long dugacakCijeliBroj) {
		this.dugacakCijeliBroj = dugacakCijeliBroj;
	}
	public double getRealniBroj() {
		return realniBroj;
	}
	public void setRealniBroj(double realniBroj) {
		this.realniBroj = realniBroj;
	}
	@Override
	public int hashCode() {
		return Objects.hash(naziv);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SlozeniObjekt))
			return false;
		SlozeniObjekt other = (SlozeniObjekt) obj;
		return Objects.equals(naziv, other.naziv);
	}
	@Override
	public String toString() {
		return "SlozeniObjekt [naziv=" + naziv + ", cijeliBroj=" + cijeliBroj + ", dugacakCijeliBroj="
				+ dugacakCijeliBroj + ", realniBroj=" + realniBroj + "]";
	}
	
}
