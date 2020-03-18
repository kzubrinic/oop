package hr.unidu.oop.p04.genericki;
public class TestBroj {
  public static void main(String[] args) {
    Broj<Integer> i = new Broj<>(15);
    System.out.println(i);
    Broj<Double> d = new Broj<>(3.14);
    // ovo ne prolazi
    //Broj<String> s = new Broj<>(3.14);
    System.out.println(d);
    // Može i ovako radi kompatibilnosti sa starijim bibliotekama koje
    // ne znaju raditi s generičkim tipovima podataka (prije jave 5).
    // NIJE preporučljivo koristiti za drugačije namjene!
	Broj d2 = new Broj(6.28);
    System.out.println(d2);
  }
}
