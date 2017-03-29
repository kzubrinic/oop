package liste;
/**
 * Standardna metoda za unos podataka
 */
import java.util.Scanner;
public class Enter {
	private Scanner sc;
	public Enter(){ 
	    sc =  new Scanner(System.in);
	}
	public double addDouble(String tekst) {
	    showText(tekst);
		return sc.nextDouble();
	}
	public int addInt(String tekst) {
	    showText(tekst);	    
		return sc.nextInt();
	}
	public String addString(String tekst) {
	    showText(tekst);	    
		return sc.next();
	}	
	private void showText(String tekst)
	{
	    System.out.println(tekst);
	}
}