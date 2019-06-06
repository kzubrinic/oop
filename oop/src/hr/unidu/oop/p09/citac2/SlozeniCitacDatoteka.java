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
    private JTextArea polje;
    private JProgressBar progressBar;
    public SlozeniCitacDatoteka(String dir, JTextArea polje, JProgressBar progressBar){
        this.dir = new File(dir);
        list = new ArrayList<>();
        this.polje=polje;
        this.progressBar = progressBar;
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
        for (int b : brojevi) {
             progressBar.setValue(b);
        }
    }

    @Override
    // obrada konačnih rezultata
    public void done() {
        try {
            List<String> rez = get();
            for (String s : rez)
                polje.append(s+"\n");
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } 
        progressBar.setValue(100);
    }
    
    private void pauziraj(int ms){
       try {
           Thread.sleep(ms);
       }catch (Exception e) {
           e.printStackTrace();
       }   
    }
}