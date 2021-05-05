package hr.unidu.oop.p09.bazendretvi;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public class PrimjerBazenaDretvi {
     public static void main(String[] args) {
    	// "Bazen dretvi" fiksne veličine 5. Kada se zauzme 5 dretvi,
    	//  obrada čeka dok neka od njih ne završi.
        ExecutorService ex1 = Executors.newFixedThreadPool(5);
        // "Bazen dretvi" dinamičke veličine. Kada je potrebno, nova dretva se
        //  stvara. Ako je obrada neke od prethodno stvorenih završila, ta
        //  dretva se "reciklira". 
		ExecutorService ex2 = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Runnable radna = new RadnaDretva(i+1);
            // U prvi bazen spremamo dretve koje ne vraćaju povratnu vrijednost
            ex1.execute(radna);
        }
		for (int i = 0; i < 10; i++) {
			// U drugi bazen spremamo dretve koje vraćaju povratnu vrijednost
			Callable<String> radna = new RadnaDretva(i+1); 
			// Za vraćanje vrijednosti se koristi objekt "omotač" tipa Future 
			Future<String> obrada = ex2.submit(radna);
			try {
				// Dohvaćamo vraćen u vrijednost
				String rez = obrada.get();
				System.out.println(rez);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
        }

        ex1.shutdown();
		ex2.shutdown();
		// Čekamo u petlji dok se sve obrade ne završe
		while (!ex1.isTerminated() || !ex2.isTerminated()) {}
 	    System.out.println("Sve obrade su završene.");
    }
}
