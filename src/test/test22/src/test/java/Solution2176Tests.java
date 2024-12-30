import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2176Tests {
    private final Solution2176 solution2176 = new Solution2176();

    @Test
    public void example1() {
        int[] nums = {3, 1, 2, 2, 2, 1, 3};
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution2176.countPairs(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int k = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution2176.countPairs(nums, k));
    }
}
