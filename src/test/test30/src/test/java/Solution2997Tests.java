import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2997Tests {
    private final Solution2997 solution2997 = new Solution2997();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3, 4};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution2997.minOperations(nums, k));
        Assertions.assertEquals(expected, solution2997.minOperations2(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 0, 2, 0};
        int k = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution2997.minOperations(nums, k));
        Assertions.assertEquals(expected, solution2997.minOperations2(nums, k));
    }
}