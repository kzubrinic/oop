package hr.unidu.oop.p09;

import java.util.concurrent.Callable;

public class OpUmnozak implements Callable<Long>{

	@Override
	public Long call() throws Exception {
		long umnozak = 1;
		for (int i = 1; i < 10; i++) {
            umnozak*=i;
        }
        System.out.println("Gotovo množenje");  
		return umnozak;
	}
}
