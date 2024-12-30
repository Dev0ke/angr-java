import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2640Tests {
    private final Solution2640 solution2640 = new Solution2640();

    @Test
    public void example1() {
        int[] nums = {2, 3, 7, 5, 10};
        long[] expected = {4, 10, 24, 36, 56};
        Assertions.assertArrayEquals(expected, solution2640.findPrefixScore(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 2, 4, 8, 16};
        long[] expected = {2, 4, 8, 16, 32, 64};
        Assertions.assertArrayEquals(expected, solution2640.findPrefixScore(nums));
    }
}