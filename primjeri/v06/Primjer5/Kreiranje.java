package Primjer5;
/**
 * Primjer izbacivanje iznimke.
 * 
 * @author Krunoslav Žubriniæ
 * @version travanj 2009.
 */
import java.util.*;
public class Kreiranje
{
    private String stog[]=new String[5];
    private int vrh=-1;
    public void kreni() {
       try {
            System.out.println("Skidam element : "+pop()); 
        }
        catch (EmptyStackException e) {
            e.printStackTrace();   
        }    
    }    
    public String pop() { 
        if (vrh < 0) { 
            throw new EmptyStackException(); 
        } 
        if (vrh>=0)
            vrh--;
        return stog[vrh+1]; 
    } 
}
