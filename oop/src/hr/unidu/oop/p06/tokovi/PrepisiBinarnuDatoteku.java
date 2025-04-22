package hr.unidu.oop.p06.tokovi;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
public class PrepisiBinarnuDatoteku {
  public void kreni(){
    Path pi = Paths.get("oop/slike/DukeMask-mala.png");
    Path po = Paths.get("oop/slike/out-DukeMask-mala.png");
    try (InputStream is = Files.newInputStream (pi);
    		OutputStream os = Files.newOutputStream (po)) {
      byte[] buff = new byte[1024];
      while (true) {
        int r = is.read(buff);
        if (r < 1) break;
        os.write(buff);
        for(int i=0; i<r; i++) {
            System.out.printf("%02x ", buff[i]);
        }
          
      }
    } catch (IOException ex) {
    	ex.printStackTrace();
      System.err.println(ex.getMessage());
    }
  }
  public static void main(String[] args) {
	  PrepisiBinarnuDatoteku o = new PrepisiBinarnuDatoteku();
	  o.kreni();
  }
}
