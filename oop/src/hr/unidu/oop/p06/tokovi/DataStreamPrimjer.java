package hr.unidu.oop.p06.tokovi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataStreamPrimjer {

	public static void main(String[] args) {
		DataStreamPrimjer d = new DataStreamPrimjer();
		d.spremi();
		d.citaj();
	}
	public void spremi(){
	    Path p = Paths.get("podaci.dat");
	    int i = 123;
	    short s = 8;
	    double pi = 3.141;
	    char znak = 'x';
	    boolean laz = false;
	    try (DataOutputStream d = new DataOutputStream(Files.newOutputStream(p))) {
	    	d.writeInt(i);
	    	d.writeShort(s);
	    	d.writeDouble(pi);
	    	d.writeChar(znak);
	    	d.writeBoolean(laz);
	    	System.out.println("Podaci spremljeni u datoteku podaci.dat su: ");
	    	System.out.println(i+", "+s+", "+pi+", "+znak+", "+laz);
	    } catch (IOException ex) {
	      System.err.println(ex.getMessage());
	    }
	  }
	public void citaj(){
		Path p = Paths.get("podaci.dat");
	    try (DataInputStream d = new DataInputStream(Files.newInputStream(p))) {
	    	int i = d.readInt();
	    	short s = d.readShort();
	    	double pi = d.readDouble();
	    	char znak = d.readChar();
	    	boolean laz = d.readBoolean();
	    	System.out.println("Podaci pročitani iz datoteke podaci.dat su:");
	    	System.out.println(i+", "+s+", "+pi+", "+znak+", "+laz);
	    } catch (IOException ex) {
	      System.err.println(ex.getMessage());
	    }
	  }
}
