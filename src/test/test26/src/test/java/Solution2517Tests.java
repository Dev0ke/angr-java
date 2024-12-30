import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2517Tests {
    private final Solution2517 solution2517 = new Solution2517();

    @Test
    public void example1() {
        int[] price = {13, 5, 1, 8, 21, 2};
        int k = 3;
        int expected = 8;
        Assertions.assertEquals(expected, solution2517.maximumTastiness(price, k));
    }

    @Test
    public void example2() {
        int[] price = {1, 3, 1};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution2517.maximumTastiness(price, k));
    }

    @Test
    public void example3() {
        int[] price = {7, 7, 7, 7};
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution2517.maximumTastiness(price, k));
    }
}
