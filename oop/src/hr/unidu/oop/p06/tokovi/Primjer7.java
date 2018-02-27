package hr.unidu.oop.p06.tokovi;
/**
 * �itanje podataka iz datoteke pomo�u metoda BufferedReader klase
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;
import java.nio.charset.Charset;

public class Primjer7 {

    public void citajRetke() {
        String c = "";
        String ime = "README.TXT";
        // podrazumijevana kodna stranica - UTF-8
        try(BufferedReader dat = new BufferedReader(new FileReader(ime))) {
            while ((c = dat.readLine()) != null) {
                // readLine() skida znak za novi red pa ga treba dodati za prikaz na ekranu
                System.out.println(c);
            }
        } catch (IOException e) {
            System.out.println("Gre�ka �itanja datoteke " + ime + " !");
            e.printStackTrace();
        }
    }
    
    public void citajRetke2() {
        String c = "";
        String ime = "README.TXT";
        // izabrana kodna stranica - windows-1250
        Charset ks = Charset.forName("windows-1250");
        try(BufferedReader dat = new BufferedReader(
            new InputStreamReader(
                new BufferedInputStream(
                    new FileInputStream(ime)), ks))){

            while ((c = dat.readLine()) != null) {
                // readLine() skida znak za novi red pa ga treba dodati za prikaz na ekranu
                System.out.println(c);
            }
        } catch (IOException e) {
            System.out.println("Gre�ka �itanja datoteke " + ime + " !");
            e.printStackTrace();
        }
    }

    public void citajTokene() {
        String c = "";
        String ime = "README.TXT";
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(ime)))) {
            s.useDelimiter("o"); // razbijamo na slovu 'o'
            while ((s.hasNext())) {
                // metoda hasNext() provjerava da li postoji sljede�i token
                // metoda next() pristupa nizu znakova
                System.out.println(s.next());
            }
        } catch (IOException e) {
            System.out.println("Gre�ka �itanja datoteke " + ime + " !");
            e.printStackTrace();
        }
    }
    
    public void citajTokene2() {
        String c = "";
        String ime = "README.TXT";
        Charset ks = Charset.forName("windows-1250");
        try(Scanner s = new Scanner(new BufferedReader(
            new InputStreamReader(
                new BufferedInputStream(
                    new FileInputStream(ime)), ks)))) {
            s.useDelimiter("o"); // razbijamo na slovu 'o'
            while ((s.hasNext())) {
                // metoda hasNext() provjerava da li postoji sljede�i token
                // metoda next() pristupa nizu znakova
                System.out.println(s.next());
            }
        } catch (IOException e) {
            System.out.println("Gre�ka �itanja datoteke " + ime + " !");
            e.printStackTrace();
        }
    }


}
