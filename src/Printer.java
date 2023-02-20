import java.util.List;

public class Printer {
    private final List<Thread> list;

    public Printer(List<Thread> list) {
        this.list = list;
    }

    public void startThreads() {
        for (Thread thread : list) {
            thread.start();
        }
    }

    public void waitEndThread() {
        for (Thread thread : list) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
