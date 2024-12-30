import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1389Tests {
    private final Solution1389 solution1389 = new Solution1389();

    @Test
    public void example1() {
        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};
        int[] expected = {0, 4, 1, 3, 2};
        Assertions.assertArrayEquals(expected, solution1389.createTargetArray(nums, index));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 0};
        int[] index = {0, 1, 2, 3, 0};
        int[] expected = {0, 1, 2, 3, 4};
        Assertions.assertArrayEquals(expected, solution1389.createTargetArray(nums, index));
    }

    @Test
    public void example3() {
        int[] nums = {1};
        int[] index = {0};
        int[] expected = {1};
        Assertions.assertArrayEquals(expected, solution1389.createTargetArray(nums, index));
    }
}