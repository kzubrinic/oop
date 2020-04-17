package hr.unidu.oop.p09.citac3;
import java.io.File;
import java.util.List;
import javax.swing.SwingWorker;

public class SlozeniCitacDatoteka2 extends SwingWorker<Void, Pomocna> {
    private File dir;
    private PokreniSlozeniCitac2 pozvani;
    public SlozeniCitacDatoteka2(String dir, PokreniSlozeniCitac2 p){
        this.dir = new File(dir);
        pozvani = p;
    }
    @Override
    // Obrada koja se vrši u pozadini
    public Void doInBackground() {
        int i = 0, bi = 0;
        int br = dir.listFiles().length;
        setProgress(i);
        for (File file : dir.listFiles()){
            bi = i*100/br;
            Pomocna p = new Pomocna(file.getName(), bi);
            publish(p); // slanje međurezultata - naziv datoteke i % obrade
            setProgress(bi);
            pauziraj(100); // pauza 1/10 sekunde
            ++i;
        }
        return null;
    }
    
    @Override
    // dohvaćanje i obrada međurezultata
    protected void process(List<Pomocna> pom) {
    	Pomocna p = pom.get(pom.size()-1); // dohvati posljednji poslani međurezultat
        pozvani.napuniTekst(p.getNaziv()); // ažurira GUI nazivom datoteke
        pozvani.napuniProgressBar(p.getBr()); // ažuriraj progress bar
    }
    @Override
    // obrada konačnih rezultata
    public void done() {
        try {
            pozvani.napuniProgressBar(100);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }


    private void pauziraj(int ms){
       try {
           Thread.sleep(ms);
       }catch (Exception e) {
           e.printStackTrace();
       }   
    }
}