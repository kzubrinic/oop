public class IspravljenaGreskaStatic2
{
    private int x, y;
    public static void main(String[] args)
    {
        // Greška je ispravljena tako da je u static metodi kreiran objekt. varijable i metode
        // Varijablama i metodama se pristupa na tom objektu, tako
        // da se zna kojoj kopiji varijabli se pristupa.
        // Ovakav naèin rada je znatno bolji od prethodnog!
	 IspravljenaGreskaStatic2 a = new IspravljenaGreskaStatic2();
         a.x = 3;
         a.y = 5;
         System.out.println(a.x + " + " + a.y + " = "+a.zbroj(a.x, a.y)); 
    }   
    public int zbroj(int a, int b)
    {
        return a+b;
    }
}
