package PrimjerOmotaèa;

public class PrimjerOmotaca {
    Number a,b;
    double c;
    public void primjerInt(int prvi, String drugi) {
        a = new Integer(prvi);
        b = new Float(drugi);

        c = a.doubleValue() + b.doubleValue(); 

        if (a.equals(b))
            System.out.println("Brojevi su jednaki. Rezultat je "+c);
        else
            System.out.println("Brojevi su razlièiti. Rezultat je "+c);
    }
}