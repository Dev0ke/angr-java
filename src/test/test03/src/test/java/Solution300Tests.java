import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution300Tests {
    private final Solution300 solution300 = new Solution300();

    @Test
    public void example1() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int expected = 4;
        Assertions.assertEquals(expected, solution300.lengthOfLIS(nums));
        Assertions.assertEquals(expected, solution300.lengthOfLIS2(nums));
        Assertions.assertEquals(expected, solution300.lengthOfLIS3(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 0, 3, 2, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solution300.lengthOfLIS(nums));
        Assertions.assertEquals(expected, solution300.lengthOfLIS2(nums));
        Assertions.assertEquals(expected, solution300.lengthOfLIS3(nums));
    }

    @Test
    public void example3() {
        int[] nums = {7, 7, 7, 7, 7, 7, 7};
        int expected = 1;
        Assertions.assertEquals(expected, solution300.lengthOfLIS(nums));
        Assertions.assertEquals(expected, solution300.lengthOfLIS2(nums));
        Assertions.assertEquals(expected, solution300.lengthOfLIS3(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] nums = {4, 10, 4, 3, 8, 9};
        int expected = 3;
        Assertions.assertEquals(expected, solution300.lengthOfLIS(nums));
        Assertions.assertEquals(expected, solution300.lengthOfLIS2(nums));
        Assertions.assertEquals(expected, solution300.lengthOfLIS3(nums));
    }
}
