package hr.unidu.oop.p06.tokovi;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
public class IspisiBinarnuDatotekuBuffer {
  public void kreni(){
    Path p = Paths.get("duke.png");
    try (BufferedInputStream is = new BufferedInputStream(Files.newInputStream (p))) {
      byte[] buff = new byte[1024];
      while (true) {
        int r = is.read(buff);
        if (r < 1) break;
        for(int i=0; i<r; i++)
          System.out.printf("%02x ", buff[i]);
      }
    } catch (IOException ex) {
      System.err.println(ex);
    }
  }
  
  public void prepisiSliku(){
    Path p = Paths.get("duke.png");
    Path p2 = Paths.get("duke2.png");
    try (BufferedInputStream is = new BufferedInputStream(Files.newInputStream (p));
         BufferedOutputStream os = new BufferedOutputStream(Files.newOutputStream (p2))) {
      byte[] buff = new byte[1024];
      while (true) {
        int r = is.read(buff);
        if (r < 1) break;
        for(int i=0; i<r; i++){
          System.out.printf("%02x ", buff[i]);
          os.write(buff[i]);
        }
      }
    } catch (IOException ex) {
      System.err.println(ex);
    }
  }
  
  
}
