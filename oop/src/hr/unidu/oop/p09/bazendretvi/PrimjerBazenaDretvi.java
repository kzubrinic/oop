package hr.unidu.oop.p09.bazendretvi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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
            ex1.execute(radna);
        }
		for (int i = 0; i < 10; i++) {
            Runnable radna = new RadnaDretva(i+1);
            ex2.execute(radna);
        }

        ex1.shutdown();
		ex2.shutdown();
		// Čekamo u petlji dok se sve obrade ne završe
		while (!ex1.isTerminated() || !ex2.isTerminated()) {}
 	    System.out.println("Sve obrade su završene.");
    }
}
