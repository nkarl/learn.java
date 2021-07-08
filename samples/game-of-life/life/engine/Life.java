package engine;

import java.util.Random;

public class Life implements View {
    char[][] map;
    int size;

    /**
     * The Life Constructor.
     *
     * @param size size of this map.
     * @param seed the seeded value for the randomizing algorithm.
     */
    public Life(int size, int seed) {
        //super(size);
        this.map = new char[size][size];
        this.size = size;
        Random random = new Random(seed);
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                this.map[i][j] = random.nextBoolean() ? 'O' : ' ';
            }
        }
    }


    public Life(int size) {
        //super(size);
        this.map = new char[size][size];
        this.size = size;
        Random random = new Random();
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                this.map[i][j] = random.nextBoolean() ? 'O' : ' ';
            }
        }
    }

    /**
     * @param gens the total number of generations to propagate through.
     */
    public void propagate(int gens) {
        for (int i = 0; i < gens; ++i) {
            //view();
            generate();
        };
        view();
    }

    void generate() {
        //Model future = new Model(this.size) {};
        char[][] future = new char[this.size][this.size];
        for (int row = 0; row < this.size; ++row) {
            for (int col = 0; col < this.size; ++col) {
                int neighbors = neighbors(row, col);
                if (neighbors == 3) {
                    future[row][col] = 'O';
                }
                else if (neighbors == 2) {
                    future[row][col] = this.map[row][col];
                } else {
                    future[row][col] = ' ';
                }
            }
        }
        view();
        this.map = future;
    }

    int neighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i < 2; ++i) {
            for (int j = -1; j < 2; ++j) {
                if (i == 0 && j == 0) continue;
                count += checkAliveCell(row + i, col + i);
            }
        }
        return count;
    }

    int checkAliveCell(int row, int col) {
        row = checkIndex(row);
        col = checkIndex(col);
        return map[row][col] == 'O' ? 1 : 0;
    }

    int checkIndex(int index) {
        int MAX = this.size - 1;
        if (index < 0) index = MAX;
        if (index > MAX) index = 0;
        return index;
    }

    /**
     * Interface: view the map of life.
     */
    @Override
    public void view() {
        for (var row : this.map) {
            for (var cell : row) {
                System.out.print(cell);
                //if (cell == 1) System.out.print('O');
                //else System.out.print('-');
            }
            System.out.println();
        }
    }
}
