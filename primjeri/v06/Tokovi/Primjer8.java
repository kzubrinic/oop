package Tokovi;

/**
 * Primjer korištenja PrintWritera za ispis
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
import java.nio.charset.Charset;
import java.io.OutputStreamWriter;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
public class Primjer8 {

    public void unosPodataka() {
        File d = stvaranjeDatoteke();
            // drugi parametar konstruktora FileWriter true znaèi da se podaci dodaju
            //  u datoteku (slièno kao append u C-u)
            // Inaèe je "normalno" ponašanje da se stara datioteka gazi novom!
        try(PrintWriter datoteka = new PrintWriter(new FileWriter(d,true))) {
            // unos podataka
            datoteka.println("Ovo ide u prvi red");
            datoteka.println("Ovo ide u drugi red "+175);
            datoteka.println("Primjeri naših èestih æukastih žalosnih ðonovskih slova");
            datoteka.print("Ovo ide u posljednji red "+3.76);
            datoteka.close();
            prikazi(d);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Greška rada s datotekom");
            e.printStackTrace();
        }

        
    }
    
    public void unosPodataka2() {
        File d = stvaranjeDatoteke();
        Charset ks = Charset.forName("windows-1250");
            // drugi parametar konstruktora FileWriter true znaèi da se podaci dodaju
            //  u datoteku (slièno kao append u C-u)
            // Inaèe je "normalno" ponašanje da se stara datioteka gazi novom!
        try(PrintWriter datoteka = new PrintWriter(
            new OutputStreamWriter(
                new BufferedOutputStream(
                    new FileOutputStream(d)),ks))) {
            // unos podataka
            datoteka.println("Ovo ide u prvi red");
            datoteka.println("Ovo ide u drugi red "+175);
            datoteka.println("Primjeri naših èestih æukastih žalosnih ðonovskih slova");
            datoteka.print("Ovo ide u posljednji red "+3.76);
            datoteka.close();
            prikazi(d,ks);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Greška rada s datotekom");
            e.printStackTrace();
        }
    }
    
    
    
    private void prikazi(File d) throws IOException{
        String c = "";
        try(BufferedReader dat = new BufferedReader(new FileReader(d))){
          while ((c = dat.readLine()) != null) {
            System.out.println(c);
          }
        }
    }
    
    private void prikazi(File d, Charset ks) throws IOException{
        String c = "";
        try(BufferedReader dat = new BufferedReader(
            new InputStreamReader(
                new BufferedInputStream(
                    new FileInputStream(d)), ks))){
          while ((c = dat.readLine()) != null) {
            System.out.println(c);
          }
        }
    }
    
    private File stvaranjeDatoteke() {
        Unos u = new Unos();
        String dat=u.unesiString("Unesi naziv datoteke: ");
        File d = new File(dat);
        if (!d.exists()){
            try{
                d.createNewFile();
            } catch (IOException e) {
                System.out.println("Greška stvaranja datoteke");
                e.printStackTrace();
            }
        }
        return d;
    }
}
