
public class Main {
    public static void main (String[] args) {

        // thread 1
        Runnable r1 = new Runnable() {
            public void run() {
                try {
                    while (true) {
                        System.out.println("Hello, world!");
                        Thread.sleep(1000L);
                    }
                } catch (InterruptedException iex) {}
            }
        };

        // thread 2
        Runnable r2 = new Runnable() {
            public void run() {
                try {
                    while (true) {
                        System.out.println("Goodbye, " + "cruel world!");
                        Thread.sleep(1500L);
                    }
                } catch (InterruptedException iex) {}
            }
        };

        // starting threads
        Thread thr1 = new Thread(r1);
        Thread thr2 = new Thread(r2);
        thr1.start();
        thr2.start();
    }
}
