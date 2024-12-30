import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2682Tests {
    private final Solution2682 solution2682 = new Solution2682();

    @Test
    public void example1() {
        int n = 5;
        int k = 2;
        int[] expected = {4, 5};
        Assertions.assertArrayEquals(expected, solution2682.circularGameLosers(n, k));
    }

    @Test
    public void example2() {
        int n = 4;
        int k = 4;
        int[] expected = {2, 3, 4};
        Assertions.assertArrayEquals(expected, solution2682.circularGameLosers(n, k));
    }
}