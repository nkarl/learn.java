// A class containing some example from the Math library
import java.util.Scanner;
import java.util.Random;

public class MathExamples {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        //double res = Math.pow(a, b);
        //System.out.println(res);
        
        Random random = new Random();
        double range = b - a;
        System.out.println("range: " + range);
        System.out.println(random.nextInt((int)range) + a + 1);

        scanner.close();
    }
}
