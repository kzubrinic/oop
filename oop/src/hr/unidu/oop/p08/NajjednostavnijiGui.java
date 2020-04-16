package hr.unidu.oop.p08;
import javax.swing.*;
/*
 * Najjednostavnija swing GUI aplikacija
 */
// Klasa je izvedena iz klase JFrame i ima pristup svinm atributima i
//   metodama u klasi JFRame i njoj nadređenih klasa.
//public class NajjednostavnijiGui extends JFrame{
public class NajjednostavnijiGui extends JFrame{
	public static void main(String[] args){
		NajjednostavnijiGui p = new NajjednostavnijiGui();   
	    p.setSize(400, 200);
	    //p.setLocationRelativeTo(null);
	    p.setVisible(true);
	}
}