package hr.unidu.oop.p03;

public class FloatUsporedjivanje {

    public void pogresno(){
        double f1 = 2.6;
        double f2 = 0;

        for (int i = 0; i < 26; i++)
            f2 += 0.1;

        // Pogrešan način uspoređivanja jesu li dva realna broja jednaka
        // Očekujemo da je f2 == 2.6
        if (f1 == f2)
            System.out.println("Brojevi su jednaki!");
        else
            System.out.println("Brojevi NISU jednaki! " + f1 + " i " + f2);
    }

    public void ispravno(){
        double f1 = 2.6;
        double f2 = 0;

        for (int i = 0; i < 26; i++)
            f2 += 0.1;

        // Ispravan način uspoređivanja jesu li dva realna broja jednaka
        // Očekujemo malu razliku koju toleriramo
        double tolRazlika = 1E-6; // razlika iza 6. decimale
        if (f1 - f2 < tolRazlika)
            System.out.println("Brojevi su jednaki!");
        else
            System.out.println("Brojevi NISU jednaki! " + f1 + " i " + f2);
    }

    public static void main(String[] args) {
        FloatUsporedjivanje kl = new FloatUsporedjivanje();
        kl.pogresno();
        kl.ispravno();
    }
}
