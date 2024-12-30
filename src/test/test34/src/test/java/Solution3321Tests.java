import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3321Tests {
    private final Solution3321 solution3321 = new Solution3321();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2, 2, 3, 4, 2, 3};
        int k = 6;
        int x = 2;
        long[] expected = {6, 10, 12};
        Assertions.assertArrayEquals(expected, solution3321.findXSum(nums, k, x));
    }

    @Test
    public void example2() {
        int[] nums = {3, 8, 7, 8, 7, 5};
        int k = 2;
        int x = 2;
        long[] expected = {11, 15, 15, 15, 12};
        Assertions.assertArrayEquals(expected, solution3321.findXSum(nums, k, x));
    }
}