package hr.unidu.oop.p09;

import java.util.concurrent.Callable;

public class OpZbroj implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {
		int suma = 0;
		for (int i = 0; i < 10; i++) {
            suma+=i;
        }
        System.out.println("Gotovo zbrajanje");  
		return suma;
	}
	
}
