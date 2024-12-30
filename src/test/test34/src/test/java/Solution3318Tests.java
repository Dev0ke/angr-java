import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3318Tests {
    private final Solution3318 solution3318 = new Solution3318();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2, 2, 3, 4, 2, 3};
        int k = 6;
        int x = 2;
        int[] expected = {6, 10, 12};
        Assertions.assertArrayEquals(expected, solution3318.findXSum(nums, k, x));
    }

    @Test
    public void example2() {
        int[] nums = {3, 8, 7, 8, 7, 5};
        int k = 2;
        int x = 2;
        int[] expected = {11, 15, 15, 15, 12};
        Assertions.assertArrayEquals(expected, solution3318.findXSum(nums, k, x));
    }
}