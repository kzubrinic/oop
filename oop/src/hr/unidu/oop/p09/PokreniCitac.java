package hr.unidu.oop.p09;
import javax.swing.SwingWorker;
public class PokreniCitac{
    public static void main(String[] args){
        SwingWorker cs = new CitacDatoteka("c:/Windows");  
        cs.execute();
    }
}
