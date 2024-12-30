import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1674Tests {
    private final Solution1674 solution1674 = new Solution1674();

    @Test
    public void example1() {
        int[] nums = {1, 2, 4, 3};
        int limit = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solution1674.minMoves(nums, limit));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 2, 1};
        int limit = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution1674.minMoves(nums, limit));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 1, 2};
        int limit = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution1674.minMoves(nums, limit));
    }
}