import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2163Tests {
    private final Solution2163 solution2163 = new Solution2163();

    @Test
    public void example1() {
        int[] nums = {3, 1, 2};
        long expected = -1L;
        Assertions.assertEquals(expected, solution2163.minimumDifference(nums));
    }

    @Test
    public void example2() {
        int[] nums = {7, 9, 5, 8, 1, 3};
        long expected = 1L;
        Assertions.assertEquals(expected, solution2163.minimumDifference(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = {16, 46, 43, 41, 42, 14, 36, 49, 50, 28, 38, 25, 17, 5, 18, 11, 14, 21, 23, 39, 23};
        long expected = -14L;
        Assertions.assertEquals(expected, solution2163.minimumDifference(nums));
    }
}