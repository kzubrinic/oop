package hr.unidu.oop.p09;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Dretva koja vraća povratnu vrijednost 
 * @author Krunoslav Žubrinić
 */
public class VirtualnaDretvaVracaVrijednost {
 
    public static void main(String[] args) throws Exception, ExecutionException{
    	Callable<Integer> objZbroj = new OpZbroj();
    	Callable<Long> objUmnozak = new OpUmnozak();
    	
        FutureTask<Integer> obrada1 = new FutureTask<>(objZbroj);
        FutureTask<Long> obrada2 = new FutureTask<>(objUmnozak);
        
        Thread t1 = Thread.ofVirtual().start(obrada1);
        Thread t2 = Thread.ofVirtual().start(obrada2);

        int zbroj = obrada1.get();
        long umnozak = obrada2.get();
        
        System.out.println("Dretve su vratile zbroj: " + zbroj + " i umnožak: " + umnozak);
    }
    
    
}
//Posao koji se obavlja u dretvi stavlja se u metodu call
	
	