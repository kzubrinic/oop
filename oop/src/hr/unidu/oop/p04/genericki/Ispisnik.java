package hr.unidu.oop.p04.genericki;

public class Ispisnik<T> {
    private T podatak;
    public Ispisnik(T t) {
        podatak = t;
    }
    @Override
    public String toString() {
        String pom;
        if (podatak instanceof Integer)
            pom = String.format("Cijeli broj %d", podatak);
        else if (podatak instanceof Double || podatak instanceof Float )
            pom = String.format("Realan broj %.2f", podatak);
        else
            pom = String.format("\"Znakovni prikaz %s", podatak);
        return pom;
    }
}
