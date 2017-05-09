package oop.projekt.prez;

import java.util.Scanner;
import oop.projekt.apl.Sveuciliste;
import oop.projekt.apl.Student;
import oop.projekt.baza.Baza;
import oop.projekt.baza.BazaDatotekom;

public class TekstualnaEvidencija {
    private Sveuciliste s;
    private Baza b;
    private Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        TekstualnaEvidencija e = new TekstualnaEvidencija();
        Baza b = new BazaDatotekom();
        b.init("studenti.txt");
        // drugi parametar je referenca na bazu
        e.s = new Sveuciliste("UNIDU", b);
        e.izbornik();
        
    }
    private void izbornik(){
        while(true) {
            System.out.println("----- I Z B O R N I K -----");
            System.out.println("1 Unos novog studenta");
            System.out.println("2 Promjena e-mail adrese studenta");
            System.out.println("3 Prikaz podataka izabranog studenta");
            System.out.println("4 Prikaz broja studenata");
            System.out.println("5 Prikaz podataka svih studenata");
            System.out.println("6 Izlaz");
            System.out.println("---------------------------");
            System.out.print("Upišite vaš izbor: ");
            if (!izbor())
                return;
        }
    }
    private boolean izbor(){
    	int izbor ;
    	if (sc.hasNextInt())
    		izbor = sc.nextInt();
    	else {
    		sc.next();
    		System.out.println("Pogrešan izbor! Izbor mora biti u intervalu 1-6");
            return true;
    	}
        sc.nextLine();
        System.out.println();
        switch(izbor){
            case 1: 
                unos();
                return true;
            case 2: 
                promjenaEmaila();
                return true;
            case 3: 
                prikaz1();
                return true;
            case 4: 
                prebroji();
                return true;
            case 5: 
                prikaz();
                return true;
            case 6:
                return false;
            default:
                System.out.println("Pogrešan izbor! Izbor mora biti u intervalu 1-6");
                return true;
        }
    }
    private void unos(){
        String ime, prezime, email;
        System.out.print("Ime i prezime studenta: ......... ");
        ime = sc.nextLine();
        //sc.nextLine();  // guta \n koji nastane nakon pritiska na Enter        
        System.out.print("E-mail adresa studenta:.......... ");
        email = sc.nextLine();
        Student st = s.dodajStudenta(ime, email);
        if (st != null)
            System.out.println("Student s id-jem " + st.getId() + " uspješno upisan!");
        else    
            System.out.println("Greška kod upisa!");
    }

    private void promjenaEmaila(){
        System.out.print("Id studenta: .................... ");
        int id = sc.nextInt();
        sc.nextLine();  // guta \n koji nastane nakon pritiska na Enter      
        Student st = s.citajStudenta(id);
        if (st == null){
            System.out.println("Student s id-jem " + id + " ne postoji!");
            return;
        }
        System.out.print("E-mail adresa studenta:.......... ");
        String email = sc.nextLine();
        if (s.promjeniEmail(id, email))
            System.out.println("Studentu s id-jem " + id + " e-mail adresa je promijenjena!");
        else    
            System.out.println("Greška kod promjene e-mail adrese!");
    }
    private void prikaz1(){
        System.out.print("Id studenta: .................... ");
        int id = sc.nextInt();
        String red = s.ispisiSveStudente(id);
        if (red != null)
            System.out.println(red);
        else    
            System.out.println("Student s id-jem " + id + " ne postoji!");
    }
    private void prebroji(){
        System.out.println("Na sveučilište je upisano " + s.getBrojStudenata() + " studenata.");
    }
    private void prikaz(){
        String red = s.ispisiSveStudente();
        if (red != null)
            System.out.println(red);
        else    
            System.out.println("Na sveučilište nije upisan niti jedan student!");
    }
}