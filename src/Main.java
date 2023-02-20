import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String URL = "https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg";

    public static void main(String[] args){
        ShowBytesCallBack.Base showBytesCallBack = new ShowBytesCallBack.Base();

        List<Thread> list = new ArrayList<>();
        list.add(new Downloader(showBytesCallBack, "firstImage"));
        list.add(new Downloader(URL, showBytesCallBack, "secondImage"));
        list.add(new Downloader(showBytesCallBack, "firstImage"));
        list.add(new Downloader(URL, showBytesCallBack, "firstImage"));

        Printer printer = new Printer(list);
        printer.startThreads();
        printer.waitEndThread();
        showBytesCallBack.totalBytes(System.out);
    }
}