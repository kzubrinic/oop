package Primjer6b;


/**
 * primjer stvaranja vlastite iznimke
 * @author (kruno) 
 * @version (travanj 2015.)
 */
import java.io.IOException;
public class PolumjerException extends IOException{
    public PolumjerException(String s){
        super(s);
    }
}
