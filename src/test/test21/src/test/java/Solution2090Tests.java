import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2090Tests {
    private final Solution2090 solution2090 = new Solution2090();

    @Test
    public void example1() {
        int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
        int k = 3;
        int[] expected = {-1, -1, -1, 5, 4, 4, -1, -1, -1};
        Assertions.assertArrayEquals(expected, solution2090.getAverages(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {100000};
        int k = 0;
        int[] expected = {100000};
        Assertions.assertArrayEquals(expected, solution2090.getAverages(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {8};
        int k = 100000;
        int[] expected = {-1};
        Assertions.assertArrayEquals(expected, solution2090.getAverages(nums, k));
    }
}
