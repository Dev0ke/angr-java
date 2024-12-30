import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2905Tests {
    private final Solution2905 solution2905 = new Solution2905();

    @Test
    public void example1() {
        int[] nums = {5, 1, 4, 1};
        int indexDifference = 2;
        int valueDifference = 4;
        int[] expected = {0, 3};
        Assertions.assertArrayEquals(expected, solution2905.findIndices(nums, indexDifference, valueDifference));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1};
        int indexDifference = 0;
        int valueDifference = 0;
        int[] expected = {0, 0};
        Assertions.assertArrayEquals(expected, solution2905.findIndices(nums, indexDifference, valueDifference));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int indexDifference = 2;
        int valueDifference = 4;
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution2905.findIndices(nums, indexDifference, valueDifference));
    }
}