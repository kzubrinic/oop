package hr.unidu.oop.p09;

/**
 * Virtualna dretva pomoću implementacije sučelja Drugi način stvaranja: pomoću
 * klase graditelja virtualnih dretvi Java min. verzije 21
 * 
 * @author Krunoslav Žubrinić
 */
public class VirtualnaDretvaDva implements Runnable {
	// Posao koji se obavlja u dretvi stavlja se u metodu run
	public void run() {
		// dohvaća naziv trenutne dretve
		String naziv = Thread.currentThread().getName();
		System.out.println("Dretva " + naziv + " radi.");
	}

	public static void main(String args[]) throws InterruptedException {
		VirtualnaDretvaDva obj = new VirtualnaDretvaDva();
		obj.virtualna();
		obj.virtualnaAnonimna();
		obj.virtualnaLambda();
	}

	private void virtualna() throws InterruptedException {
		Runnable obj = new VirtualnaDretvaDva();
		// Stvara objekt tipa graditelj platformske dretve
		Thread.Builder.OfVirtual graditelj = Thread.ofVirtual();
		// Graditelj ima niz metoda za podešavanje dretve
		// Želimo li virtualnoj dretvi zadati ime, to radimo metodom name
		graditelj.name("Druga virtualna dretva");
		// Stvara dretvu, predaje objekt obrade i pokreće dretvu
		Thread t2 = graditelj.start(obj);
		// Sve to može i u jednoj liniji
		Thread t3 = Thread.ofVirtual().name("treća").start(obj);
		// Čekamo da dretve završe za nastavak obrade.
		// Bez ove naredbe program bi se često završio prije dretve i
		// na zaslonu ne bismo vidjeli rezultat izvođenja.
		// Meroda join izbacuje provjeravanu iznimku InterruptedException
		t2.join();
		t3.join();
	}

	private void virtualnaAnonimna() throws InterruptedException {
		// Stvara objekt tipa graditelj platformske dretve
		Thread.Builder.OfVirtual graditelj = Thread.ofVirtual();
		// Graditelj ima niz metoda za podešavanje dretve
		// Želimo li virtualnoj dretvi zadati ime, to radimo metodom name
		graditelj.name("Druga virtualna dretva");
		// Stvara dretvu, predaje objekt obrade i pokreće dretvu
		Thread t2 = graditelj.start(new Runnable() {
			@Override
			public void run() {
				// Posao koji se obavlja u dretvi stavlja se u metodu run funkcijskog sučelja
				String naziv = Thread.currentThread().getName();
				System.out.println("Virtualna dretva (anon) " + naziv + " radi.");
			}
		});
		// Sve to može i u jednoj liniji
		Thread t3 = Thread.ofVirtual().name("treća").start(new Runnable() {
			@Override
			public void run() {
				// Posao koji se obavlja u dretvi stavlja se u metodu run funkcijskog sučelja
				String naziv = Thread.currentThread().getName();
				System.out.println("Virtualna dretva (anon) " + naziv + " radi.");
			}
		});
		// Čekamo da dretve završe za nastavak obrade.
		// Bez ove naredbe program bi se često završio prije dretve i
		// na zaslonu ne bismo vidjeli rezultat izvođenja.
		// Meroda join izbacuje provjeravanu iznimku InterruptedException
		t2.join();
		t3.join();
	}

	private void virtualnaLambda() throws InterruptedException {
		// Stvara objekt tipa graditelj platformske dretve
		Thread.Builder.OfVirtual graditelj = Thread.ofVirtual();
		// Graditelj ima niz metoda za podešavanje dretve
		// Želimo li virtualnoj dretvi zadati ime, to radimo metodom name
		graditelj.name("Druga virtualna dretva");
		// Stvara dretvu, predaje objekt obrade i pokreće dretvu
		Thread t2 = graditelj.start(() -> {
			// Posao koji se obavlja u dretvi stavlja se u metodu run funkcijskog sučelja
			String naziv = Thread.currentThread().getName();
			System.out.println("Virtualna dretva (anon) " + naziv + " radi.");

		});
		// Sve to može i u jednoj liniji
		Thread t3 = Thread.ofVirtual().name("treća").start(() -> {
			// Posao koji se obavlja u dretvi stavlja se u metodu run funkcijskog sučelja
			String naziv = Thread.currentThread().getName();
			System.out.println("Virtualna dretva (anon) " + naziv + " radi.");
		});
		// Čekamo da dretve završe za nastavak obrade.
		// Bez ove naredbe program bi se često završio prije dretve i
		// na zaslonu ne bismo vidjeli rezultat izvođenja.
		// Meroda join izbacuje provjeravanu iznimku InterruptedException
		t2.join();
		t3.join();
	}

}
