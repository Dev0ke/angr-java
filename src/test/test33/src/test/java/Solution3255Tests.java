import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3255Tests {
    private final Solution3255 solution3255 = new Solution3255();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 3, 2, 5};
        int k = 3;
        int[] expected = {3, 4, -1, -1, -1};
        Assertions.assertArrayEquals(expected, solution3255.resultsArray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 2, 2, 2};
        int k = 4;
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution3255.resultsArray(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {3, 2, 3, 2, 3, 2};
        int k = 2;
        int[] expected = {-1, 3, -1, 3, -1};
        Assertions.assertArrayEquals(expected, solution3255.resultsArray(nums, k));
    }
}