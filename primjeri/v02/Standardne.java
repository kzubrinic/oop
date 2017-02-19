import java.util.Date;
import java.text.SimpleDateFormat;

public class Standardne
{
    public void odrediDatum()
    {
        Date danas = new Date();
        System.out.println(danas.getTime());
        System.out.println(danas.toString());
    }
    public void formatirajDatum()
    {
        Date dan = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm"); 
        System.out.println("Danas je "+ df.format(dan));

    }
    public void desetSlucajnih(int pocetak, int kraj)
    {
        for (int i = 0; i < 10; i++)
        System.out.println(pocetak +(int)(Math.random()*kraj));
    }
    public void josNekeMath()
    {
        double x = 10, y = 7.671, neg = -12; 
        System.out.println("Modulo broja "+ neg + " je " + Math.abs(neg));
        System.out.println("Od dva broja "+ x + " i " + y + ", veæi je " + Math.max(x,y));        
        System.out.println(x + " na treæu je " + Math.pow(x, 3));
        System.out.println(y + " zaokružen iznosi " + Math.round(y));        
        System.out.println("Kvadratni korijen broja "+ x + " je " + Math.sqrt(x));
    }
    public void formatiraj()
    {
        float a = 2.7189f, b = 1.122f;
        String novi = String.format("%.2f %.1f %.3f", a, b, Math.PI);
        System.out.println(novi);

    }
    
}
