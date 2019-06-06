package hr.unidu.oop.p03;

public class KomandnaLinija
{
    public static void main(String[] args) {
		for (String par : args)
			System.out.println(par);
		// može i ovako pomoću klasične for petlje
//	for (int i = 0; i < args.length; i ++)
//		System.out.println(args[i]);

}

}
