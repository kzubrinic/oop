package hr.unidu.oop.p03;

public class KomandnaLinija
{
    public static void main(String[] args) {
	for (int i = 0; i < args.length; i ++)	
		System.out.println(args[i]);
	// može i ovako pomoću for–each petlje
    // for (String par : args)
	//   System.out.println(par);
}

}
