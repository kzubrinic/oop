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
            publish(bi); // slanje međurezultata - % obrade
            setProgress(bi);
            pauziraj(100); // pauza 1/10 sekunde
            ++i;
        }
        return list;
    }
    
    @Override
    // dohvaćanje i obrada međurezultata
    protected void process(List<Integer> brojevi) {
    	// Priksaži zadnji primljeni međurezultat iz liste
    	Integer b = brojevi.get(brojevi.size()-1);
        pozvani.napuniProgressBar(b);
    }

    @Override
    // obrada konačnih rezultata
    public void done() {
        try {
            List<String> rez = get();
            pozvani.napuniTekst(rez); // ažurira GUI polje pozivom metode iz GUI klase
            pozvani.napuniProgressBar(100);
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