import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2006Tests {
    private final Solution2006 solution2006 = new Solution2006();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 1};
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution2006.countKDifference(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3};
        int k = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution2006.countKDifference(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {3, 2, 1, 5, 4};
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution2006.countKDifference(nums, k));
    }
}
