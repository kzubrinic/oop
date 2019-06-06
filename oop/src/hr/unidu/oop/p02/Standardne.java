package hr.unidu.oop.p02;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Standardne{
	/**
	 * Metoda koristi klase i metode uvedene u Javi verzije 8
	 */
    public void odrediDatum()    {
    	System.out.println();
    	System.out.println("---- METODA odrediDatum ---- ");
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
    private void formatirajDatum(LocalDateTime datVri){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String datVr = datVri.format(formatter);
        System.out.println("Sada je "+ datVr);

    }
    /**
	 * Metoda koristi klase i metode podržane u Javi prije verzije 8
	 */
    public void odrediDatumStaro()    {
    	System.out.println();
    	System.out.println("---- METODA odrediDatumStaro ---- ");
    	Date danas = new Date(); // trenutni datum
    	//System.out.println(danas.toString());

    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
    	System.out.println(df.format(danas));
    	df = new SimpleDateFormat("HH:mm:ss.SS"); 
    	System.out.println(df.format(danas));

    	// Klase calendar i Date - zadani datum i vrijeme
        Calendar calendar = new GregorianCalendar();
        // mjeseci: siječanj = 0, veljača = 1,... prosinac = 11
        calendar.set(2017, 1, 19,17, 55);
    	Date dat1 = calendar.getTime();

    	df = new SimpleDateFormat("dd.MM.yyyy");
    	System.out.println(df.format(dat1));
    	df = new SimpleDateFormat("HH:mm"); 
    	System.out.println(df.format(dat1));
 
        formatirajDatumStaro(danas);
    }
    private void formatirajDatumStaro(Date datVri){
    	SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm"); 
    	System.out.println("Sada je " + df.format(datVri));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    }
    public void slucajni() {
    	System.out.println();
    	System.out.println("---- METODA slucajni ---- ");
        Random r = new Random();
        boolean b = r.nextBoolean();
        float f1 = r.nextFloat();
        float f2 = r.nextFloat()*100;
        System.out.println("Slučajna logička vrijednost: " + b);
        System.out.println("Slučajni float: " + f1);
        System.out.println("Slučajni float u intervalu 0.00 - 99.99: " + f2);
    	for (int i = 0; i < 10; i++)
        System.out.println("Slučajni cijeli broj u intervalu 10-100: " + (r.nextInt(90)+10));
    }
    public void josNekeMath(){
    	System.out.println();
    	System.out.println("---- METODA josNekeMath ---- ");
        double x = 10, y = 7.671, neg = -12; 
        System.out.println("Modulo broja "+ neg + " je " + Math.abs(neg));
        System.out.println("Od dva broja "+ x + " i " + y + ", veći je " + Math.max(x,y));        
        System.out.println(x + " na treću je " + Math.pow(x, 3));
        System.out.println(y + " zaokružen iznosi " + Math.round(y));        
        System.out.println("Kvadratni korijen broja "+ x + " je " + Math.sqrt(x));
    }
    public void formatiraj(){
    	System.out.println();
    	System.out.println("---- METODA formatiraj ---- ");
        float a = 2.7189f, b = 1.122f;
        String novi = String.format("%.2f %.1f %.3f", a, b, Math.PI);
        System.out.println(novi);
    }
    public static void main(String[] args){
        Standardne s = new Standardne();
        s.odrediDatum();
        s.odrediDatumStaro();
        s.slucajni();
        s.josNekeMath();
        s.formatiraj();
    }
    
}
