import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int k = scanner.nextInt();
        int y = 0;

        double res = m;
        for (int i = 1; res <= k; ++i) {
            double margin = res - k;
            print(margin);
            if (margin > 0 && margin < m) {
                y = i;
                break;
            }
            res += (res * p) / 100;
            System.out.println("RESULT IS:" + res);
            y = i - 1;
            System.out.println("YEAR IS:" + res);
        }
        scanner.close();
    }

    public static void print(int val) {
        System.out.println(val);
    }
    public static void print(double val) {
        System.out.println(val);
    }
}
