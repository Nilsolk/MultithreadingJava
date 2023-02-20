
public class Deadlock {
    public static void main(String[] args) {
        final String res1 = "my sample text";
        final String res2 = "some other text";

        Runnable P1 = () -> {
            synchronized (res1) {
                System.out.println("Thread 1 takes Res 1");
                try {
                    Thread.sleep(100);
                } catch (Exception ignored) {
                }

                synchronized (res2) {
                    System.out.println("Thread 1 takes Res 2");
                }
            }
        };

        Runnable P2 = () -> {
            synchronized (res2) {
                System.out.println("Thread 2 takes Res 2");
                try {
                    Thread.sleep(100);
                } catch (Exception ignored) {
                }
                synchronized (res1) {
                    System.out.println("Thread 2 takes Res 1");
                }
            }
        };

        new Thread(P1).start();
        new Thread(P2).start();

    }
}
