package hr.unidu.oop.p06;
/**
 * Primjer izbacivanje iznimke.
 * 
 * @author Krunoslav �ubrini�
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
    public static void main(String[] args) {
    	Kreiranje k = new Kreiranje();
    	// Stog je prazan pa će pokušaj skidanja izazvati iznimku
    	k.kreni();
    }
}
