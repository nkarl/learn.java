import java.util.Random;
import java.lang.StringBuilder;

public class printmatrix {
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int seed = Integer.parseInt(args[1]);

        int[][] matrix = new int[size][size];

        Random rnd = new Random(seed);
        for (var i = 0; i < size; ++i) {
            for (var j = 0; j < size; ++j) {
                matrix[i][j] = (rnd.nextBoolean()) ? 1 : 0;
            }
        }
        view(matrix, size);
        //view_raw(matrix, size);
    }

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
