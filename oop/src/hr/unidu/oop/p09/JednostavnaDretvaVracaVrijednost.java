package hr.unidu.oop.p09;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Dretva koja vraća povratnu vrijednost 
 * @author Krunoslav Žubrinić
 */
public class JednostavnaDretvaVracaVrijednost implements Callable<Integer>{
	// Posao koji se obavlja u dretvi stavlja se u metodu call
	@Override
	public Integer call() throws Exception {
		int suma = 0;
		for (int i = 0; i < 10; i++) {
            suma+=i;
        }
        System.out.println("Gotovo zbrajanje");  
		return suma;
	} 
  
    public static void main(String[] args) throws Exception, ExecutionException{
    	Callable<Integer> obj = new JednostavnaDretvaVracaVrijednost();
        FutureTask<Integer> obrada = new FutureTask<>(obj);
        Thread t1 = new Thread(obrada);  
        t1.start(); 
        int rezultatObrade = obrada.get();
        System.out.println("Dretva je vratila: " + rezultatObrade);
    }
	 
}