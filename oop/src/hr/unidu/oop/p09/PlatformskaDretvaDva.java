package hr.unidu.oop.p09;

/**
 * Platformska dretva pomoću implementacije sučelja Drugi način stvaranja:
 * pomoću klase graditelja platformskih dretvi Java min. verzije 21
 * 
 * @author Krunoslav Žubrinić
 */
public class PlatformskaDretvaDva implements Runnable {
	// Posao koji se obavlja u dretvi stavlja se u metodu run
	public void run() {
		// dohvaća naziv trenutne dretve
		String naziv = Thread.currentThread().getName();
		System.out.println("Dretva " + naziv + " radi.");
	}

	public static void main(String args[]) throws InterruptedException {
		PlatformskaDretvaDva obj = new PlatformskaDretvaDva();
		obj.platformska();
		obj.platformskaAnonimna();
		obj.platformskaLambda();
	}

	private void platformska() throws InterruptedException {
		Runnable obj = new PlatformskaDretvaDva();
		// Stvara objekt tipa graditelj platformske dretve
		Thread.Builder.OfPlatform graditelj = Thread.ofPlatform();
		// Graditelj ima niz metoda za podešavanje dretve
		graditelj.name("Druga platformska dretva (implem)");
		graditelj.priority(2);
		// Stvara dretvu, predaje objekt obrade i pokreće dretvu
		Thread t2 = graditelj.start(obj);
		// Čekamo da dretva završi za nastavak obrade.
		// Bez ove naredbe program biu se često završio prije dretve i
		// na zaslonu ne bismo vidjeli rezultat izvođenja.
		// Metoda join izbacuje provjeravanu iznimku InterruptedException
		t2.join();
		// Sve to može i u jednoj liniji
		Thread t3 = Thread.ofPlatform().priority(2).name("Treća dretva (implem)").start(obj);
		t3.join();
	}

	private void platformskaAnonimna() throws InterruptedException {
		Thread.Builder.OfPlatform graditelj = Thread.ofPlatform();
		// Graditelj ima niz metoda za podešavanje dretve
		graditelj.name("Druga platformska dretva (anon)");
		graditelj.priority(2);
		// Stvara dretvu, predaje objekt obrade i pokreće dretvu
		Thread t2 = graditelj.start(new Runnable() {
			@Override
			public void run() {
				// Posao koji se obavlja u dretvi stavlja se u metodu run funkcijskog sučelja
				String naziv = Thread.currentThread().getName();
				System.out.println("Dretva " + naziv + " radi.");
			}
		});
		// Čekamo da dretva završi za nastavak obrade.
		// Bez ove naredbe program biu se često završio prije dretve i
		// na zaslonu ne bismo vidjeli rezultat izvođenja.
		// Metoda join izbacuje provjeravanu iznimku InterruptedException
		t2.join();
		// Sve to može i u jednoj liniji
		Thread t3 = Thread.ofPlatform().priority(2).name("Treća dretva (anon)").start(new Runnable() {
			@Override
			public void run() {
				// Posao koji se obavlja u dretvi stavlja se u metodu run funkcijskog sučelja
				String naziv = Thread.currentThread().getName();
				System.out.println("Dretva " + naziv + " radi.");
			}
		});
		// Čekamo da dretva završi za nastavak obrade.
		// Bez ove naredbe program biu se često završio prije dretve i
		// na zaslonu ne bismo vidjeli rezultat izvođenja.
		// Metoda join izbacuje provjeravanu iznimku InterruptedException
		t3.join();
	}

	private void platformskaLambda() throws InterruptedException {
		Thread.Builder.OfPlatform graditelj = Thread.ofPlatform();
		// Graditelj ima niz metoda za podešavanje dretve
		graditelj.name("Druga platformska dretva (lambda)");
		graditelj.priority(2);
		// Stvara dretvu, predaje objekt obrade i pokreće dretvu koristeći lambda izraz
		Thread t2 = graditelj.start(() -> {
			// Posao koji se obavlja u dretvi stavlja se u metodu run funkcijskog sučelja
			String naziv = Thread.currentThread().getName();
			System.out.println("Dretva " + naziv + " radi.");
		});
		// Čekamo da dretva završi za nastavak obrade.
		// Bez ove naredbe program biu se često završio prije dretve i
		// na zaslonu ne bismo vidjeli rezultat izvođenja.
		// Metoda join izbacuje provjeravanu iznimku InterruptedException
		t2.join();
		// Sve to može i u jednoj liniji
		Thread t3 = Thread.ofPlatform().priority(2).name("Treća dretva (lambda)").start(() -> {
			// Posao koji se obavlja u dretvi stavlja se u metodu run funkcijskog sučelja
			String naziv = Thread.currentThread().getName();
			System.out.println("Dretva " + naziv + " radi.");
		});
		// Čekamo da dretva završi za nastavak obrade.
		// Bez ove naredbe program biu se često završio prije dretve i
		// na zaslonu ne bismo vidjeli rezultat izvođenja.
		// Metoda join izbacuje provjeravanu iznimku InterruptedException
		t3.join();
	}
}
