package hr.unidu.oop.p03;

public class ParametriKomandna {
    public static void main(String[] args) {
        if (args.length > 0)
            System.out.println("Program je primio " + args.length + " " +
                    "parametara.");
        else
            System.out.println("Program nije primio niti jedan parametar");
        for (String s : args)
            System.out.println("Primljeni parametar: " + s);
    }
}
