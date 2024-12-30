import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1799Tests {
    private final Solution1799 solution1799 = new Solution1799();

    @Test
    public void example1() {
        int[] nums = {1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution1799.maxScore(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 4, 6, 8};
        int expected = 11;
        Assertions.assertEquals(expected, solution1799.maxScore(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int expected = 14;
        Assertions.assertEquals(expected, solution1799.maxScore(nums));
    }
}
