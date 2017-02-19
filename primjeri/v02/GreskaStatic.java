public class GreskaStatic
{
    private int x, y;
    public static void main(String[] args)
    {
        // greška kod prevoðenja jer se iz static metode
        // pokušavaju koristiti varijable i metode koje nisu static
        x=3;
        y=5;
        System.out.println(x + " + " + y + " = "+zbroj(x,y));
    }
    public int zbroj(int a, int b)
    {
        return a+b;
    }
}
