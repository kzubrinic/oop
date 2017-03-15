package usporedbaobjekata;

public class Trokut implements Comparable{
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
        if ((t == null) || !(t instanceof Trokut)){
            return false;
        }
        Trokut drugi = (Trokut) t;
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
    
    public int compareTo(Object o){
        Trokut t = (Trokut)o;
        if (a+b+c < t.getA()+t.getB()+t.getC())
            return -1;
        else if (a+b+c > t.getA()+t.getB()+t.getC()) 
            return 1;
        else
            return 0;
    }
}
