package hr.unidu.oop.p08.simplemvc;

import javax.swing.SwingUtilities;

public class Primjer {

	public static void main(String[] args) {
		try {
		       SwingUtilities.invokeAndWait(() -> {
		    	   new MvcView();
		       });
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}
