import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3290Tests {
    private final Solution3290 solution3290 = new Solution3290();

    @Test
    public void example1() {
        int[] a = {3, 2, 5, 6};
        int[] b = {2, -6, 4, -5, -3, 2, -7};
        long expected = 26;
        Assertions.assertEquals(expected, solution3290.maxScore(a, b));
    }

    @Test
    public void example2() {
        int[] a = {-1, 4, 5, -2};
        int[] b = {-5, -1, -3, -2, -4};
        long expected = -1;
        Assertions.assertEquals(expected, solution3290.maxScore(a, b));
    }
}