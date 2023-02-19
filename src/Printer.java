public class Printer {
    public void print(int count, String string) throws InterruptedException {
        for (int i = 1; i < count; i++) {
            Thread.sleep(100L * i);
            System.out.println(Thread.currentThread().getName() + " " + string);

        }
    }
}
