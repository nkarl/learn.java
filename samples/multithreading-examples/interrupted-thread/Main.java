
class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            if (!Thread.interrupted()) {
                System.out.println(Thread.interrupted());
            } else {
                while (true) {
                    if (!Thread.interrupted()) {
                        System.out.println(Thread.interrupted());
                        break;
                    }
                }
            }
        });
        thread.start();
        thread.interrupt();
    }
}
