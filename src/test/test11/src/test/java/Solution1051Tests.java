import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1051Tests {
    private final Solution1051 solution1051 = new Solution1051();

    @Test
    public void example1() {
        int[] heights = {1, 1, 4, 2, 1, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution1051.heightChecker(heights));
    }

    @Test
    public void example2() {
        int[] heights = {5, 1, 2, 3, 4};
        int expected = 5;
        Assertions.assertEquals(expected, solution1051.heightChecker(heights));
    }

    @Test
    public void example3() {
        int[] heights = {1, 2, 3, 4, 5};
        int expected = 0;
        Assertions.assertEquals(expected, solution1051.heightChecker(heights));
    }
}
