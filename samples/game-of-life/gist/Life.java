import java.util.Random;
import java.io.IOException;
import java.util.concurrent.*;

public class Life extends Model {

    // Constructor: First Gen
    public Life(int size, int seed) {
        super(size);

        Random random = new Random(seed);
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j)
                this.map[i][j] = (random.nextBoolean()) ? 1 : 0;
        }
    }

    // Constructor: First Gen (Overloaded)
    public Life(int size) {
        super(size);

        Random random = new Random();
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j)
                this.map[i][j] = (random.nextBoolean()) ? 1 : 0;
        }
    }

    // Propagate the map a number of times (gens > 0)
    public void propagate() {
        int gens = 100;

        for (int i = 0; i < gens; ++i) {
            generate();
            System.out.println("GENERATION #" + (i) + ":");
            System.out.println("------------------------");
            view(this.map, this.size);
            try {
                Thread.sleep(100);
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("GENERATION #" + (gens - 1) + ":");
        System.out.println("------------------------");
        view(this.map, this.size);
    }

    // default function
    void generate() {
        Model future = new Model(this.size) {};

        for (int row = 0; row < this.size - 1; ++row) {
            for (int col = 0; col < this.size - 1; ++col) {
                int neighbors = neighbors(row, col);
                if      (neighbors == 3)    future.map[row][col] = 1;
                else if (neighbors == 2)    future.map[row][col] = this.map[row][col];
                else                        future.map[row][col] = 0;
            }
        }
        this.map = future.map;
    }

    // Count the surrouding neighborhood
    int neighbors(int row, int col) {
        int count = 0;
        int r, c;

        for (int rmod = -1; rmod <= 1; ++rmod) {
            for (int cmod = -1; cmod <= 1; ++cmod) {
                if (rmod == 0 && cmod == 0)
                    continue;
                r = checkIndex(row + rmod);
                c = checkIndex(col + cmod);
                count += (this.map[r][c] == 1) ? 1 : 0;
            }
        }
        return count;
    }

    // loop back at the edges of the map
    int checkIndex(int coordinate) {
        return (coordinate + this.size) % this.size;
    }

    /**
     * Interface: view the map of life.
     */
    public static void view(int[][] matrix, int s) {
        StringBuilder view = new StringBuilder(); 
        view.append("\t  | ");
        for (var i = 0; i < s; ++i) {
            view.append(i % 10);
            view.append(' ');
        }
        view.append('\n');
        view.append('\t');
        view.append("----");
        for (var i = 0; i < s; ++i) {
            view.append("--");
        }
        view.append('\n');
        for (int row = 0; row < s; ++row) {
            view.append('\t');
            view.append(row % 10);
            view.append(" | ");
            for (int col = 0; col < s; ++col) {
                if (matrix[row][col] == 1) view.append("O ");
                else view.append("  ");
            }
            view.append('\n');
        }
        System.out.print(view);
    }

    public static void view_raw(int[][] matrix, int s) {
        for (int row = 0; row < s; ++row) {
            for (int col = 0; col < s; ++col) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}

abstract class Model {
    int size;
    int[][] map;

    Model (int size) {
        this.size = size;
        this.map = new int[size][size];
    }
}

class MyRunnable implements Runnable {
    private Life v;

    public MyRunnable(Life v) {
        this.v = v;
    }
    
    public void run() {
        //v.generate();
        //Life.view(v.map, v.size);
        //try {
            //this.wait(500);
        //} catch (InterruptedException e) {
            //e.printStackTrace();
        //}
    }
}
