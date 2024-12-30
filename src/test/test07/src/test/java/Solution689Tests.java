import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution689Tests {
    private final Solution689 solution689 = new Solution689();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        int[] expected = {0, 3, 5};
        Assertions.assertArrayEquals(expected, solution689.maxSumOfThreeSubarrays(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1, 2, 1, 2, 1, 2, 1};
        int k = 2;
        int[] expected = {0, 2, 4};
        Assertions.assertArrayEquals(expected, solution689.maxSumOfThreeSubarrays(nums, k));
    }
}