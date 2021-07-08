
import java.util.Scanner;
import life.engine.Life;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        //// Scanner scanner = new Scanner(System.in);
        // int size = Integer.parseInt(args[0]);// scanner.nextInt();
        // long seed = Integer.parseInt(args[1]);// scanner.nextLong();
        // int gens = Integer.parseInt(args[2]);// scanner.nextInt();
        // Life world = new Life(size, seed);
        // world.view();
        // world.propagate(gens);
        //// scanner.close();

        Scanner scanner = new Scanner(System.in);
        var inArgs = Stream.of(scanner.nextLine().split(" "))
                            .map(String::new)
                            .collect(Collectors
                            .toList());
        // var inArgs = new ArrayList<>();
        // for (String elem : scanner.nextLine().split(" ")) {
        // String s = new String(elem);
        // inArgs.add(s);
        // }
        scanner.close();

        int size, seed, gens = 10;
        Life world;
        if (inArgs.size() == 1) {
            world = new Life(Integer.parseInt(inArgs.remove(0)));
        } else {
            size = Integer.parseInt(inArgs.remove(0));
            seed = Integer.parseInt(inArgs.remove(0));
            gens = Integer.parseInt(inArgs.remove(0));
            world = new Life(size, seed);
        }

        world.propagate(gens);
    }
}
