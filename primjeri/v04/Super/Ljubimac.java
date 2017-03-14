package Super;
public class Ljubimac {
    Ljubimac() {
        Pas p = new Pas("Reks");
        p.glasanje();
        p.lutanje();
        Zivotinja.spavanje();

        // primjer korištenja kljuène rijeèi super
        PorodicaPasa pp=new PorodicaPasa("reks");
        pp.glasanje();
    }    
    
}
