package hr.unidu.oop.p09;
/*
 * Primjer podjele realnog posla na N dretvi.
 * Podjela je jednostavna tako da svaka dretva obrađuje N/brojDretvi elemenata
 */
public class MaxdT{
	public static void main(String[] args) {
		MaxdT p = new MaxdT();
		p.radi();
	}
	private void radi() {
		int brDretvi = 4;
		int N = 100000;
		long startTime = System.currentTimeMillis();
		Obrada[] dretve = new Obrada[brDretvi];
		for (int i = 0; i < brDretvi; i++) {
			dretve[i] = new Obrada(brDretvi, i, N);
			dretve[i].start();
		}
		for (int i = 0; i < brDretvi; i++) {
	         while (dretve[i].isAlive()) {
	             try {
	            	 dretve[i].join();
	             }
	             catch (InterruptedException e) {
	            	 e.printStackTrace();
	             }
	          }
		}
		int pomI = 0;
		int pomMax = 0;
		for (int i = 0; i < brDretvi; i++) {
			if (dretve[i].getMaxDiv() > pomMax) {
				pomMax = dretve[i].getMaxDiv();
				pomI = dretve[i].getWhichInt();
			}
		}
		long proteklo = System.currentTimeMillis() - startTime;
		System.out.println("\nNajviše djelitelja u intervalu " + 
	            "1 - " + N + " je " + pomMax);
	      System.out.println("Broj koji ima najviše djelitelja je " + pomI);
	      System.out.println("Ukupno vrijeme:  " + 
	            (proteklo / 1000.0) + " s");
	}

	class Obrada extends Thread {
		private int br;
		private int preostalo;
		private int n;
		private int maxBrDjelitelja = 0;
		private int kojiBrojMax = 0;

		public Obrada(int br, int pr, int n) {
			this.br = br;
			this.preostalo = pr;
			this.n = n;
		}

		@Override
		public void run() {
			int brDjelitelja = 0;
			for (int i = 0; i <= n; i++) {
        		 if (i % br == preostalo) {
        			 brDjelitelja = 0;
       	           	 for (int d = 1;  d <= i;  ++d ) {  
        	              if (i % d == 0)
        	                 brDjelitelja++;
        	         }
       	           	 if (brDjelitelja > maxBrDjelitelja) {
       	           		 maxBrDjelitelja = brDjelitelja;
       	           		 kojiBrojMax = i;
       	           	 }
        		 }
    		 }
		}

		public int getMaxDiv() {
			return maxBrDjelitelja;
		}
		public int getWhichInt() {
			return kojiBrojMax;
		}
	}
}
