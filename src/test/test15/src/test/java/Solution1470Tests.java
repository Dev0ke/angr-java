import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1470Tests {
    private final Solution1470 solution1470 = new Solution1470();

    @Test
    public void example1() {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        int[] expected = {2, 3, 5, 4, 1, 7};
        Assertions.assertArrayEquals(expected, solution1470.shuffle(nums, n));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 4, 3, 2, 1};
        int n = 4;
        int[] expected = {1, 4, 2, 3, 3, 2, 4, 1};
        Assertions.assertArrayEquals(expected, solution1470.shuffle(nums, n));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 2, 2};
        int n = 2;
        int[] expected = {1, 2, 1, 2};
        Assertions.assertArrayEquals(expected, solution1470.shuffle(nums, n));
    }
}