import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Standardne
{
    public void odrediDatum()
    {
        LocalDateTime datVri = LocalDateTime.now();
        LocalDate danas = datVri.toLocalDate();
        LocalTime sada = datVri.toLocalTime();

        System.out.println(danas);
        System.out.println(sada);
        
        LocalDate dat1 = LocalDate.of(2017, Month.FEBRUARY, 19);
        //LocalDate dat1 = LocalDate.parse("2017-02-19");

        LocalTime vrij1 = LocalTime.of(17,55);
        //LocalTime vrij1 = LocalTime.parse("17:55:10");
        System.out.println(dat1);
        System.out.println(vrij1);
        
        formatirajDatum(datVri);
        
    }
    private void formatirajDatum(LocalDateTime datVri)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String datVr = datVri.format(formatter);
        
        System.out.println("Sada je "+ datVr);

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
