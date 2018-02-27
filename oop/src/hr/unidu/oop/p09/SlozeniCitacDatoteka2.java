package hr.unidu.oop.p09;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.JProgressBar;

public class SlozeniCitacDatoteka2 extends SwingWorker<Void, Pomocna> {
    private File dir;
    private List<String> list;
    private JTextArea polje;
    private JProgressBar progressBar;
    public SlozeniCitacDatoteka2(String dir, JTextArea polje, JProgressBar progressBar){
        this.dir = new File(dir);
        this.polje=polje;
        this.progressBar = progressBar;
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
        for (Pomocna p : pom){
                polje.append(p.getNaziv()+"\n"); // ažurira GUI nazivom datoteke
                progressBar.setValue(p.getBr()); // ažurira progressbar
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