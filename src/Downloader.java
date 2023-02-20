import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

public class Downloader extends Thread {
    private final String url;
    private final ShowBytesCallBack showBytesCallBack;
    private final String name;

    Downloader(String url, ShowBytesCallBack showBytesCallBack, String name) {
        this.url = url;
        this.showBytesCallBack = showBytesCallBack;
        this.name = name;
    }

    Downloader(ShowBytesCallBack showBytesCallBack, String name) {
        this.showBytesCallBack = showBytesCallBack;
        this.url = "https://cdn-icons-png.flaticon.com/512/1256/1256397.png";
        this.name = name;
    }

    @Override
    public synchronized void run() {
        String nameOfThread = currentThread().getName();

        System.out.println(nameOfThread + "Started at" + new Date());
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(name)) {
            byte[] buffer = new byte[1024];
            int bytes;
            while ((bytes = in.read(buffer, 0, 1024)) != -1) {
                fileOutputStream.write(buffer, 0, bytes);
                System.out.println(nameOfThread);
                showBytesCallBack.updateValue(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(nameOfThread + " finished at" + new Date());
        }
    }
}
