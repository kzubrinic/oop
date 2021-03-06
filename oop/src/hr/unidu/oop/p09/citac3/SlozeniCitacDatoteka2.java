package hr.unidu.oop.p09.citac3;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
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
            Pomocna p = new Pomocna(file.getName(), (file.isFile())? " [Datoteka] " : " [Mapa]");
            publish(p); // slanje međurezultata - naziv i tip datoteke
            // Stvara objekt tipa PropertyChange i aktivira PropertyChangeListener u
            //  klasi koja je pozvala ovu obradu (klasa PokreniSlozeniCitac2)
            // Ta obrada ažurira prograss bar.
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
        pozvani.napuniTekst(p.toString()); // ažurira GUI nazivom datoteke
    }
    @Override
    // obrada konačnih rezultata
    public void done() {
        try {
            pozvani.napuniProgressBar(100);
            pozvani.postaviStatusGumba(true);
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