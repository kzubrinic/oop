package hr.unidu.oop.p09.citac2;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.JProgressBar;

public class SlozeniCitacDatoteka extends SwingWorker<List<String>, Integer> {
    private File dir;
    private List<String> list;
    private PokreniSlozeniCitac pozvani;
    public SlozeniCitacDatoteka(String dir, PokreniSlozeniCitac poz){
        this.dir = new File(dir);
        list = new ArrayList<>();
        pozvani = poz;
    }
    @Override
    // Obrada koja se vrši u pozadini
    public List<String> doInBackground() {
        int i = 0, bi = 0;
        int br = dir.listFiles().length;
        setProgress(i);
        for (File file : dir.listFiles()){
            list.add(file.getName());
            bi = i*100/br;
            // Stvara objekt tipa PropertyChange i aktivira PropertyChangeListener u
            //  klasi koja je pozvala ovu obradu (klasa PokreniSlozeniCitac)
            // Ta obrada ažurira prograss bar.
            setProgress(bi); //
            pauziraj(100); // pauza 1/10 sekunde
            ++i;
        }
        return list;
    }

    @Override
    // obrada konačnih rezultata
    public void done() {
        try {
            List<String> rez = get();
            pozvani.napuniTekst(rez); // ažurira GUI polje pozivom metode iz GUI klase
            pozvani.napuniProgressBar(100); // napuni na ktajnju vrijednost
        } catch (ExecutionException | InterruptedException e) {
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