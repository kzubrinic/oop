public class IspravljenaGreskaStatic1
{
    private static int x, y;
    public static void main(String[] args)
    {
        // Greška je ispravljena tako da su varijable i metode
        // deklarirane kao static pa se mogu pozivati iz static
        // metode.
        // Ovakav naèin rada nije praktièan!
        IspravljenaGreskaStatic1.x=3;
        IspravljenaGreskaStatic1.y=5;
        System.out.println(IspravljenaGreskaStatic1.x + " + " + IspravljenaGreskaStatic1.y + " = 		"+zbroj(IspravljenaGreskaStatic1.x,IspravljenaGreskaStatic1.y));
    }
    public static int zbroj(int a, int b)
    {
        return a+b;
    }
}
