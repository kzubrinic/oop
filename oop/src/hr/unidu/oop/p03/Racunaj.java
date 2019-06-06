package hr.unidu.oop.p03;
/**
 * Vježbe 3 - primjer s razinama pristupa - testna metoda
 * @author Krunoslav Žubrinić
 * @version ožujak 2008.
 */
public class Racunaj {
	public static void main(String[] args) {
		MatOp novi=new MatOp();

		// Pokušaj korištenja metode zbroj iz klase MatOp uzrokovat će
		// grešku jer metoda zbroj ima private razinu pristupa!
		//System.out.println(novi.zbroj(3,7));
	}
}