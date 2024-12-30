import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1438Tests {
    private final Solution1438 solution1438 = new Solution1438();

    @Test
    public void example1() {
        int[] nums = {8, 2, 4, 7};
        int limit = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution1438.longestSubarray(nums, limit));
    }

    @Test
    public void example2() {
        int[] nums = {10, 1, 2, 4, 7, 2};
        int limit = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solution1438.longestSubarray(nums, limit));
    }

    @Test
    public void example3() {
        int[] nums = {4, 2, 2, 2, 4, 4, 2, 2};
        int limit = 0;
        int expected = 3;
        Assertions.assertEquals(expected, solution1438.longestSubarray(nums, limit));
    }
}
