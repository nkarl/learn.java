import java.util.Arrays;

public class InputMap extends DigitMap<Integer> {
    public InputMap() {
        this.map = Arrays.asList(new Integer[len]);
        String input = "_X_X_X_X_";

        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == '_')
                this.map.set(i, 0);
            else this.map.set(i, 1);
        }
    }
}
