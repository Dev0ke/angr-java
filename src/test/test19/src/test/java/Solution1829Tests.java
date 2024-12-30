import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1829Tests {
    private final Solution1829 solution1829 = new Solution1829();

    @Test
    public void example1() {
        int[] nums = {0, 1, 1, 3};
        int maximumBit = 2;
        int[] expected = {0, 3, 2, 3};
        Assertions.assertArrayEquals(expected, solution1829.getMaximumXor(nums, maximumBit));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 4, 7};
        int maximumBit = 3;
        int[] expected = {5, 2, 6, 5};
        Assertions.assertArrayEquals(expected, solution1829.getMaximumXor(nums, maximumBit));
    }

    @Test
    public void example3() {
        int[] nums = {0, 1, 2, 2, 5, 7};
        int maximumBit = 3;
        int[] expected = {4, 3, 6, 4, 6, 7};
        Assertions.assertArrayEquals(expected, solution1829.getMaximumXor(nums, maximumBit));
    }
}