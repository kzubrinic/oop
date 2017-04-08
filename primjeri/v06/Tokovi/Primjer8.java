package Tokovi;

/**
 * Primjer kori�tenja PrintWritera za ispis
 * @author kruno
 *
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Primjer8 {

    public void unosPodataka() {
        Unos u = new Unos();
        String dat=u.unesiString("Unesi naziv datoteke: ");
        File d = new File(dat);
        if (!d.exists()){
            try{
                d.createNewFile();
            } catch (IOException e) {
                System.out.println("Gre�ka stvaranja datoteke");
                e.printStackTrace();
            }
        }
            // drugi parametar konstruktora FileWriter true zna�i da se podaci dodaju
            //  u datoteku (sli�no kao append u C-u)
            // Ina�e je "normalno" pona�anje da se stara datioteka gazi novom!
        try(PrintWriter datoteka = new PrintWriter(new FileWriter(dat,true))) {
            // unos podataka
            datoteka.println("Ovo ide u prvi red");
            datoteka.println("Ovo ide u drugi red "+175);
            datoteka.println("Primjeri na�ih �estih �ukastih �alosnih �onovskih slova");
            datoteka.print("Ovo ide u posljednji red "+3.76);
            datoteka.close();
            prikazi(dat);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Gre�ka rada s datotekom");
            e.printStackTrace();
        }

        
    }
    private void prikazi(String ime) throws IOException{
        String c = "";
        try(BufferedReader dat = new BufferedReader(new FileReader(ime))){
          while ((c = dat.readLine()) != null) {
            System.out.println(c);
          }
        }
    }
}
