package hr.unidu.oop.p06.tokovi;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
public class PrepisiBinarnuDatotekuBuffer {
  public void prepisiSliku(){
    Path pi = Paths.get("oop/slike/DukeMask-mala.png");
    Path po = Paths.get("oop/slike/out-DukeMask-mala2.png");
    try (BufferedInputStream is = new BufferedInputStream(Files.newInputStream (pi));
         BufferedOutputStream os = new BufferedOutputStream(Files.newOutputStream (po))) {
      byte[] buff = new byte[1024];
      while (true) {
        int r = is.read(buff);
        if (r < 1) break;
        os.write(buff);
        for(int i=0; i<r; i++){
          System.out.printf("%02x ", buff[i]);
        }
      }
    } catch (IOException ex) {
      System.err.println(ex.getMessage());
    }
  }
  
  public static void main(String[] args) {
	  PrepisiBinarnuDatotekuBuffer o = new PrepisiBinarnuDatotekuBuffer();
	  o.prepisiSliku();
  }
}
