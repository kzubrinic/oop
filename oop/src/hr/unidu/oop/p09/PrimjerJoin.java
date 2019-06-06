package hr.unidu.oop.p09;

class PrimjerJoin implements Runnable{
    public void run(){

        try {
            // Dretva pauzira 2 sekunde
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i<10; i++){
            // dohvaća naziv trenutne dretve
            String naziv = Thread.currentThread().getName();
            System.out.println("Dretva " + naziv + " radi.");
        }
    }

    public static void main(String[] args){
        VisestrukeDretve obj = new VisestrukeDretve();
        Thread t1 = new Thread(obj, "PRVA");
        Thread t2 = new Thread(obj);
        t2.setName("DRUGA");
        Thread t3 = new Thread(obj);
        t3.setName("TREĆA");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(5);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        try {
            // sljedeća dretva neće početi s izvođenjem sve dok ova
            // ne završi
            t1.join();
        } catch(Exception ex)  {
            ex.printStackTrace();
        }
        // 2. dretva neće početi s izvođenjem sve dok 1. ne završi
        t2.start();
        try {
            // sljedeća dretva neće početi s izvođenjem sve dok ova
            // ne završi
            t2.join();
        } catch(Exception ex)  {
            ex.printStackTrace();
        }
        // 3. dretva neće početi s izvođenjem sve dok 2. ne završi
        t3.start();
    }
}
