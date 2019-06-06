package hr.unidu.oop.p03;

import java.util.Random;

public class VisedimenzijskoPolje{
    // Primjer pravokutnog polja zadane velikčine kod deklaracije
    // Paralela s C 2D poljima
    public void prikazi(){
        int [][] arr = new int[2][3];
        arr[0][0]=2;
        arr[0][1]=3;
        arr[0][2]=7;
        arr[1][0]=1;
        arr[1][1]=9;
        arr[1][2]=4;
        for (int i = 0; i < arr.length; i++) 
            for (int j = 0; j < arr[i].length; j++) 
            System.out.println("Podatak na poziciji ("+i+","+j+") je: "+arr[i][j]);
    }

    // Primjer polja koje se sastoji od polja različite duljine
    // Paralela s C poljima pokazivača
    public void prikazi2(){
        int [][] arr = new int[5][];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int brs = r.nextInt(5) + 1;
            arr[i] = new int[brs]; // svaki redak sadrži polje različite duljine
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = r.nextInt(100);
                System.out.println("Podatak na poziciji (" + i + "," + j + ") je: " + arr[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        VisedimenzijskoPolje v = new VisedimenzijskoPolje();
        v.prikazi();
        v.prikazi2();
    }
}
