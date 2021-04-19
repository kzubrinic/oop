package hr.unidu.oop.p06;

/**
 * Rad s datotekama (razred File).
 * Programski kod je inspiriran primjerima s FER-ovih predavanja iz OOP-a
 * (Tema 8 - rad s datotekama 2014/2015.).
 *
 * @version (travanj 2015.)
 */

import java.io.*;

public class PrimjerFile {
    public void osnovneMetode() {
        File dir = new File("c:/Windows");
        File file1 = new File(dir, "write.exe");
        File file2 = new File("Datoteke/testna.txt");
        File parent = file1.getParentFile();
        boolean exists = file2.exists();
        boolean readable = file1.canRead();
        boolean writeable = file1.canWrite();
        boolean executable = file1.canExecute();
        long fileSize = file1.length();
        boolean isFile = file1.isFile();
        boolean isDirectory = file1.isDirectory();
        boolean isDirectory2 = dir.isDirectory();
        String path = file2.getPath();
        String pathA = file2.getAbsolutePath();
        System.out.println("Folder datoteke write.exe: " + parent);
        System.out.println("Datoteke/testna.txt postoji? " + exists);
        System.out.println("c:/Windows/write.exe se može čitati? " + readable);
        System.out.println("c:/Windows/write.exe se može mijenjati? " + writeable);
        System.out.println("c:/Windows/write.exe se može izvesti? " + executable);
        System.out.println("Veličina datoteke c:/Windows/write.exe je: " + fileSize + "B");
        System.out.println("c:/Windows/write.exe je datoteka? " + isFile);
        System.out.println("c:/Windows/write.exe je mapa? " + isDirectory);
        System.out.println("c:/Windows je mapa? " + isDirectory2);
        System.out.println("Putanja do datoteke testna.txt je " + path);
        System.out.println("Apsolutna putanja do datoteke testna.txt je " + pathA);
    }

    public void ispisDatoteka() {
        File mapa = new File("Datoteke");
        File[] d = mapa.listFiles();
        System.out.println("MAPA: " + mapa.getAbsolutePath());
        for (File f : d) {
            if (f.isDirectory()) {
                System.out.println("[MAPA]" + f.getName());
            } else
                System.out.println(f.getName());
        }
    }

    public void stvoriNovu() {
        File file2 = new File("Datoteke/testna2.txt");
        try {
            if (file2.createNewFile())
                System.out.println("Datoteka " + file2.getAbsolutePath() + " je" +
                        " uspješno stvorena!");
            else
                System.out.println("Datoteka " + file2.getAbsolutePath() + " " +
                        "već postoji!");
        } catch (IOException e) {
            System.out.println("Greška stvaranja datoteke " + file2.getAbsolutePath());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PrimjerFile o = new PrimjerFile();
        o.osnovneMetode();
        o.ispisDatoteka();
        o.stvoriNovu();
    }

}
