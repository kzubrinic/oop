package hr.unidu.oop.p06.iznimka3;


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
