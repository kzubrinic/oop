public class TestOsoba2
{
    public static void main(String[] args) {
        Osoba2 p1 = new Osoba2();
        p1.setIme("Pero");
        p1.setStarost(27);
        Osoba2 p2 = new Osoba2("Ana");
        p2.setStarost(25);
        Osoba2 p3 = new Osoba2("Ivo", 29);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
