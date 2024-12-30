import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2161Tests {
    private final Solution2161 solution2161 = new Solution2161();

    @Test
    public void example1() {
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;
        int[] expected = {9, 5, 3, 10, 10, 12, 14};
        Assertions.assertArrayEquals(expected, solution2161.pivotArray(nums, pivot));
    }

    @Test
    public void example2() {
        int[] nums = {-3, 4, 3, 2};
        int pivot = 2;
        int[] expected = {-3, 2, 4, 3};
        Assertions.assertArrayEquals(expected, solution2161.pivotArray(nums, pivot));
    }
}
