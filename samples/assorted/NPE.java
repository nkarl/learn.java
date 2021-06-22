// This is a test for NPE
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String string = "null";

        string = "null".equals(string) ? null : string;

        if (string == null)
            System.out.println("NPE");
        else
            System.out.println(string.toLowerCase());
    }
}
