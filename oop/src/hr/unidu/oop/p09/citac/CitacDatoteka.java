package hr.unidu.oop.p09.citac;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;
public class CitacDatoteka extends SwingWorker<List<String>, Void> {
   private File dir;
   private List<String> list;
   // referenca na GUI klasu kako bismo mogli ažurirati GUI komponentu
   private PokreniCitac polazni; 
   // u konstruktoru se vrši inicijalizacija "radnika"
   public CitacDatoteka(String d, PokreniCitac p){
       dir = new File(d);
       list = new ArrayList<>();
       polazni = p;
   }
   @Override
   // Obrada koja se vrši u pozadini
   public List<String> doInBackground() {
       for (File file : dir.listFiles()){
           list.add(file.getName());
       }
       return list;
   }
    
   @Override
   // obrada konačnih rezultata
   public void done() {
       try {
           List<String> rez = get();
           polazni.napuniTekst(rez); // ažurira GUI polje pozivom metode iz GUI klase
       } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
       } 
   }
}
