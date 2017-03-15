package genericki;
public class Test{
  public static void main(String[] args) {
    Broj<Integer> i = new Broj<>(15);
    System.out.println(i);
    Broj<Double> d = new Broj<>(3.14);
    // ovo ne prolazi
    //Broj<String> s = new Broj<>(3.14);
    System.out.println(d);
  }
}
