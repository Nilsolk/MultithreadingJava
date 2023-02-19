public class Printer {
    synchronized public void print(int count, String string) throws InterruptedException {
        for (int i = 1; i < count; i++) {
            Thread.sleep(100 * i);
            System.out.println(string);
        }
    }
}
