package hr.unidu.oop.p04.usporedbaobjekata;

import java.util.Comparator;
import java.util.Objects;

public class Kvadrat implements Comparable<Kvadrat>, Comparator<Kvadrat>{
	private int a;
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public Kvadrat(int a) {
		this.a = a;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(a);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Kvadrat))
			return false;
		Kvadrat other = (Kvadrat) obj;
		return a == other.a;
	}
	

	@Override
	public String toString() {
		return "Kvadrat [a=" + a + "]";
	}

	public static void main(String[] args) {
		Kvadrat k1 = new Kvadrat(10);
		Kvadrat k2 = new Kvadrat(12);
		k1.radi(k2);
	}

	private void radi(Kvadrat k) {
		if (this.compareTo(k) < 0)
			System.out.println(this + "je manji od " + k);
		else if (this.compareTo(k) > 0)
			System.out.println(this + "je veći od " + k);
		else
			System.out.println(this + " i " + k + " su jednaki");
	}
	
	// Metoda compareTo koristi implementiranu funkcionalnost metode compare
	@Override
	public int compareTo(Kvadrat o) {
		return compare(this, o);
	}

	@Override
	public int compare(Kvadrat o1, Kvadrat o2) {
		return o1.getA() - o2.getA();
	}

}
