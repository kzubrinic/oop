/**
 * Spori način spajanja nizova znakova u String pomoću
 * operatora +.
 * 
 * @author Krunoslav Žubrinić 
 * @version ožujak 2015.
 */
public class StvaranjeStringa{
    String s;
    public void kreniSporo(int n){
        s = "";
        System.out.println("Krenuo...");
        for (int i=0;i<n;i++)
            s = s + 'x';
        System.out.println("Završio!");  
    }
     public void kreniBrzo(int n){
        s = "";
        System.out.println("Krenuo!"); 
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;i++)
            sb.append('x');
        String s=sb.toString();
        System.out.println("Završio!");  
    }

    
}
