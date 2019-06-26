package hr.unidu.oop.p04.genericki;

public class Trokut {
    private int a,b,c;
    public Trokut(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public String toString(){
        int o = a + b + c;
        return "Trokut opsega " + o;
    }
}
