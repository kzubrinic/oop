package hr.unidu.oop.p04.provjerainstance;

public class Trokut extends Lik
{
    // instance variables - replace the example below with your own
    private int a, b, c;

    public Trokut()
    {
        // initialise instance variables
        a = 3;
        b = 4;
        c = 5;
    }
    
    public boolean equals(Trokut t){
        if (! (t instanceof Trokut))
            return false;
        if (t == this)
            return true;
        return (a == t.a) && (b == t.b) && (c == t.c);
    }
    public String toString()
    {
        return String.format("Trokut stranica duljine: %d, %d i %d", a, b, c);
    }
}
