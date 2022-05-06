package hr.unidu.oop.p09.citac3;
import java.io.File;
import java.util.List;
import java.util.concurrent.CancellationException;

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
            if (isCancelled()) { // metoda vraća true ako je dretva prekinuta (pozvana metoda cancel() na dretvi)
                System.out.println("Dretva je prekinuta");
                break;
            }
            bi = i*100/br;
            Pomocna p = new Pomocna(file.getName(), (file.isFile())? " [Datoteka] " : " [Mapa]");
            publish(p); // slanje međurezultata - naziv i tip datoteke
            // Stvara objekt tipa PropertyChange i aktivira PropertyChangeListener u
            //  klasi koja je pozvala ovu obradu (klasa PokreniSlozeniCitac2)
            // Ta obrada ažurira prograss bar.
            setProgress(bi);
            pauziraj(10); // pauza 1/10 sekunde

            ++i;
        }
        return null;
    }
    
    @Override
    // dohvaćanje i obrada međurezultata
    protected void process(List<Pomocna> pom) {
    	// Metoda publish se može pozvati i nekoliko puta zaredom prije nego se pozove metoda 
    	//   process na EDT. Zbog toga se međurezultati (koji čekaju na obradu u metodi process) 
    	//   slažu u listu. Kada se pozove metoda process najčešće treba obraditi sve 
    	//   međurezultate u listi
    	for(Pomocna p : pom) {
    	  pozvani.napuniTekst(p.toString()); // ažurira GUI nazivom datoteke
    	}
    }
    @Override
    // obrada konačnih rezultata
    public void done() {
        try {
            pozvani.napuniProgressBar(100);
            pozvani.postaviStatusGumba(true);
        } catch (CancellationException e){
       	     System.out.println("Dretva je prekinuta");
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