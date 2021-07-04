import java.util.List;

public abstract class DigitMap<T> {
   // class attributes
    public static final int r_dim = 5;
    public static final int c_dim = 3;
    public static final int WHITE = -1;
    public static final int BLUE = 1;
    static int len = r_dim * c_dim + 1;

//    protected int[] map;  // instance attribute
    public List<T> map;
}
