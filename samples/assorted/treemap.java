import java.util.*;

public class treemap {
    public static void main(String[] args) {
        SortedMap<String, Integer> map = new TreeMap<>();
        map.put("Omega", 24);
        map.put("Alpha", 1);
        map.put("Gamma", 3);

        System.out.println(map);
    }
}
