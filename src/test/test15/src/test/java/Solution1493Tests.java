import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1493Tests {
    private final Solution1493 solution1493 = new Solution1493();

    @Test
    public void example1() {
        int[] nums = {1, 1, 0, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution1493.longestSubarray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        int expected = 5;
        Assertions.assertEquals(expected, solution1493.longestSubarray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution1493.longestSubarray(nums));
    }
}