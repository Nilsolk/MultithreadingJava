public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Downloader downloader = new Downloader("https://i.pinimg.com/236x/8a/de/fe/8adefe5af862b4f9cec286c6ee4722cb.jpg");

        Runnable firstPrinter = () -> {
            try {
                printer.print(10, "first");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable secondPrinter = () -> {
            try {
                printer.print(5, "second");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread first = new Thread(firstPrinter);
        Thread second = new Thread(secondPrinter);
        Thread download = new Thread(downloader);


        Thread.yield();
        first.setName("First thread");
        second.setName("Second name");

        download.start();
        first.start();
        second.start();
        System.out.println(Thread.currentThread().getName());


    }
}