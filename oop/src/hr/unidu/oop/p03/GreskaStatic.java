package hr.unidu.oop.p03;
public class GreskaStatic
{
    private int x, y;
    public static void main(String[] args)
    {
        // gre�ka kod prevo�enja jer se iz static metode
        // poku�avaju koristiti varijable i metode koje nisu static
        //x=3;
        //y=5;
       // System.out.println(x + " + " + y + " = "+zbroj(x,y));
    }
    public int zbroj(int a, int b)
    {
        return a+b;
    }
}
