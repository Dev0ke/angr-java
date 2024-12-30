import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2644Tests {
    private final Solution2644 solution2644 = new Solution2644();

    @Test
    public void example1() {
        int[] nums = {4, 7, 9, 3, 9};
        int[] divisors = {5, 2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution2644.maxDivScore(nums, divisors));
    }

    @Test
    public void example2() {
        int[] nums = {20, 14, 21, 10};
        int[] divisors = {5, 7, 5};
        int expected = 5;
        Assertions.assertEquals(expected, solution2644.maxDivScore(nums, divisors));
    }

    @Test
    public void example3() {
        int[] nums = {12};
        int[] divisors = {10, 16};
        int expected = 10;
        Assertions.assertEquals(expected, solution2644.maxDivScore(nums, divisors));
    }
}