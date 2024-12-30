import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution918Tests {
    private final Solution918 solution918 = new Solution918();

    @Test
    public void example1() {
        int[] nums = {1, -2, 3, -2};
        int expected = 3;
        Assertions.assertEquals(expected, solution918.maxSubarraySumCircular(nums));
        Assertions.assertEquals(expected, solution918.maxSubarraySumCircular2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, -3, 5};
        int expected = 10;
        Assertions.assertEquals(expected, solution918.maxSubarraySumCircular(nums));
        Assertions.assertEquals(expected, solution918.maxSubarraySumCircular2(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, -1, 2, -1};
        int expected = 4;
        Assertions.assertEquals(expected, solution918.maxSubarraySumCircular(nums));
        Assertions.assertEquals(expected, solution918.maxSubarraySumCircular2(nums));
    }

    @Test
    public void example4() {
        int[] nums = {3, -2, 2, -3};
        int expected = 3;
        Assertions.assertEquals(expected, solution918.maxSubarraySumCircular(nums));
        Assertions.assertEquals(expected, solution918.maxSubarraySumCircular2(nums));
    }

    @Test
    public void example5() {
        int[] nums = {-2, -3, -1};
        int expected = -1;
        Assertions.assertEquals(expected, solution918.maxSubarraySumCircular(nums));
        Assertions.assertEquals(expected, solution918.maxSubarraySumCircular2(nums));
    }

    // 补充用例
    @Test
    public void example6() {
        int[] nums = {-2};
        int expected = -2;
        Assertions.assertEquals(expected, solution918.maxSubarraySumCircular(nums));
        Assertions.assertEquals(expected, solution918.maxSubarraySumCircular2(nums));
    }
}
