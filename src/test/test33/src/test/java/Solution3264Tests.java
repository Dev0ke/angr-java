import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3264Tests {
    private final Solution3264 solution3264 = new Solution3264();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;
        int[] expected = {8, 4, 6, 5, 6};
        Assertions.assertArrayEquals(expected, solution3264.getFinalState(nums, k, multiplier));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2};
        int k = 3;
        int multiplier = 4;
        int[] expected = {16, 8};
        Assertions.assertArrayEquals(expected, solution3264.getFinalState(nums, k, multiplier));
    }
}