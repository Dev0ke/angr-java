import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1005Tests {
    private final Solution1005 solution1005 = new Solution1005();

    @Test
    public void example1() {
        int[] nums = {4, 2, 3};
        int k = 1;
        int expected = 5;
        Assertions.assertEquals(expected, solution1005.largestSumAfterKNegations(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, -1, 0, 2};
        int k = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solution1005.largestSumAfterKNegations(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {2, -3, -1, 5, -4};
        int k = 2;
        int expected = 13;
        Assertions.assertEquals(expected, solution1005.largestSumAfterKNegations(nums, k));
    }
}
