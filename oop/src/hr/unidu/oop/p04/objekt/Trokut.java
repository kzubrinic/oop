package hr.unidu.oop.p04.objekt;

public class Trokut
{
    // instance variables - replace the example below with your own
    private int a, b, c;
    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }
    public int getC(){
        return c;
    }
    public Trokut(){
        a = 3;
        b = 4;
        c = 5;
    }
    public Trokut(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public boolean equals(Trokut t){
        if (this == t) {
            return true;
        }
        if (!(t instanceof Trokut)){
            return false;
        }
        return (a == t.getA() && b == t.getB() && c == t.getC());
    }
    public int hashCode(){
        final int prim = 31;
        int hash = 1;
        hash = prim * hash + a;
        hash = prim * hash + b;
        hash = prim * hash + c;
        return hash;
    }
    public String toString(){
        return String.format("Trokut stranica duljine: %d, %d i %d", a, b, c);
    }
}
