import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

public class Downloader implements Runnable {
    private final String url;

    Downloader(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        System.out.println("Started at" + new Date());
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("somePhoto.jpg")) {
            byte[] buffer = new byte[1024];
            int bytes;
            while ((bytes = in.read(buffer, 0, 1024)) != -1) {
                fileOutputStream.write(buffer, 0, bytes);
                System.out.println(new Date());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finished at" + new Date());
        }
    }
}
