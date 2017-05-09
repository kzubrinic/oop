package oop.projekt.baza;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import oop.projekt.apl.Student;

public class BazaDatotekom implements Baza{
    private File datoteka;
    private Map<Integer,Student> m;
    public void init(String dat){
        datoteka = new File(dat);
        if (!datoteka.exists()){
            try{
                datoteka.createNewFile();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public Map<Integer,Student> citaj(){
        m = new TreeMap<>();
        String c;
        try(BufferedReader dat = new BufferedReader(new
            FileReader(datoteka))) {
            while ((c = dat.readLine()) != null) {
                String[] dijelovi = c.split(";");
                Student st = new Student(Integer.valueOf(dijelovi[0]).intValue(),dijelovi[1], dijelovi[2]);
                if (!m.containsKey(Integer.valueOf(dijelovi[0])))
                    m.put(Integer.valueOf(dijelovi[0]), st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
    public void dodaj(int id, Student s){
        try(PrintWriter dat = new
            PrintWriter(new FileWriter(datoteka,true))){ 
                dat.println(s.getId()+";"+s.getImePrezime()+";"+s.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void izmjeni(int id, Student s){
        String c;
        List<String> lines = new ArrayList<>();
        try(BufferedReader dat = new BufferedReader(new FileReader(datoteka))) {
            while ((c = dat.readLine()) != null) {
                String[] dijelovi = c.split(";");
                if (Integer.valueOf(dijelovi[0]).intValue() == id){
                    lines.add(s.getId()+";"+s.getImePrezime()+";"+s.getEmail());
                } else{
                    lines.add(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try(PrintWriter dat = new PrintWriter(new FileWriter(datoteka))) {
            for (String l: lines)
                dat.println(l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
