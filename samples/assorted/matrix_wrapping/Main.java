import java.util.Random;

public class Main {
    final int SIZE = 5;
    final String[] CARDINALS = {
            "NW", "N", "NE", "W", "E", "SW", "S", "SE"
    };
    
    char[][] arr = new char[SIZE][SIZE];
   
    public void start() {
        Random r = new Random();
        for (char[] row : arr) {
            for (int i = 0; i < row.length; ++i) {
                row[i] = r.nextInt(2) == 0 ? ' ' : '*';
            }
        }
        System.out.printf("%s%n%n", this);
        reportNeighbors();
    }
    
    public void reportNeighbors() {
        for (int row = 0; row < SIZE; ++row) {
            for (int col = 0; col < SIZE; ++col) {
                printNeighborsOf(row, col);
            }
        }
    }
    
    private void printNeighborsOf(int cellRow, int cellCol) {
        System.out.printf("Neighbors of cell at (row: %d, col: %d):%n" +
                        "==============================================%n",
                cellRow, cellCol);
        int i = 0;
        for (int v = -1; v <= 1; ++v) {
            for (int h = -1; h <= 1; ++h) {
                if (v == 0 && h == 0) {
                    continue;
                }
                int row = validate(cellRow + v);
                int col = validate(cellCol + h);
                System.out.printf("%2s neighbor at (row: %d, col: %d), contains \"%c\";%n",
                        CARDINALS[i++],
                        row, col,
                        arr[row][col]);
            }
        }
        System.out.printf("==============================================%n%n");
    }
    
    private int validate(int coord) {
        if (coord < 0) {
            return coord + SIZE;
        }
        if (coord >= SIZE) {
            return coord - SIZE;
        }
        return coord;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("+");
        sb.append("-+".repeat(SIZE)).append("-+\n");
        for (char[] row : arr) {
            sb.append("+");
            for (char c : row) {
                sb.append(" ").append(c);
            }
            sb.append(" +\n");
        }
        sb.append("+").append("-+".repeat(SIZE)).append("-+");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        new Main().start();
    }
}
