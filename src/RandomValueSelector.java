import java.util.Random;

public class RandomValueSelector {
    private static Random r = new Random();

    public static int choose(int size) {
        return r.nextInt(size);
    }
}
