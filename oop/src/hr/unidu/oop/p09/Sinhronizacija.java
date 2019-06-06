package hr.unidu.oop.p09;

/**
 * @author Krunoslav Žubrinić
 */
public class Sinhronizacija implements Runnable {
    private int iznos = 100;

    // Posao koji se obavlja u dretvi stavlja se u metodu run
    public void run() {
        for (int i = 0; i < 10; i++) {

            //smanjiNesinhronizirano();

            //smanjiSinhroniziranouBloku();

            smanjiSinhronizirano();

            String naziv = Thread.currentThread().getName();
            //System.out.print("Dretva " + naziv + " radi. ");
            System.out.println("Iznos je " + iznos);
        }
    }

    // Neće otići u minus zbog sinhronizacije na razini metode
    private synchronized void smanjiSinhronizirano() {
        if (iznos >= 10) {
            String naziv = Thread.currentThread().getName();
            System.out.println("Dretva " + naziv + " skida 10 ");
            iznos = iznos - 10;
        }
    }

    // Neće otići u minus zbog sinhronizacije na razini bloka instrunkcija
    private void smanjiSinhroniziranouBloku() {
        synchronized (this) { // sinhronizacija na razini OVOG objekta
            if (iznos >= 10) {
                String naziv = Thread.currentThread().getName();
                System.out.println("Dretva " + naziv + " skida 10 ");
                iznos = iznos - 10;
            }
        }
    }

    // Vjerojatno će otići u minus zbog višedretvenog rada
    private void smanjiNesinhronizirano() {
        if (iznos >= 10) {
            String naziv = Thread.currentThread().getName();
            System.out.println("Dretva " + naziv + " skida 10 ");
            iznos = iznos - 10;
        }
    }

    public static void main(String[] args) {
        Sinhronizacija obj = new Sinhronizacija();
        Thread t1 = new Thread(obj, "PRVA");
        Thread t2 = new Thread(obj, "DRUGA");
        Thread t3 = new Thread(obj, "TREĆA");
        System.out.println("Početni iznos je " + obj.iznos);
        t1.start();
        t2.start();
        t3.start();
    }
}