import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int size = scanner.nextInt();
        // long seed = scanner.nextLong();
        // int gens = scanner.nextInt();
        // scanner.close();
        int size = Integer.parseInt(args[0]);
        //long seed = Integer.parseInt(args[1]);
        //int gens = Integer.parseInt(args[2]);
        //Life world = new Life(size, seed);
        Life world = new Life(size);
        //world.propagate(gens);
        world.propagate();

        MyRunnable myRun = new MyRunnable(world);
        Thread myThread = new Thread(myRun) {
            @Override
            public void run () {
                world.generate();
            }
        };
        myThread.start();
        //for (int i = 0; i < 300; ++i) {
        //while(true) {
            //world.generate();
            //Life.view(world.map, world.size);
            ////try {
                ////System.out.println("\033[H\033[2J");
                ////Thread.sleep(30);
            ////} catch (InterruptedException e) {
                ////e.printStackTrace();
            ////}
            //try {
                ////if (System.getProperties().contains("Windows"))
                    //Thread.sleep(150);
                    //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                ////else
                    ////Runtime.getRuntime().exec("clear");
            //} catch (IOException | InterruptedException e) {
                //e.printStackTrace();
            //}
        //}
    }
}

