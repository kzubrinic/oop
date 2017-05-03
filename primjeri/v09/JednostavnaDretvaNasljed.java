
/**
 * Dretva pomoću nasljeđivanja klase
 * @author Krunoslav Žubrinić
 */
public class JednostavnaDretvaNasljed extends Thread{
    // Posao koji se obavlja u dretvi stavlja se u metodu run
    public void run(){  
        for (int i = 0; i < 10; i++) {
            System.out.println("broj " + i);
        }
        System.out.println("Gotovo brojanje");  
    }   
    public static void main(String args[]){  
        JednostavnaDretvaNasljed obj = new JednostavnaDretvaNasljed();  
        obj.start();     
    }
    
    public void pokretanjeDretveAnonimnomKlasom(){
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("broj " + i);
                }
                System.out.println("Gotovo brojanje");
            }
        };
        thread.start();
    }
    
    public void pokretanjeDretvelambdaIzrazom(){
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("broj " + i);
            }
            System.out.println("Gotovo brojenje");
        }).start();
    }
}