import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int size = scanner.nextInt();
        // long seed = scanner.nextLong();
        // int gens = scanner.nextInt();
        int size = Integer.parseInt(args[0]);
        long seed = Integer.parseInt(args[1]);
        int gens = Integer.parseInt(args[2]);
        Life world = new Life(size, seed);
        world.propagate(gens);
        // scanner.close();
    }
}

class Life {
    int size; // map size
    int[][] map; // universe map

    // Constructor: First Gen
    public Life(int size, long seed) {
        this.size = size;
        this.map = new int[size][size];

        Random random = new Random(seed);
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j)
                this.map[i][j] = (random.nextBoolean()) ? 1 : 0;
        }
    }

    // Propagate the map a number of times (gens > 0)
    public void propagate(int gens) {
        //view(this.map, this.size);
        for (int i = 0; i < gens; ++i) {
            System.out.println("GENERATION #" + (i) + ":");
            System.out.println("------------------------");
            view(this.map, this.size);
            generate();
        }
        System.out.println("GENERATION #" + (gens) + ":");
        System.out.println("------------------------");
        view(this.map, this.size);
    }

    void generate() {
        int[][] future = new int[this.size][this.size];
        for (int i = 0; i < this.size - 1; ++i) {
            for (int j = 0; j < this.size - 1; ++j) {
                int surrounding = countNeighbors(i, j);
                if (this.map[i][j] == 1) {
                    if (surrounding == 2 || surrounding == 3)
                        future[i][j] = 1;
                    else
                        future[i][j] = 0;
                } else {
                    if (surrounding == 3)
                        future[i][j] = 1;
                    else
                        future[i][j] = 0;
                }
            }
        }
        this.map = future;
    }

    // Count the surrouding neighborhood
    int countNeighbors(int row, int col) {
        int count = 0;
        int r, c;

        for (int i = -1; i < 2; ++i) {
            r = loopCoordinate(i + row);
            for (int j = -1; j < 2; ++j) {
                c = loopCoordinate(j + col);
                if (r == row && c == col)
                    continue;
                count += (this.map[r][c] == 1) ? 1 : 0;
            }
        }
        return count;
    }

    // loop back at the edges of the map
    int loopCoordinate(int coordinate) {
        return (coordinate + this.size) % this.size;
    }

    /**
     * Interface: view the map of life.
     */
    public static void view(int[][] matrix, int s) {
        StringBuilder view = new StringBuilder(); 
        view.append("\t  | ");
        for (var i = 0; i < s; ++i) {
            view.append(i);
            view.append(' ');
        }
        view.append('\n');
        view.append('\t');
        view.append("----");
        for (var i = 0; i < s; ++i) {
            view.append("--");
        }
        view.append('\n');
        for (int i = 0; i < s; ++i) {
            view.append('\t');
            view.append(i);
            view.append(" | ");
            for (int j = 0; j < s; ++j) {
                if (matrix[i][j] == 1) view.append("O ");
                else view.append("- ");
            }
            view.append('\n');
        }
        System.out.print(view);
    }

    public static void view_raw(int[][] matrix, int s) {
        for (int i = 0; i < s; ++i) {
            for (int j = 0; j < s; ++j) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
