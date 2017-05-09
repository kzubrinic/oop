package oop.projekt.baza;
import java.util.Map;
import oop.projekt.apl.Student;

public interface Baza{
    void init(String s);
    Map<Integer,Student> citaj();
    void dodaj(int id, Student s);
    void izmjeni(int id, Student s);
}
