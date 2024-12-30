import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3149Tests {
    private final Solution3149 solution3149 = new Solution3149();

    @Test
    public void example1() {
        int[] nums = {1, 0, 2};
        int[] expected = {0, 1, 2};
        Assertions.assertArrayEquals(expected, solution3149.findPermutation(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 2, 1};
        int[] expected = {0, 2, 1};
        Assertions.assertArrayEquals(expected, solution3149.findPermutation(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = {0, 2, 1, 3};
        int[] expected = {0, 2, 3, 1};
        Assertions.assertArrayEquals(expected, solution3149.findPermutation(nums));
    }

    @Test
    public void example4() {
        int[] nums = {0, 2, 3, 1, 4, 5};
        int[] expected = {0, 3, 4, 5, 2, 1};
        Assertions.assertArrayEquals(expected, solution3149.findPermutation(nums));
    }
}