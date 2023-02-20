import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String URL = "https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg";

    public static void main(String[] args) throws InterruptedException {
        ShowBytesCallBack.Base showBytesCallBack = new ShowBytesCallBack.Base();

        List<Thread> list = new ArrayList<>();
        list.add(new Downloader(showBytesCallBack, "firstImage"));
        list.add(new Downloader(URL, showBytesCallBack, "secondImage"));
        list.add(new Downloader(showBytesCallBack, "firstImage"));
        list.add(new Downloader(URL, showBytesCallBack, "firstImage"));

        for (Thread thread : list) {
            thread.start();
        }

        for (Thread thread : list) {
            thread.join();
        }
        showBytesCallBack.totalBytes(System.out);
    }
}