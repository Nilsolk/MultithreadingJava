public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

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

        first.start();
        secondPrinter.run();
    }
}