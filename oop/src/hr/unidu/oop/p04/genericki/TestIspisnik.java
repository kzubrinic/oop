package hr.unidu.oop.p04.genericki;
public class TestIspisnik{
    public static void main(String[] args) {
        Ispisnik<Integer> i = new Ispisnik<>(28);
        System.out.println(i);
        Ispisnik<Double> d = new Ispisnik<>(14.7712);
        System.out.println(d);
        Ispisnik<Float> f = new Ispisnik<>(5.9874f);
        System.out.println(f);
        Ispisnik<String> s = new Ispisnik<>("Dobar dan!");
        System.out.println(s);
        Ispisnik<Trokut> t = new Ispisnik<>(new Trokut(3,4,5));
        System.out.println(t);
     }
}

