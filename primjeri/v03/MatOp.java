/**
 * Vježbe 3 - primjer s razinama pristupa
 * @author Krunoslav Žubrinić
 * @version ožujak 2008.
 */
 
public class MatOp {
	public static void main(String[] args) {
		MatOp novi=new MatOp();
		System.out.println(novi.zbroj(3,7));
	}
	private int zbroj(int a, int b) {
		return a+b;
	}
}
