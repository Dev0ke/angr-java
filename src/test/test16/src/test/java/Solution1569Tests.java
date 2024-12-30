import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1569Tests {
    private final Solution1569 solution1569 = new Solution1569();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution1569.numOfWays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 4, 5, 1, 2};
        int expected = 5;
        Assertions.assertEquals(expected, solution1569.numOfWays(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution1569.numOfWays(nums));
    }
}