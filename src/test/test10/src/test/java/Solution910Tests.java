import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution910Tests {
    private final Solution910 solution910 = new Solution910();

    @Test
    public void example1() {
        int[] nums = {1};
        int k = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution910.smallestRangeII(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {0, 10};
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution910.smallestRangeII(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 3, 6};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution910.smallestRangeII(nums, k));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] nums = {3, 1, 10};
        int k = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution910.smallestRangeII(nums, k));
    }
}
