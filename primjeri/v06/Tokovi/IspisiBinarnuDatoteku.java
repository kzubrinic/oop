package Tokovi;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.InputStream;
import java.io.IOException;
public class IspisiBinarnuDatoteku {
  public void kreni(){
    Path p = Paths.get("duke.png");
    try (InputStream is = Files.newInputStream (p)) {
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
}
