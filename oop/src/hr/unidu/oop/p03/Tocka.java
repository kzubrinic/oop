package hr.unidu.oop.p03;
public class Tocka
{
    private int x,y;

    public Tocka(int x, int y){
        this.x = x;
        this.y = y;
        System.out.println(this);
    }

    public String toString(){
        return String.format("Točka na poziciji x=%d, y=%d", x, y);
    }
}
