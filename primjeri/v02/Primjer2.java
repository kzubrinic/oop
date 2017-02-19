public class Primjer2 {
    public void main(String[] args) {
        // Static metoda se poziva navoðenjem naziva klase, 
        //  a ne objekta.
        Pjesmas.sviranje("Mozart");
    } 
    public int test(final int a){
        final int h=9 ;
        h = h+1;
        return h+1;
    }
}

